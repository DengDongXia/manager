package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.ShowProxyUserMessageService;
import dao.user.ShowUserProxy;
import dto.user.ShowUserProxyMessageInput;
import dto.user.ShowUserProxyMessageResult;
@Service
public class ShowProxyUserMessageServiceImpl implements ShowProxyUserMessageService
{
	@Autowired
	private ShowUserProxy showUserProxyDao;//相关的数据库操作类对象

	public int getPageNumber(ShowUserProxyMessageInput input)
	{
		return showUserProxyDao.getPageNumber(input);
	}

	public List<ShowUserProxyMessageResult> getContentByInput(ShowUserProxyMessageInput input)
	{
		return showUserProxyDao.getProxyUserList(input);
	}

	public int getUserRoleId(int userId)
	{
		return showUserProxyDao.getUserRoleId(userId);
	}
	
	
	
	
}
