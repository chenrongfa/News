package chen.yy.com.news.news.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.opendanmaku.DanmakuItem;
import com.opendanmaku.DanmakuView;
import com.opendanmaku.IDanmakuItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import chen.yy.com.news.R;
import chen.yy.com.news.news.bean.NewBean;
import chen.yy.com.news.utils.Constants;
import chen.yy.com.news.utils.TimeUtil;

/**
 * shopmall2
 * Created by chenrongfa on 2017/2/11
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */
public class NewAdapter extends BaseAdapter {
      Context context;
      List<NewBean.ResultBean> result;
      private int currposition = 0;
      private boolean onlyOne=true;


      public NewAdapter(Context context, List<NewBean.ResultBean> result) {
            this.context = context;
            this.result = result;
      }

      @Override
      public int getCount() {
            return result.size();
      }

      @Override
      public Object getItem(int i) {
            return result.get(i);
      }

      @Override
      public long getItemId(int i) {
            return 0;
      }

      @Override
      public View getView(int i, View view, ViewGroup viewGroup) {
            currposition = i;
            ViewHolder viewHolder;
            if (view == null) {
                  view = View.inflate(context, R.layout.newdiscuss, null);
                  viewHolder = new ViewHolder(view);
                  view.setTag(viewHolder);
            } else {
                  viewHolder = (ViewHolder) view.getTag();
            }
            NewBean.ResultBean resultBean = result.get(i);
            bindData(i, viewHolder, resultBean);

            setEvent(viewHolder, resultBean);
            return view;
      }

      private void setEvent(final ViewHolder viewHolder, final NewBean.ResultBean resultBean) {
            viewHolder.rgDiscuss.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                        if (viewHolder.llSay.isShown()) {
                              viewHolder.llSay.setVisibility(View.GONE);
                        } else {
                              viewHolder.llSay.setVisibility(View.VISIBLE);
                        }
                  }
            });
            viewHolder.rbLike.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                        int i = Integer.parseInt(resultBean.getLikes());
                        if (onlyOne) {
                              viewHolder.rbLike.setText(++i+"");
                              onlyOne=false;
                              viewHolder.rbLike.setBackgroundColor(Color.RED);
                              Toast.makeText(context, "455", Toast.LENGTH_SHORT).show();
                        } else {
                              onlyOne= true;
                              viewHolder.rbLike.setBackgroundColor(Color.WHITE);
                              viewHolder.rbLike.setText(--i+"");
                        }
                        resultBean.setLikes(i + "");
                  }
            });
            viewHolder.btnSend.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                        String s = viewHolder.etSay.getText().toString();
                        if (s != null && s.length() > 0) {
                              showDa(s, viewHolder);
                              int i = Integer.parseInt(resultBean.getComments());
                              viewHolder.rgDiscuss.setText(++i+"");
                              resultBean.setComments(i + "");

                        } else {
                              Toast.makeText(context, "不能为空", Toast.LENGTH_SHORT).show();
                        }
                  }

            });

      }

      private void showDa(String s, ViewHolder viewHolder) {
            viewHolder.dvShow.addItemToHead(new DanmakuItem(context, s, (int) (Math.random() * viewHolder.dvShow.getX())));
            viewHolder.etSay.setText("");
      }

      private void bindData(int i, ViewHolder viewHolder, NewBean.ResultBean resultBean) {

            Glide.with(context).load(Constants.IMG_URL + resultBean.getAvatar()).override(30, 30).fitCenter().into(viewHolder.ivUserIcon);
            viewHolder.tvUserName.setText(resultBean.getUsername());
            resovleHide(viewHolder, resultBean);
            viewHolder.tvShowdate.setText(TimeUtil.parseTime(resultBean.getAdd_time()));
            Glide.with(context).load(Constants.IMG_URL + resultBean.getAvatar()).override(200, 200).fitCenter().into(viewHolder.ivShowpic);
            viewHolder.tvGoodsdesc.setText(resultBean.getSaying());
            viewHolder.rbLike.setText(resultBean.getLikes());
            viewHolder.rgDiscuss.setText(resultBean.getComments());
            List<IDanmakuItem> list = new ArrayList<>();
            List<String> comment_list = resultBean.getComment_list();
            for (int num = 0; num < comment_list.size(); num++) {
                  IDanmakuItem id = new DanmakuItem(context, comment_list.get(num), (int) (Math.random() * viewHolder.dvShow.getX()));
                  list.add(id);
            }
            //打乱   下次 不一样
            Collections.shuffle(comment_list);
            viewHolder.dvShow.addItem(list, false);
            viewHolder.dvShow.show();
      }

      /**
       * 显示和隐藏
       *
       * @param viewHolder
       * @param resultBean
       */
      private void resovleHide(ViewHolder viewHolder, NewBean.ResultBean resultBean) {
            int isAllHide = 0;
            if ("0".equals(resultBean.getIs_hot())) {
                  viewHolder.tvIshot.setVisibility(View.GONE);
                  isAllHide++;
            } else {
                  viewHolder.tvIshot.setVisibility(View.VISIBLE);
            }
            if ("0".equals(resultBean.getIs_top())) {
                  viewHolder.tvIsTop.setVisibility(View.GONE);
                  isAllHide++;
            } else {
                  viewHolder.tvIsTop.setVisibility(View.VISIBLE);
            }
            if ("0".equals(resultBean.getIs_like())) {
                  viewHolder.tvIsElite.setVisibility(View.GONE);
                  isAllHide++;
            } else {
                  viewHolder.tvIsElite.setVisibility(View.VISIBLE);
            }
            if (isAllHide == 3) {
                  viewHolder.llHotDiscuss.setVisibility(View.GONE);

            } else {

                  viewHolder.llHotDiscuss.setVisibility(View.VISIBLE);
            }
      }


      static class ViewHolder {
            @BindView(R.id.iv_user_icon)
            ImageView ivUserIcon;
            @BindView(R.id.tv_user_name)
            TextView tvUserName;
            @BindView(R.id.tv_showdate)
            TextView tvShowdate;
            @BindView(R.id.iv_showpic)
            ImageView ivShowpic;
            @BindView(R.id.dv_show)
            DanmakuView dvShow;
            @BindView(R.id.tv_goodsdesc)
            TextView tvGoodsdesc;
            @BindView(R.id.tv_ishot)
            TextView tvIshot;
            @BindView(R.id.tv_isTop)
            TextView tvIsTop;
            @BindView(R.id.tv_isElite)
            TextView tvIsElite;
            @BindView(R.id.ll_hot_discuss)
            LinearLayout llHotDiscuss;
            @BindView(R.id.rb_like)
            RadioButton rbLike;
            @BindView(R.id.iv_diviver)
            ImageView ivDiviver;
            @BindView(R.id.rg_discuss)
            RadioButton rgDiscuss;
            @BindView(R.id.et_say)
            EditText etSay;
            @BindView(R.id.btn_send)
            Button btnSend;
            @BindView(R.id.ll_say)
            LinearLayout llSay;

            ViewHolder(View view) {
                  ButterKnife.bind(this, view);
            }
      }
}
