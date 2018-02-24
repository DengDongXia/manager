package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.GoodsOrderMessageService;
import dao.data.GoodsOrderMessage;
import dto.data.SendGoodsMessageResult;
import dto.data.ShowGoodsOrderInput;

@Service
public class GoodsOrderMessageServiceImpl implements GoodsOrderMessageService
{
	@Autowired
	private GoodsOrderMessage goodsOrderDao;//相关的数据库操作类
	
	public List<SendGoodsMessageResult> getSendGoodsContent(ShowGoodsOrderInput input)
	{
		return goodsOrderDao.getContent(input);
	}

	public int getPageNumber(ShowGoodsOrderInput input)
	{
		return goodsOrderDao.getPageNumber(input);
	}

}
