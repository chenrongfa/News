package chen.yy.com.news.utils;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * Created by crf on 2017/4/1.
 * company:逸辰
 * qq:952786280
 * feature:
 */



public class ViewPagertranform implements ViewPager.PageTransformer{
	public static final float min_scale =0.85f;
	public static final  float min_alpha=0.5f;
	private static final String TAG = "ViewPagertranform";


	@Override
	public void transformPage(View page, float position) {
		float height=page.getHeight();
		float width=page.getWidth();
		if(position<-1){
			page.setAlpha(0);
		}else if (position<=0){
			page.setAlpha(1);
			page.setScaleX(1);
			page.setScaleY(1);
			page.setTranslationX(0);
		}
		else if (position<=1){
			page.setAlpha(Math.max(position,min_alpha));
			page.setTranslationX(width*-position);
			float scale=  Math.max(min_scale,1-position);
			Log.e(TAG, "transformPage: scale"+scale );
			Log.e(TAG, "transformPage:+ "+scale*width );
			page.setScaleX(scale);
			page.setScaleY(scale);

		}	else {
			page.setAlpha(0);
		}

	}


}