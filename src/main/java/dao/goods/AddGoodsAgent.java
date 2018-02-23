package dao.goods;

import dto.goods.AddGoodsAgentInput;

/**
 * 相关的数据库操作接口
 * @author 学徒
 *
 */
public interface AddGoodsAgent
{
	/**
	 * 用于新增其对应的代理记录
	 * @param input 输入的数据对象
	 * @return 受影响的行数
	 */
	public abstract int addGoodsAgent(AddGoodsAgentInput input);
	
	/**
	 * 用于减少其对应的代理记录
	 * @param input 输入的数据对象
	 * @return 受影响的行数
	 */
	public abstract int reduceGoods(AddGoodsAgentInput input);
}
