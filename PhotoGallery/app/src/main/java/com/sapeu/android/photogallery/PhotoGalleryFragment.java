package com.sapeu.android.photogallery;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sapeu on 2016/11/2.
 */

public class PhotoGalleryFragment extends Fragment {

    private static final String TAG = "PhotoGalleryFragment";
    private RecyclerView mPhotoRecyclerView;
    private List<GalleryItem> mItems = new ArrayList<>();
    private ThumbnailDownloader<PhotoHolder> mThumbnailDownloader;

    public static PhotoGalleryFragment newInstance() {
        return new PhotoGalleryFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        new FetchItemsTask().execute();

        Handler responseHandler = new Handler();
        mThumbnailDownloader = new ThumbnailDownloader<>(responseHandler);
        mThumbnailDownloader.setThumbnailDownloadListener(
                new ThumbnailDownloader.ThumbnailDownloadListener<PhotoHolder>() {
                    @Override
                    public void onThumbnailDownloaded(PhotoHolder photoHolder, Bitmap bitmap) {
                        Drawable drawable = new BitmapDrawable(getResources(),bitmap);
                        photoHolder.bindGalleryItem(drawable);
                    }
                }
        );
        mThumbnailDownloader.start();
        mThumbnailDownloader.getLooper();
        Log.i(TAG,"Background thread started");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_photo_gallery,container,false);
        mPhotoRecyclerView = (RecyclerView) v.findViewById(R.id.fragment_photo_gallery_recycler_view);
        mPhotoRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        setupAdapter();
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mThumbnailDownloader.clearQueue();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mThumbnailDownloader.quit();
        Log.i(TAG, "Background thread destroyed");
    }

    private void setupAdapter(){
        if (isAdded()) {
            mPhotoRecyclerView.setAdapter(new PhotoAdapter(mItems));
        }
    }

    private class FetchItemsTask extends AsyncTask<Void,Void,List<GalleryItem>> {

        @Override
        protected List<GalleryItem> doInBackground(Void... voids) {
//            try {
//                String result = new FlickrFetchr().getUrlString("http://image.baidu.com/channel/listjson?pn=0&rn=30&tag1=%E6%98%8E%E6%98%9F&tag2=%E5%85%A8%E9%83%A8&ftags=%E5%A5%B3%E6%98%8E%E6%98%9F&ie=utf8");
//                Log.i(TAG,"Fetched contents of URL: " + result);
//            } catch (IOException e) {
//                Log.e(TAG,"Failed to fetch URL: ", e);
//            }
            return new FlickrFetchr().fetchItems();
//            return null;
        }

        @Override
        protected void onPostExecute(List<GalleryItem> galleryItems) {
            super.onPostExecute(galleryItems);
            mItems = galleryItems;
            setupAdapter();
        }
    }

    private class PhotoHolder extends RecyclerView.ViewHolder {

//        private TextView mTextView;
        private ImageView mItemImageView;

        public PhotoHolder(View itemView) {
            super(itemView);
//            mTextView = (TextView) itemView;
            mItemImageView = (ImageView) itemView.findViewById(R.id.fragment_photo_gallery_image_view);
        }

//        public void bindGalleryItem(GalleryItem item) {
//            mTextView.setText(item.toString());
//        }

        public void bindGalleryItem(Drawable drawable) {
            mItemImageView.setImageDrawable(drawable);
        }
    }

    private class PhotoAdapter extends RecyclerView.Adapter<PhotoHolder> {

        private List<GalleryItem> mGalleryItems;

        public PhotoAdapter (List<GalleryItem> galleryItems) {
            mGalleryItems = galleryItems;
        }

        @Override
        public PhotoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view= inflater.inflate(R.layout.gallery_item,parent,false);
//            TextView textView = new TextView(getActivity());
            return new PhotoHolder(view);
        }

        @Override
        public void onBindViewHolder(PhotoHolder photoHolder, int position) {
            GalleryItem galleryItem = mGalleryItems.get(position);
            Drawable placeholder = getResources().getDrawable(R.drawable.ysbqs);
            photoHolder.bindGalleryItem(placeholder);
            mThumbnailDownloader.queueThumbnail(photoHolder,galleryItem.getUrl());
        }

        @Override
        public int getItemCount() {
            return mGalleryItems.size();
        }
    }
}
