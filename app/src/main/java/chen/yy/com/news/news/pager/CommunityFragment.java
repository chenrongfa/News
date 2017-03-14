package chen.yy.com.news.news.pager;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import chen.yy.com.news.R;
import chen.yy.com.news.base.BaseFragment;
import chen.yy.com.news.news.adapter.CommunityViewPager;

/**
 * shopmall2
 * Created by chenrongfa on 2017/1/19
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class CommunityFragment extends BaseFragment implements View.OnClickListener {

      private static final String TAG = "HomeFragment";
//      @BindView(R.id.ib_backToIndex)
//      ImageButton ibBackToIndex;
//      @BindView(R.id.ib_message)
//      ImageButton ibMessage;
      @BindView(R.id.tl_3)
      SegmentTabLayout tl3;
      @BindView(R.id.vp_community)
      ViewPager vpCommunity;
     private String titles[];
      private List<BaseFragment> fragments;

      @Override
      public View initView() {
            View inflate = inflater.inflate(R.layout.community_fragment, null);
            ButterKnife.bind(this, inflate);

            return inflate;
      }

      @Override
      public void bindData() {
//        super.bindData();
            initData();

      }

      private void initData() {
            titles=new String[]{"新帖","热帖"};
            fragments=new ArrayList<>();
            fragments.add(new NewDiscuss());
            fragments.add(new HotDiscuss());
            setTl();

      }
      private void setTl() {
            tl3.setTabData(titles);
            tl3.setOnTabSelectListener(new OnTabSelectListener() {
                  @Override
                  public void onTabSelect(int position) {
                        Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
                        vpCommunity.setCurrentItem(position);
                  }
                  @Override
                  public void onTabReselect(int position) {

                  }
            });
            vpCommunity.setAdapter(new CommunityViewPager(getActivity().getSupportFragmentManager()
            ,titles,fragments));
            vpCommunity.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                  @Override
                  public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                  }

                  @Override
                  public void onPageSelected(int position) {
                        tl3.setCurrentTab(position);

                  }

                  @Override
                  public void onPageScrollStateChanged(int state) {

                  }
            });

      }

    @Override
    public void onClick(View v) {

    }

    //
//      @OnClick({R.id.ib_message})
//      public void onClick(View view) {
//            Toast.makeText(context, "11", Toast.LENGTH_SHORT).show();
//
//      }


}
