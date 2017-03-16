package chen.yy.com.news.home.adapter;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import java.util.List;

import chen.yy.com.news.base.BaseFragment;
import chen.yy.com.news.home.bean.HomeTabBean;

/**
 * News
 * Created by chenrongfa on 2017/3/3
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class HomeDetailAdapter extends FragmentStatePagerAdapter {
	private static final String TAG = "NewsDetailPagerFragment";
	int count;
	private Context mContext;
	private List<BaseFragment> newsPager;
private List<HomeTabBean.ChannellistBean> channellistBean;
	private FragmentManager fragmentManager;

	public HomeDetailAdapter(FragmentManager fragmentManager, Context guideActivity,HomeTabBean dataBeen, List<BaseFragment> newsPager) {
		super(fragmentManager);
		Log.e(TAG, "NewsDetailAdapter: ");
		this.fragmentManager = fragmentManager;
		this.mContext = guideActivity;
		this.newsPager=newsPager;
		channellistBean=dataBeen.getChannellist();


//		}
	}

	@Override
	public int getCount() {

	return  channellistBean.size();
	}

	@Override
	public Fragment getItem(int position) {
		return newsPager.get(position);
	}

	@Override
	public int getItemPosition(Object object) {

		return POSITION_NONE;
	}

	@Override
	public CharSequence getPageTitle(int position) {
//		return dataBeen.get(position).getTitle();
		return channellistBean.get(position).getChlname();
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {

		fragmentManager.beginTransaction().show(newsPager.get(position)).commit();
		return super.instantiateItem(container, position);
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {

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
