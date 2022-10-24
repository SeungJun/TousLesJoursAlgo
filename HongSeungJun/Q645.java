import java.util.ArrayList;
import java.util.List;

public class Q645 {
    public int[] findErrorNums(int[] nums) {
        int size = nums.length+1;

        int[] check = new int[size];

        for(int i= 0; i < check.length; i++){
            check[nums[i]]++;
        }

        int[] result = new int[2];
        for(int i = 0; i < size; i++){
            if(check[i] >1 ){
                result[0] = check[i];
            } else if (check[i] == 0) {
                result[1] = check[i];

            }
        }
        return result;
    }
}
