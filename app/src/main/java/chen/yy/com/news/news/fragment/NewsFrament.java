package chen.yy.com.news.news.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import chen.yy.com.news.R;
import chen.yy.com.news.activity.MainActivity;
import chen.yy.com.news.base.BaseFragment;
import chen.yy.com.news.news.bean.NewsBeans;
import chen.yy.com.news.news.pager.CommunityFragment;
import chen.yy.com.news.news.pager.NewsImagesPagerFragment;
import chen.yy.com.news.news.pager.NewsVotePagerFragment;
import chen.yy.com.news.utils.CacheUtils;
import chen.yy.com.news.utils.Constants;
import chen.yy.com.news.utils.InternetStateutil;

/**
 * News
 * Created by chenrongfa on 2017/3/3
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class NewsFrament extends BaseFragment {
	@BindView(R.id.tv_shop_bar)
	TextView tvTitleBar;
	@BindView(R.id.btn_toggle)
	ImageButton btnToggle;
	@BindView(R.id.fl_container_news)
	FrameLayout  frameLayout;
	private List<BaseFragment> mFragments;
	private int mPosition;//记录fragment的位置;
	private BaseFragment mFragment;//当前的fragment;
	private BaseFragment mNextFragement;//下一个;
	private FragmentManager supportFragmentManager;
	private NetStateBroadcast mNetstate;
	private NewsDetailFragmnet newsDetailFragmnet;
	private CommunityFragment newsCommunityFragmnet;
	private NewsImagesPagerFragment newsImagesFragmnet;
	private NewsVotePagerFragment newsVoteFragmnet;
	private NewsBeans newsBean;
	private ThemeDetailFragment newsThemeFragmnet;


	@Override
	protected View initView() {
		View inflate = inflater.inflate(R.layout.fragment_news, null);
		ButterKnife.bind(this, inflate);

		mNetstate=new NetStateBroadcast();
		return inflate;
	}

	private void initFragment(NewsBeans newsBean) {
		supportFragmentManager = getChildFragmentManager();
		mFragments=new ArrayList<>();
		Bundle bundle=new Bundle();
		bundle.putSerializable("news",newsBean);

		newsDetailFragmnet = new NewsDetailFragmnet();
		newsDetailFragmnet.setArguments(bundle );
		mFragments.add(newsDetailFragmnet);
		newsThemeFragmnet = new ThemeDetailFragment();
		newsThemeFragmnet.setArguments(bundle);
		mFragments.add(newsThemeFragmnet);
		newsImagesFragmnet = new NewsImagesPagerFragment();
		newsImagesFragmnet.setArguments(bundle);
		mFragments.add(newsImagesFragmnet);
		newsCommunityFragmnet = new CommunityFragment();
		newsCommunityFragmnet.setArguments(bundle);
		mFragments.add(newsCommunityFragmnet);

		newsVoteFragmnet = new NewsVotePagerFragment();
		newsVoteFragmnet.setArguments(bundle);
		mFragments.add(newsVoteFragmnet);
		mNextFragement=getFragment(mPosition);
		switchFragment (mFragment,mNextFragement);
	}

	private void switchFragment(BaseFragment mFragment, BaseFragment mNextFragement) {
		FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();

		if(mFragment!=mNextFragement){
		if(mNextFragement.isAdded()&&mNextFragement.isHidden()){
			fragmentTransaction.show(mNextFragement);

		}else{
			fragmentTransaction.add(R.id.fl_container_news,mNextFragement);
		}
			if(mFragment!=null){
				fragmentTransaction.hide(mFragment);
			}
			fragmentTransaction.commit();


	}
		this.mFragment=mNextFragement;
	}

	private BaseFragment getFragment(int mPosition) {
		BaseFragment next=null;
		if(mFragments!=null&&mFragments.size()>=mPosition){
			next=mFragments.get(mPosition);
		}
		return  next;
	}

	private static final String TAG = "NewsFrament";
	@Override
	public void bindData() {
		IntentFilter intent=new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
		getActivity().registerReceiver(mNetstate, intent);
		tvTitleBar.setText(R.string.news);
		MainActivity activity = (MainActivity) this.context;
		RequestParams url = new RequestParams(Constants.NEWSCENTER_PAGER_URL);
		x.http().get(url, new HttpRequestCall());
		LeftFrament fragmentByTag = (LeftFrament) activity.getSupportFragmentManager().findFragmentByTag(activity.LEFT_TAG);
		//leftfragment的接口回调
		fragmentByTag.getChildFragmentManager();
		fragmentByTag.setOnLeftlistener(new LeftFrament.onLeftListener() {
			@Override
			public void onItem(int position) {
				mPosition=position;
				mNextFragement=getFragment(mPosition);
				switchFragment (mFragment,mNextFragement);

			}
		});
		//网络监听
		//// TODO: 2017/3/10
		mNetstate.setOnInternetStateListener(new NetStateBroadcast.OnInternetStateListener() {
			@Override
			public void onInternetState(int state) {
				if (state == InternetStateutil.getInternetStateutil().NO_INTERNET) {
					Log.e(TAG, "onInternetState: NO_INTERNET");
					String news = CacheUtils.getInstance().get("news", "");
					if(!TextUtils.isEmpty(news)){
						NewsBeans newsBeans = parseJson(news);
						if(newsBeans!=null)
							initFragment(newsBeans);
					}
				}
			}

		});
	}



	@OnClick(R.id.btn_toggle)
	public void onClick() {
		((MainActivity)context).getSlidingMenu().toggle();
	}

	class HttpRequestCall implements Callback.CommonCallback<String> {

		@Override
		public void onSuccess(String result) {
			CacheUtils.getInstance().save("news",result);
			newsBean = parseJson(result);
			if(newsBean!=null){
				//通过eventbus发送数据
				initFragment(newsBean);
				Log.e(TAG, "onSuccess: "+newsBean );
			}


		}

		@Override
		public void onError(Throwable ex, boolean isOnCallback) {
			Log.e(TAG, "onError: "+ex.toString());
			String news = CacheUtils.getInstance().get("news", "");
			if(!TextUtils.isEmpty(news)) {
				newsBean = parseJson(news);
				if (newsBean != null) {
					//通过eventbus发送数据
					initFragment(newsBean);
					Log.e(TAG, "onSuccess: " + newsBean);
				}
			}

		}

		@Override
		public void onCancelled(CancelledException cex) {
			Log.e(TAG, "onCancelled: ");
		}

		@Override
		public void onFinished() {
			Log.e(TAG, "onFinished: ");

		}
	}

	private NewsBeans parseJson(String result) {
		NewsBeans newsBean = JSON.parseObject(result, NewsBeans.class);


		if(newsBean!=null){
			return  newsBean;
		}
	return newsBean;

	}

	/**
	 *  网络状态监听
	 */

	public static class NetStateBroadcast extends BroadcastReceiver {
		private OnInternetStateListener mOnInternetStateListener;
		@Override
		public void onReceive(Context context, Intent intent) {

			if(intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)){
				int state= InternetStateutil.getInternetStateutil().getInternetstate(context);

				if(mOnInternetStateListener!=null)
					mOnInternetStateListener.onInternetState(state);
			}

		}
		public void setOnInternetStateListener(OnInternetStateListener onInternetStateListener){
			if (onInternetStateListener!=null){
				mOnInternetStateListener=onInternetStateListener;
			}
		}
		//根据需要写接口还是其他的
		public interface OnInternetStateListener{

			void onInternetState(int state);
		}
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		getActivity().unregisterReceiver(mNetstate);
	}
}
