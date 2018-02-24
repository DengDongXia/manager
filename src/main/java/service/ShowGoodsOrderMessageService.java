package service;

import java.util.List;

import dto.data.ShowGoodsMessageTableResult;
import dto.data.ShowGoodsOrderTableInput;

/**
 * 用于获取其相应的商品的报表情况的服务类对象
 * @author 学徒
 *
 */
public interface ShowGoodsOrderMessageService
{
	/**
	 * 获取其相应的报表情况
	 * @param input 输入对象
	 * @return 结果集
	 */
	public abstract  List<ShowGoodsMessageTableResult> getContent(ShowGoodsOrderTableInput input);
	
	/**
	 * 通过商品的Id获取其相应的商品名称
	 * @param goodsId 商品Id
	 * @return 商品名
	 */
	public abstract String getGoodsNameByGoodsId(int goodsId);
	
	
}
