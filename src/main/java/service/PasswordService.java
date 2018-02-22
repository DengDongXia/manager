package service;
/**
 * 密码相关的服务类对象
 * @author 学徒
 *
 */
public interface PasswordService
{
	/**
	 * 用于获取时间戳和密码进行加密并采用base64编码过的结果的字符串
	 * @param password 密码字符串
	 * @param timestamp 时间戳字符串
	 * @return 加密之后的结果
	 */
	public abstract String getEncodingResult(String password,String timestamp);
	
}
