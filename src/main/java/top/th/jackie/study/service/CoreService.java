package top.th.jackie.study.service;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import top.th.jackie.study.entity.resp.TextMessage;
import top.th.jackie.study.util.MessageUtil;

public class CoreService {

	public static String processRequest(HttpServletRequest request) {
		String respXml = null;
		String respContent ="未知的消息类型！";
		Map<String, String> requestMap = MessageUtil.parseXml(request);
		String fromUserName = requestMap.get("FromUserName");
		String toUserName = requestMap.get("ToUserName");
		String msgType = requestMap.get("MsgType");
		TextMessage textMessage = new TextMessage();
		textMessage.setToUserName(fromUserName);
		textMessage.setFromUserName(toUserName);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
		if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
			respContent = "您发送给我的是文本消息"+requestMap.get("Content");
		}
		textMessage.setContent(respContent);
		respXml = MessageUtil.messageToXml(textMessage);
		return respXml ;
	}
}
