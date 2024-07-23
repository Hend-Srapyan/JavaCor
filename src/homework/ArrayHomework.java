package homework;

public class ArrayHomework {
    public static void main(String[] args) {
        int[] nums = {6, 8, 4, 7, 5, 6, 1, 4};
        System.out.println("1 վարժություն");
        int n = 6;
        int sum = 0;

        for (int x : nums) {
            if (x == n) {
                sum++;
            }
        }
        System.out.println(sum);
        System.out.println();


        System.out.println("3 վարժություն");
        int x;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                x = nums[j];
                if (x == nums[i]) {
                    sum += 1;
                }
            }
        }
        System.out.println(sum);
    }
}
