package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.SearchGoodsOrderService;
import dao.goods.SearchGoodsOrder;
import dto.goods.SearchGoodsOrderInput;
import dto.goods.SearchGoodsOrderResult;
@Service
public class SearchGoodsOrderServiceImpl implements SearchGoodsOrderService
{
	@Autowired
	private SearchGoodsOrder searchGoodsOrderDao;//获取其对应的订单的显示情况的数据库操作类

	public int getPageNumber(SearchGoodsOrderInput input)
	{
		return searchGoodsOrderDao.getPageNumber(input);
	}

	public List<SearchGoodsOrderResult> getContent(SearchGoodsOrderInput input)
	{
		return searchGoodsOrderDao.getContent(input);
	}
	
	
}
