package service;
/**
 * 用于获取验证码的获取
 * @author 学徒
 *
 */
public interface ValidateGetService
{
	/**
	 * 用于获取其对应的验证码，并进行返回
	 * @return 验证码
	 */
	public abstract String getValidateCodeString();
}
