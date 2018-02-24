package service;

import dto.goods.CompanyGoodsInput;

/**
 * 厂商增加其相应的商品的录入信息的接口操作类
 * @author 学徒
 *
 */
public interface CompanyGoodsMessageService
{
	/**
	 * 用于厂商添加其相应的商品的信息的操作
	 * @param input 商品的输入信息
	 * @return 其新增的商品的结果
	 */
	public abstract boolean addGoodsMessage(CompanyGoodsInput input);
}
