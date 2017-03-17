package chen.yy.com.news.shop.bean;

import java.io.Serializable;

/**
 * shopmall2
 * Created by chenrongfa on 2017/2/6
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class GoodsBean  implements Serializable{


    /**
     * cover_price : 159.00
     * figure : /1477984921265.jpg
     * name : 现货【一方尘寰】剑侠情缘三剑三七秀 干将莫邪 90橙武仿烧蓝复古对簪
     * product_id : 9356
     */

    private String cover_price;
    private String figure;
    private String name;
    private String product_id;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof GoodsBean))
            return false;

        GoodsBean goodsBean = (GoodsBean) o;

        if (isChecked != goodsBean.isChecked)
            return false;
        if (count != goodsBean.count)
            return false;
        if (cover_price != null ? !cover_price.equals(goodsBean.cover_price) : goodsBean.cover_price != null)
            return false;
        if (figure != null ? !figure.equals(goodsBean.figure) : goodsBean.figure != null)
            return false;
        if (name != null ? !name.equals(goodsBean.name) : goodsBean.name != null)
            return false;
        return product_id != null ? product_id.equals(goodsBean.product_id) : goodsBean.product_id == null;

    }

    @Override
    public int hashCode() {
        int result = cover_price != null ? cover_price.hashCode() : 0;
        result = 31 * result + (figure != null ? figure.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (product_id != null ? product_id.hashCode() : 0);
        result = 31 * result + (isChecked ? 1 : 0);
        result = 31 * result + count;
        return result;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    private boolean isChecked= true;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private int count=1;

    public String getCover_price() {
        return cover_price;
    }

    public void setCover_price(String cover_price) {
        this.cover_price = cover_price;
    }

    public String getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = figure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    @Override
    public String toString() {
        return "GoodsBean{" +
                "cover_price='" + cover_price + '\'' +
                ", figure='" + figure + '\'' +
                ", name='" + name + '\'' +
                ", product_id='" + product_id + '\'' +
                ", isChecked=" + isChecked +
                ", count=" + count +
                '}';
    }
}
