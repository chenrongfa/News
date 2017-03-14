package chen.yy.com.news.news.bean;

import java.util.List;

/**
 * News
 * Created by chenrongfa on 2017/3/7
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class NewsPagerBean {
  private Data data;
	private String retcode;

	@Override
	public String toString() {
		return "NewsPagerBean{" +
				"data=" + data +
				", retcode='" + retcode + '\'' +
				'}';
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public String getRetcode() {
		return retcode;
	}

	public void setRetcode(String retcode) {
		this.retcode = retcode;
	}

	public class Data{
		public String getCountcommenturl() {
			return countcommenturl;
		}

		public void setCountcommenturl(String countcommenturl) {
			this.countcommenturl = countcommenturl;
		}

		public String getMore() {
			return more;
		}

		public void setMore(String more) {
			this.more = more;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public List<String> getTopic() {
			return topic;
		}

		public void setTopic(List<String> topic) {
			this.topic = topic;
		}

		public List<News> getNews() {
			return news;
		}

		public void setNews(List<News> news) {
			this.news = news;
		}

		public List<Topnews> getTopnews() {
			return topnews;
		}

		public void setTopnews(List<Topnews> topnews) {
			this.topnews = topnews;
		}

		@Override
		public String toString() {
			return "Data{" +
					"countcommenturl='" + countcommenturl + '\'' +
					", more='" + more + '\'' +
					", title='" + title + '\'' +
					", topic=" + topic +
					", news=" + news +
					", topnews=" + topnews +
					'}';
		}

		private String countcommenturl;
		private String more;
		private String title;
		private List<String> topic;
		private List<News> news;
		private List<Topnews> topnews;
      public class  News{
		  @Override
		  public String toString() {
			  return "News{" +
					  "comment='" + comment + '\'' +
					  ", commentlist='" + commentlist + '\'' +
					  ", commenturl='" + commenturl + '\'' +
					  ", listimage='" + listimage + '\'' +
					  ", pubdate='" + pubdate + '\'' +
					  ", title='" + title + '\'' +
					  ", type='" + type + '\'' +
					  ", url='" + url + '\'' +
					  ", id=" + id +
					  '}';
		  }

		  public String getComment() {
			  return comment;
		  }

		  public void setComment(String comment) {
			  this.comment = comment;
		  }

		  public String getCommentlist() {
			  return commentlist;
		  }

		  public void setCommentlist(String commentlist) {
			  this.commentlist = commentlist;
		  }

		  public String getCommenturl() {
			  return commenturl;
		  }

		  public void setCommenturl(String commenturl) {
			  this.commenturl = commenturl;
		  }

		  public String getListimage() {
			  return listimage;
		  }

		  public void setListimage(String listimage) {
			  this.listimage = listimage;
		  }

		  public String getPubdate() {
			  return pubdate;
		  }

		  public void setPubdate(String pubdate) {
			  this.pubdate = pubdate;
		  }

		  public String getTitle() {
			  return title;
		  }

		  public void setTitle(String title) {
			  this.title = title;
		  }

		  public String getType() {
			  return type;
		  }

		  public void setType(String type) {
			  this.type = type;
		  }

		  public String getUrl() {
			  return url;
		  }

		  public void setUrl(String url) {
			  this.url = url;
		  }

		  public int getId() {
			  return id;
		  }

		  public void setId(int id) {
			  this.id = id;
		  }

		  private String comment;
     private String commentlist;
     private String commenturl;
     private String listimage;
     private String pubdate;
     private String title;
     private String type;
     private String url;
     private int  id;

	  }
      public class  Topnews{
		  private String comment;
		  private String commentlist;
		  private String commenturl;
		  private String topimage;

		  @Override
		  public String toString() {
			  return "Topnews{" +
					  "comment='" + comment + '\'' +
					  ", commentlist='" + commentlist + '\'' +
					  ", commenturl='" + commenturl + '\'' +
					  ", topimage='" + topimage + '\'' +
					  ", pubdate='" + pubdate + '\'' +
					  ", title='" + title + '\'' +
					  ", type='" + type + '\'' +
					  ", url='" + url + '\'' +
					  ", id=" + id +
					  '}';
		  }

		  public String getComment() {
			  return comment;
		  }

		  public void setComment(String comment) {
			  this.comment = comment;
		  }

		  public String getCommentlist() {
			  return commentlist;
		  }

		  public void setCommentlist(String commentlist) {
			  this.commentlist = commentlist;
		  }

		  public String getCommenturl() {
			  return commenturl;
		  }

		  public void setCommenturl(String commenturl) {
			  this.commenturl = commenturl;
		  }

		  public String getTopimage() {
			  return topimage;
		  }

		  public void setTopimage(String topimage) {
			  this.topimage = topimage;
		  }

		  public String getPubdate() {
			  return pubdate;
		  }

		  public void setPubdate(String pubdate) {
			  this.pubdate = pubdate;
		  }

		  public String getTitle() {
			  return title;
		  }

		  public void setTitle(String title) {
			  this.title = title;
		  }

		  public String getType() {
			  return type;
		  }

		  public void setType(String type) {
			  this.type = type;
		  }

		  public String getUrl() {
			  return url;
		  }

		  public void setUrl(String url) {
			  this.url = url;
		  }

		  public int getId() {
			  return id;
		  }

		  public void setId(int id) {
			  this.id = id;
		  }

		  private String pubdate;
		  private String title;
		  private String type;
		  private String url;
		  private int  id;

	  }

	}

}
