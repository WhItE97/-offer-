package _37_���л�������;

public class Solution2 {
	/**
	 * ��ָoffer˼·��
	 * 1.background��
	 * ǰ��+���� or ����+���� ����ȷ��һ����
	 * ����>ǰ���ǣ�1.����û���ظ��ڵ�[DISAD1]
	 * ����>�ң�2.ֻ�е������������������ݶ���������ܷ����л�
	 * 2.
	 * ���ǣ�����������ġ����л��ǴӸ���ʼ���ģ���Ӧ�ķ����л��ڸ���������ʱ��Ҳ�Ϳ��Կ�ʼ�ˣ�
	 * so��������ǰ��DLR�����л������Ұ�nullҲ�����л���������ȷ��Ψһ�ԣ���
	 * 3.
	 * ��1�����л�EZ��DLR�����ղ�#���ɣ�
	 * ��2���������л�HHHD��
	 *    ��ͬ����DLR���нڵ�����ɣ�ÿ��һ��nodes[i]�ж�����ǿգ�����Ӧ�������Ҷ��ӣ�DLR�ݹ鰴�����������Ҷ��Ӿ�vans����
	 *    ������д�������߼�����������������һ��ATT:����nodes���±�i������д��ȫ�ֱ��������������ڲ��ݹ���ʹ����ȷ�Ľڵ�ֵ����
	 */
	// Encodes a tree to a single string.
	//���л�˼·��ǰ�������nullҲ���룬ÿ���ڵ���÷��Ÿ���
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
    //�����л�˼·��DLRÿ��ȡһ������һ������
    public TreeNode deserialize(String data) {
    	if(data.length()==0) {
    		return null;
    	}
    	String[] nodes = data.split(",");
    	return deserialize(nodes);
    }
    int i = 0;//��HHHHDP�����ڱ�ʶnodes�������±꣡��������Ϊȫ�ֱ�������Ȼ����node.left��right������i�޷���ȷ����
    public TreeNode deserialize(String[] nodes) {
    	if(nodes[i].equals("#")) {
    		//˵����null�ڵ�
    		i++;
    		return null;
    	}
    	//�����Ƿ�null�ڵ�
    	TreeNode node = new TreeNode(Integer.parseInt(nodes[i]));
    	i++;
    	node.left = deserialize(nodes);
    	node.right = deserialize(nodes);
    	return node;
    }
}
