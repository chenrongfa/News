package chen.yy.com.news.news.pager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import chen.yy.com.news.R;
import chen.yy.com.news.activity.ImagesActivity;
import chen.yy.com.news.news.adapter.ImagesAdapter;
import chen.yy.com.news.base.BaseFragment;
import chen.yy.com.news.news.bean.ImagesBean;
import chen.yy.com.news.news.bean.NewsBeans;
import chen.yy.com.news.utils.CacheUtils;
import chen.yy.com.news.utils.Constants;

/**
 * News
 * Created by chenrongfa on 2017/3/6
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class NewsImagesPagerFragment extends BaseFragment {

	private static final int OK = 0;
	private static final int ERROR = 1;
	private GridView gridView;

	private static final String TAG = "NewsImagesPagerFragment";
	private NewsBeans.DataBean dataBean;
	private String url;
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
				case OK:
					resolveData();


					break;
				case ERROR:
					resolveLocalData();
					break;



			}
		}
	};
	private ImagesBean images;
	private ImagesAdapter imagesAdapter;
	private AlertDialog alertDialog;
	private int mPsotion;
	private String[] urlImages;

	private void resolveLocalData() {
	}

	/**
	 *  设置适配器
	 */
	private void resolveData() {

		if(imagesAdapter!=null){

		}else{
			imagesAdapter = new ImagesAdapter(getActivity(),images.getData().getNews()
					, R.layout.image_news_item);
			gridView.setAdapter(imagesAdapter);
		}


	}

	@Override
	protected View initView() {
		View inflate = inflater.inflate(R.layout.images_news, null);
		gridView = (GridView) inflate.findViewById(R.id.gv_images);
		NewsBeans news = (NewsBeans) getArguments().getSerializable("news");
		if(dataBean==null)
		dataBean = news.getData().get(2);
		return inflate;
	}

	@Override
	public void bindData() {
		url = dataBean.getUrl();
		resovleDialog(getResources().getStringArray(R.array.images));
		if(url!=null){
			getInternetData(Constants.BASE_URL+url);
		}
		gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
				alertDialog.show();


				return true;
			}
		});
		gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent=new Intent(getActivity(), ImagesActivity.class);
				intent.putExtra("position",position);
				intent.putExtra(Constants.URL,urlImages);
				startActivity(intent);

			}
		});
	}

	private void getInternetData(final String url) {
		RequestParams params = new RequestParams(url);
		x.http().get(params, new Callback.CommonCallback<String>() {
			@Override
			public void onFinished() {
				Log.e(TAG, "onFinished: ");
			}

			@Override
			public void onSuccess(String result) {
				Log.e(TAG, "onSuccess: " + result);
				images = CacheUtils.getInstance().parseJson(result, ImagesBean.class);

				if (images != null) {
					List<ImagesBean.DataBean.NewsBean> size = images.getData().getNews();
					urlImages=new String[size.size()];
					for(int i = 0; i< size.size(); i++){
						urlImages[i]= Constants.BASE_URL+size.get(i).getLargeimage();
					}
					handler.sendEmptyMessage(OK);
				}
			}

			@Override
			public void onError(Throwable ex, boolean isOnCallback) {
				Log.e(TAG, "onError: " + ex.toString());
			}

			@Override
			public void onCancelled(CancelledException cex) {
				Log.e(TAG, "onCancelled: " + cex.toString());
			}
		});
	}
	private void resovleDialog(String[] font) {
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
				builder.setSingleChoiceItems(font, 2, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						mPsotion=which;
					}
				});
				builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						switch (mPsotion){
							case 0:
								gridView.setNumColumns(1);
								imagesAdapter.status=0;
								break;case 1:
								gridView.setNumColumns(2);
								imagesAdapter.status=1;
								break;
							case 2:
								gridView.setNumColumns(4);
								imagesAdapter.status=2;
								break;
							default:
								gridView.setNumColumns(1);
								imagesAdapter.status=0;
								break;



						}
						imagesAdapter.notifyDataSetChanged();
							}


				});
				builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {



					}
				});
				alertDialog = builder.create();
			}


}
