package tqm.bianfeng.com.xinanproject.CustomView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

/**
 * Created by johe on 2017/4/20.
 */

public class MyHScrollView  extends HorizontalScrollView{

    public MyHScrollView(Context context) {
        super(context);
    }

    public MyHScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyHScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    float startX;
    float startY;

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_UP: {
                //Log.i("gqf","ACTION_UP"+event.getX());
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
               // Log.i("gqf","ACTION_MOVE"+(startX-event.getX()));
                if(Math.abs(startX-event.getX())>=Math.abs(startY-event.getY()/2)){
                    this.getParent().requestDisallowInterceptTouchEvent(true);
                    this.getParent().getParent().requestDisallowInterceptTouchEvent(true);
                }
            }
            break;
        }
        return super.dispatchTouchEvent(event);
    }


}
