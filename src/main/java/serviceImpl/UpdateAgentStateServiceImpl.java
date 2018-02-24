package serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.UpdateAgentStateService;
import dao.user.UpdateAgent;
import dto.user.UpdateAgentInput;
@Service
public class UpdateAgentStateServiceImpl implements UpdateAgentStateService
{
	@Autowired
	private UpdateAgent updateAgentDao;//修改其相应的代理情况的数据库操作对象
	
	public boolean updateAgentState(UpdateAgentInput input)
	{
		return updateAgentDao.updateUserAgentState(input)==1;
	}
}
