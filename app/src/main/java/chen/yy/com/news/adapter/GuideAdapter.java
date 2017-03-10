package chen.yy.com.news.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import chen.yy.com.news.activity.GuideActivity;

/**
 * News
 * Created by chenrongfa on 2017/3/3
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class GuideAdapter extends PagerAdapter {
	private Context mContext;
	private String mTitle[];
	private int mImages[];
	public GuideAdapter(GuideActivity guideActivity, String[] title, int[] images) {
		this.mContext=guideActivity;
		this.mImages=images;
		mTitle=title;

	}

	@Override
	public int getCount() {
		return mTitle.length;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
//		super.destroyItem(container, position, object);

	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		ImageView imageView=new ImageView(mContext);
		imageView.setBackgroundResource(mImages[position]);
		container.addView(imageView);
		return imageView;
	}



	@Override
	public CharSequence getPageTitle(int position) {
		return mTitle[position];
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view==object;
	}
}
