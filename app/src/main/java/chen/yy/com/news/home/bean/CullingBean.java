package chen.yy.com.news.home.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * News
 * Created by chenrongfa on 2017/3/16
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class CullingBean {

	private int ret;
	private ForecastBean forecast;
	private String version;
	private int timestamp;
	private List<IdlistBean> idlist;

	@Override
	public String toString() {
		return "CullingBean{" +
				"ret=" + ret +
				", forecast=" + forecast +
				", version='" + version + '\'' +
				", timestamp=" + timestamp +
				", idlist=" + idlist +
				'}';
	}

	public int getRet() {
		return ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}

	public ForecastBean getForecast() {
		return forecast;
	}

	public void setForecast(ForecastBean forecast) {
		this.forecast = forecast;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	public List<IdlistBean> getIdlist() {
		return idlist;
	}

	public void setIdlist(List<IdlistBean> idlist) {
		this.idlist = idlist;
	}

	public static class ForecastBean {
		@Override
		public String toString() {
			return "ForecastBean{" +
					"num=" + num +
					", title='" + title + '\'' +
					", start_time=" + start_time +
					'}';
		}

		/**
		 * num : 34
		 * title : 理想国丨在菜市场遇见心中的上海
		 * start_time : 1489723200
		 */

		private int num;
		private String title;
		private long start_time;

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public long getStart_time() {
			return start_time;
		}

		public void setStart_time(long start_time) {
			this.start_time = start_time;
		}
	}

	public static class IdlistBean {
		@Override
		public String toString() {
			return "IdlistBean{" +
					"setction='" + section + '\'' +
					", ids=" + ids +
					", newslist=" + newslist +
					'}';
		}

		public String getSection() {
			return section;
		}

		public void setSection(String section) {
			this.section = section;
		}

		private String section;
		private List<IdsBean> ids;
		private List<NewslistBean> newslist;



		public List<IdsBean> getIds() {
			return ids;
		}

		public void setIds(List<IdsBean> ids) {
			this.ids = ids;
		}

		public List<NewslistBean> getNewslist() {
			return newslist;
		}

		public void setNewslist(List<NewslistBean> newslist) {
			this.newslist = newslist;
		}

		public class IdsBean {
			@Override
			public String toString() {
				return "IdsBean{" +
						"id='" + id + '\'' +
						", exist=" + exist +
						", comments=" + comments +
						", hidepic=" + hidepic +
						'}';
			}

			private String id;
			private int exist;
			private int comments;
			private int hidepic;


			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public int getExist() {
				return exist;
			}

			public void setExist(int exist) {
				this.exist = exist;
			}

			public int getComments() {
				return comments;
			}

			public void setComments(int comments) {
				this.comments = comments;
			}

			public int getHidepic() {
				return hidepic;
			}

			public void setHidepic(int hidepic) {
				this.hidepic = hidepic;
			}
		}

			public static class NewslistBean {

				@Override
				public String toString() {
					return "NewslistBean{" +
							"id='" + id + '\'' +
							", uinnick='" + uinnick + '\'' +
							", uinname='" + uinname + '\'' +
							", title='" + title + '\'' +
							", longtitle='" + longtitle + '\'' +
							", surl='" + surl + '\'' +
							", short_url='" + short_url + '\'' +
							", weiboid='" + weiboid + '\'' +
							", commentid='" + commentid + '\'' +
							", url='" + url + '\'' +
							", time='" + time + '\'' +
							", timestamp=" + timestamp +
							", articletype='" + articletype + '\'' +
							", media_id='" + media_id + '\'' +
							", showType_video='" + showType_video + '\'' +
							", qishu='" + qishu + '\'' +
							", source='" + source + '\'' +
							", imagecount=" + imagecount +
							", comment='" + comment + '\'' +
							", flag='" + flag + '\'' +
							", abstractX='" + abstractX + '\'' +
							", pushCommentCount=" + pushCommentCount +
							", graphicLiveID='" + graphicLiveID + '\'' +
							", specialID='" + specialID + '\'' +
							", showType='" + showType + '\'' +
							", show_expr=" + show_expr +
							", openAds=" + openAds +
							", openAdsText=" + openAdsText +
							", openAdsComment=" + openAdsComment +
							", openAdsPhotos=" + openAdsPhotos +
							", adTitle='" + adTitle + '\'' +
							", chlid='" + chlid + '\'' +
							", gesture=" + gesture +
							", smallWindow=" + smallWindow +
							", openBigImage=" + openBigImage +
							", FadCid='" + FadCid + '\'' +
							", video_channel=" + video_channel +
							", live_info=" + live_info +
							", card=" + card +
							", is_live=" + is_live +
							", roseLiveStatus='" + roseLiveStatus + '\'' +
							", zhibo_vid='" + zhibo_vid + '\'' +
							", picShowType=" + picShowType +
							", show_source=" + show_source +
							", forbidCommentUpDown=" + forbidCommentUpDown +
							", disableDeclare=" + disableDeclare +
							", disableDelete=" + disableDelete +
							", isSensitive=" + isSensitive +
							", forbidRedPacket=" + forbidRedPacket +
							", roseLiveID='" + roseLiveID + '\'' +
							", roseFlag='" + roseFlag + '\'' +
							", zhibo_audio_flag='" + zhibo_audio_flag + '\'' +
							", roseHeadType=" + roseHeadType +
							", enableCommentPic=" + enableCommentPic +
							", specialData=" + specialData +
							", roseLiveFinishAt='" + roseLiveFinishAt + '\'' +
							", thumbnails_qqnews_photo=" + thumbnails_qqnews_photo +
							", thumbnails_qqnews=" + thumbnails_qqnews +
							", thumbnails=" + thumbnails +
							", tag=" + tag +
							'}';
				}

				private String id;
				private String uinnick;
				private String uinname;
				private String title;
				private String longtitle;
				private String surl;
				private String short_url;
				private String weiboid;
				private String commentid;
				private String url;
				private String time;
				private int timestamp;
				private String articletype;
				private String media_id;
				private String showType_video;
				private String qishu;
				private String source;
				private int imagecount;
				private String comment;
				private String flag;
				@SerializedName("abstract")
				@JSONField(name = "abstract")
				private String abstractX;
				private int pushCommentCount;
				private String graphicLiveID;
				private String specialID;
				private String showType;
				private int show_expr;
				private int openAds;
				private int openAdsText;
				private int openAdsComment;
				private int openAdsPhotos;
				private String adTitle;
				private String chlid;
				private int gesture;
				private int smallWindow;
				private int openBigImage;
				private String FadCid;
				private VideoChannelBean video_channel;
				private LiveInfoBean live_info;
				private CardBean card;
				private int is_live;
				private String roseLiveStatus;
				private String zhibo_vid;
				private int picShowType;
				private int show_source;
				private int forbidCommentUpDown;
				private int disableDeclare;
				private int disableDelete;
				private int isSensitive;
				private int forbidRedPacket;
				private String roseLiveID;
				private String roseFlag;
				private String zhibo_audio_flag;
				private int roseHeadType;
				private int enableCommentPic;
				private SpecialDataBean specialData;
				private String roseLiveFinishAt;
				private List<String> thumbnails_qqnews_photo;
				private List<String> thumbnails_qqnews;
				private List<String> thumbnails;
				private List<?> tag;

				public String getId() {
					return id;
				}

				public void setId(String id) {
					this.id = id;
				}

				public String getUinnick() {
					return uinnick;
				}

				public void setUinnick(String uinnick) {
					this.uinnick = uinnick;
				}

				public String getUinname() {
					return uinname;
				}

				public void setUinname(String uinname) {
					this.uinname = uinname;
				}

				public String getTitle() {
					return title;
				}

				public void setTitle(String title) {
					this.title = title;
				}

				public String getLongtitle() {
					return longtitle;
				}

				public void setLongtitle(String longtitle) {
					this.longtitle = longtitle;
				}

				public String getSurl() {
					return surl;
				}

				public void setSurl(String surl) {
					this.surl = surl;
				}

				public String getShort_url() {
					return short_url;
				}

				public void setShort_url(String short_url) {
					this.short_url = short_url;
				}

				public String getWeiboid() {
					return weiboid;
				}

				public void setWeiboid(String weiboid) {
					this.weiboid = weiboid;
				}

				public String getCommentid() {
					return commentid;
				}

				public void setCommentid(String commentid) {
					this.commentid = commentid;
				}

				public String getUrl() {
					return url;
				}

				public void setUrl(String url) {
					this.url = url;
				}

				public String getTime() {
					return time;
				}

				public void setTime(String time) {
					this.time = time;
				}

				public int getTimestamp() {
					return timestamp;
				}

				public void setTimestamp(int timestamp) {
					this.timestamp = timestamp;
				}

				public String getArticletype() {
					return articletype;
				}

				public void setArticletype(String articletype) {
					this.articletype = articletype;
				}

				public String getMedia_id() {
					return media_id;
				}

				public void setMedia_id(String media_id) {
					this.media_id = media_id;
				}

				public String getShowType_video() {
					return showType_video;
				}

				public void setShowType_video(String showType_video) {
					this.showType_video = showType_video;
				}

				public String getQishu() {
					return qishu;
				}

				public void setQishu(String qishu) {
					this.qishu = qishu;
				}

				public String getSource() {
					return source;
				}

				public void setSource(String source) {
					this.source = source;
				}

				public int getImagecount() {
					return imagecount;
				}

				public void setImagecount(int imagecount) {
					this.imagecount = imagecount;
				}

				public String getComment() {
					return comment;
				}

				public void setComment(String comment) {
					this.comment = comment;
				}

				public String getFlag() {
					return flag;
				}

				public void setFlag(String flag) {
					this.flag = flag;
				}

				public String getAbstractX() {
					return abstractX;
				}

				public void setAbstractX(String abstractX) {
					this.abstractX = abstractX;
				}

				public int getPushCommentCount() {
					return pushCommentCount;
				}

				public void setPushCommentCount(int pushCommentCount) {
					this.pushCommentCount = pushCommentCount;
				}

				public String getGraphicLiveID() {
					return graphicLiveID;
				}

				public void setGraphicLiveID(String graphicLiveID) {
					this.graphicLiveID = graphicLiveID;
				}

				public String getSpecialID() {
					return specialID;
				}

				public void setSpecialID(String specialID) {
					this.specialID = specialID;
				}

				public String getShowType() {
					return showType;
				}

				public void setShowType(String showType) {
					this.showType = showType;
				}

				public int getShow_expr() {
					return show_expr;
				}

				public void setShow_expr(int show_expr) {
					this.show_expr = show_expr;
				}

				public int getOpenAds() {
					return openAds;
				}

				public void setOpenAds(int openAds) {
					this.openAds = openAds;
				}

				public int getOpenAdsText() {
					return openAdsText;
				}

				public void setOpenAdsText(int openAdsText) {
					this.openAdsText = openAdsText;
				}

				public int getOpenAdsComment() {
					return openAdsComment;
				}

				public void setOpenAdsComment(int openAdsComment) {
					this.openAdsComment = openAdsComment;
				}

				public int getOpenAdsPhotos() {
					return openAdsPhotos;
				}

				public void setOpenAdsPhotos(int openAdsPhotos) {
					this.openAdsPhotos = openAdsPhotos;
				}

				public String getAdTitle() {
					return adTitle;
				}

				public void setAdTitle(String adTitle) {
					this.adTitle = adTitle;
				}

				public String getChlid() {
					return chlid;
				}

				public void setChlid(String chlid) {
					this.chlid = chlid;
				}

				public int getGesture() {
					return gesture;
				}

				public void setGesture(int gesture) {
					this.gesture = gesture;
				}

				public int getSmallWindow() {
					return smallWindow;
				}

				public void setSmallWindow(int smallWindow) {
					this.smallWindow = smallWindow;
				}

				public int getOpenBigImage() {
					return openBigImage;
				}

				public void setOpenBigImage(int openBigImage) {
					this.openBigImage = openBigImage;
				}

				public String getFadCid() {
					return FadCid;
				}

				public void setFadCid(String FadCid) {
					this.FadCid = FadCid;
				}

				public VideoChannelBean getVideo_channel() {
					return video_channel;
				}

				public void setVideo_channel(VideoChannelBean video_channel) {
					this.video_channel = video_channel;
				}

				public LiveInfoBean getLive_info() {
					return live_info;
				}

				public void setLive_info(LiveInfoBean live_info) {
					this.live_info = live_info;
				}

				public CardBean getCard() {
					return card;
				}

				public void setCard(CardBean card) {
					this.card = card;
				}

				public int getIs_live() {
					return is_live;
				}

				public void setIs_live(int is_live) {
					this.is_live = is_live;
				}

				public String getRoseLiveStatus() {
					return roseLiveStatus;
				}

				public void setRoseLiveStatus(String roseLiveStatus) {
					this.roseLiveStatus = roseLiveStatus;
				}

				public String getZhibo_vid() {
					return zhibo_vid;
				}

				public void setZhibo_vid(String zhibo_vid) {
					this.zhibo_vid = zhibo_vid;
				}

				public int getPicShowType() {
					return picShowType;
				}

				public void setPicShowType(int picShowType) {
					this.picShowType = picShowType;
				}

				public int getShow_source() {
					return show_source;
				}

				public void setShow_source(int show_source) {
					this.show_source = show_source;
				}

				public int getForbidCommentUpDown() {
					return forbidCommentUpDown;
				}

				public void setForbidCommentUpDown(int forbidCommentUpDown) {
					this.forbidCommentUpDown = forbidCommentUpDown;
				}

				public int getDisableDeclare() {
					return disableDeclare;
				}

				public void setDisableDeclare(int disableDeclare) {
					this.disableDeclare = disableDeclare;
				}

				public int getDisableDelete() {
					return disableDelete;
				}

				public void setDisableDelete(int disableDelete) {
					this.disableDelete = disableDelete;
				}

				public int getIsSensitive() {
					return isSensitive;
				}

				public void setIsSensitive(int isSensitive) {
					this.isSensitive = isSensitive;
				}

				public int getForbidRedPacket() {
					return forbidRedPacket;
				}

				public void setForbidRedPacket(int forbidRedPacket) {
					this.forbidRedPacket = forbidRedPacket;
				}

				public String getRoseLiveID() {
					return roseLiveID;
				}

				public void setRoseLiveID(String roseLiveID) {
					this.roseLiveID = roseLiveID;
				}

				public String getRoseFlag() {
					return roseFlag;
				}

				public void setRoseFlag(String roseFlag) {
					this.roseFlag = roseFlag;
				}

				public String getZhibo_audio_flag() {
					return zhibo_audio_flag;
				}

				public void setZhibo_audio_flag(String zhibo_audio_flag) {
					this.zhibo_audio_flag = zhibo_audio_flag;
				}

				public int getRoseHeadType() {
					return roseHeadType;
				}

				public void setRoseHeadType(int roseHeadType) {
					this.roseHeadType = roseHeadType;
				}

				public int getEnableCommentPic() {
					return enableCommentPic;
				}

				public void setEnableCommentPic(int enableCommentPic) {
					this.enableCommentPic = enableCommentPic;
				}

				public SpecialDataBean getSpecialData() {
					return specialData;
				}

				public void setSpecialData(SpecialDataBean specialData) {
					this.specialData = specialData;
				}

				public String getRoseLiveFinishAt() {
					return roseLiveFinishAt;
				}

				public void setRoseLiveFinishAt(String roseLiveFinishAt) {
					this.roseLiveFinishAt = roseLiveFinishAt;
				}

				public List<String> getThumbnails_qqnews_photo() {
					return thumbnails_qqnews_photo;
				}

				public void setThumbnails_qqnews_photo(List<String> thumbnails_qqnews_photo) {
					this.thumbnails_qqnews_photo = thumbnails_qqnews_photo;
				}

				public List<String> getThumbnails_qqnews() {
					return thumbnails_qqnews;
				}

				public void setThumbnails_qqnews(List<String> thumbnails_qqnews) {
					this.thumbnails_qqnews = thumbnails_qqnews;
				}

				public List<String> getThumbnails() {
					return thumbnails;
				}

				public void setThumbnails(List<String> thumbnails) {
					this.thumbnails = thumbnails;
				}

				public List<?> getTag() {
					return tag;
				}

				public void setTag(List<?> tag) {
					this.tag = tag;
				}

				public static class VideoChannelBean {
					/**
					 * egid : 20170316A01V8I00
					 * eid : 1
					 * video : {"videosourcetype":2,"playmode":1,"playurl":"http://inews.qq.com/webVideo?vid=407122802","vid":"","desc":"家乡有腔调|观音菩萨生日，客家人这样贺寿（上）","img":"http://inews.gtimg.com/newsapp_ls/0/1267160125_580328/0","broadcast":{"url":"http://zb.v.qq.com:1863/?progid=407122802&amp;ostype=ios&amp;ver=2.0&amp;apptype=qqnews_android","starttime":"2017-03-16 09:58:37","endtime":"2038-01-19 11:14:07","progid":"407122802"},"is_multi_streams":0,"pid":"1052311927"}
					 */

					private String egid;
					private String eid;
					private VideoBean video;

					public String getEgid() {
						return egid;
					}

					public void setEgid(String egid) {
						this.egid = egid;
					}

					public String getEid() {
						return eid;
					}

					public void setEid(String eid) {
						this.eid = eid;
					}

					public VideoBean getVideo() {
						return video;
					}

					public void setVideo(VideoBean video) {
						this.video = video;
					}

					public static class VideoBean {
						/**
						 * videosourcetype : 2
						 * playmode : 1
						 * playurl : http://inews.qq.com/webVideo?vid=407122802
						 * vid :
						 * desc : 家乡有腔调|观音菩萨生日，客家人这样贺寿（上）
						 * img : http://inews.gtimg.com/newsapp_ls/0/1267160125_580328/0
						 * broadcast : {"url":"http://zb.v.qq.com:1863/?progid=407122802&amp;ostype=ios&amp;ver=2.0&amp;apptype=qqnews_android","starttime":"2017-03-16 09:58:37","endtime":"2038-01-19 11:14:07","progid":"407122802"}
						 * is_multi_streams : 0
						 * pid : 1052311927
						 */

						private int videosourcetype;
						private int playmode;
						private String playurl;
						private String vid;
						private String desc;
						private String img;
						private BroadcastBean broadcast;
						private int is_multi_streams;
						private String pid;

						public int getVideosourcetype() {
							return videosourcetype;
						}

						public void setVideosourcetype(int videosourcetype) {
							this.videosourcetype = videosourcetype;
						}

						public int getPlaymode() {
							return playmode;
						}

						public void setPlaymode(int playmode) {
							this.playmode = playmode;
						}

						public String getPlayurl() {
							return playurl;
						}

						public void setPlayurl(String playurl) {
							this.playurl = playurl;
						}

						public String getVid() {
							return vid;
						}

						public void setVid(String vid) {
							this.vid = vid;
						}

						public String getDesc() {
							return desc;
						}

						public void setDesc(String desc) {
							this.desc = desc;
						}

						public String getImg() {
							return img;
						}

						public void setImg(String img) {
							this.img = img;
						}

						public BroadcastBean getBroadcast() {
							return broadcast;
						}

						public void setBroadcast(BroadcastBean broadcast) {
							this.broadcast = broadcast;
						}

						public int getIs_multi_streams() {
							return is_multi_streams;
						}

						public void setIs_multi_streams(int is_multi_streams) {
							this.is_multi_streams = is_multi_streams;
						}

						public String getPid() {
							return pid;
						}

						public void setPid(String pid) {
							this.pid = pid;
						}

						public static class BroadcastBean {
							/**
							 * url : http://zb.v.qq.com:1863/?progid=407122802&amp;ostype=ios&amp;ver=2.0&amp;apptype=qqnews_android
							 * starttime : 2017-03-16 09:58:37
							 * endtime : 2038-01-19 11:14:07
							 * progid : 407122802
							 */

							private String url;
							private String starttime;
							private String endtime;
							private String progid;

							public String getUrl() {
								return url;
							}

							public void setUrl(String url) {
								this.url = url;
							}

							public String getStarttime() {
								return starttime;
							}

							public void setStarttime(String starttime) {
								this.starttime = starttime;
							}

							public String getEndtime() {
								return endtime;
							}

							public void setEndtime(String endtime) {
								this.endtime = endtime;
							}

							public String getProgid() {
								return progid;
							}

							public void setProgid(String progid) {
								this.progid = progid;
							}
						}
					}
				}

				public static class LiveInfoBean {
					/**
					 * live_status : 2
					 * start_time : 1489629517
					 * end_time : 2147483647
					 * match_type : 0
					 * screenType : 0
					 * online_total : 11553
					 * up_num : 1
					 * orderLive_num : 0
					 */

					private int live_status;
					private long start_time;
					private long end_time;
					private int match_type;
					private int screenType;
					private int online_total;
					private int up_num;
					private int orderLive_num;

					public int getLive_status() {
						return live_status;
					}

					public void setLive_status(int live_status) {
						this.live_status = live_status;
					}

					public long getStart_time() {
						return start_time;
					}

					public void setStart_time(long start_time) {
						this.start_time = start_time;
					}

					public long getEnd_time() {
						return end_time;
					}

					public void setEnd_time(long end_time) {
						this.end_time = end_time;
					}

					public int getMatch_type() {
						return match_type;
					}

					public void setMatch_type(int match_type) {
						this.match_type = match_type;
					}

					public int getScreenType() {
						return screenType;
					}

					public void setScreenType(int screenType) {
						this.screenType = screenType;
					}

					public int getOnline_total() {
						return online_total;
					}

					public void setOnline_total(int online_total) {
						this.online_total = online_total;
					}

					public int getUp_num() {
						return up_num;
					}

					public void setUp_num(int up_num) {
						this.up_num = up_num;
					}

					public int getOrderLive_num() {
						return orderLive_num;
					}

					public void setOrderLive_num(int orderLive_num) {
						this.orderLive_num = orderLive_num;
					}
				}

				public static class CardBean {
					/**
					 * chlname : 二手历史
					 * chlid : 5470326
					 * desc : 讲述正史、野史；古今多少事，都付笑谈中。
					 * icon : http://inews.gtimg.com/newsapp_ls/0/1162108921_200200/0
					 * uin : ec8bb1459b9d84100312bf035bb43cd4d0
					 * intro :
					 * subCount : 49
					 * msgEntry : 1
					 * pubCount : 17
					 */

					private String chlname;
					private String chlid;
					private String desc;
					private String icon;
					private String uin;
					private String intro;
					private int subCount;
					private int msgEntry;
					private int pubCount;

					public String getChlname() {
						return chlname;
					}

					public void setChlname(String chlname) {
						this.chlname = chlname;
					}

					public String getChlid() {
						return chlid;
					}

					public void setChlid(String chlid) {
						this.chlid = chlid;
					}

					public String getDesc() {
						return desc;
					}

					public void setDesc(String desc) {
						this.desc = desc;
					}

					public String getIcon() {
						return icon;
					}

					public void setIcon(String icon) {
						this.icon = icon;
					}

					public String getUin() {
						return uin;
					}

					public void setUin(String uin) {
						this.uin = uin;
					}

					public String getIntro() {
						return intro;
					}

					public void setIntro(String intro) {
						this.intro = intro;
					}

					public int getSubCount() {
						return subCount;
					}

					public void setSubCount(int subCount) {
						this.subCount = subCount;
					}

					public int getMsgEntry() {
						return msgEntry;
					}

					public void setMsgEntry(int msgEntry) {
						this.msgEntry = msgEntry;
					}

					public int getPubCount() {
						return pubCount;
					}

					public void setPubCount(int pubCount) {
						this.pubCount = pubCount;
					}
				}

				public static class SpecialDataBean {
					/**
					 * ztTitle : 「股市财经」系列直播
					 * titlePre : 正在直播
					 * liveNum : 4
					 */

					private String ztTitle;
					private String titlePre;
					private int liveNum;

					public String getZtTitle() {
						return ztTitle;
					}

					public void setZtTitle(String ztTitle) {
						this.ztTitle = ztTitle;
					}

					public String getTitlePre() {
						return titlePre;
					}

					public void setTitlePre(String titlePre) {
						this.titlePre = titlePre;
					}

					public int getLiveNum() {
						return liveNum;
					}

					public void setLiveNum(int liveNum) {
						this.liveNum = liveNum;
					}
				}

			}

	}
}
