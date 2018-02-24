package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.AgentGoodsService;
import dao.data.AgentGoodsData;
import dto.data.AgentGoodsDataResult;
@Service
public class AgentGoodsServiceImpl implements AgentGoodsService
{
	@Autowired
	private AgentGoodsData agentGoodsDao;//用于获取操作其对应的数据库的对象
	
	public List<AgentGoodsDataResult> getAgentGoodsMessage(int userId)
	{
		return agentGoodsDao.getAgentUserGoodsData(userId);
	}

}
