package chen.yy.com.news.news.pager;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import chen.yy.com.news.R;
import chen.yy.com.news.activity.NewsActivity;
import chen.yy.com.news.news.adapter.NewsListAdapter;
import chen.yy.com.news.base.BaseFragment;
import chen.yy.com.news.base.NewsPagerAdapter;
import chen.yy.com.news.news.bean.NewsPagerBean;
import chen.yy.com.news.model.GlideImageLoader;
import chen.yy.com.news.utils.CacheUtils;
import chen.yy.com.news.utils.Constants;
import chen.yy.com.news.utils.ShowTipUtils;
import chen.yy.com.news.views.RefreshListView;

/**
 * News
 * Created by chenrongfa on 2017/3/7
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class NewsDetailPagerFragment extends BaseFragment {
	private static final String TAG = "NewsDetailPagerFragment";
	private final int OK = 0;
	private final int MORE = 2;
	private final int ERROR = 1;
	Banner vpNewsTop;
	RefreshListView lvNewsDetail;
	private View inflate;
	private NewsPagerAdapter mNewsAdapter;
	private List<View> views = new ArrayList<>();
	private NewsPagerBean o;
	private int mPosition;
	private boolean isLoad = false;//是否已经加载数据
	private boolean isReload = false;//是否重载刷新
	private List<NewsPagerBean.Data.News> news;
	private String urlData;
	private boolean isReFresh;
	private boolean isReloadMore;
	private NewsListAdapter newsLIsts;
	private NewsPagerBean more;
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
				case OK:
					resolveData();
					if (!isLoad) {
						removeMessages(OK);
						sendEmptyMessageDelayed(OK, 100);
					}
					break;
				case ERROR:
					resolveLocalData();
					break;
				case MORE:
					resolveMore();
					break;


			}
		}
	};
	private int SELfMORE = 3;
	private int SELfREFRESH=4;
	private List<NewsPagerBean.Data.Topnews> topnews;

	private void resolveMore() {
		if (newsLIsts != null) {
			List<NewsPagerBean.Data.News> newsMore = more.getData().getNews();
			newsLIsts.loadMore(newsMore);
		}

	}

	/**
	 * 无网络 绑定本地数据
	 */
	private void resolveLocalData() {
		String result = CacheUtils.getInstance().get(Constants.NEWSDETAIL + mPosition, "");
		if (!TextUtils.isEmpty(result)) {
			o = CacheUtils.getInstance().parseJson(result, NewsPagerBean.class);
			resolveData();
		}
	}

	/**
	 * 绑定网络数据
	 */
	private void resolveData() {
		if (!isLoad && vpNewsTop != null) {
			resolveBanner();
			resolveList();
			isLoad = true;
		}
	}

	private void resolveList() {

		if (news == null) {
			news = o.getData().getNews();
		}
		if (newsLIsts == null) {
			newsLIsts = new NewsListAdapter(getContext(), news, R.layout.new_list_item);
			lvNewsDetail.setAdapter(newsLIsts);
		} else {
			newsLIsts.refresh(news);

		}


	}

	private void resolveBanner() {
		topnews = o.getData().getTopnews();
	if(topnews !=null) {
		String images[] = new String[topnews.size()];
		String titles[] = new String[topnews.size()];
		//图片地址
		for (int i = 0; i < topnews.size(); i++) {
			images[i] = Constants.BASE_URL + topnews.get(i).getTopimage();
		}
		//标题
		for (int i = 0; i < topnews.size(); i++) {
			titles[i] = topnews.get(i).getTitle();
		}

		vpNewsTop.setImageLoader(new GlideImageLoader());
		vpNewsTop.setImages(Arrays.asList(images));
		vpNewsTop.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);


		//设置banner动画效果
		vpNewsTop.setBannerAnimation(Transformer.DepthPage);
		//设置标题集合（当banner样式有显示title时）
		vpNewsTop.setBannerTitles(Arrays.asList(titles));
		//设置轮播时间
		vpNewsTop.setDelayTime(1500);
		//设置指示器位置（当banner模式中有指示器时）
		vpNewsTop.setIndicatorGravity(BannerConfig.CENTER);
		vpNewsTop.setOnBannerListener(new OnBannerListener() {
			@Override
			public void OnBannerClick(int position) {
				Log.e(TAG, "OnBannerClick: " + position);
				startActivity(topnews.get(position).getUrl());

			}
		});
		vpNewsTop.start();
	}
	}

	@Override
	protected View initView() {
		Log.e(TAG, "initView: ");
		inflate = inflater.inflate(R.layout.news_item, null);
		View banner = inflater.inflate(R.layout.topbanner, null);
		vpNewsTop = (Banner) banner.findViewById(R.id.vp_news_top);
		lvNewsDetail = (RefreshListView) inflate.findViewById(R.id.lv_news_detail);
		lvNewsDetail.addHeaderView(banner);
		return inflate;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void bindData() {
//// TODO: 2017/3/10
		lvNewsDetail.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				if(position>=2) {
					View view1 = (View) newsLIsts.sparseArray.get(news.get(position - 2).getId());
					if(view1==null){
						newsLIsts.sparseArray.put(news.get(position - 2).getId(),view1);
						newsLIsts.notifyDataSetChanged();
					}

					startActivity(news.get(position - 2).getUrl());
				}
			}
		});
		/**
		 *  接口回调
		 *
		 */
		lvNewsDetail.setOnLoadMoreListener(new RefreshListView.OnLoadMoreListener() {
			@Override
			public void onLoadMore() {
				isReloadMore = true;
				if (o != null) {
					String moreUrl = o.getData().getMore();
					getNetData(Constants.BASE_URL + moreUrl);
				}

			}

			@Override
			public void onRefresh() {

				//设置isload让他进入
				isLoad = false;
				//联网更新数
				isReFresh = true;
				getNetData(urlData);

			}
		});


		Log.e(TAG, "bindData: ");
	}

	private void startActivity(String url) {
		Intent intent=new Intent(getActivity(), NewsActivity.class);
		intent.putExtra(Constants.URL, Constants.BASE_URL+url);
		getActivity().startActivity(intent);
	}

	@Override
	public void init(String url, int position) {
		urlData = Constants.BASE_URL + url;
		Log.e(TAG, "init: ");
		mPosition = position;
		if (CacheUtils.getInstance().get("isLoad" + position, false) || isReload) {
			String result = CacheUtils.getInstance().get(Constants.NEWSDETAIL + mPosition, "");
			if (o == null) {
				o = CacheUtils.getInstance().parseJson(result, NewsPagerBean.class);
				if (o != null) {
					handler.sendEmptyMessage(OK);
				}
			}

		} else {
			getNetData(Constants.BASE_URL + url);

		}
	}

	private void getNetData(String url) {

		RequestParams urls = new RequestParams(url);
		x.http().get(urls, new Callback.CommonCallback<String>() {
			@Override
			public void onSuccess(String result) {
				Log.e(TAG, "onSuccess:new " + result);
				if (isReloadMore) {
					//加载更多
					more = CacheUtils.getInstance().parseJson(result, NewsPagerBean.class);
					if (more != null) {
						handler.sendEmptyMessage(MORE);
					}
				} else {
					o = CacheUtils.getInstance().parseJson(result, NewsPagerBean.class);
					//				mNewsAdapter = new NewsPagerAdapter(getContext(), o.getData().getTopnews());
					if (o != null) {
						//保存和发送数据
						CacheUtils.getInstance().save(Constants.NEWSDETAIL + mPosition, result);
						CacheUtils.getInstance().save("isLoad" + mPosition, true);
						handler.sendEmptyMessage(OK);
					}
				}
			}

			@Override
			public void onError(Throwable ex, boolean isOnCallback) {
				Log.e(TAG, "onError: sdfsdf" + ex.toString());
				handler.sendEmptyMessage(ERROR);
				setRfresh(ex);
				setLoadMore(ex);

			}

			@Override
			public void onCancelled(CancelledException cex) {
				Log.e(TAG, "onCancelled: sdf");
			}

			@Override
			public void onFinished() {
				setRfresh(null);
				setLoadMore(null);

			}
		});

	}

	private void setLoadMore(final Throwable ex) {
		new Handler() {
			@Override
			public void handleMessage(Message msg) {
				if (isReloadMore) {
					if (ex != null) {
						ShowTipUtils.Show(context, "加载失败" + ex.toString());
					} else {
						ShowTipUtils.Show(context, "加载成功");
					}
					//隐藏
					lvNewsDetail.setPadding(lvNewsDetail.getInflate1(), -lvNewsDetail.getFooster());
					isReloadMore = false;
				}
			}
		}.sendEmptyMessageDelayed(SELfMORE, 2000);
	}

	private void setRfresh(final Throwable ex) {

		new Handler() {
			@Override
			public void handleMessage(Message msg) {
				if (isReFresh) {
					if (ex != null) {
						ShowTipUtils.Show(context, "更新失败" + ex.toString());
					} else {
						ShowTipUtils.Show(context, "更新成功");
					}
					//隐藏
					lvNewsDetail.setPadding(lvNewsDetail.getInflate(), -lvNewsDetail.getHeigth());
					lvNewsDetail.setProgressBar();
					isReFresh = false;
				}
			}

		}.sendEmptyMessageDelayed(SELfREFRESH, 2000);
	}
}
