package chen.yy.com.news.views;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import chen.yy.com.news.R;
import chen.yy.com.news.utils.DensityUtils;
import chen.yy.com.news.utils.ShowTipUtils;

import static chen.yy.com.news.R.id.pb_arrow;


/**
 * News
 * Created by chenrongfa on 2017/3/9
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class RefreshGridView extends GridView implements AbsListView.OnScrollListener {
	private static final String TAG = "RefreshListView";
	@BindView(R.id.iv_arrow)
	ImageView ivArrow;
	@BindView(pb_arrow)
	ProgressBar pbArrow;
	@BindView(R.id.tv_refresh)
	TextView tvRefresh;
	@BindView(R.id.tv_refresh_time)
	TextView tvRefreshTime;
	ProgressBar pbFooter;
	TextView tvMore;
	LinearLayout llFooter;
	private LayoutInflater mInflater;
	private View inflate;
	private Context mContext;
	private View inflate1;
	private float lastX;
	private float lasty;
	private int totleHeigth;
	private int headerHeigth;
	private int mStatus;//当前状态
	private int mPosition;
	private boolean isTop;
	private boolean isBottom;
	private boolean isReaded;

	private SparseArray<Animation> animotions;
	private SimpleDateFormat date;
	private Date data;
	private boolean isCanOnLoadMore;
	private OnLoadMoreListener on;
	private int foosterHeigth;
	private String mLastTime;
	private int totleFooster;
	private boolean isFlingTop;//是否滑到的最顶部
	private boolean isFlingBottom;//是否滑到最底部

	public RefreshGridView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		this.mContext = context;
		bindView();
		setOnScrollListener(this);
		animotions = new SparseArray<>();

	}


	public RefreshGridView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public RefreshGridView(Context context) {
		this(context, null);
	}

	private void bindView() {
		mInflater = LayoutInflater.from(mContext);
		inflate = mInflater.inflate(R.layout.refresh_header, null);
		inflate1 = mInflater.inflate(R.layout.refresh_footer, null);
		ButterKnife.bind(this, inflate);
		llFooter = (LinearLayout) inflate1.findViewById(R.id.ll_footer);
		tvMore = (TextView) inflate1.findViewById(R.id.tv_more);
		pbFooter = (ProgressBar) inflate1.findViewById(R.id.pb_footer);
		tvRefresh.setText("dssdf");
		pbArrow.setVisibility(GONE);

		makeChildren(inflate);
		headerHeigth = inflate.getMeasuredHeight();
		Log.e(TAG, "bindView: "+headerHeigth );
		setPadding(inflate, -headerHeigth);
		makeChildren(inflate1);
		foosterHeigth = inflate1.getMeasuredHeight();
		Log.e(TAG, "bindView: foosterHeigth"+foosterHeigth );
		setPadding(inflate1, -foosterHeigth);
		addView(inflate,0);
		addView(inflate1,getCount()-1);

//		llFooter.setVisibility(GONE);
		date = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		data = new Date();


	}
public void setProgressBar(){
	if(pbArrow.isShown()){
		pbArrow.setVisibility(GONE);
	}
}
	private void makeChildren(View view) {
		ViewGroup.LayoutParams layout = view.getLayoutParams();

		if (layout == null) {
			layout = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, DensityUtils.dipToPx(mContext, 60));
		}
		int width = ViewGroup.getChildMeasureSpec(0, 0, layout.width);
		int height = ViewGroup.getChildMeasureSpec(0, 0, layout.height);

		if (height > 0) {
			height = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
		} else {
			height = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
		}
		view.measure(width, height);

	}

	@OnClick(R.id.pb_arrow)
	public void click(View view) {
		ShowTipUtils.Show(mContext, "dd");

	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		switch (scrollState) {
			case SCROLL_STATE_IDLE:
				Log.e(TAG, "onScroll: " + "空闲");
				mStatus = SCROLL_STATE_IDLE;

				break;
			case SCROLL_STATE_FLING:
				mStatus = SCROLL_STATE_FLING;
				Log.e(TAG, "onScroll: " + "抛开");
				break;
			case SCROLL_STATE_TOUCH_SCROLL:
				Log.e(TAG, "onScroll: " + "滚动");
				mStatus = SCROLL_STATE_TOUCH_SCROLL;
				break;

		}


	}
public View getInflate(){

		return inflate;
}
	public View getInflate1(){
		return inflate1;
}
	public int getFooster(){
		return foosterHeigth;
	}
	@Override
	public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
		if (mStatus == SCROLL_STATE_FLING || mStatus == SCROLL_STATE_TOUCH_SCROLL) {
			mPosition = firstVisibleItem;
			if (mPosition == 0) {
				isTop = true;
				Log.e(TAG, "onScroll: " + "daotdingle");
			} else {
				isTop = false;
			}
			if (mPosition + visibleItemCount == totalItemCount) {
				isBottom = true;
				Log.e(TAG, "onScroll: " + "daodile");
			} else {
				isBottom = false;
			}
		}

	}

	public void setPadding(View view, int heigth) {
		//解决下拉移动不断padding
		if(view==inflate){
		totleHeigth += heigth;
		if (Math.abs(totleHeigth) > headerHeigth) {
			isFlingTop=true;
			view.setPadding(view.getPaddingLeft(), -headerHeigth, view.getPaddingRight(), view.getPaddingBottom());
			totleHeigth = 0;
		} else {
			view.setPadding(view.getPaddingLeft(), heigth, view.getPaddingRight(), view.getPaddingBottom());

		}
		}else {
			totleFooster += heigth;
			if (totleFooster>= foosterHeigth) {
			   isFlingBottom=true;
				view.setPadding(view.getPaddingLeft(), -foosterHeigth, view.getPaddingRight(), view.getPaddingBottom());
				totleFooster = 0;
			} else {
				view.setPadding(view.getPaddingLeft(), heigth, view.getPaddingRight(), view.getPaddingBottom());

			}

		}
		view.postInvalidate();
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		switch (ev.getAction()) {
			case MotionEvent.ACTION_DOWN:
				getParent().requestDisallowInterceptTouchEvent(true);
				lastX = ev.getX();
				lasty = ev.getY();
				break;
			//				return true;
			case MotionEvent.ACTION_MOVE:
				float rawX = ev.getX();
				float rawY = ev.getY();
				float distanceY = rawY - lasty;
				float distanceX = rawX - lastX;

				if (Math.abs(distanceY) > Math.abs(distanceX)) {
					getParent().requestDisallowInterceptTouchEvent(false);
					resovleRefresh(distanceY);
				} else {
					getParent().requestDisallowInterceptTouchEvent(false);
				}
				lastX = rawX;
				lasty = rawY;
				break;

			//				return true;
			case MotionEvent.ACTION_UP:
				resolveRefresh();
				resolveLoadMore();
				break;

		}

		return super.onTouchEvent(ev);
	}

	/**
	 *  上啦加载更多
	 */
	private void resolveLoadMore() {
		if (isCanOnLoadMore) {
			isCanOnLoadMore = false;

			//回调
			if (on != null) {
				on.onLoadMore();
			}
		}
//		else{
//			setPadding(inflate1,-(totleFooster+foosterHeigth));
//		}
	}

	/**
	 *  下拉刷新处理
	 */
	private void resolveRefresh() {
		if (isReaded) {
			tvRefresh.setText("正在更新");
			setLastTime();
			isReaded = false;
			isFlingTop = false;
			Log.e(TAG, "onTouchEvent: fsdfsfdf");
			//					  ivArrow.clearAnimation();//清除动画
			ivArrow.clearAnimation();
			setAnimation(ivArrow, R.anim.refresh_arrow1);
			//然后一秒后 隐藏箭头显示 进度
			postDelayed(new Runnable() {
				@Override
				public void run() {
					Log.e(TAG, "run: " + Thread.currentThread().getName());
					ivArrow.clearAnimation();//清除动画
					ivArrow.setVisibility(GONE);

					pbArrow.setVisibility(VISIBLE);
					if (on != null) {
						//刷新回调
						on.onRefresh();
					}
				}
			}, 300);

		}
//		}else{
//			setPadding(inflate,-(headerHeigth+totleHeigth));
//		}
	}

	private void resovleRefresh(float distanceY) {
		//只能下拉 不能往上推
		Log.e(TAG, "onTouchEvent: " + distanceY);
		if (distanceY > 0) {
			Log.e(TAG, "onTouchEvent: " + distanceY);
			if (isTop) {
				if (distanceY > headerHeigth) {
					setPadding(inflate, headerHeigth);
				} else {
					setPadding(inflate, (int) distanceY);
				}
				isReaded = true;
				setAnimation(ivArrow, R.anim.refresh_arrow);
				tvRefresh.setText("下拉可以刷新");
				setLastTime();

			}
		} else {
			if (isBottom) {
				Log.e(TAG, "resovleRefresh:isBottom jinlai" );
				float abs = Math.abs(distanceY);
				if (abs > foosterHeigth) {
					setPadding(inflate1, foosterHeigth);
				} else {
					setPadding(inflate1, (int) abs);
				}
				isCanOnLoadMore = true;
			}

		}
	}

	private void setLastTime() {
		if(TextUtils.isEmpty(mLastTime)) {
			tvRefreshTime.setText("没有刷新过");
			mLastTime=date.format(data);
			Log.e(TAG, "resovleRefresh: 0" );
		}else{
			tvRefreshTime.setText(mLastTime);
			Log.e(TAG, "resovleRefresh: 1" );
			mLastTime=date.format(data.getTime());
		}
	}

	/**
	 * 设置动画
	 */
	private void setAnimation(ImageView view, int id) {
		RotateAnimation rotateAnimation = (RotateAnimation) animotions.get(id);
		if (rotateAnimation == null) {
			rotateAnimation = (RotateAnimation) AnimationUtils.loadAnimation(mContext, id);
			animotions.put(id, rotateAnimation);
		}
		rotateAnimation.setDuration(500);
		rotateAnimation.setFillAfter(true);

		view.startAnimation(rotateAnimation);
	}

	public void setOnLoadMoreListener(OnLoadMoreListener onLoadMore) {
		if (onLoadMore != null)
			on = onLoadMore;
	}

	public int getHeigth() {
		return headerHeigth;
	}

	/**
	 * 设置尾部隐藏
	 */
	public void setFooterGone() {
		if (llFooter.isShown()) {
			llFooter.setVisibility(View.GONE);
		}
	}

	/**
	 * 下拉刷新和上啦加载更多 接口回调
	 */
	public interface OnLoadMoreListener {
		void onLoadMore();

		void onRefresh();
	}

}
