package dao.goods;

import dto.goods.GoodsMessage;
import dto.goods.GoodsMessageInput;

/**
 * 用于获取其相应的商品信息
 * @author 学徒
 *
 */
public interface GetGoodsMessage
{
	/**
	 * 用于获取其相应的商品信息
	 * @param input 用于获取其相应的商品信息的输入对象
	 * @return 商品的相关信息
	 */
	public abstract GoodsMessage getGoodsMessage(GoodsMessageInput input);
}
