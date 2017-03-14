package chen.yy.com.news.base;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.xutils.x;

import java.util.List;

import chen.yy.com.news.R;
import chen.yy.com.news.news.bean.NewsPagerBean;
import chen.yy.com.news.utils.Constants;

import static android.content.ContentValues.TAG;


/**
 * News
 * Created by chenrongfa on 2017/3/7
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class NewsPagerAdapter extends PagerAdapter {
	Context context;
	List<NewsPagerBean.Data.Topnews> topnews;
	public NewsPagerAdapter(Context context, List<NewsPagerBean.Data.Topnews> topnews) {
	this.topnews=topnews;
		this.context=context;
	}

	@Override
	public int getCount() {
		return topnews.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view==object;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		Log.e(TAG, "instantiateItem: laile" );
		ImageView imageView=new ImageView(context);
		imageView.setImageResource(R.drawable.news_pic_default);
		x.image().bind(imageView, Constants.BASE_URL+topnews.get(position).getUrl());
		container.addView(container);
		return imageView;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(container.getChildAt(position));
	}
}
