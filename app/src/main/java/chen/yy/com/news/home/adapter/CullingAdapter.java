package chen.yy.com.news.home.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import chen.yy.com.news.R;
import chen.yy.com.news.base.CommonAdapter;
import chen.yy.com.news.base.CommonViewHolder;
import chen.yy.com.news.home.bean.CullingBean;

/**
 * News
 * Created by chenrongfa on 2017/3/16
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class CullingAdapter extends CommonAdapter <CullingBean.IdlistBean.NewslistBean>{
	private List<CullingBean.IdlistBean.NewslistBean> newslistBeen;
	private Context mContext;
	public CullingAdapter(Context context, List<CullingBean.IdlistBean.NewslistBean> list, int layoutID) {
		super(context, list, layoutID);
		mContext=context;

	}

	private static final String TAG = "CullingAdapter";

	@Override
	public void bindData(CommonViewHolder viewHolder, CullingBean.IdlistBean.NewslistBean  bean, int position) {
		TextView textView= viewHolder.getView(R.id.tv_title);
		TextView tv_people_num= viewHolder.getView(R.id.tv_people_num);
		TextView tv_hot_num= viewHolder.getView(R.id.tv_hot_num);
		ImageView imageView=viewHolder.getView(R.id.iv_icon);
		TextView tv_sources=viewHolder.getView(R.id.tv_sources);
		TextView tv_serie=viewHolder.getView(R.id.tv_serie);
		TextView tv_serie_num=viewHolder.getView(R.id.tv_serie_num);
		TextView tv_time=viewHolder.getView(R.id.tv_serie_num);
		LinearLayout ll_serie_live=viewHolder.getView(R.id.ll_serie_live);
		LinearLayout ll_bottom=viewHolder.getView(R.id.ll_bottom);
		String title = bean.getTitle();
		if(!TextUtils.isEmpty(title))
		textView.setText(title);
		CullingBean.IdlistBean.NewslistBean.LiveInfoBean live_info = bean.getLive_info();
		//存在
		if(live_info!=null) {
			int up_num = live_info.getUp_num();
			if (up_num != 0)
				tv_hot_num.setText(up_num + "");
			else{
			 tv_hot_num.setVisibility(View.GONE);}
			int online_total = live_info.getOnline_total();
			if (online_total != 0)
				tv_people_num.setText(online_total + "");
		}
		ImageView isLive=viewHolder.getView(R.id.iv_isLive);
		if(bean.getIs_live()!=1){
			isLive.setVisibility(View.GONE);
		}
		//处理最底部
		resolveBottom(bean, tv_sources, tv_time, ll_bottom);
		//处理中间图片
		resovleIcon(bean, imageView);
		//处理一系列直播
		resolveSerie(bean, tv_serie, tv_serie_num, ll_serie_live);

	}

	private void resolveBottom(CullingBean.IdlistBean.NewslistBean bean, TextView tv_sources, TextView tv_time, LinearLayout ll_bottom) {
		int num=0;
		String source = bean.getSource();
		if(TextUtils.isEmpty(source)){
			num++;

		}else{
			tv_sources.setText(source);
		}
		String time = bean.getTime();
		if(TextUtils.isEmpty(time)){
			num++;
		}else{
		 time = time.substring(3);
			tv_time.setText(time);
		}
		if(num==2){
			ll_bottom.setVisibility(View.GONE);
		}else{
			ll_bottom.setVisibility(View.VISIBLE);
		}
	}

	private void resolveSerie(CullingBean.IdlistBean.NewslistBean bean, TextView tv_serie, TextView tv_serie_num, LinearLayout ll_serie_live) {
		CullingBean.IdlistBean.NewslistBean.SpecialDataBean specialData =bean.getSpecialData();
		Log.e(TAG, "bindData: "+specialData );
		if(specialData==null){
			ll_serie_live.setVisibility(View.GONE);
		}else{
			ll_serie_live.setVisibility(View.VISIBLE);
			tv_serie.setText(specialData.getZtTitle());
			tv_serie_num.setText("共"+specialData.getLiveNum()+"场"+specialData.getTitlePre());
		}
	}

	private void resovleIcon(CullingBean.IdlistBean.NewslistBean bean, ImageView imageView) {
		if(!TextUtils.isEmpty(bean.getThumbnails_qqnews().get(0))){
		Glide.with(mContext).load(bean.getThumbnails_qqnews().get(0))
				.placeholder(R.drawable.news_pic_default)
				.centerCrop()
				.diskCacheStrategy(DiskCacheStrategy.ALL)
				.into(imageView);
		}else if( !TextUtils.isEmpty(bean.getThumbnails().get(0))){
			Glide.with(mContext).load(bean.getThumbnails().get(0))
					.placeholder(R.drawable.news_pic_default)
					.centerCrop()
					.diskCacheStrategy(DiskCacheStrategy.ALL)
					.into(imageView);
		}else if(!TextUtils.isEmpty(bean.getThumbnails_qqnews_photo().get(0))){
			Glide.with(mContext).load(bean.getThumbnails_qqnews_photo().get(0))
					.placeholder(R.drawable.news_pic_default)
					.centerCrop()
					.diskCacheStrategy(DiskCacheStrategy.ALL)
					.into(imageView);
		}
	}
}
