package _37_序列化二叉树;

public class Solution2 {
	/**
	 * 剑指offer思路：
	 * 1.background：
	 * 前序+中序 or 后序+中序 才能确定一棵树
	 * ——>前提是：1.树中没有重复节点[DISAD1]
	 * ——>且：2.只有当两个序列中所有数据都读出后才能反序列化
	 * 2.
	 * 但是！如果二叉树的【序列化是从根开始】的，相应的反序列化在根读出来的时候也就可以开始了！
	 * so！【根据前序DLR来序列化，并且把null也给序列化进来，以确保唯一性！】
	 * 3.
	 * （1）序列化EZ（DLR遇到空插#即可）
	 * （2）【反序列化HHHD】
	 *    （同样是DLR进行节点的生成！每轮一个nodes[i]判断如果非空，它就应该有左右儿子！DLR递归按序生成其左右儿子就vans！）
	 *    （很少写这样的逻辑！不够熟练！且有一个ATT:关于nodes的下标i！必须写在全局变量！这样才能在层层递归中使用正确的节点值！）
	 */
	// Encodes a tree to a single string.
	//序列化思路：前序遍历，null也存入，每个节点间用符号隔开
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root==null) {
        	return sb.toString();
        }
        return serialize(root,sb);
    }
    public String serialize(TreeNode node,StringBuilder sb) {
    	//DLR
    	if(node!=null) {
    		sb.append(node.val);
    		sb.append(",");
    		serialize(node.left,sb);
        	serialize(node.right,sb);
    	}
    	else {
    		sb.append("#");
    		sb.append(",");
    	}
    	return sb.toString();
    }

    // Decodes your encoded data to tree.
    //反序列化思路：DLR每读取一个建立一个连接
    public TreeNode deserialize(String data) {
    	if(data.length()==0) {
    		return null;
    	}
    	String[] nodes = data.split(",");
    	return deserialize(nodes);
    }
    int i = 0;//【HHHHDP】用于标识nodes数组中下标！必须设置为全局变量！不然后序node.left和right迭代中i无法正确更迭
    public TreeNode deserialize(String[] nodes) {
    	if(nodes[i].equals("#")) {
    		//说明是null节点
    		i++;
    		return null;
    	}
    	//否则是非null节点
    	TreeNode node = new TreeNode(Integer.parseInt(nodes[i]));
    	i++;
    	node.left = deserialize(nodes);
    	node.right = deserialize(nodes);
    	return node;
    }
}
