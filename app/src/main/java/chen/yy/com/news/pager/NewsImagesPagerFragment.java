package chen.yy.com.news.pager;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import chen.yy.com.news.base.BaseFragment;

/**
 * News
 * Created by chenrongfa on 2017/3/6
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class NewsImagesPagerFragment extends BaseFragment {

	private TextView textView;

	@Override
	protected View initView() {
		textView = new TextView(context);
		textView.setGravity(Gravity.CENTER);
		return textView;
	}

	@Override
	public void bindData() {
		textView.setText("imgaes");
	}
}