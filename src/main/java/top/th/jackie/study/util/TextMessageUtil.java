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
	public String initMessage(String toUserName , String fromUserName) {
		MessageText msg = new MessageText();
		msg.setToUserName(toUserName);
		msg.setFromUserName(fromUserName);
		msg.setContent("hello");
		msg.setCreateTime(new Date().getTime());
		msg.setMsgType("text");
		return messageToXml(msg);
	}
}
