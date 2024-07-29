package homework;

public class ArrayHomework {
    public static void main(String[] args) {
        int[] array = {6, 8, 4, 7, 5, 6, 1, 4};
        System.out.println("1 վարժություն");
        int n = 6;
        int count = 0;

        for (int x : array) {
            if (x == n) {
                count++;
            }
        }
        System.out.println(count);
        System.out.println();
        System.out.println("2 վարժություն");
        int[] reversedArray = new int[array.length];
        int sum = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            reversedArray[sum++] = array[i];
        }
        for (int x : reversedArray) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("3 վարժություն");
        int x;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                x = array[j];
                if (x == array[i]) {
                    count += 1;
                }
            }
        }
        System.out.println(count);
        System.out.println();
        System.out.println("4 վարժություն");
        char[] charArray = {'բ', 'ա', 'ր', 'և', 'ա', 'շ', 'խ', 'ա', 'ր', 'հ'};
        char[] vowels = {'ա', 'ե', 'ը', 'է', 'ի', 'ո', 'օ'};
            int vowelsCount = 0;
        for (char c : charArray) {
            for (char v : vowels) {
                if (c == v){
                    vowelsCount++;
                    break;
                }
            }
        }
        System.out.println(vowelsCount);
    }
}
