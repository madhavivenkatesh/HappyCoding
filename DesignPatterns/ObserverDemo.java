package designpatterns;

import java.util.HashSet;
import java.util.Set;

interface Subject {
	
	public void registerObserver(Observer obj);
	public void unregisterObserver(Observer obj);
	public void notifyMessage();
	public Object getupdate(Observer obj);
}

interface Observer
{
	public void update();
	public void setSubject(Subject sub);
}

class SubjectImpl implements Subject{
	
	private Set<Observer> set ;
	private String message;
	private boolean changed;
	private Object MUTEX = new Object();
	
	public SubjectImpl(){
		this.set = new HashSet<Observer>();
	}

	@Override
	public void registerObserver(Observer obj) {
		if(obj==null) throw new NullPointerException("Observer is null");
		synchronized(MUTEX){
			if(!set.contains(obj)){
				set.add(obj);
			}
				
		}
		
	}

	@Override
	public void unregisterObserver(Observer obj) {
		if(obj==null || !set.contains(obj)) throw new NullPointerException("Observer is null or not in set");
		synchronized(MUTEX){
			set.remove(obj);
		}
		
	}

	@Override
	public void notifyMessage() {
		Set<Observer> localset = null;
		synchronized(MUTEX){
			if(!changed){
				return;
			}
			
			localset = new HashSet<>(this.set);
			this.changed=false;
			
			for(Observer o:localset)
				o.update();
		}
	}

	@Override
	public Object getupdate(Observer obj) {
		return this.message;
	}
	
	public void postMessage(String msg){
		System.out.println("Message Posted to Topic:"+msg);
		this.message=msg;
		this.changed=true;
		notifyMessage();
	}

	
}

class ObserverImpl implements Observer{
	
	private String name;
	private Subject topic;
	
	public ObserverImpl(String nm){
		this.name=nm;
	}

	@Override
	public void update() {
		String msg = (String) topic.getupdate(this);
		if(msg == null)
			System.out.println(name+":: No new message");
		else
			System.out.println(name+":: Consuming message::"+msg);
	}

	@Override
	public void setSubject(Subject sub) {
		this.topic = sub;
		
	}
	
}

public class ObserverDemo {
	
	public static void main(String[] args) {
		//create subject
		SubjectImpl topic = new SubjectImpl();
		
		//create observers
		Observer obj1 = new ObserverImpl("Obj1");
		Observer obj2 = new ObserverImpl("Obj2");
		Observer obj3 = new ObserverImpl("Obj3");
		
		//register observers to the subject
		topic.registerObserver(obj1);
		topic.registerObserver(obj2);
		topic.registerObserver(obj3);
		
		//attach observer to subject
		obj1.setSubject(topic);
		obj2.setSubject(topic);
		obj3.setSubject(topic);
		
		//check if any update is available
		obj1.update();
		
		//now send message to subject
		topic.postMessage("New Message");
	}

}
