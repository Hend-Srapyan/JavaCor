package homework;

public class ArrayHomework {
    public static void main(String[] args) {
        int[] nums = {6, 8, 4, 7, 5, 6, 1, 4};
        int n = 6;
        int sum = 0;

        for (int x : nums) {
            if (x == n) {
                sum++;
            }
        }
        System.out.println(sum);

    }
}
