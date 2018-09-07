package top.th.jackie.study.entity;

public class BaseMessage {

		protected String ToUserName;
		protected String FromUserName;
		protected long CreateTime;
		protected String MsgType;

		public BaseMessage() {
			super();
		}

		public String getToUserName() {
			return ToUserName;
		}

		public void setToUserName(String toUserName) {
			this.ToUserName = toUserName;
		}

		public String getFromUserName() {
			return FromUserName;
		}

		public void setFromUserName(String fromUserName) {
			this.FromUserName = fromUserName;
		}

		public long getCreateTime() {
			return CreateTime;
		}

		public void setCreateTime(long createTime) {
			this.CreateTime = createTime;
		}

		public String getMsgType() {
			return MsgType;
		}

		public void setMsgType(String msgType) {
			this.MsgType = msgType;
		}
	
}
