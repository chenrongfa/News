package chen.yy.com.news.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import java.util.List;

import chen.yy.com.news.base.BaseFragment;

/**
 * News
 * Created by chenrongfa on 2017/3/4
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class MainAdapter extends FragmentPagerAdapter {
	List<BaseFragment> mBaseFragments;
	FragmentManager fragmentManager;
	public MainAdapter(FragmentManager fm, List<BaseFragment> baseFragments) {
		super(fm);
		fragmentManager=fm;
		mBaseFragments=baseFragments;
	}

	@Override
	public Fragment getItem(int position) {
		return mBaseFragments.get(position);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		Log.e("11", "instantiateItem: "+container.getId());
		fragmentManager.beginTransaction().show(mBaseFragments.get(position)).commit();
		return super.instantiateItem(container, position);
	}

	@Override
	public int getCount() {
		return mBaseFragments.size();
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		fragmentManager.beginTransaction().hide(mBaseFragments.get(position)).commit();

	}
}
