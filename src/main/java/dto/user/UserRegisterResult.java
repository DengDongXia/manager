package dto.user;

public class UserRegisterResult
{
	private boolean emailExist;//邮箱存在情况
	private boolean passwordResult;//重复密码的输入情况
	private boolean validateCodeResult;//验证码的输入情况
	public boolean isEmailExist()
	{
		return emailExist;
	}
	public void setEmailExist(boolean emailExist)
	{
		this.emailExist = emailExist;
	}
	public boolean isPasswordResult()
	{
		return passwordResult;
	}
	public void setPasswordResult(boolean passwordResult)
	{
		this.passwordResult = passwordResult;
	}
	public boolean isValidateCodeResult()
	{
		return validateCodeResult;
	}
	public void setValidateCodeResult(boolean validateCodeResult)
	{
		this.validateCodeResult = validateCodeResult;
	}
	public boolean isPass()
	{
		return this.emailExist&&this.passwordResult&&this.validateCodeResult;
	}
}
