package service;

import domain.goods.GoodsOrder;

/**
 * 用于用户新增其对应的订单的服务接口
 * @author 学徒
 *
 */
public interface AddGoodsOrderService
{
	/**
	 * 用于用户新增其对应的订单
	 * @param input 用户新增订单的输入对象
	 * @return 新增的情况
	 */
	public abstract boolean addGoodsOrder(GoodsOrder input);
	
}
