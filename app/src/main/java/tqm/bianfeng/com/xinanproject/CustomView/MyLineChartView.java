package tqm.bianfeng.com.xinanproject.CustomView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;

import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.renderer.LineChartRenderer;
import lecho.lib.hellocharts.view.LineChartView;

/**
 * Created by johe on 2017/4/19.
 */

public class MyLineChartView extends LineChartView {
    public MyLineChartView(Context context) {
        this(context, null, 0);
    }

    public MyLineChartView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyLineChartView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setChartRenderer(new LineChartRenderer(context, this, this));
        setLineChartData(LineChartData.generateDummyData());
    }

    float startX;
    float startY;

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_UP: {
                Log.i("gqf","ACTION_UP"+event.getX());
                startX=0;
                startY=0;
            }
            break;
            case MotionEvent.ACTION_DOWN: {
                startX=event.getX();
                startY=event.getY();
            }
            break;
            case MotionEvent.ACTION_MOVE: {
                Log.i("gqf","ACTION_MOVE"+(startX-event.getX()));
                if(Math.abs(startX-event.getX())>=Math.abs(startY-event.getY())){
                    this.getParent().requestDisallowInterceptTouchEvent(true);
                }
            }
            break;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
    }


}
