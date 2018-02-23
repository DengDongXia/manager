package service;

import dto.goods.GoodsMessage;
import dto.goods.GoodsMessageInput;

/**
 * 用于获取其对应的商品的信息
 * @author 学徒
 *
 */
public interface GoodsMessageService
{
	/**
	 * 通过用户的输入信息，查找其对应的商品信息
	 * @param input 用户的输入信息对象
	 * @return 商品信息的封装对象
	 */
	public abstract GoodsMessage getGoodsMessage(GoodsMessageInput input);
}
