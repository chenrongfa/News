package chen.yy.com.news;

import android.app.Application;

import com.tencent.smtt.sdk.QbSdk;
import com.zhy.http.okhttp.OkHttpUtils;

import org.xutils.x;

import java.util.concurrent.TimeUnit;

import chen.yy.com.news.utils.CacheUtils;
import cn.jpush.android.api.JPushInterface;
import okhttp3.OkHttpClient;

/**
 * News
 * Created by chenrongfa on 2017/3/3
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class InitApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		//初始化 sp
		CacheUtils.getInstance().init(this);
		//初始化 xutils3
		x.Ext.init(this);
		x.Ext.setDebug(true);
		JPushInterface.setDebugMode(true); 	// 设置开启日志,发布时请关闭日志
		JPushInterface.init(this);     		// 初始化 JPush

//		PlatformConfig.setAlipay("2016032901249316");

		OkHttpClient.Builder okHttpClient=new OkHttpClient.Builder();
		okHttpClient.connectTimeout(5*1000, TimeUnit.MILLISECONDS);
		okHttpClient.readTimeout(5*1000,TimeUnit.MILLISECONDS);
		OkHttpUtils.initClient(okHttpClient.build());
		//初始化腾讯webview
		QbSdk.initX5Environment(this, null);



	}
}
