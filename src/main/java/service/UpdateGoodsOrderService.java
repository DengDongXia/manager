package service;

import dto.goods.UpdateGoodsOrderInput;

/**
 * 用于更新用户的订单的相关服务类接口
 * @author 学徒
 *
 */
public interface UpdateGoodsOrderService
{
	/**
	 * 用于更新其相应的用户订单的情况
	 * @param input 用户订单的更新情况
	 * @return 更新的结果
	 */
	public abstract boolean updateGoodsOrder(UpdateGoodsOrderInput input);
}
