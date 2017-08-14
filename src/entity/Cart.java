package entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Cart {
	//��Ʒ��Ϣ����
    private HashMap<Items,Integer> goods; 
    //�ܼ�
    private double totalprice;
    //���췽��
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
			
			calTotalPrice(); //���¼��㹺�ﳵ���ܽ��
			return true;
	 }
	public boolean RemoveGoodsFromCart(Items item){
		goods.remove(item);
		calTotalPrice();
		return true;
	}
	public double calTotalPrice(){
		double sum=0.0;
	
		Set<Items> keys = goods.keySet(); //��ü��ļ���
		Iterator<Items> it = keys.iterator(); //��õ���������
	    while(it.hasNext())
	    {
	    	Items i = it.next();
	    	sum += i.getPrice()* goods.get(i);
	    }
	    this.setTotalprice(sum); //���ù��ﳵ���ܽ��
	    return this.getTotalprice();
	}
public static void main(String[] args) {
		
		//�ȴ���������Ʒ����
		Items i1 = new Items(1,"��������Ь","����",200,500,"001.jpg");
		Items i2 = new Items(2,"�����˶�Ь","����",300,500,"002.jpg");
		Items i3 = new Items(2,"�����˶�Ь","����",300,500,"002.jpg");
		
		Cart c = new Cart();
		c.AddGoodsInCart(i1, 1);
		c.AddGoodsInCart(i2, 2);
		    //�ٴι�����������Ь������3˫
		c.AddGoodsInCart(i3, 2);
		
		//����������Ʒ�ļ���
		Set<Map.Entry<Items, Integer>> items= c.getGoods().entrySet();
		for(Map.Entry<Items, Integer> obj:items)
		{
			System.out.println(obj);
		  }
		
		
		System.out.println("���ﳵ���ܽ�"+c.getTotalprice());
		
	}
}
