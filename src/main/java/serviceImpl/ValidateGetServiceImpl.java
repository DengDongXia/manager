package serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import service.ValidateGetService;
import util.validate.ValidateCode;
@Service
public class ValidateGetServiceImpl implements ValidateGetService
{
	@Autowired
	@Qualifier("validate")
	private ValidateCode validateCode;//注入获取其相应的验证码的值的服务类
	
	public String getValidateCodeString()
	{
		return validateCode.getRandomString();
	}

}
