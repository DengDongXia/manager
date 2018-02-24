package serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.AgentUserJudgeService;
import dao.user.IsAgentUser;
import domain.user.User;
import dto.user.AgentUserMessage;
import dto.user.IsAgentInput;
@Service
public class AgentUserJudgeServiceImpl implements AgentUserJudgeService
{
	@Autowired
	private IsAgentUser agentUserDao;//其对应的数据库操作类对象
	
	public AgentUserMessage isAgentUser(IsAgentInput input)
	{
		AgentUserMessage result=new AgentUserMessage();
		if(agentUserDao.isAgentUser(input)==1)
		{
			result.setAgent(true);
			User user=agentUserDao.getAgentUserMessage(input);
			result.setEmail(user.getEmail());
			result.setLocked(user.isLocked());
			result.setName(user.getName());
			result.setPictureURL(user.getPictureURL());
			result.setQuote(user.getQuote());
		}
		return result;
	}

}
