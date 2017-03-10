package chen.yy.com.news.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 *
 * 所有 fragment的基类
 * News
 * Created by chenrongfa on 2017/3/3
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public abstract class BaseFragment extends Fragment {
	public Context context;
	public  LayoutInflater inflater;
	protected ViewGroup container;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context=getActivity();
		inflater=LayoutInflater.from(context);
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		this.container=container;
		return initView();
	}
	protected abstract View initView();

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		bindData();
	}
	public void bindData(){};

	public void init(String url,int position) {

	}
}
