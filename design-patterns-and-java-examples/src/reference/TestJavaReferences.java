package reference;

public class TestJavaReferences {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		
		Message m = null;
		//init(m);
		//System.out.println(m.toString()); 
		m = new Message("main");
		update(m);
		System.out.println(m.toString());
		
	}
	
	public static void init(Message m) {
		m = new Message("init");
	}
	
	public static void update(Message m) {
		m.setMsg("updated");;
	}
}

class Message {
	
	private String msg;
	
	public Message(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Message [msg=" + msg + "]";
	}
	
	
}