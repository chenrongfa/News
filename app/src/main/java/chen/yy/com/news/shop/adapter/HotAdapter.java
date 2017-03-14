package chen.yy.com.news.shop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import chen.yy.com.news.R;
import chen.yy.com.news.shop.bean.HomeData;
import chen.yy.com.news.utils.Constants;

/**
 * shopmall2
 * Created by chenrongfa on 2017/1/21
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */
public class HotAdapter extends BaseAdapter {
    List<HomeData.ResultBean.HotInfoBean> hot_info;
    Context co;
    private LayoutInflater layoutInflater;
    public HotAdapter(List<HomeData.ResultBean.HotInfoBean> hot_info, Context co) {
        this.hot_info=hot_info;
        this.co=co;
        layoutInflater=LayoutInflater.from(co);
    }

    @Override
    public int getCount() {
        return hot_info.size();
    }

    @Override
    public Object getItem(int i) {
        return hot_info.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.hot_item_son, null);
            viewHolder=new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) view.getTag();
        }
        HomeData.ResultBean.HotInfoBean recommendInfoBean = hot_info.get(i);
        Glide.with(co).load(Constants.IMG_URL+recommendInfoBean.getFigure())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.new_user_login_icon)
                .into(viewHolder.ivRd);
        String name = recommendInfoBean.getName();
        if(name.length()>11){
            name=name.substring(0,11)+"...";
        }
        viewHolder.tvDesc.setText(name);
        viewHolder.tvPrice.setText(recommendInfoBean.getCover_price());
        return view;
    }

    static class ViewHolder {
        @BindView(R.id.iv_hot)
        ImageView ivRd;
        @BindView(R.id.tv_desc)
        TextView tvDesc;
        @BindView(R.id.tv_price)
        TextView tvPrice;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
