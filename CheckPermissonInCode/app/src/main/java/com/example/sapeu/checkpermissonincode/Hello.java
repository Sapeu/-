package com.example.sapeu.checkpermissonincode;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by Sapeu on 2016/8/13.
 */
public class Hello {
    public static final String PERMISSON_SAY_HELLO = "com.example.sapeu.checkpermissonincode.permission.SAY_HELLO";
    public static void sayHello(Context context){
        int chheckResult = context.checkCallingOrSelfPermission(PERMISSON_SAY_HELLO);
        if(chheckResult != PackageManager.PERMISSION_GRANTED){
            throw new SecurityException("执行sayHello方法需要有com.example.sapeu.checkpermissonincode.permission.SAY_HELLO权限");
        }
        System.out.println("Hello Android!");
    }
}
