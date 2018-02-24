package dao.data;

import dto.data.SendGoodsInput;

/**
 * 用于获取某件商品的月平均销售情况的数据库接口
 * @author 学徒
 *
 */
public interface SendGoods
{
	/**
	 * 获取某件商品的总的月销售量
	 * @param input 输入对象
	 * @return 其相应的结果
	 */
	public abstract int getSendGoodsAccount(SendGoodsInput input);
	
	/**
	 * 某件商品的销售的月数
	 * @param input 输入对象
	 * @return 相应的结果
	 */
	public abstract int getSendGoodsMonth(SendGoodsInput input);
	
}
