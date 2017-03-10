package chen.yy.com.news.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * News
 * Created by chenrongfa on 2017/3/7
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public abstract class BaseViewPager {
	public Context context;
	public LayoutInflater inflater;
	public FrameLayout frameLayout;

	public BaseViewPager(Context context){
		this.context=context;
		inflater=LayoutInflater.from(context);
		frameLayout=new FrameLayout(context);
		ViewGroup.LayoutParams param=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
		frameLayout.setLayoutParams(param);
	}
	public abstract void init(String url);
}
