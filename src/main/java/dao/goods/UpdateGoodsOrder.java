package dao.goods;

import dto.goods.UpdateGoodsOrderInput;

/**
 * 更新其用户的订单情况的数据库操作对象
 * @author 学徒
 *
 */
public interface UpdateGoodsOrder
{
	/**
	 * 用于更新其对应的数据库订单记录
	 * @param input 用户的输入数据
	 * @return 受影响的行数
	 */
	public abstract int updateGoodsOrder(UpdateGoodsOrderInput input);
}
