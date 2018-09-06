package top.th.jackie.study.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import top.th.jackie.study.util.CheckUtil;

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
}
