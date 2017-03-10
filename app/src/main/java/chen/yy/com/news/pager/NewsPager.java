package chen.yy.com.news.pager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import chen.yy.com.news.R;
import chen.yy.com.news.base.BaseViewPager;
import chen.yy.com.news.base.NewsPagerAdapter;
import chen.yy.com.news.bean.NewsPagerBean;
import chen.yy.com.news.utils.CacheUtils;
import chen.yy.com.news.utils.Constans;

/**
 * News
 * Created by chenrongfa on 2017/3/7
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class NewsPager extends BaseViewPager {

	private  View inflate;

	ViewPager vpNewsTop;

	ListView lvNewsDetail;
	private NewsPagerAdapter mNewsAdapter;

	public NewsPager(Context context) {
		super(context);
		inflate = inflater.inflate(R.layout.news_item, null);
		vpNewsTop= (ViewPager) inflate.findViewById(R.id.vp_news_top);
		lvNewsDetail= (ListView) inflate.findViewById(R.id.lv_news_detail);

	}

	@Override
	public void init(String url) {
		getNetData(Constans.BASE_URL + url);
	}

	private static final String TAG = "NewsPager";

	private void getNetData(String url) {

		RequestParams urls = new RequestParams(url);
		x.http().get(urls, new Callback.CommonCallback<String>() {
			@Override
			public void onSuccess(String result) {
				Log.e(TAG, "onSuccess:new " + result);
				NewsPagerBean o = CacheUtils.getInstance().parseJson(result, NewsPagerBean.class);
				mNewsAdapter=new NewsPagerAdapter(context,o.getData().getTopnews());
				vpNewsTop.setAdapter(mNewsAdapter);
				Log.e(TAG, "onSuccess:10 " + o.toString());
			}

			@Override
			public void onError(Throwable ex, boolean isOnCallback) {

			}

			@Override
			public void onCancelled(CancelledException cex) {

			}

			@Override
			public void onFinished() {

			}
		});
	}

	public FrameLayout getConverView() {
		if (frameLayout != null) {
			frameLayout.removeAllViews();
			 frameLayout.addView(inflate);
			return frameLayout;
		}
		return null;
	}
}
