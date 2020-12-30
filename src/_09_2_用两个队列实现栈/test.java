package _09_2_用两个队列实现栈;

public class test {

	public static void main(String[] args) {
		bestStack st = new bestStack();
		System.out.println(st.empty());
		System.out.println(st.top());
		st.push(1);
		st.push(2);
		st.push(3);
		System.out.println("pop="+st.pop()+",after pop,top="+st.top());
		System.out.println("now top="+st.top());
		
//		st.q1.add(2);
//		st.q1.add(3);
//		System.out.println("size:"+st.q1.size());
//		for(int i=0;i<st.q1.size()+1;i++) {
//			System.out.println("i="+i);
//			System.out.println("q1.size this turn:"+st.q1.size());
//			System.out.println("poll():"+st.q1.poll());
//		}
//		System.out.println("size after poll:"+st.q1.size());
	}

}
