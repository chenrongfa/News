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

import java.util.List;

import chen.yy.com.news.R;
import chen.yy.com.news.activity.NewsActivity;
import chen.yy.com.news.base.BaseFragment;
import chen.yy.com.news.home.adapter.CullingAdapter;
import chen.yy.com.news.home.bean.CullingBean;
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


	@Override
	protected View initView() {
		inflate = inflater.inflate(R.layout.news_theme_item, null);

		viewById = (PullToRefreshLayout) inflate.findViewById(R.id.refresh_view);

		lvCulling = (ListView) viewById.getPullableView();
		lvCulling.setDivider(null);
		getInternetData();
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

	}
	private void getInternetData() {
		OkHttpUtils.get().
				url(Constants.CULLING_URL).
				tag(this)
				.build().
				execute(new StringResult());
	}
	class StringResult extends StringCallback {

		@Override
		public void onError(Call call, Exception e, int i) {
			ShowTipUtils.Show(getActivity(),e.toString());
			String result = CacheUtils.getInstance().get(Constants.CULLING_URLCACHE, "");
			if(!TextUtils.isEmpty(result)){
				culling1 = CacheUtils.getInstance().parseJson(result, CullingBean.class);
				resolveTab();
			}
		}

		@Override
		public void onResponse(String s, int i) {

			Log.e(TAG, "onResponse: Dsds"+s );
			culling1 = CacheUtils.getInstance().parseJson(s, CullingBean.class);


			//缓存
			CacheUtils.getInstance().save(Constants.HOMETAB,s);
			Log.e(TAG, "onResponse: "+s );
			resolveTab();


		}
	}

	private void resolveTab() {
		if(culling1!=null){
			Log.e(TAG, "resolveTab: "+culling1 );
			newslist = culling1.getIdlist().get(0).getNewslist();
			CullingAdapter adapter=new CullingAdapter(getActivity(),newslist,R.layout.culling_item);
			lvCulling.setAdapter(adapter);

		}

	}

	private static final String TAG = "CullingPagerFragment";
}
