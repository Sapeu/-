package com.sapeu.android.criminalintent;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

/**
 * Created by Sapeu on 2016/9/17.
 */
public class PictureUtils {
    public static Bitmap getScaledBitmap(String path, int desWidth, int desHeight){
        // 读取磁盘上的图像的尺寸
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path,options);

        float srcWidth = options.outWidth;
        float srcHeight = options.outHeight;

        // 计算出需要降低多少比例 >
        int inSampleSize = 1;
        if (srcHeight > desHeight || srcWidth > desWidth){
            if (srcWidth > desHeight){
                inSampleSize = Math.round(srcHeight / desHeight);
            } else {
                inSampleSize = Math.round(srcWidth / desWidth);
            }
        }

        options = new BitmapFactory.Options();
        options.inSampleSize = inSampleSize;

        // 读取图像并生成适合的图像
        return BitmapFactory.decodeFile(path,options);
    }

    public static Bitmap getScaledBitmap(String path, Activity activity){
        Point size = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(size);
        return getScaledBitmap(path,size.x,size.y);
    }
}
