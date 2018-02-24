package service;

import java.util.List;

import dto.data.AgentGoodsDataResult;

/**
 * 获取其下级代理商品的销售情况的服务接口
 * @author 学徒
 *
 */
public interface AgentGoodsService
{
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public abstract List<AgentGoodsDataResult> getAgentGoodsMessage(int userId);
}
