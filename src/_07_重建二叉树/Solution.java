package _07_�ؽ�������;

public class Solution {
/**
 * ��Ŀ�������������ǰ�������������У��ؽ��ö�����
 * ˼·��
 * Ele��ǰ����׸�ֵΪÿһ�ֵĸ��ڵ������ĸ��ڵ�ֵ�����黮��Ϊ����������
 * Steps��
 * ����ǰ��õ����ڵ�ֵ
 * �ҵ����ڵ�ֵ����������е�λ��
 * ���ݸ��ڵ������������λ�÷ָ�������������еݹ�
 */
	public TreeNode buildTree(int[] preorder,int[] inorder) {
		//base
		if(preorder.length==0||inorder.length==0) {
			return null;
		}
		//ÿһ�ֵĽڵ㴴������Ҫ�õ���ǰ���������鷶Χ����������һ������
		return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
	}
	
	public TreeNode buildTree(int[] preorder,int prestart,int preend,int[] inorder,int instart,int inend) {
		//base
		if(prestart>preend) {
			return null;
		}
		TreeNode node = new TreeNode(preorder[prestart]);//���ɱ��ֵĸ��ڵ�
		int index = -1;//���ڴ洢���ڵ�����������е�λ��
		for(int i=0;i<inorder.length;i++) {
			if(inorder[i]==node.val) {
				index = i;
				break;
			}
		}
		//��������������ڵ�����뱾�ֵ������ٴο������룬�ݹ�
		int leftsize = index-instart;//��¼�������Ľڵ������������ݹ鴫ֵ
		node.left = buildTree(preorder,prestart+1,prestart+leftsize,inorder,instart,index-1);
		node.right = buildTree(preorder,prestart+leftsize+1,preend,inorder,index+1,inend);
		return node;
	}
}
