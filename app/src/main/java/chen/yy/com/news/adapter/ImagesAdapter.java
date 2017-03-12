package chen.yy.com.news.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import chen.yy.com.news.R;
import chen.yy.com.news.base.CommonAdapter;
import chen.yy.com.news.base.CommonViewHolder;
import chen.yy.com.news.bean.ImagesBean;
import chen.yy.com.news.utils.Constans;

/**
 * News
 * Created by chenrongfa on 2017/3/11
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class ImagesAdapter extends CommonAdapter<ImagesBean.DataBean.NewsBean> {

	private Context context;
	public static int status;

	public ImagesAdapter(Context context, List<ImagesBean.DataBean.NewsBean> list, int layoutID) {
		super(context, list, layoutID);
		this.context=context;
	}

	@Override
	public void bindData(CommonViewHolder viewHolder, ImagesBean.DataBean.NewsBean bean, int position) {
		ImageView imageView= viewHolder.getView(R.id.iv_images);
		Glide.with(context).load(Constans.BASE_URL+bean.getSmallimage())
				.override(180,180)
				.animate(R.anim.alpha_images)
				.fitCenter()
				.placeholder(R.drawable.news_pic_default)
				.diskCacheStrategy(DiskCacheStrategy.ALL)
				.into(imageView);
		TextView textView=viewHolder.getView(R.id.tv_images);
		if(status==0) {
			textView.setText(bean.getTitle());
		}
	}
}
