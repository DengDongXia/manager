package dao.data;

import java.util.List;

import dto.data.SendGoodsMessageResult;
import dto.data.ShowGoodsOrderInput;

/**
 * 用于获取其相应的商品列表的统计信息的服务类对象
 * @author 学徒
 *
 */
public interface GoodsOrderMessage
{
	/**
	 * 获取其可进行显示的页面的数目
	 * @param input 输入类对象
	 * @return 可进行显示的页面数
	 */
	public abstract int getPageNumber(ShowGoodsOrderInput input);
	
	/**
	 * 获取其相应的统计信息情况
	 * @param input 输入类对象
	 * @return 统计信息列表
	 */
	public abstract List<SendGoodsMessageResult> getContent(ShowGoodsOrderInput input);
	
}
