package chen.yy.com.news.shopcar.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import chen.yy.com.news.R;
import chen.yy.com.news.shop.bean.GoodsBean;
import chen.yy.com.news.utils.CacheUtil;
import chen.yy.com.news.utils.ShowTipUtils;

import static android.content.ContentValues.TAG;

/**
 * shopmall2
 * Created by chenrongfa on 2017/2/7
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */
public class ShopAdapter extends BaseAdapter implements View.OnClickListener {
    Context context;



    SparseArray<GoodsBean> cache;
    private Button btnDelete;
    private CheckBox cbAll;
    private CheckBox cbEditall;
    private TextView tvCount;
    private RelativeLayout tlEmpty;
    private LinearLayout ll_eidt;

    public ShopAdapter(Context context, SparseArray<GoodsBean> cache, Button btnDelete, CheckBox cbAll, CheckBox cbEditall, TextView tvConut, RelativeLayout tlEmpty, LinearLayout llEdit) {
        this.context = context;
        this.cache = cache;
        this.btnDelete = btnDelete;
        this.cbAll = cbAll;
        this.cbEditall = cbEditall;
        ll_eidt=llEdit;
        this.tlEmpty=tlEmpty;
        tvCount=tvConut;
        cbAll.setOnClickListener(this);
        cbEditall.setOnClickListener(this);
        setCheckAll(cbAll);
        setCountSum();
        setCheckAll(cbEditall);
        btnDelete.setOnClickListener(this);
    }
//计算总的价格
    private void setCountSum() {
        Log.e(TAG, "setCountSum: "+"111" +cache.size());
        double sum=0.0;
        for(int i=0;i<cache.size();i++){
            if(cache.get(cache.keyAt(i)).isChecked()){
                Log.e(TAG, "setCountSum: "+"111"+cache.size() );
                 sum+= Double.parseDouble(cache.get(cache.keyAt(i)).getCover_price())*
                         cache.get(cache.keyAt(i)).getCount();
            }
            }
        //设置字体部分的颜色
//        tvCount.setText(Html.fromHtml("<font color=\"#ff0000\">合计为:</font>")+String
//                .valueOf(sum));
        SpannableStringBuilder spannableString=new SpannableStringBuilder("合计:"+sum);
        spannableString.setSpan(new ForegroundColorSpan(Color.RED),0,2, Spannable
                .SPAN_INCLUSIVE_INCLUSIVE);
        tvCount.setText(spannableString);
    }

    public SparseArray<GoodsBean> getCache() {
        return cache;
    }

    public void setCache(SparseArray<GoodsBean> cache) {
        if(cache!=null) {
            this.cache = cache;
            notifyDataSetChanged();
        }
    }
    /**
     *  set 全选checkbox
     * @param cbAll
     */
    private void setCheckAll(CheckBox cbAll) {
        if(isSelectorAll()){
            cbAll.setChecked(true);
        }else{
            cbAll.setChecked(false);
        }
    }

    /**
     *  判断是否全选
     * @return
     */
    private boolean isSelectorAll() {
        //默认全选
        boolean isSelectorAll=true;
        for(int i=0;i<cache.size();i++){
            if(!cache.get(cache.keyAt(i)).isChecked()){
                isSelectorAll=false;
                return isSelectorAll;
            }

        }
        return  isSelectorAll;

    }

    @Override
    public int getCount() {
        return cache.size();
    }

    @Override
    public Object getItem(int position) {
        return cache.get(cache.keyAt(position));
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.shop_goods_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        setData(viewHolder, (GoodsBean) getItem(position));
        return convertView;
    }

    public void setData(final ViewHolder data, final GoodsBean goods) {
        data.tvShopPrice.setText("$" + goods.getCover_price());
        Glide.with(context).load(goods.getFigure()).into(data.ivGoods);
        data.tvGoods.setText(goods.getName());
        data.tvCount.setText(goods.getCount() + "");
        data.cb_item.setChecked(goods.isChecked());
        setEvent(data, goods);
    }

    private void setEvent(final ViewHolder data, final GoodsBean goods) {
        //复选框事件
        data.cb_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(goods.isChecked()){
                    data.cb_item.setChecked(false);
                    goods.setChecked(false);
                }else{
                    data.cb_item.setChecked(true);
                    goods.setChecked(true);
                }
                Log.e(TAG, "onClick: "+data.cb_item.toString() );
                notifyDataSetChanged();
                setCheckAll(cbAll);
                setCheckAll(cbEditall);//编辑状态
                setCountSum();
            }
        });

        //ibt_add增加
        data.ibtAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sum=10;//设置库存为10
                int count = goods.getCount();
                if(count<sum){
                    count++;
                    data.tvCount.setText(count+"");
                    goods.setCount(count);
                }
                //数据更新
                notifyDataSetChanged();
                setCountSum();
            }
        });
        //ibt_decre增加
        data.ibtDecre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sum=1;//设置库存为最少购买数量
                int count = goods.getCount();
                if(count==1){
                    ShowTipUtils.Show(context,"不能在减少了");
                }
                if(count>sum){
                    count--;
                    data.tvCount.setText(count+"");
                    goods.setCount(count);
                    //数据更新
                    notifyDataSetChanged();
                    setCountSum();
                }

            }
        });

    }

    @Override
    public void onClick(View v) {
        if(v==cbAll){
            setChecklistener(cbAll);
        }else if(v==btnDelete){
            setDeleteChecked();
        }else if (v==cbEditall){
            setChecklistener(cbEditall);
        }
    }

    private void setDeleteChecked() {
        for(int i=0;i<cache.size();i++){
            GoodsBean goodsBean = cache.get(cache.keyAt(i));
            if(goodsBean.isChecked()){
                cache.removeAt(i);
                CacheUtil.delete(context,goodsBean);
            }
        }
        Log.e(TAG, "setDeleteChecked: "+cache.size());
        //更新数据
        if(cache.size()==0){
            //数据为零通知隐藏视图
            Log.e("bug", "setDeleteChecked: fasong" );
            EventBus.getDefault().post(0);
        }else{
        notifyDataSetChanged();
        setCountSum();
        setCheckAll(cbEditall);
    }
    }

    private void setChecklistener(CheckBox box) {
        if(isSelectorAll()){
            box.setChecked(false);
            for(int i=0;i<cache.size();i++){
                if(cache.get(cache.keyAt(i)).isChecked()){
                    cache.get(cache.keyAt(i)).setChecked(false);
                }
            }
            notifyDataSetChanged();
        }else{

            box.setChecked(true);
            for(int i=0;i<cache.size();i++){
                if(!cache.get(cache.keyAt(i)).isChecked()){
                    cache.get(cache.keyAt(i)).setChecked(true);
                }
            }
            notifyDataSetChanged();

        }
        //再次计算总
        setCountSum();
    }

    static class ViewHolder {
        @BindView(R.id.cb_item)
        CheckBox cb_item;
        @BindView(R.id.iv_goods)
        ImageView ivGoods;
        @BindView(R.id.tv_goods)
        TextView tvGoods;
        @BindView(R.id.tv_shopPrice)
        TextView tvShopPrice;
        @BindView(R.id.ibt_decre)
        ImageButton ibtDecre;
        @BindView(R.id.tv_count)
        TextView tvCount;
        @BindView(R.id.ibt_add)
        ImageButton ibtAdd;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
