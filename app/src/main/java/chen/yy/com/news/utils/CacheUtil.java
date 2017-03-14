package chen.yy.com.news.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

import chen.yy.com.news.shop.bean.GoodsBean;

import static android.content.ContentValues.TAG;

/**
 * shopmall2
 * Created by chenrongfa on 2017/2/7
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class CacheUtil {
    public static  boolean isClear=false;//清除所有缓存
    public static  boolean  dataChange=false;
    public static  boolean iscache= true;//是否使用缓存
    public static List<GoodsBean> beanList = new ArrayList<>();

  public  static  SparseArray<GoodsBean> cache=new SparseArray<>();
    public  static void setSparseArray(Context context ){
        List<GoodsBean> goodsList = getGoodsList(context);
        parseToSparseArray(goodsList);


    }

    private static void parseToSparseArray(List<GoodsBean> goodsList) {
           if(goodsList!=null){
            for (GoodsBean goods:goodsList){
                cache.put(Integer.parseInt(goods.getProduct_id()),goods);
            }
    }
    }

    /**
     *  添加到购物车
     * @param goodsBean
     */
    public static boolean add(GoodsBean goodsBean,Context context){
        if(!contain(goodsBean)) {

            cache.put(Integer.parseInt(goodsBean.getProduct_id()), goodsBean);
            dataChange=true;
            if(iscache){
                beanList.add(goodsBean);
                Log.e(TAG, "add: "+goodsBean );
                saveGoods(context);
            }
            return true;
        }else {
            return false;
        }
    }

    /**
     *  是否包含
     * @param goods
     * @return
     */

    public static  boolean contain(GoodsBean goods){
        for (int i=0;i<cache.size();i++){
            if (cache.keyAt(i)==Integer.parseInt(goods.getProduct_id()))
                return true;
        }
        return false;

    }


    /**
     *  delete
     * @param goodsBean
     */
    public static void delete(GoodsBean goodsBean){

        cache.remove(Integer.parseInt(goodsBean.getProduct_id()));
        dataChange=true;
    }

    /**
     * 删除内存的数据并缓存标志true;
     */

    public static void deleteAll(){

        isClear=true;
        if(cache.size()>0){
            for (int i=0;i<cache.size();i++){
                cache.removeAt(i);
            }
        }

    }

    /**
     *  获得goods信息 并转换为list
     * @param context
     * @return
     */
    public static List<GoodsBean> getGoodsList(Context context){
        SharedPreferences goods = context.getSharedPreferences("goods", Context
                .MODE_PRIVATE);
        String goodsmessage = goods.getString("goodsmessage", "");
        List<GoodsBean> goodsBeen = parseToList(goodsmessage);

        return goodsBeen;
    }
//    public static List<GoodsBean> getGoodsList(){
//
//        String goodsmessage = goods.getString("goodsmessage", "");
//        List<GoodsBean> goodsBeen = parseToList(goodsmessage);
//
//        return goodsBeen;
//    }

    private static List<GoodsBean> parseToList(String goodsmessage) {
        if(!TextUtils.isEmpty(goodsmessage)){
        List<GoodsBean> been = JSON.parseArray(goodsmessage, GoodsBean.class);
            return been;}
        return beanList;
    }

    /**
     *  保存到sp
     * @param context
     */
    public static void saveGoods(Context context){
        SharedPreferences goods = context.getSharedPreferences("goods", Context.MODE_PRIVATE);
        if(!isClear) {
            Log.e(TAG, "saveGoods: "+"保存" );

            if (beanList.size() > 0) {
                String toJSONString = JSON.toJSONString(beanList);
                goods.edit().putString("goodsmessage", toJSONString).commit();
            }
        }else{
            //清空缓存
            goods.edit().putString("goodsmessage","").commit();


        }


    }


}
