package chen.yy.com.news.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import chen.yy.com.news.R;
import chen.yy.com.news.adapter.GuideAdapter;

public class GuideActivity extends AppCompatActivity {

	@BindView(R.id.vp_guide)
	ViewPager vpGuide;
	@BindView(R.id.btn_go)
	Button btnGo;
	@BindView(R.id.iv_point1)
	ImageView ivPoint1;
	@BindView(R.id.iv_point2)
	ImageView ivPoint2;
	@BindView(R.id.iv_point3)
	ImageView ivPoint3;
	int images[];//图片数据
	String title[];//标题
	private int mPosition;//当前viewpager位置

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guide);
		ButterKnife.bind(this);
		Log.e("11", "fragmencontainer: "+R.id.fr_container );
		initData();
		initEvent();
	}
  public void onethrowthree(){}
	private void initEvent() {
		ivPoint1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				vpGuide.setCurrentItem(0);

			}
		});
		ivPoint2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				vpGuide.setCurrentItem(1);

			}
		});
		ivPoint3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				vpGuide.setCurrentItem(2);
			}
		});
		btnGo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mPosition == 0) {
					mPosition++;
					vpGuide.setCurrentItem(mPosition);
				} else if (mPosition == 1) {
					mPosition++;
					vpGuide.setCurrentItem(mPosition);
				} else {
					//进入main
					Intent intent =new Intent(GuideActivity.this,MainActivity.class);
					startActivity(intent);
					finish();
				}
			}

		});
		vpGuide.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

			}

			@Override
			public void onPageSelected(int position) {
				GuideActivity.this.mPosition = position;
				Log.e(TAG, "onPageSelected: " );
				//红点处理
				resovleHot(position);
			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});
	}

	private void resovleHot(int position) {
		switch (position) {
			case 0:
				ivPoint1.setBackgroundResource(R.drawable.shade_point_red);
				ivPoint2.setBackgroundResource(R.drawable.shade_point_gray);
				ivPoint3.setBackgroundResource(R.drawable.shade_point_gray);
				btnGo.setText("向导");
				break;
			case 1:
				ivPoint1.setBackgroundResource(R.drawable.shade_point_gray);
				ivPoint2.setBackgroundResource(R.drawable.shade_point_red);
				ivPoint3.setBackgroundResource(R.drawable.shade_point_gray);
				btnGo.setText("下一步");
				break;
			case 2:
				ivPoint1.setBackgroundResource(R.drawable.shade_point_gray);
				ivPoint2.setBackgroundResource(R.drawable.shade_point_gray);
				ivPoint3.setBackgroundResource(R.drawable.shade_point_red);
				btnGo.setText("进入主题");
				break;
		}
	}

	private void initData() {
		images = new int[]{R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3};
//		images=getResources().getIntArray(R.array.guideImages);
		title = getResources().getStringArray(R.array.guideTitle);
		GuideAdapter guideAdapter = new GuideAdapter(this, title, images);
		vpGuide.setAdapter(guideAdapter);
//		ObjectAnimator ob=new ObjectAnimator();
//
//				vpGuide.setPageTransformer(true, )

	}

	private static final String TAG = "GuideActivity";
}
