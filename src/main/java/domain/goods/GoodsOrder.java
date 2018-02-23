package domain.goods;

import java.util.Date;

/**
 * 相应的数据库映射对象
 * @author 学徒
 *
 */
public class GoodsOrder
{
	private int id;//订单的Id
	private String customerName;//用户名
	private String customerPhone;//用户的手机号
	private String customerEmail;//用户的邮箱
	private int goodsId;//商品的Id
	private String address;//用户邮寄商品的地址
	private int price;//商品的定价
	private String deliveryId;//快递单号
	private String deliveryCompany;//快递公司
	private boolean state;//收货状态
	private Date time;//其订单填写的时间
	private int userId;//新增该订单的用户Id
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getCustomerName()
	{
		return customerName;
	}
	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}
	public String getCustomerPhone()
	{
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone)
	{
		this.customerPhone = customerPhone;
	}
	public String getCustomerEmail()
	{
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail)
	{
		this.customerEmail = customerEmail;
	}
	public int getGoodsId()
	{
		return goodsId;
	}
	public void setGoodsId(int goodsId)
	{
		this.goodsId = goodsId;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public int getPrice()
	{
		return price;
	}
	public void setPrice(int price)
	{
		this.price = price;
	}
	public String getDeliveryId()
	{
		return deliveryId;
	}
	public void setDeliveryId(String deliveryId)
	{
		this.deliveryId = deliveryId;
	}
	public String getDeliveryCompany()
	{
		return deliveryCompany;
	}
	public void setDeliveryCompany(String deliveryCompany)
	{
		this.deliveryCompany = deliveryCompany;
	}
	public boolean isState()
	{
		return state;
	}
	public void setState(boolean state)
	{
		this.state = state;
	}
	public Date getTime()
	{
		return time;
	}
	public void setTime(Date time)
	{
		this.time = time;
	}
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
}
