package chen.yy.com.news.utils;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by crf on 2017/4/1.
 * company:逸辰
 * qq:952786280
 * feature:
 */

public class ZoominViewpagerTranform implements ViewPager.PageTransformer{
	public static final float min_scale =0.85f;
	public static final  float min_alpha=0.5f;

	@Override
	public void transformPage(View page, float position) {
		int height=page.getHeight();
		int width=page.getWidth();
		if(position<-1){
			page.setAlpha(0);
		}else if (position<1){
			float scale=Math.max(min_scale,1-Math.abs(position));
			int horizontal= (int) (width*(1-scale)/2);
			int vertal= (int) (height*(1-scale)/2);
			if (position<0){
				page.setTranslationX(horizontal-vertal/2);
			}else {
				page.setTranslationX(-horizontal+vertal/2);
			}
			page.setScaleX(scale);
			page.setScaleY(scale);
			page.setAlpha(min_alpha+(scale-min_alpha)/(1-scale)*(1-min_alpha));

		}	else {
			page.setAlpha(0);
		}

	}
}

