package com.example.domuscustomview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by osati.m on 12/13/2017.
 */

public class DCRadioButton extends android.support.v7.widget.AppCompatRadioButton {
    private static final String TAG = "DCButton";
    public DCRadioButton(Context context) {
        super(context);
        makeCustomFont(context , null);
    }

    public DCRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        makeCustomFont(context , attrs);
    }

    public DCRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        makeCustomFont(context , attrs);
    }

    public void makeCustomFont(Context context , AttributeSet attrs) {
        if(attrs!=null){
            TypedArray typedArray = context.obtainStyledAttributes(attrs , R.styleable.DCView);
            try {
                String path =typedArray.getString(R.styleable.DCView_font);
                Typeface typeface = CashFont.getInstance().getTypeFace(getContext() , path) ;
                Log.i(TAG, "makeCustomFont: " + typeface);
                setTypeface(typeface);
            }finally {
                invalidate();
                requestLayout();
                typedArray.recycle();
            }
        }
    }
}
