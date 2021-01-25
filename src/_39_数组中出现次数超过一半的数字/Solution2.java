package _39_�����г��ִ�������һ�������;

public class Solution2 {
	/**
	 * �ⷨ����ʱ��O(NlogN):1422ms �ռ�0(1)����
	 * ���������򣬵õ����м�Ԫ��һ���Ǵ���Ԫ�أ�
	 * 
	 * review:����˼·
	 * ÿ��ѡ��һ��pivot(һ���ǿ�ͷԪ�أ�)����pivotΪ���ް����黮�ֳ����룬Ȼ��ݹ�
	 */
	public int majorityElement(int[] nums) {
		quicksort(nums,0,nums.length-1);
		return nums[nums.length/2];
	}
	//�ݹ�quicksort
	public void quicksort(int[] arr,int start,int end) {
		if(start>=end) {
			return;
		}
		//ÿ�εݹ����һ�ηָ����midԪ�ذ���ߵ�Ԫ��
		int left = start;
		int right = end;
		int pivot = arr[left];
		while(left<right) {
			//�ȴ��ұ߿�ʼ�ƶ����ҵ�һ����pivotС�ġ�����pivot��λ�ã���
			while(arr[right]>=pivot&&right>left) {
				right--;
			}
			arr[left] = arr[right];
			//�ٴ���߿�ʼ�ƶ����ҵ�һ����pivot��Ĳ����ұ�
			while(arr[left]<=pivot&&left<right) {//��HDP �����жϱ�©..��
				left++;
			}
			arr[right] = arr[left];//�����left rightײ�ˣ���ô��һ��͸�û�����ˣ���
		}
		arr[left] = pivot;//����Ϊbreak��������left==right����������left or right���pivot�����ԣ���
		//�ݹ�
		quicksort(arr,start,left);
		quicksort(arr,left+1,end);
	}
}
