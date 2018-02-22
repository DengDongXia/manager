package serviceImpl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.PasswordService;
import service.UserLoginService;
import dao.user.UserLogin;
import domain.user.User;
@Service
public class UserLoginServiceImpl implements UserLoginService
{
	@Autowired
	private UserLogin userLoginDao;//用户登录相关的数据库操作类
	@Autowired
	private PasswordService passwordService;//注入密码安全的相关的操作类
	
	public boolean checkValidateCode(String input, String validateCode)
	{
		return input.equalsIgnoreCase(validateCode);
	}

	public boolean checkPassword(String user,String input)
	{
		User users=userLoginDao.getUserByInput(user);
		return	users.getPassword().equals(passwordService.getEncodingResult(input,users.getTimeStamp()));
	}

	public boolean checkAccount(String input)
	{
		return userLoginDao.isUserExist(input)==1;
	}

	public boolean getAccountState(String input)
	{
		User user=userLoginDao.getUserByInput(input);
		return user.isLocked();
	}

	public void saveUserMessageToSession(String input, HttpSession session)
	{
		session.setAttribute("user", userLoginDao.getUserByInput(input));
	}

}
