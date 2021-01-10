package com.SIT.jichen.myapplication.visualization;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;

import androidx.core.content.ContextCompat;

import com.SIT.jichen.myapplication.R;

public class SortingVisualizer extends AlgoVisualizer {

    Paint paint;
    Paint highlightPaintSwap;
    Paint highlightPaintTrace;
    Paint highlightPaintFound;
    Paint textPaint;
    int[] array;

    int swapPositionOne = -1, swapPositionTwo = -1;
    int tracePosition = -1;
    int foundPosition = -1;
    int lineStrokeWidth = getDimensionInPixel(20);

    public SortingVisualizer(Context context) {
        super(context);
        initialise();
    }

    public SortingVisualizer(Context context, AttributeSet atrrs) {
        super(context, atrrs);
        initialise();
    }

    private void initialise() {
        paint = new Paint();
        paint.setColor(ContextCompat.getColor(getContext(), R.color.green));
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(lineStrokeWidth);

        highlightPaintSwap = new Paint(paint);
        highlightPaintSwap.setColor(ContextCompat.getColor(getContext(), R.color.red));

        highlightPaintTrace = new Paint(paint);
        highlightPaintTrace.setColor(ContextCompat.getColor(getContext(), R.color.light_Blue));

        highlightPaintFound = new Paint(paint);
        highlightPaintFound.setColor(ContextCompat.getColor(getContext(), R.color.deep_Blue));

        textPaint = new TextPaint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(getDimensionInPixelFromSP(15));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (array != null) {
            int numberOfLines = array.length;

            float margin = (getWidth() - (30 * numberOfLines)) / (numberOfLines + 1);

            float xPos = margin + getDimensionInPixel(10);
            for (int i = 0; i < array.length; i++) {

                if (i == swapPositionOne || i == swapPositionTwo) {
                    canvas.drawLine(xPos, getHeight() - (float) ((array[i] / 10.0) * getHeight()), xPos, getHeight(), highlightPaintSwap);
                } else if (i == foundPosition)
                    canvas.drawLine(xPos, getHeight() - (float) ((array[i] / 10.0) * getHeight()), xPos, getHeight(), highlightPaintFound);
                else if (i == tracePosition)
                    canvas.drawLine(xPos, getHeight() - (float) ((array[i] / 10.0) * getHeight()), xPos, getHeight(), highlightPaintTrace);
                else {
                    canvas.drawLine(xPos, getHeight() - (float) ((array[i] / 10.0) * getHeight()), xPos, getHeight(), paint);
                }

                canvas.drawText(String.valueOf(array[i]), xPos - lineStrokeWidth / 3, getHeight() - (float) ((array[i] / 10.0) * getHeight()) - 30, textPaint);

                xPos += margin + 30;
            }
            swapPositionOne = -1;
            swapPositionTwo = -1;
        }


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setData(int[] integers) {
        this.array = integers;
        invalidate();
    }

    public void highlightSwap(int one, int two) {
        this.swapPositionOne = one;
        this.swapPositionTwo = two;
        invalidate();
    }

    public void highlightTrace(int position) {
        this.tracePosition = position;
        invalidate();
    }

    public void highlightFound(int position) {
        this.foundPosition = position;
        invalidate();
    }

    @Override
    public void onCompleted() {
        this.tracePosition = -1;
        this.swapPositionTwo = -1;
        this.swapPositionOne = -1;
        this.foundPosition = -1;
        invalidate();
    }
}
