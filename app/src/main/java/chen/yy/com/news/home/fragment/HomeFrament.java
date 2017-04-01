package chen.yy.com.news.home.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import chen.yy.com.news.R;
import chen.yy.com.news.activity.MainActivity;
import chen.yy.com.news.base.BaseFragment;
import chen.yy.com.news.home.adapter.HomeDetailAdapter;
import chen.yy.com.news.home.bean.HomeTabBean;
import chen.yy.com.news.home.pager.ArtPagerFragment;
import chen.yy.com.news.home.pager.ChannelPagerFragment;
import chen.yy.com.news.home.pager.CullingPagerFragment;
import chen.yy.com.news.home.pager.FinancePagerFragment;
import chen.yy.com.news.home.pager.GymPagerFragment;
import chen.yy.com.news.home.pager.InformationPagerFragment;
import chen.yy.com.news.home.pager.LivePagerFragment;
import chen.yy.com.news.home.pager.NpcPagerFragment;
import chen.yy.com.news.home.pager.PlayPagerFragment;
import chen.yy.com.news.home.pager.SlowLivePagerFragment;
import chen.yy.com.news.utils.CacheUtils;
import chen.yy.com.news.utils.Constants;
import chen.yy.com.news.utils.ShowTipUtils;
import chen.yy.com.news.utils.ViewPagertranform;
import chen.yy.com.news.views.TabView;
import okhttp3.Call;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * News
 * Created by chenrongfa on 2017/3/3
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class HomeFrament extends BaseFragment {


	@BindView(R.id.titles)
	TabView titles;
	@BindView(R.id.iv_come)
	ImageView ivCome;
	@BindView(R.id.vp_news)
	ViewPager vpNews;
	private View inflate;
	private HomeTabBean homeTab;
	private List<BaseFragment> baseFragments;
	private int mPosition;
	private SlidingMenu slidingMenu;

	@Override
	protected View initView() {
		inflate = inflater.inflate(R.layout.fragment_home_detail, null);
		ButterKnife.bind(this, inflate);
		// 设置是否能滚动,其他属性不能使style渲染有效
		titles.setTabMode(TabLayout.MODE_SCROLLABLE);
		titles.setupWithViewPager(vpNews);
		//设置动画
		vpNews.setPageTransformer(true,new ViewPagertranform());
		getInternetData();
		return inflate;
	}

	private void initFragment() {
		baseFragments=new ArrayList<>();
			for (int i=0;i<homeTab.getChannellist().size();i++){
				baseFragments.add(new CullingPagerFragment());
				baseFragments.add(new NpcPagerFragment());
				baseFragments.add(new InformationPagerFragment());
				baseFragments.add(new ArtPagerFragment());
				baseFragments.add(new PlayPagerFragment());
				baseFragments.add(new FinancePagerFragment());
				baseFragments.add(new ChannelPagerFragment());
				baseFragments.add(new GymPagerFragment());
				baseFragments.add(new SlowLivePagerFragment());
				baseFragments.add(new LivePagerFragment());

			}
	}

	private void getInternetData() {
		OkHttpUtils.get().
				url(Constants.HOME_TAB_URL).
				tag(this)
				.build().
				execute(new StringResult());
	}

	@Override
	public void bindData() {
		slidingMenu = ((MainActivity)getActivity()).getSlidingMenu();
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
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
				if(slidingMenu==null)
					slidingMenu = ((MainActivity)getActivity()).getSlidingMenu();
				if(mPosition==0){
					slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
				}else{
					slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
				}
			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});


	}



	class StringResult extends StringCallback{

			@Override
			public void onError(Call call, Exception e, int i) {
				ShowTipUtils.Show(getActivity(),e.toString());
				String result = CacheUtils.getInstance().get(Constants.HOMETAB, "");
				if(!TextUtils.isEmpty(result)){
					homeTab = CacheUtils.getInstance().parseJson(result, HomeTabBean.class);
					resolveTab();
				}
			}

			@Override
			public void onResponse(String s, int i) {
				homeTab = CacheUtils.getInstance().parseJson(s, HomeTabBean.class);
				Log.d(TAG, "onResponse() called with: s = [" + s + "], i = [" + i + "]"+ homeTab.toString());
				//缓存
				CacheUtils.getInstance().save(Constants.HOMETAB,s);
				resolveTab();


			}
		}

	private void resolveTab() {
		if(homeTab!=null){
			initFragment();
			vpNews.setAdapter(new HomeDetailAdapter(getChildFragmentManager(),
					getActivity(),homeTab,baseFragments));

		}
	}
	@OnClick(R.id.iv_come)
	public void Click(View view){
		if(mPosition<homeTab.getChannellist().size()){
			mPosition++;
			vpNews.setCurrentItem(mPosition);
		}else{
			ShowTipUtils.Show(context,"你应经点完了");
		}
	}
}
