package _68_2_�������������������;

public class Solution3 {
	/**
	 * �ݹ� ���� Wang˼·��8ms 50%��
	 * ����˼·Ϊ����HHHDDD.̫�������..��
	 * 1.�ݹ��ѯ�����ڵ�p q�����ĳ���ڵ���ڽڵ�p��ڵ�q���򷵻ظýڵ��ֵ�����ڵ㡣�������ýڵ�or�����������˽ڵ�p��q��
	 * 2.�����ǰ�ڵ�����������ֱ����p��q�ڵ㣬��ô����ڵ��Ȼ������Ľ⡣����Ϊ�ǵݹ飡�Ե����ϣ���
	 * 3.�����ǰ�ڵ���һ�������ķ���ֵΪp��q�ڵ㣬�򷵻ظ�ֵ�������߸��ڵ���һ���ڵ�����������У�
	 * 4.�����ǰ�ڵ��������������ֵ��Ϊ�գ��򷵻ؿ�ָ�롣
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q) {//base
        	return root;
        }
        //��MOST HD��⣺��1,2,3,4,5��2,5������������ȣ������root����left�ǿգ���rightΪ��->
        //��return��root������һ����p,q����root��left���������ҵ�˭���ͷ���˭�����ҵ���Ҳ�������Ƚڵ㣡��
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null&&right!=null) {//p,q���ҵ�,��ýڵ��������������ȣ�
        	return root;
        }
        else if(left!=null||right!=null) {//p,q�ҵ�һ��,���ϲ㴫,���������Լ�������ĳ���ڵ�
        	return (left==null)?right:left;
        }
        else {//p,q����û�ҵ�,���������Լ�����ɶҲû��
        	return null;
        }
    }
}
