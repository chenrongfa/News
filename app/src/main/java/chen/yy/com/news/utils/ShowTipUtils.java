package chen.yy.com.news.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * News
 * Created by chenrongfa on 2017/3/3
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class ShowTipUtils {
	public static void Show(Context context,String message){
		if(message!=null)
		Toast.makeText(context, ""+message, Toast.LENGTH_SHORT).show();
	else{
			Toast.makeText(context, "你输入为null", Toast.LENGTH_SHORT).show();
		}
	}
}
