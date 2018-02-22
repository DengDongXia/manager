package utilImpl.picture;
/**
 * 图像对象的相关的描述类
 * @author 学徒
 *
 */
public class Picture
{
	private String name;//图片的名称
	private String suffix;//图片的后缀名
	private byte[] data;//图片的二进制数据
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getSuffix()
	{
		return suffix;
	}
	public void setSuffix(String suffix)
	{
		this.suffix = suffix;
	}
	public byte[] getData()
	{
		return data;
	}
	public void setData(byte[] data)
	{
		this.data = data;
	}
}
