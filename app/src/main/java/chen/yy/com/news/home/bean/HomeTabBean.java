package chen.yy.com.news.home.bean;

import java.util.List;

/**
 * News
 * Created by chenrongfa on 2017/3/16
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class HomeTabBean {

	/**
	 * ret : 0
	 * version : 0.4
	 * channellist : [{"chlid":"news_live_main","chlname":"精选","type":"home"},{"chlid":"news_live_kn","chlname":"两会","type":"sub"},{"chlid":"news_live_info","chlname":"资讯","type":"sub"},{"chlid":"news_live_art","chlname":"文艺","type":"sub"},{"chlid":"news_live_ent","chlname":"娱乐","type":"sub"},{"chlid":"news_live_finance","chlname":"财经","type":"sub"},{"chlid":"news_live_tv","chlname":"电视台","type":"sub"},{"chlid":"news_live_sports","chlname":"体育","type":"sub"},{"chlid":"news_live_msj","chlname":"慢视界","type":"sub"},{"chlid":"news_live_lifes","chlname":"生活","type":"sub"}]
	 * timestamp : 1489629966
	 */

	private int ret;
	private String version;
	private int timestamp;
	private List<ChannellistBean> channellist;

	public int getRet() {
		return ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
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

	public List<ChannellistBean> getChannellist() {
		return channellist;
	}

	public void setChannellist(List<ChannellistBean> channellist) {
		this.channellist = channellist;
	}

	public static class ChannellistBean {
		@Override
		public String toString() {
			return "ChannellistBean{" +
					"chlid='" + chlid + '\'' +
					", chlname='" + chlname + '\'' +
					", type='" + type + '\'' +
					'}';
		}

		/**
		 * chlid : news_live_main
		 * chlname : 精选
		 * type : home
		 *
		 */

		private String chlid;
		private String chlname;
		private String type;

		public String getChlid() {
			return chlid;
		}

		public void setChlid(String chlid) {
			this.chlid = chlid;
		}

		public String getChlname() {
			return chlname;
		}

		public void setChlname(String chlname) {
			this.chlname = chlname;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
	}

	@Override
	public String toString() {
		return "HomeTabBean{" +
				"ret=" + ret +
				", version='" + version + '\'' +
				", timestamp=" + timestamp +
				", channellist=" + channellist +
				'}';
	}
}
