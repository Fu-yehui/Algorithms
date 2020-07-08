package list;
/**
 * 顺序结构实现的线性表
 * @author roger
 *
 */
public class ContiguousList {
	
	public static Object[] list;
	
	public static int point=0;   //线性表中元素的个数
	
	public ContiguousList(int size) {
		
		list=new Object[size];
		
		
	}
	
	/**
	 * 获取线性表中第i个元素
	 * @param i
	 * @return 若获取成功 则返回该元素的值，否则返回-1
	 */
	public Status get(int i) {
		if(point==0||i<1||i>point)
			return new Status("失败!");
		return new Status("成功!",list[i-1]);
		
	
	}
	
	/**
	 * 在线性表中第i个位置插入新元素element
	 * @param i   
	 * @param element
	 * @return
	 */
	public Status insert(int i,Object element) {
		
		if(i<1||i>point+1||point==list.length)
			
			return new Status("失败!");
		if(i==point+1)list[i]=element;
		for(int k=point;k>=i;k--) {
			list[k]=list[k-1];
		}
		
		return new Status("成功!",element);
		
	}
	
	/**
	 * 删除线性表中第i个位置的元素,若成功则返回该值
	 * @param i
	 * @return
	 */
	public Status delete(int i) {
		if(point==0||i<1||i>point) 
		
		return new Status("失败!");
		
		Object o=list[i-1];
		if(i==point-1) {
		list[i-1]=null;}
		
		return new Status("成功！",o);
			
		
		
	}
	/**
	 * 从线性表尾部插入新元素
	 * @param data
	 * @return
	 */
	public Status add(Object data) {
		if(point==list.length)return new Status("线性表已满！");
		list[point]=data;
		point+=1;
		return new Status("尾部插入成功！",data);
	}
	/**
	 * 从线性表尾部移除元素
	 * @return
	 */
	public Status remove() {
		if(point<1)return new Status("线性表为空,无法移除!");
		Object o=list[point-1];
		point-=1;
		return new Status("移除成功！",o);
	}
	public static void main(String[] args) {
		ContiguousList list=new ContiguousList(3);
		System.out.println(list.add((Object)33).info);
	//	System.out.println(list.remove().info);
		System.out.println(list.add((Object)44).info);
		System.out.println(list.add((Object)55).info);
		System.out.println(list.add((Object)66).info);
		for(Object o:list.list) {
			System.out.print(o+" ");
		}
		
		
	
		
	}
}
