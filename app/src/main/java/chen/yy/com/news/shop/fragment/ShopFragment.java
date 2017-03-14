package chen.yy.com.news.shop.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import chen.yy.com.news.R;
import chen.yy.com.news.base.BaseFragment;
import chen.yy.com.news.shop.adapter.HomeAdapter;
import chen.yy.com.news.shop.bean.HomeData;
import chen.yy.com.news.utils.Constants;
import okhttp3.Call;

/**
 * shopmall2
 * Created by chenrongfa on 2017/1/19
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class ShopFragment extends BaseFragment {

    private static final String TAG = "HomeFragment";
    @BindView(R.id.tv_main_search)
    TextView tvMainSearch;
    @BindView(R.id.iv_main_back)
    ImageView ivMainBack;
    @BindView(R.id.tv_main_message)
    TextView tvMainMessage;
    @BindView(R.id.rv_main)
    RecyclerView rvMain;
    private HomeData.ResultBean resultBean;

    @Override
    public View initView() {
        View view = inflater.inflate(R.layout.fragment_home, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void bindData() {
            OkHttpUtils.get()
                    .tag(context)
                    .url(Constants.HOME_URL)
                    .build()
                    .execute(new StringData());
    }
    class StringData extends StringCallback{

        @Override
        public void onError(Call call, Exception e, int i) {
            Log.e(TAG, "onError: "+e.toString()+"错误码"+i);
        }

        @Override
        public void onResponse(String s, int i) {
            Log.e(TAG, "onResponse: "+s );
            parstJson(s);
        }
    }

    private void parstJson(String s) {
        //解析数据
        HomeData data = JSON.parseObject(s, HomeData.class);
        resultBean=data.getResult();
        if(resultBean!= null){
            rvMain.setAdapter(new HomeAdapter(context,resultBean));
            GridLayoutManager manager=new GridLayoutManager(context,1);
                manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {
                        if(position<3){
                            ivMainBack.setVisibility(View.GONE);
                        }else{
                            ivMainBack.setVisibility(View.VISIBLE);
                        }
                        
                        return 1;
                    }
                });
            
                  rvMain.setLayoutManager(manager);

        }else{
            Toast.makeText(context, "解析错误", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;

        // STOPSHIP: 2017/1/22  dd
    }

    @OnClick({R.id.tv_main_search, R.id.tv_main_message,R.id.iv_main_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_main_search:
                showTip("search");
                break;
            case R.id.tv_main_message:
                showTip("message");
                break;
            case R.id.iv_main_back:
                rvMain.scrollToPosition(0);
                break;
        }
    }
   void showTip(String message){
       if (message!=null)
       Toast.makeText(context, message, Toast.LENGTH_SHORT).show();

    }
}
