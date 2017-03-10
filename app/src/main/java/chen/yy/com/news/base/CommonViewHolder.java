package chen.yy.com.news.base;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

/**
 * News
 * Created by chenrongfa on 2017/3/5
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class CommonViewHolder {
	private View mConvertView;
	private static int mPosition;
	private ViewGroup mParent;
	private Context mContext;
	private SparseArray<View> sparseArray;

	private CommonViewHolder(int position, View convertView, Context context){
		mPosition=position;
		mConvertView=convertView;
		mContext=context;
		sparseArray=new SparseArray<>();

	}

	/**
	 *   得到 viewHolder
	 * @param position
	 * @param convertView
	 * @param layoutID
	 * @param context
	 * @return
	 */

	public static CommonViewHolder getViewHolder(int position, View convertView, int layoutID, Context context){
		CommonViewHolder viewHolder;
		if(convertView==null){
			convertView=View.inflate(context,layoutID,null);
			viewHolder=new CommonViewHolder(position,  convertView, context);
			convertView.setTag(viewHolder);

		}else {
			viewHolder= (CommonViewHolder) convertView.getTag();
			mPosition=position;
		}
		return viewHolder;

	}

	/**
	 *  通过viewid得到view
	 * @param viewID
	 * @param <T>
	 * @return
	 */
	public   <T extends View> T getView(int viewID) {
		View view = sparseArray.get(viewID);
		if (view == null) {
			if (mConvertView == null) {
				throw new NullPointerException("没有初始化");
			} else {
				view = mConvertView.findViewById(viewID);
				sparseArray.put(viewID, view);
				//			}
			}

		}
		return (T) view;
	}
	public  View getConvertView(){

		return mConvertView;
	}
}
