package chen.yy.com.news.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import chen.yy.com.news.R;
import chen.yy.com.news.utils.Constants;
import chen.yy.com.news.utils.ShowTipUtils;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;


public class VideoActivity extends AppCompatActivity {

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
	private AlertDialog alertDialog;
	private int mPsotion;//字体的选择位置

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video);
		ButterKnife.bind(this);
		initData();
	}

	private void initData() {
		mUrl = getIntent().getStringExtra(Constants.URL);
		if(TextUtils.isEmpty(mUrl)){
			getIntent().getBundleExtra(Constants.URL);
		}

		if (mUrl != null) {
			String font[] = getResources().getStringArray(R.array.font);
			resovleDialog(font);
//			 if(TbsVideo.canUseTbsPlayer(this)){
//				 ShowTipUtils.Show(this,"jinlai");
//				 TbsVideo.openVideo(this,mUrl);
//
//
//			 }
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
		settings.setLoadWithOverviewMode(true);
		//闪屏
		getWindow().setFormat(PixelFormat.TRANSLUCENT);


		wbNews.setVerticalScrollBarEnabled(true);
		//缓存模式
		settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		//开启缓存
		settings.setDatabaseEnabled(true);
		settings.setDomStorageEnabled(true);
		settings.setPluginState(WebSettings.PluginState.ON);
		//缓存目录
		settings.setAppCachePath(getFilesDir().getAbsolutePath()+"/web");
		settings.setAppCacheEnabled(true);


//		wbNews.setWebChromeClient(new WebChromeClient());
//		wbNews.setWebViewClient(new WebViewClient(){
//
//
//			@Override
//			public boolean shouldOverrideUrlLoading(WebView view, String url) {
//			  view.loadUrl(url);
//				return true;
//
//
//			}
//
//			@Override
//			public void onPageFinished(WebView view, String url) {
//				Log.e(TAG, "onPageFinished: ");
//				super.onPageFinished(view, url);
//
////				Log.e(TAG, "shouldOverrideUrlLoading: " );
////				Intent intent=new Intent(Intent.ACTION_VIEW);
////				intent.setDataAndType(Uri.parse(url),"video/*");
////				intent.setData(Uri.parse(url));
////				startActivity(intent);
//			}
//		});
		wbNews.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideUrlLoading(WebView webView, String s) {
				wbNews.loadUrl(s);
				return true;
			}

			@Override
			public void onPageFinished(WebView webView, String s) {
				super.onPageFinished(webView, s);
				pbLoad.setVisibility(View.GONE);
			}
		});
		wbNews.loadUrl(mUrl);
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
				ShowTipUtils.Show(VideoActivity.this,""+which);
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
				ShowTipUtils.Show(VideoActivity.this,getFilesDir().getAbsolutePath());


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
				ShareSDK.initSDK(this);//初始化shareSDK
				showShare();
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
	private void showShare() {
		OnekeyShare oks = new OnekeyShare();
		//关闭sso授权
		oks.disableSSOWhenAuthorize();
		// title标题，印象笔记、邮箱、信息、微信、人人网、QQ和QQ空间使用
		oks.setTitle("标题");
		// titleUrl是标题的网络链接，仅在Linked-in,QQ和QQ空间使用
		oks.setTitleUrl(mUrl);
		// text是分享文本，所有平台都需要这个字段
		oks.setText("我是分享文本");
		//分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
		String stringExtra = getIntent().getStringExtra(Constants.IMAGES_URL);
		if(!TextUtils.isEmpty(stringExtra)){
			oks.setImageUrl(stringExtra);
		}else
		oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
		// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
		//oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
		// url仅在微信（包括好友和朋友圈）中使用
		oks.setUrl(mUrl);
		// comment是我对这条分享的评论，仅在人人网和QQ空间使用
		oks.setComment("我是测试评论文本");
		// site是分享此内容的网站名称，仅在QQ空间使用
		oks.setSite("ShareSDK");
		// siteUrl是分享此内容的网站地址，仅在QQ空间使用
		oks.setSiteUrl(mUrl);

		// 启动分享GUI
		oks.show(this);
	}
}
