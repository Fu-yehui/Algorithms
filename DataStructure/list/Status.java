package list;

public class Status {
	public Object data;
	public String info;
	public Status(String info){
		this.info=info;
		
		
	}
	public Status(String info,Object data){
		this.info=info;
		this.data=data;
	
	}

	@Override
	public String toString() {
		return ""+info+" : "+data.toString();
	}

}
