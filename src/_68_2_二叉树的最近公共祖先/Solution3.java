package _68_2_二叉树的最近公共祖先;

public class Solution3 {
	/**
	 * 递归 力扣 Wang思路【8ms 50%】
	 * 代码思路为：【HHHDDD.太难理解了..】
	 * 1.递归查询两个节点p q，如果某个节点等于节点p或节点q，则返回该节点的值给父节点。（表明该节点or其子树包含了节点p或q）
	 * 2.如果当前节点的左右子树分别包括p和q节点，那么这个节点必然是所求的解。（因为是递归！自底向上！）
	 * 3.如果当前节点有一个子树的返回值为p或q节点，则返回该值。（告诉父节点有一个节点存在其子树中）
	 * 4.如果当前节点的两个子树返回值都为空，则返回空指针。
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q) {//base
        	return root;
        }
        //【MOST HD理解：如1,2,3,4,5求2,5的最近公共祖先：这里对root，其left非空，但right为空->
        //则return了root！这里一定有p,q都在root的left！并且先找到谁，就返回谁，先找到的也必是祖先节点！】
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null&&right!=null) {//p,q都找到,则该节点就是最近公共祖先！
        	return root;
        }
        else if(left!=null||right!=null) {//p,q找到一个,往上层传,告诉上面自己这里有某个节点
        	return (left==null)?right:left;
        }
        else {//p,q个都没找到,告诉上面自己这里啥也没有
        	return null;
        }
    }
}
