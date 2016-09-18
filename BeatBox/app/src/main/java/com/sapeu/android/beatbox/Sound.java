package com.sapeu.android.beatbox;

/**
 * Created by Sapeu on 2016/9/19.
 */
public class Sound {
    private String mAssetPath;
    private String mName;

    public Sound(String assetPath){
        mAssetPath = assetPath;
        String[] components = assetPath.split("/");
        String fileNanme = components[components.length - 1];
        mName = fileNanme.replace(".wav","");
    }

    public String getAssetPath() {
        return mAssetPath;
    }

    public String getName() {
        return mName;
    }
}
