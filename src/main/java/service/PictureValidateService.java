package service;
/**
 * 图像验证码的相关服务类
 * @author 学徒
 *
 */
public interface PictureValidateService
{
	/**
	 * 用于将验证码的结果转化为相应的图像数据，并将其以base64的形式进行编码返回
	 * @param validateCode 验证码值
	 * @return 图形验证码的base64编码数据
	 */
	public abstract String getValidateCodePicture(String validateCode);
	
}
