package _30_包含min函数的栈;

public class test {

	public static void main(String[] args) {
		MinStack st = new MinStack();
//		st.push(2147483646);
//		st.push(2147483646);
//		st.push(2147483647);
//		System.out.println(st.top());
//		st.pop();//余646,646
//		System.out.println(st.min());
//		st.pop();//余646
//		System.out.println(st.min());
//		st.pop();//空栈
//		st.push(2147483647);//余647 min 647 【WRONG POINT在栈空的时候要重设min！！！】
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
		System.out.println("after pop：");
		System.out.println(st.min());

		st.push(-7);
		st.push(-7);
		System.out.println(st.min());

		st.pop();
		System.out.println(st.min());

	}

}
