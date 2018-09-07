package top.th.jackie.study.entity;

public class MessageText  extends BaseMessage{

	private String content;
	private String msgId;
	public MessageText() {
		// TODO Auto-generated constructor stub
	}
	public MessageText(String toUserName,String fromUserName,long createTime,String msgType,String content,String msgId) {
		super();
		this.setToUserName(toUserName);
		this.setFromUserName(fromUserName);
		this.setCreateTime(createTime);
		this.setMsgType(msgType);
		this.content = content;
		this.msgId = msgId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
}
