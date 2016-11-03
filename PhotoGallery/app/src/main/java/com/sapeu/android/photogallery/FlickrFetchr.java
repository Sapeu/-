package com.sapeu.android.photogallery;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sapeu on 2016/11/2.
 */

public class FlickrFetchr {

    private static final String TAG = "FlickrFetchr";
    private static final String API_KEY = "";

    public byte[] getUrlBytes(String urlSpec) throws IOException {
        URL url = new URL(urlSpec);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream in = connection.getInputStream();

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new IOException(connection.getResponseMessage() + ": with" + urlSpec);
            }

            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while ((bytesRead = in.read(buffer)) > 0) {
                out.write(buffer,0,bytesRead);
            }

            out.close();
            return out.toByteArray();

        }finally {
            connection.disconnect();
        }
    }

    public String getUrlString(String urlSpec) throws IOException {
        return new String(getUrlBytes(urlSpec));
    }

    public List<GalleryItem> fetchItems(){

        List<GalleryItem> items = new ArrayList<>();

        try {
            String url = Uri.parse("http://image.baidu.com/search/acjson")
                    .buildUpon()
                    .appendQueryParameter("tn","resultjson")
                    .appendQueryParameter("ie","utf-8")
                    .appendQueryParameter("oe","utf-8")
                    .appendQueryParameter("width","")
                    .appendQueryParameter("height","")
                    .appendQueryParameter("istype","")
                    .appendQueryParameter("cg","wallpaper")
                    .appendQueryParameter("pn","30")
                    .appendQueryParameter("rn","30")
                    .appendQueryParameter("ipn","rj")
                    .appendQueryParameter("word","动漫壁纸")
                    .build().toString();
            String jsonString = getUrlString(url);
            Log.i(TAG,"Received "+ url +" JSON: " + jsonString);
            JSONObject jsonBody = new JSONObject(jsonString);
            parseItems(items,jsonBody);
        } catch (IOException e) {
            Log.e(TAG,"Failed to fetch items ", e);
        } catch (JSONException e) {
            Log.e(TAG,"Failed to parse JSON ", e);
        }
        return items;
    }

    private void parseItems(List<GalleryItem> items,JSONObject jsonBody) throws JSONException {
//        JSONObject photosJsonObject = jsonBody.getJSONObject("data");
        JSONArray photoJsonArray = jsonBody.getJSONArray("data");

        for (int i = 0; i < photoJsonArray.length(); i++) {
            JSONObject photoJsonObject = photoJsonArray.getJSONObject(i);

            GalleryItem item = new GalleryItem();
            if (!photoJsonObject.has("di")) {
                continue;
            }
            item.setId(photoJsonObject.getString("di"));
            if (!photoJsonObject.has("fromPageTitleEnc")) {
                continue;
            }
            item.setCaption(photoJsonObject.getString("fromPageTitleEnc"));
            if (!photoJsonObject.has("objURL")) {
                continue;
            }
            item.setUrl(photoJsonObject.getString("objURL"));
            items.add(item);
        }
    }
}
