package chen.yy.com.news.news.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import chen.yy.com.news.base.BaseFragment;

/**
 * shopmall2
 * Created by chenrongfa on 2017/2/11
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */
public class CommunityViewPager extends FragmentPagerAdapter {
      String [] titles;
      List<BaseFragment> fragments;
      public CommunityViewPager(FragmentManager fm, String [] titles, List<BaseFragment>fragments) {
            super(fm);
            this.titles=titles;
            this.fragments=fragments;
      }



      @Override
      public Fragment getItem(int position) {
            return fragments.get(position);
      }

      @Override
      public CharSequence getPageTitle(int position) {
            return titles[position];
      }

      @Override
      public int getCount() {
            return fragments.size();
      }
}
