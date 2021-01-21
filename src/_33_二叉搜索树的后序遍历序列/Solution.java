package _33_�����������ĺ����������;

/**
 * ��Ŀ��
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�����������������򷵻� true�����򷵻� false���������������������������ֶ�������ͬ��
 */
public class Solution {
	/**
	 * self˼·��
	 * ��ͼ��ⷢ�֣�BST�������������һ���ڵ��Ǹ������Ը��ݸ���ǰ������黮��Ϊ��������С�ڸ������н�㣩�������������ڸ������н�㣩
	 * �ݹ黮��->1.�ݹ鵽�����ٻ��ֵĵ��ڵ�->true��2.���ֺ���������в�����һ��ȫС�ڸ���һ��ȫ���ڸ�->false
	 * ʵ�֣�
	 * ÿ�ֻ��ֺ��������������Ƿ�����һ��ȫС�ڸ���һ��ȫ���ڸ������������return���ֵ㣬�����ݹ�
	 */
	public boolean verifyPostorder(int[] postorder) {
		return split(postorder,0,postorder.length-1);
    }
	
	/**
	 * ���еݹ黮��
	 * @param postorder
	 * @param start ���ֻ��ֵ����
	 * @param end ���ֻ��ֵ��յ�
	 */
	public boolean split(int[] postorder,int start,int end) {
		if(start>=end) {//�����ݹ�����������ֵ������ڵ�
			return true;
		}
		int root = postorder[end];//���ֵĸ����ֵ
		int split = -1;//���汾�ֵĻ��ֵ��±�
		for(int i=start;i<=end;i++) {
			if(postorder[i]>root) {//BST�ĺ�������LR D��LȫС��D�������ҵ���һ������D��λ�ñ��Ϊ���ֵ㣨��ߵ�ȫС�ڸ�->��������
				split = i;
				break;
			}
		}
		//1.С��0��û�ҵ�split��˵��postorder�е�Ԫ��ȫС��root����rootֻ�����������ݹ������������Ƿ�����BST
		if(split<0) {
			return split(postorder,start,end-1);
		}
		//2.split>=0���ҵ����ֵ㣡��ʼ����Ƿ�Ϲ�->��Ϊsplitǰ�ıض���С��root�����Լ��split��Ļ���û��С��root�ľ�����
		//2.1.����У��򷵻�false
		for(int i=split;i<=end;i++) {
			if(postorder[i]<root) {
				return false;
			}
		}
		//2.2.���û�У���ݹ��黮�ֺ����������
		return split(postorder,start,split-1)&&split(postorder,split,end-1);
	}
}
