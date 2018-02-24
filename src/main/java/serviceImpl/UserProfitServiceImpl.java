package serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.UserProfitService;
import dao.user.UserProfit;
@Service
public class UserProfitServiceImpl implements UserProfitService
{
	@Autowired
	private UserProfit userProfitDao;//用户的利润的数据库查询接口
	
	public double getUserAccountProfit(int userId)
	{
		return userProfitDao.getAllSendMoney(userId)-userProfitDao.getAllAgentGoodsMoney(userId)+userProfitDao.getAgentUserGoodsMoney(userId);
	}
	
}
