/*******************************************************************************
 * Copyright 2011, 2012 Chris Banes.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package chen.yy.com.news.activity;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

import com.bumptech.glide.Glide;

import chen.yy.com.news.R;
import chen.yy.com.news.utils.Constants;
import chen.yy.com.news.views.HackyViewPager;
import uk.co.senab.photoview.PhotoView;



public class ImagesActivity extends AppCompatActivity {
	private static final String TAG = "ImagesActivity";

	private int position;
	private String[] stringArrayExtra;
	private ViewPager mViewPager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
		mViewPager = (HackyViewPager) findViewById(R.id.view_pager);
		setContentView(mViewPager);
		initData();

	}

	private void initData() {
		position = getIntent().getIntExtra("position", 0);
		//设置显示的位置
		Log.e(TAG, "initData: "+position );


		stringArrayExtra = getIntent().getStringArrayExtra(Constants.URL);
		if(stringArrayExtra!=null){
			mViewPager.setAdapter(new SamplePagerAdapter(stringArrayExtra));
			mViewPager.setCurrentItem(position);
		}
	}

	 class SamplePagerAdapter extends PagerAdapter {

		private String sDrawables[] ;

		public SamplePagerAdapter(String[] stringArrayExtra) {
			sDrawables=stringArrayExtra;
		}

		@Override
		public int getCount() {
			return sDrawables.length;
		}

		@Override
		public View instantiateItem(ViewGroup container, int position) {
			PhotoView photoView = new PhotoView(container.getContext());
			Glide.with(ImagesActivity.this).load(sDrawables[position]).into(photoView);

			container.addView(photoView, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

			return photoView;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}

	}
}
