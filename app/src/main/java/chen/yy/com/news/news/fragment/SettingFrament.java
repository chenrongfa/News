package chen.yy.com.news.news.fragment;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import chen.yy.com.news.R;
import chen.yy.com.news.base.BaseFragment;

/**
 * News
 * Created by chenrongfa on 2017/3/3
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class SettingFrament extends BaseFragment {
	@BindView(R.id.tv_shop_bar)
	TextView tvTitleBar;

	@Override
	protected View initView() {
		View inflate = inflater.inflate(R.layout.fragment_setting, null);
		ButterKnife.bind(this, inflate);
		return inflate;
	}

	@Override
	public void bindData() {
		tvTitleBar.setText(R.string.setting);

	}


}
