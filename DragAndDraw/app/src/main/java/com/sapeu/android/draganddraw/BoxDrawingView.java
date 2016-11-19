package com.sapeu.android.draganddraw;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Sapeu on 2016/11/20.
 */

public class BoxDrawingView extends View {

    private static final String TAG = "BoxDrawingView";

    /**
     * 当在代码中创建视图时使用
     * @param context
     */
    public BoxDrawingView(Context context) {
        super(context);
    }

    /**
     * 用于从XML创建视图
     * @param context
     * @param attrs
     */
    public BoxDrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        PointF current = new PointF(event.getX(),event.getY());
        String action = "";

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                action = "ACTION_DOWN";
                break;
            case MotionEvent.ACTION_MOVE:
                action ="ACTION_MOVE";
                break;
            case MotionEvent.ACTION_UP:
                action = "ACTION_UP";
                break;
            case MotionEvent.ACTION_CANCEL:
                action = "ACTION_CANCEL";
                break;
        }

        Log.i(TAG,action + " at x=" + current + " y=" + current.y);

        return true;
    }
}
