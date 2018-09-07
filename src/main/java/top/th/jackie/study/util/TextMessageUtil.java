package top.th.jackie.study.util;

import java.util.Date;

import com.thoughtworks.xstream.XStream;

import top.th.jackie.study.entity.MessageText;

public class TextMessageUtil implements BaseMessageUtil<MessageText>  {


	@Override
	public String messageToXml(MessageText t) {

		XStream stream = new XStream();
		stream.alias("xml", t.getClass());
		return stream.toXML(t);
	}

	@Override
	public String initMessage(String fromUserName, String toUserName) {
		MessageText msg = new MessageText();
		msg.setToUserName(toUserName);
		msg.setFromUserName(fromUserName);
		msg.setContent("这是机器人自动回复的信息");
		msg.setCreateTime(new Date().getTime());
		msg.setMsgType("text");
		return messageToXml(msg);
	}
}
