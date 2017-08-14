package entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Cart {
	//商品信息集合
    private HashMap<Items,Integer> goods; 
    //总价
    private double totalprice;
    //构造方法
    public Cart(){
    	goods= new HashMap<Items,Integer>();
    	 
    	totalprice= 0.0;
    }
	public HashMap<Items, Integer> getGoods() {
		return goods;
	}
	public void setGoods(HashMap<Items, Integer> goods) {
		this.goods = goods;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	 public boolean AddGoodsInCart(Items item,int number){
			
			if(goods.containsKey(item))
			{
				goods.put(item, goods.get(item)+number);
			}
			else
			{
				goods.put(item, number);	
			}	
			
			calTotalPrice(); //重新计算购物车的总金额
			return true;
	 }
	public boolean RemoveGoodsFromCart(Items item){
		goods.remove(item);
		calTotalPrice();
		return true;
	}
	public double calTotalPrice(){
		double sum=0.0;
	
		Set<Items> keys = goods.keySet(); //获得键的集合
		Iterator<Items> it = keys.iterator(); //获得迭代器对象
	    while(it.hasNext())
	    {
	    	Items i = it.next();
	    	sum += i.getPrice()* goods.get(i);
	    }
	    this.setTotalprice(sum); //设置购物车的总金额
	    return this.getTotalprice();
	}
public static void main(String[] args) {
		
		//先创建两个商品对象
		Items i1 = new Items(1,"沃特篮球鞋","温州",200,500,"001.jpg");
		Items i2 = new Items(2,"李宁运动鞋","广州",300,500,"002.jpg");
		Items i3 = new Items(2,"李宁运动鞋","广州",300,500,"002.jpg");
		
		Cart c = new Cart();
		c.AddGoodsInCart(i1, 1);
		c.AddGoodsInCart(i2, 2);
		    //再次购买沃特篮球鞋，购买3双
		c.AddGoodsInCart(i3, 2);
		
		//遍历购物商品的集合
		Set<Map.Entry<Items, Integer>> items= c.getGoods().entrySet();
		for(Map.Entry<Items, Integer> obj:items)
		{
			System.out.println(obj);
		  }
		
		
		System.out.println("购物车的总金额："+c.getTotalprice());
		
	}
}
