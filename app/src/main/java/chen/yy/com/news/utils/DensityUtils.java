package chen.yy.com.news.utils;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * News
 * Created by chenrongfa on 2017/3/3
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class DensityUtils {
	public static  int  dipToPx(Context context, int value){
		DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
		float density = displayMetrics.density;
		return (int) (value*density+0.5f);

	}
	public static  int  pxToDip(Context context, int value){
		DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
		float density = displayMetrics.density;
		return (int) (value/density+0.5f);

	}
	public static int pxToSp(Context context,int value){
		float scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
		 return (int) (value/scaledDensity+0.5);
	}
	public static int SpToPx(Context context,int value){
		float scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
		 return (int) (value*scaledDensity+0.5);
	}



}
