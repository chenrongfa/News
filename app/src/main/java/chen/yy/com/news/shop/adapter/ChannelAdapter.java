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
 * Created by chenrongfa on 2017/1/20
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */
public class ChannelAdapter extends BaseAdapter {
    private List<HomeData.ResultBean.ChannelInfoBean> channel_info;
    private Context context;
    private LayoutInflater layoutInflater;

    public ChannelAdapter(List<HomeData.ResultBean.ChannelInfoBean> channel_info,
                          Context context) {
        this.channel_info = channel_info;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return channel_info.size();
    }

    @Override
    public Object getItem(int i) {
        return channel_info.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.channel_item_sun, null);
            viewHolder=new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) view.getTag();
        }
        HomeData.ResultBean.ChannelInfoBean bean = channel_info.get(i);
        if(bean.getImage()!=null){
            Glide.with(context).load(Constants.IMG_URL+bean.getImage())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.menu)
                    .into(viewHolder.ivChannel);
        }
        if(bean.getChannel_name()!=null){
            viewHolder.tvChannel.setText(bean.getChannel_name());
        }
        return view;
    }



    class ViewHolder {
        @BindView(R.id.iv_channel)
        ImageView ivChannel;
        @BindView(R.id.tv_channel)
        TextView tvChannel;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
