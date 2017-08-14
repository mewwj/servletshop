package entity;

public class Items {
	private int id; // 商品编号
	private String name; // 商品名称
	private String city; // 产地
	private int price; // 价格
	private int number; // 库存
	private String picture; // 商品图片
	
	
	public Items(){}
	public Items(int id,String name,String city,int price,int number,String picture)
	{
		this.id = id;
		this.name = name;
		this.city = city;
		this.picture = picture;
		this.price = price;
		this.number = number;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.getId()+this.getName().hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (this== obj){
			return true;
		}
		if(obj instanceof Items){
			Items i=(Items)obj;
			if(this.id==i.getId()&&this.name.equals(i.getName())){
				return true;
			}
			else{
				return false;
			}
		}else{
			return false;
		}
	}
	@Override
	public String toString() {
		return "商品编号：" + id + " -----商品名称：" + name +"-----------商品价格："+price+"-------购买数量";
	}
	
}
