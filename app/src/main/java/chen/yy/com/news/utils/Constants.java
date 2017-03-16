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
	public static final String IMAGES_URL = "images_url";



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
	//直播  tab
	public static  final String HOME_TAB_URL="http://r.inews.qq.com/getLiveSubChannels?uid=1079045003815164&omgbizid=b599a66a49a0064403f95aaff2d37742ff3a005021220e&Cookie=lskey%3D%3Bluin%3D%3Bskey%3D%3Buin%3D%3B%20logintype%3D0%3B%20&network_type=wifi&sto]";
	//缓存 tag
	public static  final String HOMETAB="homeTab";
	//直播 culling
	public static  final  String  CULLING_URL="http://r.inews.qq.com/getLiveNewsIndexAndItems?chlid=news_live_main&uid=1079045003815164&omgbizid=b599a66a49a0064403f95aaff2d37742ff3a005021220e&Cookie=lskey%3D%3Bluin%3D%3Bskey%3D%3Buin%3D%3B%20logintype%3D0%3B%20&network_type=wifi&store=274&hw=samsung_GT-P5210&qn-sig=856cd78618557af76411670b5b18fe3f&orig_store=274&activefrom=icon&mac=08%253A00%253A27%253A2f%253Afe%253Ae0&chlid=news_live_main&origin_imei=133524148602062&qqnetwork=wifi&real_device_width=10.0&imsi_history=460000907341152&sceneid=&dpi=192&apptype=android&qn-rid=b161a13d-75b2-49c0-994b-59c9fc8ba669&devid=133524148602062&screen_width=720&real_device_height=17.78&appver=17_android_5.3.20&is_chinamobile_oem=0&mid=6af1498824155aa543fd9ea70c7efb9b529a2740&imsi=460000907341152&omgid=b14b2840ece01749bd18b65734ffcae5f48a0010211511&isoem=0&screen_height=1280";
	public static final String SLOWLIVE_URLCACH ="slowlive_urlcach" ;
     //npc
	public static  final  String  NPC_URL="http://r.inews.qq.com/getLiveNewsIndexAndItems?chlid=news_live_main&uid=1079045003815164&omgbizid=b599a66a49a0064403f95aaff2d37742ff3a005021220e&Cookie=lskey%3D%3Bluin%3D%3Bskey%3D%3Buin%3D%3B%20logintype%3D0%3B%20&network_type=wifi&store=274&hw=samsung_GT-P5210&qn-sig=1123abad1ae32f41855d7a992ffb1518&orig_store=274&activefrom=icon&mac=08%253A00%253A27%253A2f%253Afe%253Ae0&chlid=news_live_kn&origin_imei=133524148602062&qqnetwork=wifi&real_device_width=10.0&imsi_history=460000907341152&sceneid=&dpi=192&apptype=android&qn-rid=90a817bc-1645-4e03-afd4-19c9adfad1c5&devid=133524148602062&screen_width=720&real_device_height=17.78&appver=17_android_5.3.20&is_chinamobile_oem=0&mid=6af1498824155aa543fd9ea70c7efb9b529a2740&imsi=460000907341152&omgid=b14b2840ece01749bd18b65734ffcae5f48a0010211511&isoem=0&screen_height=1280";
	public static  final  String NPC_URL_CACHE="npc_url";
	public static  final  String  ART_URL="http://r.inews.qq.com/getLiveNewsIndexAndItems?chlid=news_live_main&uid=1079045003815164&omgbizid=b599a66a49a0064403f95aaff2d37742ff3a005021220e&Cookie=lskey%3D%3Bluin%3D%3Bskey%3D%3Buin%3D%3B%20logintype%3D0%3B%20&network_type=wifi&store=274&hw=samsung_GT-P5210&qn-sig=7349555dd65d74f14f5248ab2737d130&orig_store=274&activefrom=icon&mac=08%253A00%253A27%253A2f%253Afe%253Ae0&chlid=news_live_art&origin_imei=133524148602062&qqnetwork=wifi&real_device_width=10.0&imsi_history=460000907341152&sceneid=&dpi=192&apptype=android&qn-rid=1bdb0ea3-9723-4528-bad9-73a06e351ee9&devid=133524148602062&screen_width=720&real_device_height=17.78&appver=17_android_5.3.20&is_chinamobile_oem=0&mid=6af1498824155aa543fd9ea70c7efb9b529a2740&imsi=460000907341152&omgid=b14b2840ece01749bd18b65734ffcae5f48a0010211511&isoem=0&screen_height=1280";
	public static  final  String ART_URL_CACHE="art_url";
	public static  final  String  PLAY_URL="http://r.inews.qq.com/getLiveNewsIndexAndItems?chlid=news_live_main&uid=1079045003815164&omgbizid=b599a66a49a0064403f95aaff2d37742ff3a005021220e&Cookie=lskey%3D%3Bluin%3D%3Bskey%3D%3Buin%3D%3B%20logintype%3D0%3B%20&network_type=wifi&store=274&hw=samsung_GT-P5210&qn-sig=1118ef673389d42517e461354a3361f5&orig_store=274&activefrom=icon&mac=08%253A00%253A27%253A2f%253Afe%253Ae0&chlid=news_live_ent&origin_imei=133524148602062&qqnetwork=wifi&real_device_width=10.0&imsi_history=460000907341152&sceneid=&dpi=192&apptype=android&qn-rid=371857a1-f38c-4204-9ee0-e958c8245da2&devid=133524148602062&screen_width=720&real_device_height=17.78&appver=17_android_5.3.20&is_chinamobile_oem=0&mid=6af1498824155aa543fd9ea70c7efb9b529a2740&imsi=460000907341152&omgid=b14b2840ece01749bd18b65734ffcae5f48a0010211511&isoem=0&screen_height=1280";
	public static  final  String  PLAY_URL_CACHE="play_url";
	public static  final  String  INFO_URL="http://r.inews.qq.com/getLiveNewsIndexAndItems?chlid=news_live_main&uid=1079045003815164&omgbizid=b599a66a49a0064403f95aaff2d37742ff3a005021220e&Cookie=lskey%3D%3Bluin%3D%3Bskey%3D%3Buin%3D%3B%20logintype%3D0%3B%20&network_type=wifi&store=274&hw=samsung_GT-P5210&qn-sig=b577781df1ee6ae05eb3b27bf5fe7613&orig_store=274&activefrom=icon&mac=08%253A00%253A27%253A2f%253Afe%253Ae0&chlid=news_live_info&origin_imei=133524148602062&qqnetwork=wifi&real_device_width=10.0&imsi_history=460000907341152&sceneid=&dpi=192&apptype=android&qn-rid=3a73494b-e647-4633-bbae-95f3cf3ce15f&devid=133524148602062&screen_width=720&real_device_height=17.78&appver=17_android_5.3.20&is_chinamobile_oem=0&mid=6af1498824155aa543fd9ea70c7efb9b529a2740&imsi=460000907341152&omgid=b14b2840ece01749bd18b65734ffcae5f48a0010211511&isoem=0&screen_height=1280";
	public static  final  String	INFO_URL_CACHE="info_url";
	public static  final  String  FINANCE_URL="http://r.inews.qq.com/getLiveNewsIndexAndItems?chlid=news_live_main&uid=1079045003815164&omgbizid=b599a66a49a0064403f95aaff2d37742ff3a005021220e&Cookie=lskey%3D%3Bluin%3D%3Bskey%3D%3Buin%3D%3B%20logintype%3D0%3B%20&network_type=wifi&store=274&hw=samsung_GT-P5210&qn-sig=383b7a56b9f3fb8225c3adfdb08ba836&orig_store=274&activefrom=icon&mac=08%253A00%253A27%253A2f%253Afe%253Ae0&chlid=news_live_finance&origin_imei=133524148602062&qqnetwork=wifi&real_device_width=10.0&imsi_history=460000907341152&sceneid=&dpi=192&apptype=android&qn-rid=f04cbefe-ae8c-4349-96d0-a2dc0c36d56b&devid=133524148602062&screen_width=720&real_device_height=17.78&appver=17_android_5.3.20&is_chinamobile_oem=0&mid=6af1498824155aa543fd9ea70c7efb9b529a2740&imsi=460000907341152&omgid=b14b2840ece01749bd18b65734ffcae5f48a0010211511&isoem=0&screen_height=1280";
	public static  final  String  FINANCE_URL_CACHE="finance_url";
			public static  final  String  CHANNEL_URL="http://r.inews.qq.com/getLiveNewsIndexAndItems?chlid=news_live_main&uid=1079045003815164&omgbizid=b599a66a49a0064403f95aaff2d37742ff3a005021220e&Cookie=lskey%3D%3Bluin%3D%3Bskey%3D%3Buin%3D%3B%20logintype%3D0%3B%20&network_type=wifi&store=274&hw=samsung_GT-P5210&qn-sig=3ca04092bba314da7badbd2855122b41&orig_store=274&activefrom=icon&mac=08%253A00%253A27%253A2f%253Afe%253Ae0&chlid=news_live_tv&origin_imei=133524148602062&qqnetwork=wifi&real_device_width=10.0&imsi_history=460000907341152&sceneid=&dpi=192&apptype=android&qn-rid=f0f364ea-b83c-4884-bea5-31578de70651&devid=133524148602062&screen_width=720&real_device_height=17.78&appver=17_android_5.3.20&is_chinamobile_oem=0&mid=6af1498824155aa543fd9ea70c7efb9b529a2740&imsi=460000907341152&omgid=b14b2840ece01749bd18b65734ffcae5f48a0010211511&isoem=0&screen_height=1280";
	public static  final  String  CHANNEL_URL_CACHE="channel_url";
	public static  final  String  GYM_URL="http://r.inews.qq.com/getLiveNewsIndexAndItems?chlid=news_live_main&uid=1079045003815164&omgbizid=b599a66a49a0064403f95aaff2d37742ff3a005021220e&Cookie=lskey%3D%3Bluin%3D%3Bskey%3D%3Buin%3D%3B%20logintype%3D0%3B%20&network_type=wifi&store=274&hw=samsung_GT-P5210&qn-sig=3ca04092bba314da7badbd2855122b41&orig_store=274&activefrom=icon&mac=08%253A00%253A27%253A2f%253Afe%253Ae0&chlid=news_live_tv&origin_imei=133524148602062&qqnetwork=wifi&real_device_width=10.0&imsi_history=460000907341152&sceneid=&dpi=192&apptype=android&qn-rid=f0f364ea-b83c-4884-bea5-31578de70651&devid=133524148602062&screen_width=720&real_device_height=17.78&appver=17_android_5.3.20&is_chinamobile_oem=0&mid=6af1498824155aa543fd9ea70c7efb9b529a2740&imsi=460000907341152&omgid=b14b2840ece01749bd18b65734ffcae5f48a0010211511&isoem=0&screen_height=1280";
	public static  final  String  GYM_URL_CACHE="gym_url";
	public static  final  String  SLOWLIVE_URL="http://r.inews.qq.com/getLiveNewsIndexAndItems?chlid=news_live_main&uid=1079045003815164&omgbizid=b599a66a49a0064403f95aaff2d37742ff3a005021220e&Cookie=lskey%3D%3Bluin%3D%3Bskey%3D%3Buin%3D%3B%20logintype%3D0%3B%20&network_type=wifi&store=274&hw=samsung_GT-P5210&qn-sig=d34d265aa5821d4e4f9aad79606fa701&orig_store=274&activefrom=icon&mac=08%253A00%253A27%253A2f%253Afe%253Ae0&chlid=news_live_msj&origin_imei=133524148602062&qqnetwork=wifi&real_device_width=10.0&imsi_history=460000907341152&sceneid=&dpi=192&apptype=android&qn-rid=19bf1ff0-6449-47cc-b7c6-b97bbd9a0272&devid=133524148602062&screen_width=720&real_device_height=17.78&appver=17_android_5.3.20&is_chinamobile_oem=0&mid=6af1498824155aa543fd9ea70c7efb9b529a2740&imsi=460000907341152&omgid=b14b2840ece01749bd18b65734ffcae5f48a0010211511&isoem=0&screen_height=1280";

	public static String CULLING_URLCACHE="culling_urlcache";

}
