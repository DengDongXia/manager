package serviceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.AddGoodsOrderService;
import dao.goods.AddGoodsOrder;
import domain.goods.GoodsOrder;
@Service
public class AddGoodsOrderServiceImpl implements AddGoodsOrderService
{
	@Autowired
	private AddGoodsOrder addGoodsOrderDao;//注入相关的数据库操作对象
	
	public boolean addGoodsOrder(GoodsOrder input)
	{
		input.setTime(new Date());
		return addGoodsOrderDao.addGoodsOrderByInput(input)==1;
	}

}
