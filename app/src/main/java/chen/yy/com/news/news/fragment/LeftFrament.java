package chen.yy.com.news.news.fragment;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import chen.yy.com.news.R;
import chen.yy.com.news.activity.MainActivity;
import chen.yy.com.news.news.adapter.LeftAdapter;
import chen.yy.com.news.base.BaseFragment;

import static android.content.ContentValues.TAG;

/**
 * News
 * Created by chenrongfa on 2017/3/3
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class LeftFrament extends BaseFragment {
	@BindView(R.id.lv_left)
	ListView lvLeft;
	private LeftAdapter leftAdapter;
	private int mposition;
	private onLeftListener onLeftListener;
	private ContentFrament fragment;


	@Override
	protected View initView() {
		View inflate = inflater.inflate(R.layout.fragment_left, null);
		ButterKnife.bind(this, inflate);
		return inflate;

	}

	@Override
	public void bindData() {
		String[] stringArray = getResources().getStringArray(R.array.leftTitle);
		if(stringArray.length>0){
			leftAdapter=new LeftAdapter(getActivity(),stringArray,R.layout.left_item);
			lvLeft.setAdapter(leftAdapter);
			fragment = (ContentFrament) getActivity().getSupportFragmentManager().findFragmentByTag("content_tag");

		}

		lvLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	  @Override
	  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		  Log.e(TAG, "onItemClick: ");
		  leftAdapter.setSelect(position,true);
		  if(onLeftListener!=null)
		  onLeftListener.onItem(position);
		  if(fragment.getmPosition()!=1) {
			  fragment.switchFragment(1);
		  }
		  ((MainActivity)context).getSlidingMenu().toggle();

	  }
  });


}
	public void setOnLeftlistener(onLeftListener on){
		if(on!=null){
			onLeftListener=on;
		}
	}
	interface onLeftListener {
		public void onItem(int position);
	}
	public LeftAdapter getLeftAdapter(){
		if (leftAdapter!=null) {
			return leftAdapter;
		}
		return null;
	}

}
