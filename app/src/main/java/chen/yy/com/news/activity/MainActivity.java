package chen.yy.com.news.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.WindowManager;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import chen.yy.com.news.R;
import chen.yy.com.news.news.fragment.ContentFrament;
import chen.yy.com.news.news.fragment.LeftFrament;

public class MainActivity extends AppCompatActivity {

	private SlidingMenu slidingMenu;
	private LayoutInflater mlayoutInflater;
	private FragmentManager mFragment;
	private WindowManager mWindowManager;
	public  static final String LEFT_TAG="left_tag";
	public  static final String CONTENT_TAG="content_tag";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initData();
		initSlidingMenu();
		initFragment();

	}

	private static final String TAG = "MainActivity";


	private void initData() {
		mlayoutInflater=LayoutInflater.from(this);
		mFragment=getSupportFragmentManager();
		mWindowManager=getWindowManager();
	}

	private void initFragment() {
		LeftFrament left=new LeftFrament();
		ContentFrament content=new ContentFrament();
		FragmentTransaction fragmentTransaction = mFragment.beginTransaction();
		fragmentTransaction.add(R.id.fr_container,content,CONTENT_TAG);
		fragmentTransaction.add(R.id.fr_left_container,left,LEFT_TAG);
		fragmentTransaction.commit();

	}

	private void initSlidingMenu() {
//		View inflate = mlayoutInflater.inflate(R.layout.activity_left_menu, null);
		slidingMenu = new SlidingMenu(this);
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		slidingMenu.setMode(SlidingMenu.LEFT);
		DisplayMetrics displayMetrics = new DisplayMetrics();
		mWindowManager.getDefaultDisplay().getMetrics(displayMetrics);
		slidingMenu.setBehindOffset((displayMetrics.widthPixels*3)/4);
		slidingMenu.setBackgroundColor(Color.GRAY);
		slidingMenu.attachToActivity(this,SlidingMenu.SLIDING_CONTENT);
//		slidingMenu.setMenu();
		slidingMenu.setMenu(R.layout.activity_left_menu);
//		slidingMenu.addView(inflate);
		//		slidingMenu.toggle();
	}
	@Override
	public void onBackPressed() {
		if(slidingMenu.isMenuShowing()){
			slidingMenu.toggle();
			return;
		}
		super.onBackPressed();
	}

	/**
	 *  传递 slideingmenu 对象
	 * @return
	 */
	public SlidingMenu  getSlidingMenu(){
		if (slidingMenu!=null){
			return slidingMenu;
		}
		return null;

	}
}
