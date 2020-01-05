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

    public void setAllowUserDraggingFalse(ScrollView scrollView) {
        /*scrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    mAllowUserDragging = false;
                }
                if(event.getAction()==MotionEvent.ACTION_UP){
                    mAllowUserDragging = true;
                }

                return true;
            }
        });*/
    }


    @Override
    public boolean onTouchEvent(CoordinatorLayout parent, V child, MotionEvent event) {
        return super.onTouchEvent(parent, child, event);
    }

    @Override
   public boolean onInterceptTouchEvent(CoordinatorLayout parent, V child, MotionEvent event) {

       Log.d(TAG, "onInterceptTouchEvent: "+child);

       if (!mAllowUserDragging) {
           return false;
       }
       return super.onInterceptTouchEvent(parent, child, event);
   }
}

