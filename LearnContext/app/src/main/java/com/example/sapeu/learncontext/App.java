package com.example.sapeu.learncontext;

import android.app.Application;
import android.content.res.Configuration;

/**
 * Created by Sapeu on 2016/8/7.
 */
public class App extends Application {
    private String textData = "default";

    public String getTextData() {
        return textData;
    }

    public void setTextData(String textData) {
        this.textData = textData;
    }

    @Override
    public String toString() {
        return "App{" +
                "textData='" + textData + '\'' +
                '}';
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("App创建时onCreate");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        System.out.println("App结束时onTerminate");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        System.out.println("App在低内存时执行onLowMemory");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        System.out.println("程序在执行内存清理App时执行onTrimMemory");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        System.out.println("App配置发生改变时执行onConfigurationChanged");
    }
}
