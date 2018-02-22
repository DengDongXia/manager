package dto.user;
/**
 * 用户注册的输入对象
 * @author 学徒
 *
 */
public class UserRegisterInput
{
	private String email;//邮箱号码
	private String password;//密码
	private String repeatedPassword;//重复输入的密码
	private String validateCode;//验证码
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getRepeatedPassword()
	{
		return repeatedPassword;
	}
	public void setRepeatedPassword(String repeatedPassword)
	{
		this.repeatedPassword = repeatedPassword;
	}
	public String getValidateCode()
	{
		return validateCode;
	}
	public void setValidateCode(String validateCode)
	{
		this.validateCode = validateCode;
	}
	
	
}
