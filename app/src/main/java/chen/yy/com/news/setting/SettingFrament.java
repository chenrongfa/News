package chen.yy.com.news.setting;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import chen.yy.com.news.R;
import chen.yy.com.news.base.BaseFragment;
import chen.yy.com.news.setting.adapter.SettingAdapter;
import chen.yy.com.news.utils.ShowTipUtils;

/**
 * News
 * Created by chenrongfa on 2017/3/3
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class SettingFrament extends BaseFragment {


	@BindView(R.id.tv_header)
	ImageView tvHeader;
	@BindView(R.id.tv_setting)
	ImageView tvSetting;
	@BindView(R.id.lv_setting)
	ListView lvSetting;
	private String[] string;

	@Override
	protected View initView() {
		View inflate = inflater.inflate(R.layout.fragment_setting, null);
		ButterKnife.bind(this, inflate);
		initData();
		return inflate;
	}

	private void initData() {
		string = getResources().getStringArray(R.array.setting);
	}

	@Override
	public void bindData() {
		if (string != null) {
			SettingAdapter adapter = new SettingAdapter(getActivity(), string, R.layout.setting_item);
			lvSetting.setMinimumHeight(50);
			lvSetting.setAdapter(adapter);
			lvSetting.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					resovleMessage(position);
				}
			});

		}

	}

	private void resovleMessage(int position) {
		switch (position) {
			case 0:
				ShowTipUtils.Show(getActivity(), string[position]);
				break;
			case 1:
				ShowTipUtils.Show(getActivity(), string[position]);
				break;
			case 2:
				ShowTipUtils.Show(getActivity(), string[position]);
				break;
			case 3:
				ShowTipUtils.Show(getActivity(), string[position]);
				break;

			case 4:
				ShowTipUtils.Show(getActivity(), string[position]);
				break;


		}

	}

	@OnClick({R.id.tv_header, R.id.tv_setting})
	public void click(View view) {
		if (view == tvHeader) {
			ShowTipUtils.Show(getActivity(), "header");
		} else if (view == tvSetting) {
			ShowTipUtils.Show(getActivity(), "setting");
		}
	}


}
