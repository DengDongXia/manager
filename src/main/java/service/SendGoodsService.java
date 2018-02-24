package service;

import dto.data.SendGoodsInput;

/**
 * 某件商品的月平均销售情况的服务类接口
 * @author 学徒
 *
 */
public interface SendGoodsService
{
	/**
	 * 获取某件商品的月平均销售情况
	 * @param input 用户的输入数据对象
	 * @return 其月平均销售情况
	 */
	public abstract int getSendAccountPerMonth(SendGoodsInput input);
}
