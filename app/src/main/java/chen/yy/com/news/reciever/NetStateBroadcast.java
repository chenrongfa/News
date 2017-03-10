package chen.yy.com.news.reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

import chen.yy.com.news.utils.InternetStateutil;

/**
 * News
 * Created by chenrongfa on 2017/3/6
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class NetStateBroadcast extends BroadcastReceiver {
	private  OnInternetStateListener mOnInternetStateListener;
	@Override
	public void onReceive(Context context, Intent intent) {

		if(intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)){
			int state= InternetStateutil.getInternetStateutil().getInternetstate(context);

			if(mOnInternetStateListener!=null)
			mOnInternetStateListener.onInternetState(state);
		}

	}
	public void setOnInternetStateListener(OnInternetStateListener onInternetStateListener){
		if (onInternetStateListener!=null){
			mOnInternetStateListener=onInternetStateListener;
		}
	}
	//根据需要写接口还是其他的
	public interface OnInternetStateListener{

		void onInternetState(int state);
	}
}
