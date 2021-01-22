package _37_ÐòÁÐ»¯¶þ²æÊ÷;

public class test {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n3.right = n5;
		
		Solution2 s = new Solution2();
		String str = s.serialize(n1);
		System.out.println(str);
		String[] data = str.split(",");
		for(int i=0;i<data.length;i++) {
			System.out.println(data[i]);
		}
		TreeNode node = s.deserialize(str);
		System.out.println("node.val="+node.val);
		System.out.println("node.left="+node.left.val);
		System.out.println("node.right="+node.right.val);
		System.out.println("node.right.left="+node.right.left.val);
		System.out.println("node.right.right="+node.right.right.val);
	}

}
