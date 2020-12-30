package _09_用两个栈实现队列;

public class test {

	public static void main(String[] args) {
		bestCQueue obj = new bestCQueue();
		obj.appendTail(2);
		obj.appendTail(5);
		System.out.println(obj.st1.size());
		System.out.println("先2:"+obj.deleteHead());
		System.out.println("后5:"+obj.deleteHead());
	}
}
