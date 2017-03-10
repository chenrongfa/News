package chen.yy.com.news.adapter;

import android.content.Context;
import android.widget.TextView;

import chen.yy.com.news.R;
import chen.yy.com.news.base.CommonAdapter;
import chen.yy.com.news.base.CommonViewHolder;

/**
 * News
 * Created by chenrongfa on 2017/3/4
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class LeftAdapter extends CommonAdapter<String> {

private int mPosition;
	private boolean isNewsFragment;
	private int layoutId;
	public LeftAdapter(Context context, String[] t,int layoutId) {
		super(context, t,layoutId);

	}

	@Override
	public void bindData(CommonViewHolder viewHolder, String bean, int position) {
		TextView tvLeft=viewHolder.getView(R.id.tv_left);
		tvLeft.setText(bean);
		if(mPosition==position&&isNewsFragment) {
			tvLeft.setEnabled(true);
		}else {
			tvLeft.setEnabled(false);
		}
	}
public void setSelect(int posotion,boolean isNewsFragment){
	mPosition=posotion;
	this.isNewsFragment=isNewsFragment;
	notifyDataSetChanged();
}

}
