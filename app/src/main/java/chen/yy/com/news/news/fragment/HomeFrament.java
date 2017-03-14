package chen.yy.com.news.news.fragment;

import android.view.View;
import android.widget.TextView;

import chen.yy.com.news.R;
import chen.yy.com.news.base.BaseFragment;

/**
 * News
 * Created by chenrongfa on 2017/3/3
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class HomeFrament extends BaseFragment {

	private TextView tvTitleBar;

	@Override
	protected View initView() {
		tvTitleBar=new TextView(context);

		return tvTitleBar;
	}

	@Override
	public void bindData() {
		tvTitleBar.setText(R.string.home);

	}


}
