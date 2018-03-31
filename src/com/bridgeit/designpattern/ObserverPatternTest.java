package com.bridgeit.designpattern;

public class ObserverPatternTest {

	public static void main(String[] args) {
		//create subject
		MyTopic topic = new MyTopic();
		
		//create observers
		Observer obj1 = new MyTopicSubscriber("Obj1");
		Observer obj2 = new MyTopicSubscriber("Obj2");
		Observer obj3 = new MyTopicSubscriber("Obj3");
		
		//register observers to the subject
		topic.register(obj1);
		topic.register(obj2);
		topic.register(obj3);
		
		//attach observer to subject
		obj1.setSubject(topic);
		obj2.setSubject(topic);
		obj3.setSubject(topic);
		
		//check if any update is available
		obj1.update();
		obj2.update();
		//now send message to subject
		topic.postMessage("New Message");
		
		
		Observer obj4 = new MyTopicSubscriber("Obj4");
		topic.register(obj4);
		obj4.setSubject(topic);
		obj4.update();
		
		topic.postMessage("Some thing is wrong with this implementation");
		
		obj4.update();
	}

}