package _30_����min������ջ;

public class test {

	public static void main(String[] args) {
		MinStack st = new MinStack();
//		st.push(2147483646);
//		st.push(2147483646);
//		st.push(2147483647);
//		System.out.println(st.top());
//		st.pop();//��646,646
//		System.out.println(st.min());
//		st.pop();//��646
//		System.out.println(st.min());
//		st.pop();//��ջ
//		st.push(2147483647);//��647 min 647 ��WRONG POINT��ջ�յ�ʱ��Ҫ����min��������
//		System.out.println(st.top());
//		System.out.println(st.min());
//		st.push(-2147483648);
//		System.out.println(st.top());
//		System.out.println(st.min());
//		st.pop();
//		System.out.println(st.min());
		st.push(-10);
		st.push(14);
		System.out.println(st.min());

		st.push(-20);
		System.out.println(st.min());

		st.pop();
		System.out.println("after pop��");
		System.out.println(st.min());

		st.push(-7);
		st.push(-7);
		System.out.println(st.min());

		st.pop();
		System.out.println(st.min());

	}

}
