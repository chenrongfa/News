package chen.yy.com.news.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 *   adapter 的公共基类
 * News
 * Created by chenrongfa on 2017/3/4
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public abstract class CommonAdapter<T> extends BaseAdapter {
	private  T[] t;
	private Context mContext;
	private List<T> list;
	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public T[] getT() {
		return t;
	}

	public void setT(T[] t) {
		this.t = t;
	}

	/**
	 *
	 *  刷新集合
	 * @param tList
	 */
  public void refresh(List<T> tList) {
	  if (tList != null) {
		  this.list = tList;
		  notifyDataSetChanged();
	  }
  }

	/**
	 *  刷新数组
	 * @param tList
	 */
	public void refresh(T[] tList){
	  if(tList!=null){
		  this.t=tList;
		  notifyDataSetChanged();
	  }

  }
	/**
	 * j加载更多
	 */
	public void onLoadMore(List<T> tList){
		if(tList!=null&&!list.containsAll(tList)){
			list.addAll(tList);
			notifyDataSetChanged();
		}

	}
	private int layoutID;

	/**
	 *  针对数组
	 * @param context
	 * @param t
	 */
	public CommonAdapter(Context context,T[] t,int layoutID) {
		mContext=context;
		this.t=t;
		this.layoutID=layoutID;
	}

	/**
	 *  针对list集合
	 * @param context
	 * @param list
	 */
	public CommonAdapter(Context context,List<T> list,int layoutID) {
		mContext=context;
		this.list=list;
		this.layoutID=layoutID;
	}

	@Override
	public int getCount() {
		if(list!=null){
			return list.size();
		}else {
		return 	t.length;
		}

	}

	@Override
	public T getItem(int position) {
		if(list!=null){
		return 	list.get(position);
		}else{
			return t[position];
		}

	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		CommonViewHolder viewHolder=CommonViewHolder.getViewHolder(position,convertView, layoutID,mContext);
		bindData(viewHolder,getItem(position),position);
		return viewHolder.getConvertView();
	}
	public static class ViewHolder {

	}

	/**
	 *  暴露出方法接口 使用户绑定数据
	 * @param viewHolder
	 * @param bean
	 */
	public abstract void bindData(CommonViewHolder viewHolder,T bean,int position);

}
