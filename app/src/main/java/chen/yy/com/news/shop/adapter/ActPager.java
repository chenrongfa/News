package chen.yy.com.news.shop.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import chen.yy.com.news.shop.bean.HomeData;
import chen.yy.com.news.utils.Constants;

/**
 * shopmall2
 * Created by chenrongfa on 2017/1/20
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */
public class ActPager extends PagerAdapter {
    List<HomeData.ResultBean.ActInfoBean> act_info;
    Context context;
    /**
     * 标题
     */
    private List<String> titles;


    public ActPager(List<HomeData.ResultBean.ActInfoBean> act_info, Context context) {
       this.act_info=act_info;
        this.context=context;
        titles=new ArrayList<>();
        titles.add("甩卖");
        titles.add("陈荣发");

    }

    /**
     *   得到item 的个数
     * @return
     */
    @Override
    public int getCount() {
        return act_info.size();
    }

    /**
     *   加载 item
     * @param container viewpager
     * @param position
     * @return 返回的对像是isViewFromObject 里的参数
     */
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        ImageView imageView=new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        Glide.with(context).load(Constants.IMG_URL+act_info.get(position)
        .getIcon_url())
                .into(imageView);
        container.addView(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, titles.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView(container.getChildAt(position));

    }

    /**
     *  得到标题
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }

    /**
     *  判断当前 的 对象是否 shi instantiateItem返回的对象
     * @param view
     * @param object
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
