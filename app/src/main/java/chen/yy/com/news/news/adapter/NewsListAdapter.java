package chen.yy.com.news.news.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.xutils.common.util.DensityUtil;

import java.util.List;

import chen.yy.com.news.R;
import chen.yy.com.news.base.CommonAdapter;
import chen.yy.com.news.base.CommonViewHolder;
import chen.yy.com.news.news.bean.NewsPagerBean;
import chen.yy.com.news.utils.Constants;

/**
 * News
 * Created by chenrongfa on 2017/3/8
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class NewsListAdapter extends CommonAdapter<NewsPagerBean.Data.News>   {

 private Context context;
	private List<NewsPagerBean.Data.News> list;

	public List<NewsPagerBean.Data.News> getList() {
		return list;
	}

	public void setList(List<NewsPagerBean.Data.News> list) {
		this.list = list;
	}

	/**
	 *  刷新数据
	 * @param list
	 */
		public void refresh(List<NewsPagerBean.Data.News> list){
		    if(list!=null){
				this.list=list;
				notifyDataSetChanged();
			}
		}
	public SparseArray sparseArray;//储存点击过的view;
	/**
	 *  加载更多
	 * @param more
	 */
	public void loadMore(List<NewsPagerBean.Data.News> more){
		if(list!=null&&!(list.containsAll(more))){
			list.addAll(more);
			notifyDataSetChanged();
		}


	}
	public NewsListAdapter(Context context, List<NewsPagerBean.Data.News> list, int layoutID) {
		super(context, list, layoutID);
		this.context=context;
		this.list=list;
		sparseArray=new SparseArray<>();
	}

	@Override
	public void bindData(CommonViewHolder viewHolder, NewsPagerBean.Data.News bean, int position) {

		ImageView view = viewHolder.getView(R.id.iv_news);
		Glide.with(context).load(Constants.BASE_URL+bean.getListimage())
				.diskCacheStrategy(DiskCacheStrategy.ALL)
				.placeholder(R.drawable.news_pic_default)
				.fitCenter()

				.into(view);
		 View isHas= (View) sparseArray.get(bean.getId());
		TextView textView=  viewHolder.getView(R.id.tv_title);
		textView.setTextSize(DensityUtil.dip2px(7));

		if(isHas==null){
			//没有点击
			textView.setTextColor(Color.RED);
		}else{
			textView.setTextColor(Color.GRAY);
		}

		textView.setText(bean.getTitle());
		TextView time= viewHolder.getView(R.id.tv_time);
		time.setText(bean.getPubdate());



	}



}
