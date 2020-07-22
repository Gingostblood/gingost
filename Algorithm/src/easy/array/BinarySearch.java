package easy.array;

/**
 * @author:lezzy
 * @Date:2020/7/16 10:19
 *
 * some example may use the end-- & start++ to move the index of middle
 * but there are some bugs in it
 * for example:
 * int[] nums={1,2,3,4,5,6,7}
 * start=0 end=6 flag=7
 * 1.middle=3;flag>middle;start++
 * 2.start=1,end=6 but now middle=3
 * beacuse of the step2 middle is the same as the step1 middle
 * so the search times will grows up and it not belong to BinarySearch
 * so the simplest method is end=mid-1 and start=end+1
 *
 */
public class BinarySearch {
    public int binarySearch(int[] nums,int flag) {
        int start=0;
        int end=nums.length-1;
        while(start<=end) {
            int middle=(end+start)/2;
            if(flag<nums[middle]) {
                end=middle-1;
            }else if(flag>nums[middle]) {
                start=middle+1;
            }else{
                return middle;
            }
        }
        return -1;
    }
}
