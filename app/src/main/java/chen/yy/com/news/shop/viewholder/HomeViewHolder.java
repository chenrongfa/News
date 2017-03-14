package chen.yy.com.news.shop.viewholder;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import chen.yy.com.news.R;
import chen.yy.com.news.base.BaseViewHolder;
import chen.yy.com.news.shop.bean.HomeData;
import chen.yy.com.news.utils.Constants;

/**
 * shopmall2
 * Created by chenrongfa on 2017/1/20
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class HomeViewHolder extends BaseViewHolder {
    private Banner banner;
    public HomeViewHolder(View itemView) {
        super(itemView);
        banner= (Banner) itemView.findViewById(R.id.banner_main);
    }

    @Override
    public void bindData(HomeData.ResultBean resultBean, final Context context) {
        super.bindData(resultBean,context);
        List<String> images=new ArrayList<>();
        final List<String>titles=new ArrayList<>();
        titles.add("尚硅谷");
        titles.add("没座位");
        titles.add("撒贝宁演讲");
        banner.setBannerTitles(titles);

        List<HomeData.ResultBean.BannerInfoBean> banner_info = resultBean
                .getBanner_info();
        for (HomeData.ResultBean.BannerInfoBean banner:banner_info
             ) {
            images.add(Constants.BASE_URL1+"/img"+banner.getImage()) ;

        }
        banner.setImages(images);
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
                imageView.setImageURI(Uri.parse(path.toString()));
            }
        });
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        banner.setBannerAnimation(Transformer.DepthPage);
        banner.start();
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(context, titles.get(position-1), Toast.LENGTH_SHORT)
                        .show();
//                Constants.startAvtivity(context, goodsBean);
            }
        });
    }
}
