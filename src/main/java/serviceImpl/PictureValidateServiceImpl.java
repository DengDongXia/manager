package serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import service.PictureValidateService;
import util.validate.ValidateCode;

@Service
public class PictureValidateServiceImpl implements PictureValidateService
{
	@Autowired
	@Qualifier("validate")
	private ValidateCode validate;//注入图形验证码的相关服务类
	
	public String getValidateCodePicture(String validateCode)
	{
		return validate.outputValidateCode(validateCode);
	}

}
