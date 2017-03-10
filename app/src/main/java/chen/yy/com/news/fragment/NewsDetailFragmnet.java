package chen.yy.com.news.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import chen.yy.com.news.R;
import chen.yy.com.news.activity.MainActivity;
import chen.yy.com.news.adapter.NewsDetailAdapter;
import chen.yy.com.news.base.BaseFragment;
import chen.yy.com.news.bean.NewsBeans;
import chen.yy.com.news.pager.NewsDetailPagerFragment;
import chen.yy.com.news.utils.ShowTipUtils;
import chen.yy.com.news.views.TabView;

/**
 * News
 * Created by chenrongfa on 2017/3/6
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class NewsDetailFragmnet extends BaseFragment {

	@BindView(R.id.vp_news)
	ViewPager vpNews;

	@BindView(R.id.titles)
	TabView titles;
	@BindView(R.id.iv_come)
	ImageView ivCome;

	private NewsBeans news;
	private int mPosition;//被选中的位置;
	private int width;
	private boolean isLast;
	private int lastX;
	private int offset1;
	private List<BaseFragment> newsPager;

	public NewsDetailFragmnet() {
	}

	private TextView textView;
	private static final String TAG = "NewsDetailFragmnet";


	@Override
	protected View initView() {
		//		EventBus.getDefault().register(this);
		Bundle arguments = getArguments();

		news = (NewsBeans) arguments.getSerializable("news");
		View inflate = inflater.inflate(R.layout.fragment_news_detail, null);
		ButterKnife.bind(this, inflate);
		return inflate;
	}

	@Override
	public void bindData() {
		titles.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
			@Override
			public void onGlobalLayout() {
				titles.postDelayed(new Runnable() {
					@Override
					public void run() {
						width = titles.getWidth();
						offset1 = (width / 5) / 2;
					}
				}, 1000);
			}
		});

		vpNews.setOffscreenPageLimit(12);
		List<NewsBeans.DataBean> data = news.getData();
		newsPager=new ArrayList<>();
		for (int i = 0; i < data.get(0).getChildren().size(); i++) {
					newsPager.add(new NewsDetailPagerFragment());

				}
		vpNews.setAdapter(new NewsDetailAdapter(getChildFragmentManager(), (MainActivity) getActivity(),data,newsPager));
		Log.e("11", "vpnews: " + vpNews.getId());
		titles.setTabMode(TabLayout.MODE_SCROLLABLE);
		List<NewsBeans.DataBean.ChildrenBean> children = data.get(0).getChildren();

		titles.setupWithViewPager(vpNews);

		titles.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
			@Override
			public void onTabSelected(TabLayout.Tab tab) {
				int position = tab.getPosition();
				mPosition = position;
				vpNews.setCurrentItem(mPosition);

			}

			@Override
			public void onTabUnselected(TabLayout.Tab tab) {

			}

			@Override
			public void onTabReselected(TabLayout.Tab tab) {

			}
		});
		DisplayMetrics display = new DisplayMetrics();
		((MainActivity) context).getWindowManager().getDefaultDisplay().getMetrics(display);


		titles.setOnScrollChange(new TabView.Onscroll() {
			@Override
			public void onScrollChange(int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

				//				if(!isLast){
				//					isLast=true;
				//					lastX=scrollX;
				//				}else {
				//					int dx = lastX - scrollX;
				//					Log.e(TAG, "onScrollChange:dx "+dx );
				//					Log.e(TAG, "onScrollChange: offset"+offset1 );
				//					int num = Math.abs(dx) / offset1;
				//					Log.e(TAG, "onScrollChange: num"+num );
				//					if (dx > 0) {
				//						Log.e(TAG, "onScrollChange: you" );
				//
				//						if (num > 0) {
				//							mPosition -= num;
				//							if (mPosition >= 0) {
				//								vpNews.setCurrentItem(mPosition);
				//								lastX=scrollX;
				//								isLast = false;
				//							}
				//						}
				//
				//					}else{
				//						Log.e(TAG, "onScrollChange: zuo" );
				//						if (num > 0) {
				//							mPosition += num;
				//							if (mPosition <=news.getData().get(0).getChildren().size()) {
				//
				//								vpNews.setCurrentItem(mPosition);
				//								lastX=scrollX;
				//								isLast=true;
				//							}
				//						}
				//
				//					}
				//				}
			}
		});

		vpNews.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


			}

			@Override
			public void onPageSelected(int position) {
				Log.e(TAG, "onPageSelected: ");
				mPosition = position;
				TabLayout.Tab tabAt = titles.getTabAt(mPosition);
				if (!tabAt.isSelected()) {
					tabAt.select();
				}
			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});


	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		//		EventBus.getDefault().unregister(this);
	}
  @OnClick(R.id.iv_come)
	public void Click(View view){
	  if(mPosition<news.getData().get(0).getChildren().size()){
		  mPosition++;
		  vpNews.setCurrentItem(mPosition);
	  }else{
		  ShowTipUtils.Show(context,"你应经点完了");
	  }

  }


}
