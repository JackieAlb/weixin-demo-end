package top.th.jackie.study.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import top.th.jackie.study.util.CheckUtil;
import top.th.jackie.study.util.MessageUtil;
import top.th.jackie.study.util.TextMessageUtil;

@Controller
public class LoginController {

	@RequestMapping(value="wx",method = RequestMethod.GET)
	public void login(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("success");
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		PrintWriter out =null;
		try {
			out = response.getWriter();
			if(CheckUtil.checkSignature(signature,timestamp,nonce)) {
				out.write(echostr);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			out.close();
		}
	}
	
	@RequestMapping(value="wx", method = RequestMethod.POST)
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		System.out.println("=======================response");
		PrintWriter out = null;
		Map<String, String> map = MessageUtil.xmlToMap(request);
		String toUserName = map.get("ToUserName");
		String fromUserName = map.get("FromUserName");
		String msgType = map.get("MsgType");
		String content = map.get("Content");
		String message =null;
		if("text".equals(msgType)) {
			if("1".equals(content)) {
				TextMessageUtil textMessage = new TextMessageUtil();
				message = textMessage.initMessage(fromUserName, toUserName);
				System.out.println("======================xml message is "+ message);
			}
		}
		
		try {
			out =response.getWriter();
			out.write(message);
			System.out.println("=================it is success");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			out.close();
		}
	}
}
