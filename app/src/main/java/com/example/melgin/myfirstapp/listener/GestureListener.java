package com.example.melgin.myfirstapp.listener;

import android.view.GestureDetector;
import android.view.MotionEvent;

import com.example.melgin.myfirstapp.util.LoggerUtil;

/**
 * Created by melgin on 22/12/2016.
 */

public class GestureListener extends GestureDetector.SimpleOnGestureListener
{

    private static final LoggerUtil logger = LoggerUtil.getInstance();
    static String currentGestureDetected;

    // Override s all the callback methods of GestureDetector.SimpleOnGestureListener
    @Override
    public boolean onSingleTapUp(MotionEvent ev) {
        currentGestureDetected=ev.toString();
        logger.log("User performed single tap up " + ev.toString());

        return super.onSingleTapUp(ev);
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        logger.log("User performed double tap up " + e.toString());

        return super.onDoubleTap(e);
    }

    @Override
    public void onShowPress(MotionEvent ev) {
        currentGestureDetected=ev.toString();
        logger.log("User performed show press " + ev.toString());

    }
    @Override
    public void onLongPress(MotionEvent ev) {
        currentGestureDetected=ev.toString();
        logger.log("User performed long press " + ev.toString());

    }
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        StringBuilder sb = new StringBuilder();

        if(e1 != null){
            sb.append(e1.toString()+ "  ");
        }

        if(e2 != null){
            sb.append(e2.toString());
        }

        currentGestureDetected=sb.toString().trim();
        logger.log("User performed scroll " + sb.toString().trim());

        return super.onScroll(e1, e2, distanceX, distanceY);
    }


    @Override
    public boolean onDown(MotionEvent ev) {
        currentGestureDetected=ev.toString();
        logger.log("User performed down " + ev.toString());
        return super.onDown(ev);
    }
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        StringBuilder sb = new StringBuilder();

        if(e1 != null){
            sb.append(e1.toString()+ "  ");
        }

        if(e2 != null){
            sb.append(e2.toString());
        }

        currentGestureDetected=sb.toString().trim();
        logger.log("User performed fling " + sb.toString().trim());
        return super.onFling(e1, e2, velocityX, velocityY);
    }
}
