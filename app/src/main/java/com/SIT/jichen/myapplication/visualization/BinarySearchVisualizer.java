package com.SIT.jichen.myapplication.visualization;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;

import androidx.core.content.ContextCompat;

import com.SIT.jichen.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchVisualizer extends AlgoVisualizer {

    Paint paint; // green
    Paint highlightPaint; //light_blue
    Paint highlightTrace; //deep_blue
    Paint highlightTarget; //red
    Paint textPaint;

    int[] array;
    List<Integer> highlightPositions = new ArrayList<>();
    int tracePosition = -1;
    int targetPosition = -1;

    int lineStrokeWidth = getDimensionInPixel(10);


    public BinarySearchVisualizer(Context context) {
        super(context);
        initialise();
    }

    public BinarySearchVisualizer(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialise();
    }

    private void initialise() {
        paint = new Paint();
        paint.setColor(ContextCompat.getColor(getContext(), R.color.green));
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(lineStrokeWidth);

        highlightPaint = new Paint(paint);
        highlightPaint.setColor(ContextCompat.getColor(getContext(), R.color.light_Blue));

        highlightTrace = new Paint(paint);
        highlightTrace.setColor(ContextCompat.getColor(getContext(), R.color.deep_Blue));

        highlightTarget = new Paint(paint);
        highlightTarget.setColor(ContextCompat.getColor(getContext(), R.color.red));

        textPaint = new TextPaint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(getDimensionInPixelFromSP(12));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (array != null) {
            int numberOfLines = array.length;

            float margin = (getWidth() - (30 * numberOfLines)) / (numberOfLines + 1);

            float xPos = margin + getDimensionInPixel(10);
            for (int i = 0; i < array.length; i++) {
                if (highlightPositions.contains(i)) {
                    if (tracePosition != -1 && tracePosition == i)
                        canvas.drawLine(xPos, getHeight() - (float) ((array[i] / 110.0) * getHeight()), xPos, getHeight(), highlightTrace);
                    else if (targetPosition != -1 && targetPosition == i)
                        canvas.drawLine(xPos, getHeight() - (float) ((array[i] / 110.0) * getHeight()), xPos, getHeight(), highlightTarget);
                    else
                        canvas.drawLine(xPos, getHeight() - (float) ((array[i] / 110.0) * getHeight()), xPos, getHeight(), highlightPaint);
                }
                else {
                    if (tracePosition != -1 && tracePosition == i)
                        canvas.drawLine(xPos, getHeight() - (float) ((array[i] / 110.0) * getHeight()), xPos, getHeight(), highlightTrace);
                    else if (targetPosition != -1 && targetPosition == i)
                        canvas.drawLine(xPos, getHeight() - (float) ((array[i] / 110.0) * getHeight()), xPos, getHeight(), highlightTarget);
                    else
                        canvas.drawLine(xPos, getHeight() - (float) ((array[i] / 110.0) * getHeight()), xPos, getHeight(), paint);
                }

                canvas.drawText(String.valueOf(array[i]), xPos - lineStrokeWidth / 1.7f, getHeight() - (float) ((array[i] / 110.0) * getHeight()) - 30, textPaint);

                xPos += margin + 30;
            }
            highlightPositions.clear();
            tracePosition = -1;
        }


    }

    public void setData(int[] integers) {
        this.array = integers;
        invalidate();
    }

    public void highlight(List<Integer> positions) {
        this.highlightPositions.clear();
        this.highlightPositions.addAll(positions);
        invalidate();
    }

    public void highlightTrace(int pos) {
        this.tracePosition = pos;
        invalidate();
    }

    public void highlightTarget(int pos) {
        this.targetPosition = pos;
        invalidate();
    }

    @Override
    public void onCompleted() {

    }
}
