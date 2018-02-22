package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.PictureValidateService;
import service.ValidateGetService;

/**
 * 图形验证码相关的控制器类
 * @author 学徒
 *
 */
@Controller
@RequestMapping("/code")
public class PictureValidateCodeController
{
	@Autowired
	private PictureValidateService pictureValidateService;//用于注入图形验证码相关的服务类
	@Autowired
	private ValidateGetService validateGetService;//用于注入验证码相关的服务类
	
	@RequestMapping("/identifyCode")
	@ResponseBody
	public Map<String,String> getPictureValidateCode(HttpSession session)
	{
		String validateCode= validateGetService.getValidateCodeString();
		String pictureValidateCode=pictureValidateService.getValidateCodePicture(validateCode);
		session.setAttribute("validateCode",validateCode);
		Map<String,String> result=new HashMap<String,String>();
		result.put("image",pictureValidateCode);
		return result;
	}
	
	
}
