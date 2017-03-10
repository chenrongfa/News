package chen.yy.com.news.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import chen.yy.com.news.R;
import chen.yy.com.news.activity.MainActivity;
import chen.yy.com.news.adapter.MainAdapter;
import chen.yy.com.news.base.BaseFragment;

import static android.content.ContentValues.TAG;

/**
 * News
 * Created by chenrongfa on 2017/3/3
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class ContentFrament extends BaseFragment {
	@BindView(R.id.vp_content)
	ViewPager vpContent;
	@BindView(R.id.btn_home)
	RadioButton btnHome;
	@BindView(R.id.btn_news)
	RadioButton btnNews;
	@BindView(R.id.btn_shop)
	RadioButton btnShop;
	@BindView(R.id.btn_shopcar)
	RadioButton btnShopcar;
	@BindView(R.id.btn_setting)
	RadioButton btnSetting;
	@BindView(R.id.gb_bar)
	RadioGroup gbBar;
	private MainAdapter mAdapter;
	private FragmentManager mFragment;
	private List<BaseFragment> mBaseFragment;
	private int mPosition; //当前fragent 的位置
	private MainActivity mMainActivity;
	private SlidingMenu slidingMenu;

	@Override
	protected View initView() {
		View inflate = inflater.inflate(R.layout.fragment_content, null);
		ButterKnife.bind(this, inflate);
		initdata();
		return inflate;
	}

	private void initdata() {
		gbBar.setOnCheckedChangeListener(new RadioGroupChangelistener());
		mBaseFragment = new ArrayList<>();
		mBaseFragment.add(new HomeFrament());
		mBaseFragment.add(new NewsFrament());
		mBaseFragment.add(new ShopFrament());
		mBaseFragment.add(new ShopCarFrament());
		mBaseFragment.add(new SettingFrament());
		mFragment = getActivity().getSupportFragmentManager();
		mAdapter = new MainAdapter(getChildFragmentManager(), mBaseFragment);

		vpContent.setAdapter(mAdapter);
		Log.e("11", "vpcontent "+vpContent.getId());
		gbBar.check(R.id.btn_home);


	}

	@Override
	public void bindData() {
		mMainActivity= (MainActivity) getActivity();
		slidingMenu = mMainActivity.getSlidingMenu();
		vpContent.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

			}

			@Override
			public void onPageSelected(int position) {
				Log.e(TAG, "onPageSelected: " );
              switchFragment(position);
			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});


	}
  public void switchFragment(int position){
	  Log.e(TAG, "switchFragment: " );
			  mPosition=position;
	  if(mPosition!=0){
		  slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
	  }else{
		  slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
	  }
	  switch (position) {
		  case 0:
			  btnHome.setChecked(true);
			  break;
		  case 1:
			  btnNews.setChecked(true);
			  LeftFrament fragmentByTag = (LeftFrament) mFragment.findFragmentByTag(mMainActivity.LEFT_TAG);
			  fragmentByTag.getLeftAdapter().setSelect(0,true);
			  break;
		  case 2:
			  btnShop.setChecked(true);
			  break;
		  case 3:
			  btnShopcar.setChecked(true);
			  break;
		  case 4:
			  gbBar.check(R.id.btn_setting);
			  break;
		  default:
			  mPosition = 0;
			  btnHome.setChecked(true);
			  break;
	  }
  }
	class RadioGroupChangelistener implements RadioGroup.OnCheckedChangeListener {
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			Log.e(TAG, "onCheckedChanged: " );
			switch (checkedId) {
				case R.id.btn_home:
					mPosition = 0;
					vpContent.setCurrentItem(mPosition);
					break;
				case R.id.btn_news:
					mPosition = 1;
					vpContent.setCurrentItem(mPosition);
					break;
				case R.id.btn_shop:
					mPosition = 2;
					vpContent.setCurrentItem(mPosition);
					break;
				case R.id.btn_shopcar:
					mPosition = 3;
					vpContent.setCurrentItem(mPosition);
					break;
				case R.id.btn_setting:
					mPosition = 4;
					vpContent.setCurrentItem(mPosition);
					break;
				default:
					mPosition = 0;
					vpContent.setCurrentItem(mPosition);
					break;


			}

		}
	}

	/**
	 *  得到当前位置
	 * @return
	 */
	public int getmPosition(){
		return mPosition;
	}

}
