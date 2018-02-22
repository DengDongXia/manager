package dto.user;
/**
 * 用户登录的相关输入对象
 * @author 学徒
 *
 */
public class UserLoginInput
{
	private String account;//账号
	private String password;//密码
	private String validateCode;//验证码
	public String getAccount()
	{
		return account;
	}
	public void setAccount(String account)
	{
		this.account = account;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
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
