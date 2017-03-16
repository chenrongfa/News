package chen.yy.com.news.setting.adapter;

import android.content.Context;
import android.widget.TextView;

import chen.yy.com.news.R;
import chen.yy.com.news.base.CommonAdapter;
import chen.yy.com.news.base.CommonViewHolder;

/**
 * News
 * Created by chenrongfa on 2017/3/15
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class SettingAdapter extends CommonAdapter<String> {
	public SettingAdapter(Context context, String[] t, int layoutID) {
		super(context, t, layoutID);
	}

	@Override
	public void bindData(CommonViewHolder viewHolder, String bean, int position) {
		TextView tv_setting_message=viewHolder.getView(R.id.tv_setting_message);
		tv_setting_message.setText(bean);
	}
}
