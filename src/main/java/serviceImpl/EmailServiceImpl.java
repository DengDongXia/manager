package serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.EmailService;
import util.email.UserRegister;
@Service
public class EmailServiceImpl implements EmailService
{
	@Autowired
	private UserRegister userEmailSender;//用于注入相关的邮件发送类
	
	public boolean sendValidateCodeToEmail(String validate, String email)
	{
		return userEmailSender.sendValidate(validate, email);
	}
	
}
