package chen.yy.com.news.shop.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import chen.yy.com.news.R;
import chen.yy.com.news.base.BaseViewHolder;
import chen.yy.com.news.shop.bean.HomeData;
import chen.yy.com.news.shop.viewholder.ActViewHolder;
import chen.yy.com.news.shop.viewholder.ChannelViewHolder;
import chen.yy.com.news.shop.viewholder.HomeViewHolder;
import chen.yy.com.news.shop.viewholder.HotViewHolder;
import chen.yy.com.news.shop.viewholder.RecommendViewHolder;
import chen.yy.com.news.shop.viewholder.SectkillViewHolder;

/**
 * shopmall2
 * Created by chenrongfa on 2017/1/19
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class HomeAdapter extends RecyclerView.Adapter {
    private Context context;
    private  HomeData.ResultBean resultBean;
    private LayoutInflater layoutInflater;
    public static final int BANNER=0;
    public static final int CHANNEL=1;
    public static final int ACT=2;
    public static final int SECTKILL=3;
    public static final int RECOMMEND=4;
    public static final int HOT=5;
    public static int currposition=0;

    public HomeAdapter(Context context, HomeData.ResultBean resultBean) {
        this.context=context;
        this.resultBean=resultBean;
        layoutInflater=LayoutInflater.from(context);

    }

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case BANNER:
                currposition=BANNER;
                break;
            case CHANNEL:
                currposition=CHANNEL;
                break;
            case ACT:
                currposition=ACT;
                break;
            case SECTKILL:
                currposition=SECTKILL;
                break;
            case RECOMMEND:
                currposition=RECOMMEND;
                break;
            case HOT:
                currposition=HOT;
                break;

        }

        return currposition;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case BANNER:
               view= layoutInflater.inflate(R.layout.banner_item, null);
                return new HomeViewHolder(view);
            case CHANNEL:
               view = layoutInflater.inflate(R.layout.channel_item, null);
                return new ChannelViewHolder(view);
            case ACT:
                view = layoutInflater.inflate(R.layout.act_item, null);
                return new ActViewHolder(view);
            case SECTKILL:
                view = layoutInflater.inflate(R.layout.sectkill, null);
                return new SectkillViewHolder(view);
            case RECOMMEND:
                view = layoutInflater.inflate(R.layout.recommend_item, null);
                return new RecommendViewHolder(view);
            case HOT:
                view = layoutInflater.inflate(R.layout.hot_item, null);
                return new HotViewHolder(view);



        }
        return null;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((BaseViewHolder)holder).bindData(resultBean,context);
    }

    @Override
    public int getItemCount() {

        return 6;
    }
}
