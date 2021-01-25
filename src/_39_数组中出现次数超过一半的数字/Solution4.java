package _39_�����г��ִ�������һ�������;

public class Solution4 {
	/**
	 * ��ָoffer˼·����ʱ��O(N)5.02%.. �ռ�O(1)��
	 * [CORE]���ŵ�partition ����������
	 * �ȷ����������
	 * 1.������k�����±�<length/2��������������Ұ�ߣ����Ұ�߼�������
	 * 2.������k�����±�>length/2��������������Ұ�ߣ������߼�������
	 * 3.��ֱ����k==length/2->k������λ����
	 * 
	 * [HHHDDDP]���˺ܾù��ڿ��ŵ�ϸ�ڣ���DataStructureLearningĿ¼�¿��ŵıʼǣ�
	 * [HHHDDDP]�����length/2��length�����ǳ�ʼ����ĳ��ȣ�����Ҫ�ҵ�����->�����һ����������м䣡�������������ڵݹ���������м䣡����
	 */
	public int majorityElement(int[] nums) {
		//��Ϊ ����Լ��������Ƿǿյģ����Ҹ������������Ǵ��ڶ���Ԫ�ء����Բ��ÿ���base
		int start = 0;
		int end = nums.length-1;
		int mid = (start+end)/2;
		int index = partition(nums,start,end);
		while(index!=mid) {
			if(index>mid) {//˵��k����ߴ������鳤�ȵ�һ�룬��λ�������
				end = index-1;
				index = partition(nums,start,end);
			}
			else {//˵��k���ұߴ������鳤�ȵ�һ�룬��λ�����ұ�
				start = index+1;
				index = partition(nums,start,end);
			}
		}
		return nums[index];
	}
	
	//����start��end��ѡstart��pivot����������ر��ַ������pivotλ�ã��Ա��������ж�
	public int partition(int[] nums,int start,int end) {
		int pivot = nums[start];
		int left = start;
		int right = end;
		while(left<right) {
			//�ȴ���������һ��С��pivot��
			while(nums[right]>=pivot&&right>left) {//��HDP�����>=�������<��ֻ��һ����ȡ�ȣ�������
				right--;
			}
			nums[left] = nums[right];
			//�ٴ���������һ������pivot�Ĳ����������rightλ��
			while(nums[left]<pivot&&left<right) {//��HDP���ϡ�
				left++;
			}
			nums[right] = nums[left];
		}
		//������ʱ��left==right����Ϊpivot���������ַ���
		nums[left] = pivot;
		return left;//���ر��ַ���������pivotλ�ã��ݴ˾���������������
	}
}
