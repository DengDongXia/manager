package serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.AddGoodsAgentService;
import dao.goods.AddGoodsAgent;
import dto.goods.AddGoodsAgentInput;
@Service
public class AddGoodsAgentServiceImpl implements AddGoodsAgentService
{
	@Autowired
	private AddGoodsAgent addGoodsAgentDao;//用于新增商品代理的数据库操作类对象

	public boolean addGoodsAgent(AddGoodsAgentInput input)
	{
		return addGoodsAgentDao.addGoodsAgent(input)==1&&addGoodsAgentDao.reduceGoods(input)==1;
	}
}
