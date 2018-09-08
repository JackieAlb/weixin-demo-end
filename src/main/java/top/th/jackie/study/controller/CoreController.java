package top.th.jackie.study.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import top.th.jackie.study.service.CoreService;
import top.th.jackie.study.util.CheckUtil;

@Controller
public class CoreController {

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
			e.printStackTrace();
		}finally {
			out.close();
		}
	}
	
	@RequestMapping(value="wx", method = RequestMethod.POST)
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String respXml = CoreService.processRequest(request);
		System.out.println(respXml);
		PrintWriter out = response.getWriter();
		out.print(respXml);
		out.close();
	}
}
