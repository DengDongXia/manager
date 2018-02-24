package dao.data;

import java.util.List;

import dto.data.AgentGoodsDataResult;

/**
 * 用于获取其对应的数据的数据库操作类
 * @author 学徒
 *
 */
public interface AgentGoodsData
{
	/**
	 * 用于获取其下级代理的商品的销售情况
	 * @param userId 获取其下级代理商品销售情况的用户Id
	 * @return 其相应的结果
	 */
	public abstract List<AgentGoodsDataResult> getAgentUserGoodsData(int userId);
}
