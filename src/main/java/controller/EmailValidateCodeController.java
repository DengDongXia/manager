package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.EmailService;
import service.ValidateGetService;

/**
 * 用于邮箱验证码相关的请求的控制器
 * @author 学徒
 *
 */
@RequestMapping("/email")
@Controller
public class EmailValidateCodeController
{
	@Autowired
	private EmailService emailService;//注入邮箱发送的相关的服务类
	@Autowired
	private ValidateGetService validateService;//注入验证码获取相关的服务类
	
	@RequestMapping("/emailIdentifyCode")
	@ResponseBody
	public Map<String,Boolean> getEmailValidateCode(@RequestBody Map<String,Object> email,HttpSession session)
	{
		String emailString=(String)email.get("email");
		String validateCode=validateService.getValidateCodeString();
		session.setAttribute("validateCode",validateCode);
		boolean sendResult=emailService.sendValidateCodeToEmail(validateCode, emailString);
		Map<String,Boolean> result =new HashMap<String,Boolean>();
		result.put("getIdentifyCodeResult", sendResult);
		return result;
	}
	
	
}
