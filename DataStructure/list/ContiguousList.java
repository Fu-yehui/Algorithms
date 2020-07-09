package list;


/**
 * 顺序结构实现的线性表
 * @author roger
 */
public class ContiguousList {
	
	private  Object[] list;


	/**
	 *@param 线性表中元素的个数
	 */
	private  int point=0;
	
	public ContiguousList(int size) {
		
		list=new Object[size];
		
		
	}
	
	/**
	 * 获取线性表中第i个元素
	 * @param i 参数的位数
	 * @return 若获取成功 则返回该元素的值，否则返回-1
	 */
	public Object get(int i) throws IndexOutOfBoundsException {
		if(point==0||i<1||i>point) {
			throw    new IndexOutOfBoundsException();
		}

		return list[i-1];
		
	
	}
	
	/**
	 * 在线性表中第i个位置插入新元素element
	 * @param i   插入元素的位数
	 * @param element 插入元素的值
	 *
	 */
	public void insert(int i,Object element)  throws IndexOutOfBoundsException {
		//插入范围 1～point+1
		if(i<1||i>point+1||point==list.length) {
			throw new IndexOutOfBoundsException();
		}

		if(i<=point) {
			for (int k = point; k >= i; k--) {
				list[k] = list[k - 1];
			}
		}
		list[i-1]=element;
		point++;
		

		
	}
	
	/**
	 * 删除线性表中第i个位置的元素,若成功则返回该值
	 * @param i 删除元素的位数
	 * @return
	 */
	public Object delete(int i)  throws Exception {
		if(point==0||i<1||i>point) {
			throw  new IndexOutOfBoundsException();
		}

		if(i<point){
			for(int k=point-1;k>=i;k--) {
				list[k-1]=list[k];
			}
		}
		Object o=list[i-1];
		point--;
		return o;

			
		
		
	}
	/**
	 * 从线性表尾部插入新元素
	 * @param data
	 * @return
	 */
	public void add(Object data) throws Exception {
		if(point==list.length) {
			throw  new IndexOutOfBoundsException();
		}
		list[point]=data;
		point+=1;

	}
	/**
	 * 从线性表尾部移除元素
	 * @return
	 */
	public Object remove() throws Exception{
		if(point<1) {
			throw  new IndexOutOfBoundsException();
		}
		Object o=list[point-1];
		point-=1;
		return o;
	}
	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<point;i++){
			sb.append(list[i]+" ");
		}
		return sb.toString();
	}


	public static void main(String[] args) throws Exception {

		ContiguousList list=new ContiguousList(5);
		list.insert(1,1111);
		list.insert(2,2222);
		list.insert(3,3333);
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		System.out.println("删除第二个元素： "+list.delete(2));

		System.out.println(list.toString());

		list.add("first");
		list.add("second");
		list.add("third");

		System.out.println(list.toString());

		System.out.println("从线性表尾部删除一个元素： "+list.remove());
		System.out.println(list.toString());
		
	}
}
