package chen.yy.com.news.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import chen.yy.com.news.R;
import chen.yy.com.news.utils.CacheUtils;
import chen.yy.com.news.utils.Constants;

public class SplashActivity extends AppCompatActivity {
private ImageView mImageView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash_come);
		mImageView= (ImageView) findViewById(R.id.iv_splash);
		mImageView.startAnimation(animation);
		animation.setAnimationListener(new Animation.AnimationListener() {
			/**
			 *  动画开始播放
			 * @param animation
			 */
			@Override
			public void onAnimationStart(Animation animation) {


			}

			/**
			 *  播放结束
			 * @param animation
			 */
			@Override
			public void onAnimationEnd(Animation animation) {

				Boolean is_first = CacheUtils.getInstance().get(Constants.IS_FIRST, false);
				if(!is_first){
					CacheUtils.getInstance().save(Constants.IS_FIRST,true);
					Intent intent =new Intent(SplashActivity.this,GuideActivity.class);
					startActivity(intent);
					finish();

				}else{
					Intent intent =new Intent(SplashActivity.this,MainActivity.class);
					startActivity(intent);
					finish();
				}

			}

			/**
			 *  重复
			 * @param animation
			 */
			@Override
			public void onAnimationRepeat(Animation animation) {

			}
		});

	}
}
