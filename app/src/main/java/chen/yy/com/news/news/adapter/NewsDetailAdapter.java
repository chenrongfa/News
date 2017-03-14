package chen.yy.com.news.news.adapter;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import java.util.List;

import chen.yy.com.news.activity.MainActivity;
import chen.yy.com.news.base.BaseFragment;
import chen.yy.com.news.news.bean.NewsBeans;

/**
 * News
 * Created by chenrongfa on 2017/3/3
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class NewsDetailAdapter extends FragmentStatePagerAdapter {
	private static final String TAG = "NewsDetailPagerFragment";
	int count;
	private Context mContext;
	private List<BaseFragment> newsPager;
	private List<NewsBeans.DataBean.ChildrenBean> dataBeen;
	private FragmentManager fragmentManager;

	public NewsDetailAdapter(FragmentManager fragmentManager, MainActivity guideActivity, List<NewsBeans.DataBean> dataBeen,List<BaseFragment> newsPager) {
		super(fragmentManager);
		Log.e(TAG, "NewsDetailAdapter: ");
		this.fragmentManager = fragmentManager;
		this.mContext = guideActivity;
		this.dataBeen = dataBeen.get(0).getChildren();
		this.newsPager=newsPager;
//		newsPager = new ArrayList<>();
//		for (int i = 0; i < this.dataBeen.size(); i++) {
//			newsPager.add(new NewsDetailPagerFragment());
//
//		}
	}

	@Override
	public int getCount() {

		return dataBeen.size();
	}

	@Override
	public Fragment getItem(int position) {
		Log.e(TAG, "getItem: 1" + (++count));

		return newsPager.get(position);
	}

	@Override
	public int getItemPosition(Object object) {
		Log.e(TAG, "getItemPosition: " );
		return POSITION_NONE;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return dataBeen.get(position).getTitle();
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		Log.e(TAG, "instantiateItem: " );
		newsPager.get(position).init(dataBeen.get(position).getUrl(), position);
		fragmentManager.beginTransaction().show(newsPager.get(position)).commit();
		return super.instantiateItem(container, position);
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		Log.e(TAG, "destroyItem: " );
		fragmentManager.beginTransaction().hide(newsPager.get(position)).commit();
	}

	@Override
	public void restoreState(Parcelable state, ClassLoader loader) {
		Log.e(TAG, "restoreState: " );
		super.restoreState(state, loader);
	}

	@Override
	public Parcelable saveState() {
		Log.e(TAG, "saveState: " );
		return super.saveState();
	}
}
