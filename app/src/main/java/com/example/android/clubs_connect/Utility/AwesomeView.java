package com.example.android.clubs_connect.Utility;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by aaron on 3/3/2018.
 */

public class AwesomeView extends View {
    private static final float ARBITRARY_CONSTANT = 88.f;

    private static final float MIN_SIZE_DEFAULT = 50;

    //tracks current apt bytes
    private byte[] mBytes;

    @ColorInt
    private int backgroundColor;

    public AwesomeView(Context context, AttributeSet attrs){
        super(context, attrs);
        mBytes = null;

    }

}
