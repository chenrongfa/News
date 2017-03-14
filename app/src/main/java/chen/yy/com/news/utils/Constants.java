package chen.yy.com.news.utils;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import chen.yy.com.news.activity.GoodsActivity;
import chen.yy.com.news.shop.bean.GoodsBean;

/**
 * News
 * Created by chenrongfa on 2017/3/3
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class Constants {
	public static final  String IS_FIRST="is_first";
	public static final String BASE_URL = "http://192.168.2.120:8080/web_home";

	/**
	 * 新闻中心的网络地址
	 */
	public static final String NEWSCENTER_PAGER_URL = BASE_URL+"/static/api/news/categories.json";

	/**
	 * 商品热卖
	 */
	public static final String WARES_HOT_URL = "http://112.124.22.238:8081/course_api/wares/hot?pageSize=";
	/**
	 *  各种缓存常量名称
	 *
	 */
	public static final String NEWSDETAIL = "newsdetail";
	public static final String URL = "url";
	public static final String BASE_URL1="http://192.168.2.120:8080/atguigu";

	public static final  String IMG_URL=BASE_URL1+"/img";

	public static void  startAvtivity(Context context, GoodsBean goodsBean){
		Intent intent=new Intent(context , GoodsActivity.class);
		intent.putExtra("goods",goodsBean);
		context.startActivity(intent);

	}
	public static void showTip(Context context,String message){
		if (message!=null)
			Toast.makeText(context, message, Toast.LENGTH_SHORT).show();

	}

	private static final String BASE_URL_JSON = BASE_URL1+"/json/";
	//小裙子
	public static final String SKIRT_URL = BASE_URL_JSON + "SKIRT_URL.json";
	//上衣
	public static final String JACKET_URL = BASE_URL_JSON + "JACKET_URL.json";
	//下装(裤子)
	public static final String PANTS_URL = BASE_URL_JSON + "PANTS_URL.json";
	//外套
	public static final String OVERCOAT_URL = BASE_URL_JSON + "OVERCOAT_URL.json";
	//配件
	public static final String ACCESSORY_URL = BASE_URL_JSON + "ACCESSORY_URL.json";
	//包包
	public static final String BAG_URL = BASE_URL_JSON + "BAG_URL.json";
	//装扮
	public static final String DRESS_UP_URL = BASE_URL_JSON + "DRESS_UP_URL.json";
	//居家宅品
	public static final String HOME_PRODUCTS_URL = BASE_URL_JSON + "HOME_PRODUCTS_URL.json";
	//办公文具
	public static final String STATIONERY_URL = BASE_URL_JSON + "STATIONERY_URL.json";
	//数码周边
	public static final String DIGIT_URL = BASE_URL_JSON +  "DIGIT_URL.json";
	//游戏专区
	public static final String GAME_URL = BASE_URL_JSON + "GAME_URL.json";






	//主页Fragment路径
	public static final String HOME_URL = BASE_URL_JSON + "HOME_URL.json";
	//分类Fragment里面的标签Fragment页面数据
	public static final String TAG_URL = BASE_URL_JSON + "TAG_URL.json";


	public static final String NEW_POST_URL = BASE_URL_JSON + "NEW_POST_URL.json";
	public static final String HOT_POST_URL = BASE_URL_JSON + "HOT_POST_URL.json";


	//页面的具体数据的id
	public static final String GOODSINFO_URL = BASE_URL_JSON + "GOODSINFO_URL.json";

	//服饰
	public static final String CLOSE_STORE = BASE_URL_JSON + "CLOSE_STORE.json";
	//游戏
	public static final String GAME_STORE = BASE_URL_JSON + "GAME_STORE.json";
	//动漫
	public static final String COMIC_STORE = BASE_URL_JSON + "COMIC_STORE.json";
	//cosplay
	public static final String COSPLAY_STORE = BASE_URL_JSON + "COSPLAY_STORE.json";
	//古风
	public static final String GUFENG_STORE = BASE_URL_JSON + "GUFENG_STORE.json";
	//漫展
	public static final String STICK_STORE = BASE_URL_JSON + "STICK_STORE.json";
	//文具
	public static final String WENJU_STORE = BASE_URL_JSON + "WENJU_STORE.json";
	//零食
	public static final String FOOD_STORE = BASE_URL_JSON + "FOOD_STORE.json";
	//首饰厂
	public static final String SHOUSHI_STORE = BASE_URL_JSON + "SHOUSHI_STORE.json";



	public static Boolean isBackHome = false;



}
