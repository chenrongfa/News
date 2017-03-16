package chen.yy.com.news.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.GridView;

/**
 * News
 * Created by chenrongfa on 2017/3/14
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class ScrollGridView extends GridView {
	public ScrollGridView(Context context) {
		super(context);
	}

	public ScrollGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ScrollGridView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
//		switch (ev.getAction()){
//			case MotionEvent.ACTION_DOWN:
				getParent().requestDisallowInterceptTouchEvent(true);
//				break;
//			case MotionEvent.ACTION_MOVE:
//				getParent().requestDisallowInterceptTouchEvent(true);
//				break;case MotionEvent.ACTION_UP:
//				getParent().requestDisallowInterceptTouchEvent(true);
//				break;
//		}
//

		return super.onTouchEvent(ev);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		getParent().requestDisallowInterceptTouchEvent(true);
		return super.onInterceptTouchEvent(ev);
	}
}
