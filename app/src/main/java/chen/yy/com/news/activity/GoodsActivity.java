package chen.yy.com.news.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import chen.yy.com.news.R;
import chen.yy.com.news.shop.bean.GoodsBean;
import chen.yy.com.news.utils.CacheUtil;
import chen.yy.com.news.utils.Constants;
import chen.yy.com.news.utils.ShowTipUtils;

public class GoodsActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar tb_action;
    private TextView tv_goodsTip;
    private ImageView ivPhoto;
    private TextView tvGoodsName;
    private TextView tvGoodsDesc;
    private TextView tvGoodsPrice;
    private TextView tvAtguigu;
    private TextView tvOffer;
    private WebView wvAtguigu;
    private LinearLayout llBelow;
    private TextView tvRl;
    private TextView tvCl;
    private TextView ivSc;
    private Button btnAdd;
    private GoodsBean goods;
    private static final String TAG = "GoodsActivity";


    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-02-06 15:21:11 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        ivPhoto = (ImageView)findViewById( R.id.iv_photo );
        tvGoodsName = (TextView)findViewById( R.id.tv_goodsName );
        tvGoodsDesc = (TextView)findViewById( R.id.tv_goodsDesc );
        tvGoodsPrice = (TextView)findViewById( R.id.tv_goodsPrice );
        tvAtguigu = (TextView)findViewById( R.id.tv_atguigu );
        tvOffer = (TextView)findViewById( R.id.tv_offer );
        wvAtguigu = (WebView)findViewById( R.id.wv_atguigu );
        llBelow = (LinearLayout)findViewById( R.id.ll_below );
        tvRl = (TextView)findViewById( R.id.tv_rl );
        tvCl = (TextView)findViewById( R.id.tv_cl );
        ivSc = (TextView)findViewById( R.id.iv_sc );
        btnAdd = (Button)findViewById( R.id.btn_add );
//        try {
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("dd"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        btnAdd.setOnClickListener( this );
        tvRl.setOnClickListener(this);
        tvCl.setOnClickListener(this);
        ivSc.setOnClickListener(this);
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-02-06 15:21:11 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == btnAdd ) {
            boolean add = CacheUtil.add(goods,this);
            if (add){
                ShowTipUtils.Show(this,"添加成功");
            }else{
                Log.e(TAG, "onClick: "+CacheUtil.cache.toString() );
                ShowTipUtils.Show(this,"已经添加或者添加失败");
            }
        }else if(v==tvRl){
            ShowTipUtils.Show(this,"tvRl");

        }else if(v==tvCl){
            ShowTipUtils.Show(this,"tvCl");

        }else if(v==ivSc){
            ShowTipUtils.Show(this,"ivSc");
            Intent intent=new Intent(this,ShopActivity.class);
            startActivity(intent);

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
        findViews();
        initView();
        //得到数据

        goods = (GoodsBean) getIntent().getSerializableExtra("goods");
        if(goods!=null){
            initData(goods);
        }
        initToolBar();
    }

    private void initData(GoodsBean goods) {
        Glide.with(this).load(goods.getFigure()).into(ivPhoto);
        tvGoodsPrice.setText("$"+goods.getCover_price());
        tvGoodsDesc.setText(goods.getName());
        tvGoodsName.setText(goods.getName().substring(0,4));
        initWebView(goods.getProduct_id());



    }
//设置浏览器
    private void initWebView(String product_id) {
        if(product_id!=null) {
            wvAtguigu.loadUrl("http://www.baidu.com");
            WebSettings settings = wvAtguigu.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setCacheMode(WebSettings.LOAD_DEFAULT);
            settings.setUseWideViewPort(true);
            wvAtguigu.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);

                    return true;
                }
            });

        }


    }

    private void initToolBar() {
        tb_action.setNavigationIcon(R.drawable.top_bar_left_back);
        tb_action.setTitle("");

        setSupportActionBar(tb_action);
        tb_action.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tb_action.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.it_more:
                        Constants.showTip(GoodsActivity.this,"more");

                        return true;
                    case R.id.it_share:
                        Constants.showTip(GoodsActivity.this,"share");
                        return true;
                    case R.id.it_search:
                        Constants.showTip(GoodsActivity.this,"search");
                        return true;


                }

                return false;
            }
        });
    }

    private void initView() {
        tb_action = (Toolbar) findViewById(R.id.tb_action);
        tv_goodsTip= (TextView) findViewById(R.id.tv_goosTip);
    }
// 及解决

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.goods_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
