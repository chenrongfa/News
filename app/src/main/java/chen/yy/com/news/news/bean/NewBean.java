package chen.yy.com.news.news.bean;

import java.util.List;

/**
 * shopmall2
 * Created by chenrongfa on 2017/2/11
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class NewBean {
      private int code;
      private String msg;
      private List<ResultBean> result;

      public int getCode() {
            return code;
      }

      public void setCode(int code) {
            this.code = code;
      }

      public String getMsg() {
            return msg;
      }

      public void setMsg(String msg) {
            this.msg = msg;
      }

      public List<ResultBean> getResult() {
            return result;
      }

      public void setResult(List<ResultBean> result) {
            this.result = result;
      }

      public static class ResultBean {
            /**
             * add_time : 1478935514
             * avatar : /img/user_icon.png
             * comment_list : ["亲,有任何货物质量问题请及时联系我哦","亲，快来抢购吧"]
             * comments : 0
             * figure : /ugc/post/img/201611/14789355052991819.jpeg
             * is_essence : 0
             * is_hot : 0
             * is_like : 0
             * is_top : 0
             * likes : 0
             * post_id : 2646
             * saying : [尚硅谷购物节]抽我抽我抽我
             * user_id : 261219
             * username : 下一个明天丶高姿态活着
             */

            private String add_time;
            private String avatar;
            private String comments;
            private String figure;
            private String is_essence;
            private String is_hot;
            private String is_like;
            private String is_top;
            private String likes;
            private String post_id;
            private String saying;
            private String user_id;
            private String username;
            private List<String> comment_list;

            public String getAdd_time() {
                  return add_time;
            }

            public void setAdd_time(String add_time) {
                  this.add_time = add_time;
            }

            public String getAvatar() {
                  return avatar;
            }

            public void setAvatar(String avatar) {
                  this.avatar = avatar;
            }

            public String getComments() {
                  return comments;
            }

            public void setComments(String comments) {
                  this.comments = comments;
            }

            public String getFigure() {
                  return figure;
            }

            public void setFigure(String figure) {
                  this.figure = figure;
            }

            public String getIs_essence() {
                  return is_essence;
            }

            public void setIs_essence(String is_essence) {
                  this.is_essence = is_essence;
            }

            public String getIs_hot() {
                  return is_hot;
            }

            public void setIs_hot(String is_hot) {
                  this.is_hot = is_hot;
            }

            public String getIs_like() {
                  return is_like;
            }

            public void setIs_like(String is_like) {
                  this.is_like = is_like;
            }

            public String getIs_top() {
                  return is_top;
            }

            public void setIs_top(String is_top) {
                  this.is_top = is_top;
            }

            public String getLikes() {
                  return likes;
            }

            public void setLikes(String likes) {
                  this.likes = likes;
            }

            public String getPost_id() {
                  return post_id;
            }

            public void setPost_id(String post_id) {
                  this.post_id = post_id;
            }

            public String getSaying() {
                  return saying;
            }

            public void setSaying(String saying) {
                  this.saying = saying;
            }

            public String getUser_id() {
                  return user_id;
            }

            public void setUser_id(String user_id) {
                  this.user_id = user_id;
            }

            public String getUsername() {
                  return username;
            }

            public void setUsername(String username) {
                  this.username = username;
            }

            public List<String> getComment_list() {
                  return comment_list;
            }

            public void setComment_list(List<String> comment_list) {
                  this.comment_list = comment_list;
            }
      }
}
