package dto.user;
/**
 * 用户登录的验证结果
 * @author 学徒
 *
 */
public class UserLoginResult
{
	private boolean validateCodeResult;//验证码的结果
	private boolean passwordResult;//密码的结果
	private boolean accountResult;//账号的结果
	private boolean accountState;//账号的状态
	public boolean isValidateCodeResult()
	{
		return validateCodeResult;
	}
	public void setValidateCodeResult(boolean validateCodeResult)
	{
		this.validateCodeResult = validateCodeResult;
	}
	public boolean isPasswordResult()
	{
		return passwordResult;
	}
	public void setPasswordResult(boolean passwordResult)
	{
		this.passwordResult = passwordResult;
	}
	public boolean isAccountResult()
	{
		return accountResult;
	}
	public void setAccountResult(boolean accountResult)
	{
		this.accountResult = accountResult;
	}
	public boolean isAccountState()
	{
		return accountState;
	}
	public void setAccountState(boolean accountState)
	{
		this.accountState = accountState;
	}
	
	public boolean isPass()
	{
		return this.accountResult&&this.accountState&&this.passwordResult&&this.validateCodeResult;
	}
}
