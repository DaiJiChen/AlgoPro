package com.SIT.jichen.myapplication.visualization;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;

import com.SIT.jichen.myapplication.constants.Constants;

public abstract class AlgoVisualizer extends View {

    public AlgoVisualizer(Context context) {
        super(context);

    }

    public AlgoVisualizer(Context context, AttributeSet atrrs) {
        super(context, atrrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getDimensionInPixel(Constants.VISUALIZATION_WINDOW_HEIGHT));
    }

    public int getDimensionInPixel(int dp) {
        int density = getResources().getDisplayMetrics().densityDpi;

        int modifieddp = dp;
        switch (density) {
            case DisplayMetrics.DENSITY_LOW:
                modifieddp = dp - dp / 2;
                break;
            case DisplayMetrics.DENSITY_MEDIUM:
                modifieddp = dp - dp / 3;
                break;
            case DisplayMetrics.DENSITY_HIGH:
                modifieddp = dp - dp / 4;
                break;
            case DisplayMetrics.DENSITY_XHIGH:
            case DisplayMetrics.DENSITY_XXHIGH:
            case DisplayMetrics.DENSITY_XXXHIGH:
                modifieddp = dp;
                break;
            default:
                break;
        }

        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, modifieddp, getResources().getDisplayMetrics());
    }

    public int getDimensionInPixelFromSP(int sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, getResources().getDisplayMetrics());
    }

    public abstract void onCompleted();
}
