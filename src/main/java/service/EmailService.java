package service;
/**
 * 邮箱相关的服务类对象
 * @author 学徒
 *
 */
public interface EmailService
{
	/**
	 * 用于将邮箱验证码发往相应的邮箱的位置
	 * @param validate 邮箱的验证码
	 * @param email 邮箱号码
	 * @return 发送的结果
	 */
	public abstract boolean sendValidateCodeToEmail(String validate,String email);
}
