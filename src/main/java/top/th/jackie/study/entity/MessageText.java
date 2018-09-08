package top.th.jackie.study.entity;


public class MessageText  extends BaseMessage{

	private String Content;
//	private String MsgId;
	public MessageText() {
		// TODO Auto-generated constructor stub
	}
	public MessageText(String toUserName,String fromUserName,long createTime,String msgType,String content,String msgId) {
		super();
		this.setToUserName(toUserName);
		this.setFromUserName(fromUserName);
		this.setCreateTime(createTime);
		this.setMsgType(msgType);
		this.Content = content;
//		this.MsgId = msgId;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		this.Content = "<![CDATA["+content+"]]>";
	}
//	public String getMsgId() {
//		return MsgId;
//	}
//	public void setMsgId(String msgId) {
//		this.MsgId = msgId;
//	}
}
