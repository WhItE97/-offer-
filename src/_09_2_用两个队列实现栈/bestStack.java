package _09_2_用两个队列实现栈;

import java.util.LinkedList;
import java.util.Queue;

public class bestStack {
/**
 * （队列：头出尾进）
 * 自己写的逻辑太多了...绕来绕去代码很长
 * 官方优化解：
 * CORE思想：保证其中一个队列是栈的顺序！
 * Step：
 * （假设保证q1是栈的正确顺序）
 * 1.每次offer都offer到q2，然后立即把q2的全部poll到q1，这样q1从队尾按序出元素就是栈的顺序！
 * 2.pop等价于q1出队
 * 3.empty等价于q1判空
 * 4.top等价于q1取peek
 */
	int val;
	Queue<Integer> q1;
	Queue<Integer> q2;
	bestStack(){
		q1 = new LinkedList<Integer>();
		q2 = new LinkedList<Integer>();
	}
	
	public void push(int x) {
		q2.offer(x);//加到q2作头（因为后进先出），然后再把q1按栈序加入q2，这样q2也是栈序；再把q2与q1对调即可
		while(!q1.isEmpty()) {
			q2.offer(q1.poll());
		}
		Queue<Integer> temp = q2;
		q2 = q1;
		q1 = temp;
	}
	
	public int pop() {
		return q1.poll();
	}
	
	public Integer top() {
		return q1.peek();
	}
	
	public boolean empty() {
		return q1.isEmpty();
	}
}
