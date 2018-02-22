package serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.PasswordService;
import service.UserRegisterService;
import dao.user.UserRegister;
import domain.user.User;
import dto.user.UserRegisterInput;
@Service
public class UserRegisterServiceImpl implements UserRegisterService
{
	@Autowired
	private UserRegister userRegisterDao;//用户注册的相关的数据库操作对象
	@Autowired
	private PasswordService passwordService;//用户注册的密码相关的服务类
	
	public boolean isEmailExist(String email)
	{
		return userRegisterDao.isExistEmail(email)==1;
	}

	public boolean isPasswordRepeated(String password, String repeatedPassword)
	{
		return password.equals(repeatedPassword);
	}

	public boolean isValidateCodeResult(String validateCode, String input)
	{
		return validateCode.equalsIgnoreCase(input);
	}

	public void insertUser(UserRegisterInput input)
	{
		User user=new User();
		user.setEmail(input.getEmail());
		String timeStamp=String.valueOf(System.currentTimeMillis());
		user.setTimeStamp(timeStamp);
		String password=passwordService.getEncodingResult(input.getPassword(), timeStamp);
		user.setPassword(password);
		user.setName(input.getEmail().substring(0,7));
		userRegisterDao.insertUser(user);
		userRegisterDao.insertUserRole(user);
	}
	
}
