package chen.yy.com.news;

import android.app.Application;

import org.xutils.x;

import chen.yy.com.news.utils.CacheUtils;

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


	}
}
