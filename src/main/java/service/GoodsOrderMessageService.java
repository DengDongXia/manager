package service;

import java.util.List;

import dto.data.SendGoodsMessageResult;
import dto.data.ShowGoodsOrderInput;

/**
 * 用户订单情况的统计
 * @author 学徒
 *
 */
public interface GoodsOrderMessageService
{
	/**
	 * 获取其相应的商品列表的信息
	 * @param input 用户的输入对象
	 * @return 相应的商品信息的结果
	 */
	public abstract List<SendGoodsMessageResult> getSendGoodsContent(ShowGoodsOrderInput input);
	
	/**
	 * 获取其可进行显示的页面数
	 * @param input 
	 * @return
	 */
	public abstract int getPageNumber(ShowGoodsOrderInput input);
}
