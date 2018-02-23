package dto.goods;
/**
 * 用户修改相应的订单信息的数据对象
 * @author 学徒
 *
 */
public class UpdateGoodsOrderInput
{
	private int userId;//用户的Id
	private boolean state;//收货的状态
	private int orderId;//订单Id
	private String deliveryCompany;//快递公司
	private String deliveryId;//订单单号
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public boolean isState()
	{
		return state;
	}
	public void setState(boolean state)
	{
		this.state = state;
	}
	public int getOrderId()
	{
		return orderId;
	}
	public void setOrderId(int orderId)
	{
		this.orderId = orderId;
	}
	public String getDeliveryCompany()
	{
		return deliveryCompany;
	}
	public void setDeliveryCompany(String deliveryCompany)
	{
		this.deliveryCompany = deliveryCompany;
	}
	public String getDeliveryId()
	{
		return deliveryId;
	}
	public void setDeliveryId(String deliveryId)
	{
		this.deliveryId = deliveryId;
	}
}
