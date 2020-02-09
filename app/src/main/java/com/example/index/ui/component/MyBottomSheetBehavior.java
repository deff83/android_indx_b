package com.example.index.ui.component;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MyBottomSheetBehavior<V extends View> extends BottomSheetBehavior<V> {

    private static final String TAG = "MyBottomSheetBehavior";

   private boolean mAllowUserDragging = true;

   public MyBottomSheetBehavior() {
       super();
   }
   public MyBottomSheetBehavior(Context context, AttributeSet attrs) {
       super(context, attrs);
   }




    @Override
    public boolean onTouchEvent(CoordinatorLayout parent, V child, MotionEvent event) {
        Log.d(TAG, "onTouchEvent: "+super.onTouchEvent(parent, child, event));
        return super.onTouchEvent(parent, child, event);
    }

    @Override
   public boolean onInterceptTouchEvent(CoordinatorLayout parent, V child, MotionEvent event) {

       Log.d(TAG, "onInterceptTouchEvent: "+super.onInterceptTouchEvent(parent, child, event)+" + " + event.getAction());

       /*
        2020-02-10 00:20:01.704 6987-6987/com.example.index D/MyBottomSheetBehavior: onInterceptTouchEvent: false + 3
        2020-02-10 00:20:01.704 6987-6987/com.example.index D/MyBottomSheetBehavior: onInterceptTouchEvent: false + 0
        2020-02-10 00:20:01.784 6987-6987/com.example.index D/MyBottomSheetBehavior: onInterceptTouchEvent: true + 2
        return false;
        */
       return false;
   }
}

