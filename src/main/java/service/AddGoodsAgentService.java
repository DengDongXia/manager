package service;

import dto.goods.AddGoodsAgentInput;

/**
 * 用于添加其相应的商品的代理的接口
 * @author 学徒
 *
 */
public interface AddGoodsAgentService
{
	/**
	 * 用于用户添加相应的商品的代理情况
	 * @param input 用户的输入情况
	 * @return 其添加的相应的结果
	 */
	public abstract boolean addGoodsAgent(AddGoodsAgentInput input);
	
	
}
