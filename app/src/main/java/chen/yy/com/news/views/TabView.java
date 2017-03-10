package chen.yy.com.news.views;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;

/**
 * News
 * Created by chenrongfa on 2017/3/7
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class TabView extends TabLayout {
	private Onscroll onscroll;
  private Context context;
	public TabView(Context context) {
		this(context,null);
	}

	public TabView(Context context, AttributeSet attrs) {
		this(context, attrs,0);
		this.context=context;
	}

	public TabView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}



	public void setOnScrollChange(Onscroll onscroll){
		if (onscroll!=null){
			this.onscroll=onscroll;
		}
	}

	private static final String TAG = "TabView";
	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {


				if (onscroll!=null){
					onscroll.onScrollChange( l,  t, oldl, oldt);
				}
		super.onScrollChanged(l, t, oldl, oldt);
	}


	//	@Override
//	public void onScrollChanged() {
//		Log.e(TAG, "onScrollChange: ");
//		if (onscroll!=null){
//			onscroll.onScrollChange( getScrollX(),  0, 0, 0);
//		}
//	}

	public interface  Onscroll{
		void onScrollChange(int scrollX, int scrollY, int oldScrollX, int oldScrollY);
	}
}
