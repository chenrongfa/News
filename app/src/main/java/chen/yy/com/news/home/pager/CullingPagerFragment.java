package chen.yy.com.news.home.pager;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jingchen.pulltorefresh.PullToRefreshLayout;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import chen.yy.com.news.R;
import chen.yy.com.news.activity.NewsActivity;
import chen.yy.com.news.base.BaseFragment;
import chen.yy.com.news.home.adapter.CullingAdapter;
import chen.yy.com.news.home.bean.CullingBean;
import chen.yy.com.news.home.bean.CullingMoreBean;
import chen.yy.com.news.utils.CacheUtils;
import chen.yy.com.news.utils.Constants;
import chen.yy.com.news.utils.ShowTipUtils;
import okhttp3.Call;

/**
 * News
 * Created by chenrongfa on 2017/3/16
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class CullingPagerFragment extends BaseFragment {

	private PullToRefreshLayout viewById;
	private View inflate;
	private ListView lvCulling;

	private CullingBean culling1;
	private List<CullingBean.IdlistBean.NewslistBean> newslist;
	private boolean isFresh;
	private CullingAdapter adapter;
	private boolean isLoadMore;
	private CullingMoreBean more;


	@Override
	protected View initView() {
		inflate = inflater.inflate(R.layout.news_theme_item, null);

		viewById = (PullToRefreshLayout) inflate.findViewById(R.id.refresh_view);

		lvCulling = (ListView) viewById.getPullableView();
		lvCulling.setDivider(null);
		getInternetData(Constants.CULLING_URL);
		return inflate;
	}

	@Override
	public void bindData() {
		super.bindData();
		lvCulling.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent inent=new Intent(getActivity(), NewsActivity.class);
				inent.putExtra(Constants.URL,newslist.get(position).getSurl());
				inent.putExtra(Constants.IMAGES_URL,newslist.get(position).getThumbnails().get(0));
				startActivity(inent);
			}
		});
		viewById.setOnPullListener(new PullToRefreshLayout.OnPullListener() {
			@Override
			public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
				isFresh =true;
				getInternetData(Constants.CULLING_URL);
			}

			@Override
			public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
					OkHttpUtils.get().url("http://r.inews.qq.com/getLiveNewsListItems?uid=1079045003815164&omgbizid=b599a66a49a0064403f95aaff2d37742ff3a005021220e&Cookie=lskey%3D%3Bluin%3D%3Bskey%3D%3Buin%3D%3B%20logintype%3D0%3B%20&network_type=wifi&store=274&hw=samsung_GT-P5210&qn-sig=6d670f99e66ee98340cd345f84474690&orig_store=274&activefrom=icon&mac=08%253A00%253A27%253A2f%253Afe%253Ae0&chlid=news_live_main&origin_imei=133524148602062&qqnetwork=wifi&real_device_width=10.0&imsi_history=460000907341152&sceneid=&dpi=192&apptype=android&qn-rid=965a6e3e-ade1-4ec2-9d2f-0b0042a4efa0&devid=133524148602062&ids=ZLV2017021903254100%2CZLV2017021901708100%2CZLV2017021705556400%2CZLV2017021705246200%2CZLV2017021901024700%2CZLV2017021702120500%2CZLV2017021703653800%2CZLV2017021703308200%2CZLV2017021604034900%2CZLV2017021603942200%2CZLV2017021100805900%2CZLV2017020903474600%2CZLV2017021200386900%2CZLV2017020802124600%2CZLV2017020800772600%2CZLV2017020800927800%2CZLV2017020701763600%2CZLV2017020901398500%2CZLV2017020903296400%2CZLV2017020803238500&screen_width=720&real_device_height=17.78&appver=17_android_5.3.21&is_chinamobile_oem=0&patchver=5321&mid=6af1498824155aa543fd9ea70c7efb9b529a2740&imsi=460000907341152&omgid=b14b2840ece01749bd18b65734ffcae5f48a0010211511&isoem=0&screen_height=1280")
							.build().execute(new StringCallback() {
						@Override
						public void onError(Call call, Exception e, int i) {
							Log.e(TAG, "onError: " +e.toString());
							viewById.loadmoreFinish(PullToRefreshLayout.FAIL);
						}

						@Override
						public void onResponse(String s, int i) {
							viewById.loadmoreFinish(PullToRefreshLayout.SUCCEED);

							more = CacheUtils.getInstance().parseJson(s,CullingMoreBean.class);
							isLoadMore=true;
							resolveTab();
							Log.e(TAG, "onResponse: more"+more );
						}
					});
			}
		});

	}
	private void getInternetData(String url) {
		OkHttpUtils.get().
				url(url).
				tag(this)
				.build().
				execute(new StringResult());
	}
	class StringResult extends StringCallback {

		@Override
		public void onError(Call call, Exception e, int i) {
			if(isFresh){
				isFresh=false;
				viewById.refreshFinish(PullToRefreshLayout.FAIL);
			}
			ShowTipUtils.Show(getActivity(),e.toString());
			String result = CacheUtils.getInstance().get(Constants.CULLING_URLCACHE, "");
			if(!TextUtils.isEmpty(result)){
				culling1 = CacheUtils.getInstance().parseJson(result, CullingBean.class);
				resolveTab();
			}
		}

		@Override
		public void onResponse(String s, int i) {
			if(isFresh){
				isFresh=false;
				viewById.refreshFinish(PullToRefreshLayout.SUCCEED);
			}
			Log.e(TAG, "onResponse: Dsds"+s );
			culling1 = CacheUtils.getInstance().parseJson(s, CullingBean.class);


			//缓存
			CacheUtils.getInstance().save(Constants.HOMETAB,s);
			Log.e(TAG, "onResponse: "+s );
			resolveTab();


		}
	}

	private void resolveTab() {
		if (isLoadMore==true){
			isLoadMore=false;
			if(adapter!=null){
				List<CullingBean.IdlistBean.NewslistBean> newslist2 =new ArrayList<>();
				List<CullingMoreBean.NewslistBean> newslist1 = more.getNewslist();
				for (int i = 0; i < newslist1.size(); i++) {
					newslist2.add(newslist1.get(i));

				}
				adapter.onLoadMore(newslist2);
				return;
			}
		}
		if(culling1!=null){
			Log.e(TAG, "resolveTab: "+culling1 );
			newslist = culling1.getIdlist().get(0).getNewslist();
			if(adapter==null){
			adapter = new CullingAdapter(getActivity(),newslist, R.layout.culling_item);
			lvCulling.setAdapter(adapter);
			}else{
				adapter.refresh(newslist);
			}

		}

	}

	private static final String TAG = "CullingPagerFragment";
}
