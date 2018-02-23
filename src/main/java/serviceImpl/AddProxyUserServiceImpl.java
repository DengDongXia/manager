package serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.AddProxyUserService;
import service.PasswordService;
import dao.user.AddUserProxy;
import domain.user.User;
import domain.user.UserRole;
import dto.user.AddProxyUserInput;
@Service
public class AddProxyUserServiceImpl implements AddProxyUserService
{
	@Autowired
	private AddUserProxy addUserProxyDao;//注入相应的数据库操作类对象
	@Autowired
	private PasswordService passwordService;//注入密码安全相关的服务类对象
	public boolean insertUserProxy(AddProxyUserInput input)
	{
		User user=makeUserByAddProxyUserInput(input);
		addUserProxyDao.insertUserProxyMessage(user);
		int userProxyId=addUserProxyDao.getInsertUserProxyId(input.getUserId());
		int userroleId=addUserProxyDao.getUserRoleId(input.getUserId());
		UserRole role=new UserRole();
		role.setRoleID(userroleId);
		role.setUserID(userProxyId);
		addUserProxyDao.insertUserProxyRole(role);
		return true;
	}

	public int getNewUserProxyId(int userId)
	{
		return addUserProxyDao.getInsertUserProxyId(userId);
	}
	
	/**
	 * 用于获取其对应的用户生成的代理的用户角色
	 * @param userId 用于生成用户代理的用户Id
	 * @return 生成的代理用户的用户角色Id
	 */
	private int getProxyUserRoleId(int userId)
	{
		int userroleId=addUserProxyDao.getUserRoleId(userId);
		int result=1;
		switch(userroleId)
		{
			case 1:result=5;break;
			case 5:result=2;break;
			case 2:result=3;break;
			case 3:result=4;break;
		}
		return result;
	}
	
	/**
	 * 用于将用户的输入对象转化为相应的数据库表对象
	 * @param input 用户的输入对象
	 * @return 数据库对应的对象
	 */
	private User makeUserByAddProxyUserInput(AddProxyUserInput input)
	{
		User user=new User();
		String timestamp=String.valueOf(System.currentTimeMillis());
		user.setTimeStamp(timestamp);
		user.setBelong(input.getUserId());
		user.setEmail(input.getEmail());
		user.setName(input.getName());
		user.setPictureURL(input.getPictureURL());
		user.setProxyState(input.isProxyState());
		user.setQuote(input.getQuote());
		user.setPassword(passwordService.getEncodingResult(input.getPassword(), timestamp));
		return user;
	}
	
	
}
