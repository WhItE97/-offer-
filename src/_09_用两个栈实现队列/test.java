package _09_������ջʵ�ֶ���;

public class test {

	public static void main(String[] args) {
		bestCQueue obj = new bestCQueue();
		obj.appendTail(2);
		obj.appendTail(5);
		System.out.println(obj.st1.size());
		System.out.println("��2:"+obj.deleteHead());
		System.out.println("��5:"+obj.deleteHead());
	}
}
