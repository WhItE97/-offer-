package _39_数组中出现次数超过一半的数字;

public class Solution5 {
    public int majorityElement(int [] array) {
        if(array.length <= 0){
            return 0;
        }
        int left=0,right=array.length-1;
        int index = partition(array,left,right);
        while(index!=array.length/2){
            if(index<array.length/2)
                index = partition(array,index+1,right);
            else
                index = partition(array,left,index-1);
        }
        int result = array[index]; 
        if(!checkHalf(array,result)){
            return 0;
        }
        return result;
    }
    public boolean checkHalf(int [] array,int num){
        int count = 0;
        for(int i = 0;i < array.length;i++){
            if(array[i] == num){
                count ++;
            }
        }
        if( count * 2 <= array.length){
            return false;
        }
        return true;
    }
    public static int partition(int[] nums,int left,int right){
    	System.out.println("s5,left="+left+",right="+right);
        int pivot = nums[left];
        while(left<right){
            while (left<right && nums[right]>=pivot)
                right--;
            if(left<right)
                nums[left] = nums[right];
            while (left<right && nums[left]<pivot)
                left++;
            if(left<right)
                nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
}

