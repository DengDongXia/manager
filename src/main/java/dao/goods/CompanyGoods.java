package dao.goods;

import dto.goods.CompanyGoodsInput;

/**
 * 用户新增其商品的数据库操作类
 * @author 学徒
 *
 */
public interface CompanyGoods
{
	/**
	 * 用于厂商添加其相应的商品信息
	 * @param input 商品信息的输入对象
	 * @return 受影响的行数
	 */
	public abstract int addGoodsMessage(CompanyGoodsInput input);
}
