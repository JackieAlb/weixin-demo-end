package top.th.jackie.study.entity;

public class BaseMessage {

	public static class Message {
		public String toUserName;
		public String fromUserName;
		public long createTime;
		public String msgType;

		public Message() {
		}
	}
	protected Message data = new Message();
	public String getToUserName() {
		return data.toUserName;
	}
	public void setToUserName(String toUserName) {
		this.data.toUserName = toUserName;
	}
	public String getFromUserName() {
		return data.fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.data.fromUserName = fromUserName;
	}
	public long getCreateTime() {
		return data.createTime;
	}
	public void setCreateTime(long createTime) {
		this.data.createTime = createTime;
	}
	public String getMsgType() {
		return data.msgType;
	}
	public void setMsgType(String msgType) {
		this.data.msgType = msgType;
	}
	
}
