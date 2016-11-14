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
    private static final String FETCH_RECENTS_METHOD = "";
    private static final String SEARCH_METHOD = "";
    private static final String DEFAULT_WORD = "表情";
    private static final Uri ENDPOINT = Uri
            .parse("http://image.baidu.com/search/acjson")
            .buildUpon()
            .appendQueryParameter("tn", "resultjson")
            .appendQueryParameter("ie", "utf-8")
            .appendQueryParameter("oe", "utf-8")
            .appendQueryParameter("width", "")
            .appendQueryParameter("height", "")
            .appendQueryParameter("istype", "")
            .appendQueryParameter("cg", "wallpaper")
            .appendQueryParameter("pn", "1") // 第几页
            .appendQueryParameter("rn", "66") // 一页中的数量
            .appendQueryParameter("ipn", "rj")
            .appendQueryParameter("word", DEFAULT_WORD)
            .build();

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
                out.write(buffer, 0, bytesRead);
            }

            out.close();
            return out.toByteArray();

        } finally {
            connection.disconnect();
        }
    }

    public String getUrlString(String urlSpec) throws IOException {
        return new String(getUrlBytes(urlSpec));
    }

    /**
     * 默认的表情链接
     *
     * @return 返回搜索出来的表情对象集合
     */
    public List<GalleryItem> fetchRecentPhotots() {
//        String url = buildUrl(FETCH_RECENTS_METHOD,null);
        String url = buildUrl(null);
        return downloadGalleryItems(url);
    }

    /**
     * 搜索表情链接
     *
     * @param query 搜索关键字
     * @return 返回搜索出来的表情对象集合
     */
    public List<GalleryItem> searchPhotos(String query) {
//        String url = buildUrl(SEARCH_METHOD,query);
        String url = buildUrl(query);
        return downloadGalleryItems(url);
    }

    //    public List<GalleryItem> fetchItems(){
    public List<GalleryItem> downloadGalleryItems(String url) {

        List<GalleryItem> items = new ArrayList<>();

        try {
            /*String url = Uri.parse("http://image.baidu.com/search/acjson")
                    .buildUpon()
                    .appendQueryParameter("tn","resultjson")
                    .appendQueryParameter("ie","utf-8")
                    .appendQueryParameter("oe","utf-8")
                    .appendQueryParameter("width","")
                    .appendQueryParameter("height","")
                    .appendQueryParameter("istype","")
                    .appendQueryParameter("cg","wallpaper")
                    .appendQueryParameter("pn","1") // 第几页
                    .appendQueryParameter("rn","100") // 一页中的数量
                    .appendQueryParameter("ipn","rj")
                    .appendQueryParameter("word","逗比表情")
                    .build().toString();*/
            String jsonString = getUrlString(url);
            Log.i(TAG, "Received " + url + " JSON: " + jsonString);
            JSONObject jsonBody = new JSONObject(jsonString);
            parseItems(items, jsonBody);
            Log.i(TAG, items.toString());
        } catch (IOException e) {
            Log.e(TAG, "Failed to fetch items ", e);
        } catch (JSONException e) {
            Log.e(TAG, "Failed to parse JSON ", e);
        }
        return items;
    }

    /**
     * 根据关键字构建搜索链接
     *
     * @param query 搜索关键字
     * @return 搜索链接
     */
//    private String buildUrl(String method, String query) {
    private String buildUrl(String query) {
        Uri.Builder uriBuilder = ENDPOINT.buildUpon();
//                .appendQueryParameter("method", method);

//        if (method.equals(SEARCH_METHOD)) {
        if (query != null) {
//            uriBuilder.appendQueryParameter("text",query);
            uriBuilder.appendQueryParameter("word", query + DEFAULT_WORD);
        }

        return uriBuilder.build().toString();
    }

    /**
     * 解析JSON 到 items
     *
     * @param items    图片对象集合
     * @param jsonBody 示例化后的json对象
     * @throws JSONException json异常
     */
    private void parseItems(List<GalleryItem> items, JSONObject jsonBody) throws JSONException {
//        JSONObject photosJsonObject = jsonBody.getJSONObject("data");
        JSONArray photoJsonArray = jsonBody.getJSONArray("data");

        for (int i = 0; i < photoJsonArray.length(); i++) {
            JSONObject photoJsonObject = photoJsonArray.getJSONObject(i);

            GalleryItem item = new GalleryItem();
            if (!photoJsonObject.has("di") || !photoJsonObject.has("objURL") || !photoJsonObject.has("fromPageTitleEnc")) {
                continue;
            }
            item.setId(photoJsonObject.getString("di"));
            item.setCaption(photoJsonObject.getString("fromPageTitleEnc"));
            item.setUrl(photoJsonObject.getString("objURL"));
            items.add(item);
        }
    }
}
