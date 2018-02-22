package serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.AddProxyUserService;
import dao.user.AddUserProxy;
import dto.user.AddProxyUserInput;
@Service
public class AddProxyUserServiceImpl implements AddProxyUserService
{
	@Autowired
	private AddUserProxy addUserProxyDao;//注入相应的数据库操作类对象

	
	
}
