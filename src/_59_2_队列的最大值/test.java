package _59_2_���е����ֵ;

public class test {

	public static void main(String[] args) {
		MaxQueue q = new MaxQueue();
		q.push_back(868);
		System.out.println(q.pop_front());
		System.out.println(q.pop_front());
		System.out.println(q.pop_front());
		q.push_back(525);
		System.out.println(q.pop_front());
		System.out.println(q.max_value());
	}

}
