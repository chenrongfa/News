package chen.yy.com.news.shop.viewholder;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import chen.yy.com.news.R;
import chen.yy.com.news.base.BaseViewHolder;
import chen.yy.com.news.shop.bean.GoodsBean;
import chen.yy.com.news.shop.bean.HomeData;
import chen.yy.com.news.utils.Constants;

/**
 * shopmall2
 * Created by chenrongfa on 2017/1/20
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */
public class SectkillViewHolder extends BaseViewHolder {
    private static final int UPDATE = 0;
    private TextView tv_seck_time;
    private TextView tv_seck_more;
    private RecyclerView rv_seck;
    private   Context context=null ;
    private   HomeData.ResultBean listBean ;
    private long update;
    private long stop;
    private long start;
    Date date;
    SimpleDateFormat dateFormat;
    String format;
    private static final String TAG = "SectkillViewHolder";
    private Handler hanlder=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case UPDATE:

                    if(update<=0){
                        Toast.makeText(context, "秒杀开始", Toast.LENGTH_SHORT).show();
                        return ;
                    }
                    tv_seck_time.setText(format);
                    update-=1000l;
                    date.setTime(update);
                   format= dateFormat.format(date);

                    removeMessages(UPDATE);
                    sendEmptyMessageDelayed(UPDATE,1000);
                    break;
            }
        }
    };

    public SectkillViewHolder(View view) {
        super(view);
        tv_seck_more = (TextView) view.findViewById(R.id.tv_seck_more);
        tv_seck_time = (TextView) view.findViewById(R.id.tv_seck_time);
        rv_seck = (RecyclerView) view.findViewById(R.id.rv_seck);

    }

    @Override
    public void bindData(HomeData.ResultBean resultBean, final Context context) {
        super.bindData(resultBean, context);
        this.context=context;

        rv_seck.setAdapter(new SeckAdapter(resultBean.getSeckill_info().getList(),
                context));
        rv_seck.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager
                .HORIZONTAL, false));
        tv_seck_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "gengduo", Toast.LENGTH_SHORT).show();
            }
        });
        //发送 ---更新时间
        setUpdate(resultBean);
    }

    private void setUpdate(HomeData.ResultBean resultBean) {
        HomeData.ResultBean.SeckillInfoBean list = resultBean
                .getSeckill_info();
        start= Integer.parseInt(list.getStart_time());
        stop= Integer.parseInt(list.getEnd_time());
        update=stop-start;
        date = new Date(update);
        dateFormat = new SimpleDateFormat("hh:mm:ss");
        format = dateFormat.format(date);
        hanlder.sendEmptyMessage(UPDATE);

    }

    private class SeckAdapter extends RecyclerView.Adapter {
        List<HomeData.ResultBean.SeckillInfoBean.ListBean> list;
        Context context;
        LayoutInflater layoutInflater;

        public SeckAdapter(List<HomeData.ResultBean.SeckillInfoBean.ListBean> list,
                           Context context) {
            this.list = list;
            this.context = context;
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int
                viewType) {
            View inflate = layoutInflater.inflate(R.layout.sectkill_item, null);
            ViewHolder holder = new ViewHolder(inflate);
            holder.setOnItemClick(new ViewHolder.RecyclerListener() {
                @Override
                public void onItemClick(int position) {
                    Toast.makeText(context, "position"+position, Toast.LENGTH_SHORT).show();
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
             ViewHolder viewHolder= (ViewHolder) holder;
            Glide.with(context).load(Constants.IMG_URL+list.get(position)
                    .getFigure())
                    .into(viewHolder.ivSect);
            viewHolder.setOnItemClick(new ViewHolder.RecyclerListener() {
                @Override
                public void onItemClick(int position) {

                    HomeData.ResultBean.SeckillInfoBean.ListBean hotInfoBean =list
                            .get(position);
                    GoodsBean goodsBean=new GoodsBean();
                    goodsBean.setCover_price(hotInfoBean.getCover_price());
                    goodsBean.setProduct_id(hotInfoBean.getProduct_id());
                    goodsBean.setName(hotInfoBean.getName());//描述
                    goodsBean.setFigure(Constants.IMG_URL+hotInfoBean.getFigure());//图片

                    Constants.startAvtivity(context, goodsBean);

                }
            });
//            viewHolder.ivSect.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Toast.makeText(context, list.get(position).getOrigin_price(), Toast.LENGTH_SHORT)
//                            .show();
//                }
//            });
            viewHolder.tvNewPrice.setText(list.get(position).getCover_price());
            viewHolder.tvOldPrice.setText(list.get(position).getOrigin_price());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }


    }
    static  class ViewHolder extends BaseViewHolder{
        public RecyclerListener listener;
        @BindView(R.id.iv_sect)
        ImageView ivSect;
        @BindView(R.id.tv_new_price)
        TextView tvNewPrice;
        @BindView(R.id.tv_old_price)
        TextView tvOldPrice;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Toast.makeText(context, "111"+getLayoutPosition(), Toast.LENGTH_SHORT)

//                            .show();


                    if(listener!=null)
                    listener.onItemClick(getLayoutPosition());
                }
            });
        }
     interface   RecyclerListener{

        public void onItemClick(int position);
    }
        public void setOnItemClick(RecyclerListener listener){
            this.listener=listener;
        }
    }

}
