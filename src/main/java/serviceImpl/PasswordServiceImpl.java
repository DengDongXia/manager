package serviceImpl;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.PasswordService;
import util.password.PasswordSecurity;
@Service
public class PasswordServiceImpl implements PasswordService
{
	@Autowired
	private PasswordSecurity passwordSecurity;//注入密码安全的相关的操作类

	public String getEncodingResult(String password, String timestamp)
	{
		String result=null;
		try
		{
			result= passwordSecurity.encodeByteArrays((passwordSecurity.digest(password, timestamp)));
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	
}
