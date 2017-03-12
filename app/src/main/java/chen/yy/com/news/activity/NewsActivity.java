package chen.yy.com.news.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import chen.yy.com.news.R;
import chen.yy.com.news.utils.Constans;
import chen.yy.com.news.utils.ShowTipUtils;

public class NewsActivity extends AppCompatActivity {

	private static final String TAG = "NewsActivity";
	@BindView(R.id.iv_back)
	TextView ivBack;
	@BindView(R.id.iv_font)
	ImageView ivFont;
	@BindView(R.id.iv_share)
	ImageView ivShare;
	@BindView(R.id.wb_news)
	WebView wbNews;
	@BindView(R.id.activity_news)
	RelativeLayout activityNews;
	@BindView(R.id.pb_load)
	ProgressBar pbLoad;
	private String mUrl;
	private WebSettings settings;
	private Dialog dialog;
	private AlertDialog alertDialog;
	private int mPsotion;//字体的选择位置

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news);
		ButterKnife.bind(this);
		initData();
	}

	private void initData() {
		mUrl = getIntent().getStringExtra(Constans.URL);

		if (mUrl != null) {
			String font[] = getResources().getStringArray(R.array.font);
			resovleDialog(font);
			resolveWebView();
		}
	}

	private void resolveWebView() {
		settings = wbNews.getSettings();
		settings.setUseWideViewPort(true);
		//支持缩放
		settings.setSupportZoom(true);
		settings.setBuiltInZoomControls(false);
		//支持javascript
		settings.setJavaScriptEnabled(true);

		wbNews.setVerticalScrollBarEnabled(true);
		//缓存模式
		settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		//开启缓存
		settings.setDatabaseEnabled(true);
		settings.setDomStorageEnabled(true);
		//缓存目录
		settings.setAppCachePath(getFilesDir().getAbsolutePath()+"/web");
		settings.setAppCacheEnabled(true);
		wbNews.loadUrl(mUrl);

		wbNews.setWebViewClient(new WebViewClient() {
			@Override
			public void onScaleChanged(WebView view, float oldScale, float newScale) {
				Log.e(TAG, "onScaleChanged:oldScale " + oldScale);
				Log.e(TAG, "onScaleChanged:newScale " + newScale);
				super.onScaleChanged(view, oldScale, newScale);
			}

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				wbNews.loadUrl(url);
				return true;
			}

			@Override
			public void onPageFinished(WebView view, String url) {
				super.onPageFinished(view, url);
				pbLoad.setVisibility(View.GONE);
			}
		});
	}

	private void resovleDialog(String[] font) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setSingleChoiceItems(font, 2, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				mPsotion=which;
			}
		});
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				ShowTipUtils.Show(NewsActivity.this,""+which);
				if (settings != null) {
					switch (mPsotion) {
						case 0 :
							settings.setTextZoom(25);
							break;
						case 1 :
							settings.setTextZoom(50);
							break;
						case 2 :
							settings.setTextZoom(100);
							break;
						case 3 :
							settings.setTextZoom(150);
							break;
						case 4 :
							settings.setTextZoom(200);
							break;
						default:
							settings.setTextZoom(100);
							break;

					}
				}
			}
		});
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				ShowTipUtils.Show(NewsActivity.this,getFilesDir().getAbsolutePath());


			}
		});
		alertDialog = builder.create();
	}

	@OnClick({R.id.iv_back, R.id.iv_font, R.id.iv_share})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.iv_back:
				finish();
				break;
			case R.id.iv_font:
				alertDialog.show();
				break;
			case R.id.iv_share:
				ShowTipUtils.Show(this, "share");
				break;
		}
	}

	@Override
	public void onBackPressed() {
		if(wbNews.canGoBack())
		{
			wbNews.goBack();
			return;
		}
		super.onBackPressed();
	}
}
