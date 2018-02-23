package serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.UpdateGoodsOrderService;
import dao.goods.UpdateGoodsOrder;
import dto.goods.UpdateGoodsOrderInput;
@Service
public class UpdateGoodsOrderServiceImpl implements UpdateGoodsOrderService
{
	@Autowired
	private UpdateGoodsOrder updateGoodsOrderDao;//更新数据库订单情况的数据库操作对象
	
	public boolean updateGoodsOrder(UpdateGoodsOrderInput input)
	{
		return updateGoodsOrderDao.updateGoodsOrder(input)==1;
	}

}
