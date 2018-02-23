package dao.goods;

import domain.goods.GoodsOrder;

/**
 * 相应的数据库操作类
 * @author 学徒
 *
 */
public interface AddGoodsOrder
{
	/**
	 * 用于往数据库中新增用户订单情况
	 * @param input 用户的输入情况
	 * @return 其对应的新增结果
	 */
	public abstract int addGoodsOrderByInput(GoodsOrder input);
}
