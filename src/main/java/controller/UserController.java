package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.AddProxyUserService;
import service.UserLoginService;
import service.UserRegisterService;
import dto.user.AddProxyUserInput;
import dto.user.AddProxyUserResult;
import dto.user.UserLoginInput;
import dto.user.UserLoginResult;
import dto.user.UserRegisterInput;
import dto.user.UserRegisterResult;

/**
 * 用户相关的控制器类
 * @author 学徒
 *
 */
@Controller
@RequestMapping("/user")
public class UserController
{
	@Autowired
	private UserLoginService userLoginService;//用户登录相关的服务类
	@Autowired
	private UserRegisterService userRegisterService;//用户注册的相关的服务类
	@Autowired
	private AddProxyUserService addUserProxyService;//用于新增用户代理的相关服务类
	
	@RequestMapping("/login")
	@ResponseBody
	public UserLoginResult userLogin(@RequestBody UserLoginInput input,HttpSession session)
	{
		boolean exist=userLoginService.checkAccount(input.getAccount());
		UserLoginResult result =new UserLoginResult();
		if(exist)
		{
			result.setAccountResult(userLoginService.checkAccount(input.getAccount()));
			result.setAccountState(userLoginService.getAccountState(input.getAccount()));
			result.setPasswordResult(userLoginService.checkValidateCode(input.getAccount(), input.getPassword()));
			String validateCode =(String)session.getAttribute("validateCode");
			result.setValidateCodeResult(userLoginService.checkValidateCode(validateCode,input.getValidateCode()));
		}
		if(result.isPass())
		{
			userLoginService.saveUserMessageToSession(input.getAccount(), session);
		}
		return result;
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public UserRegisterResult userRegister(@RequestBody UserRegisterInput input,HttpSession session)
	{
		UserRegisterResult result =new UserRegisterResult();
		String validateCode=(String)session.getAttribute("validateCode");
		boolean emailExist=userRegisterService.isEmailExist(input.getEmail());
		boolean passwordResult=userRegisterService.isPasswordRepeated(input.getPassword(),input.getRepeatedPassword());
		boolean validateCodeResult =userRegisterService.isValidateCodeResult(validateCode, input.getValidateCode());
		result.setEmailExist(emailExist);
		result.setPasswordResult(passwordResult);
		result.setValidateCodeResult(validateCodeResult);
		if(result.isPass())
		{
			userRegisterService.insertUser(input);
		}
		return result;
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public AddProxyUserResult addProxyUser(@RequestBody AddProxyUserInput input)
	{
		AddProxyUserResult result=new AddProxyUserResult();
		result.setPassword(input.getPassword());
		result.setAddResult(addUserProxyService.insertUserProxy(input));
		result.setId(addUserProxyService.getNewUserProxyId(input.getUserId()));
		return result;
	}
	
	
}
