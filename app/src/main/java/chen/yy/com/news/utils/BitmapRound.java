package chen.yy.com.news.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.Log;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

/**
 * News
 * Created by chenrongfa on 2017/3/13
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class BitmapRound extends BitmapTransformation {
	private static final String TAG = "BitmapRound";
	private Context mContext;
	public BitmapRound(Context context) {
		super(context);
		mContext=context;
	}

	@Override
	protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {

		Bitmap bitmap = Bitmap.createBitmap(toTransform.getWidth(), toTransform.getHeight(), Bitmap.Config.ARGB_8888);
		Canvas canvas=new Canvas(bitmap);
		Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);

		canvas.drawRoundRect(new RectF(0,0,toTransform.getWidth(),toTransform.getHeight()),toTransform.getWidth()/4,toTransform.getWidth()/4,paint);

		Log.e(TAG, "transform: toTransform.getWidth()1" +toTransform.getWidth());
		Log.e(TAG, "transform: toTransform.getHeight()1" +toTransform.getHeight());
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
		canvas.drawBitmap(toTransform,0,0,paint);

		return bitmap;
	}

	@Override
	public String getId() {
		return System.currentTimeMillis()+"";
	}

}

