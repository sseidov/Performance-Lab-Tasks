package task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) throws FileNotFoundException {
        int[] nums = readFile(args[0]);
        Arrays.sort(nums);
        int  count = 0;
        for (int i = 0; i < nums.length; i++) {
            count+= Math.abs(nums[i] - nums[nums.length/2]);
        }
        System.out.println(count);
    }

    public static int[] readFile(String arg) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(arg));
        StringBuilder stringBuilder = new StringBuilder();

        while (scanner.hasNext())
            stringBuilder.append(scanner.next() + " ");

        String[] strings = stringBuilder.toString().split(" ");
        int[] integers = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            integers[i] = Integer.parseInt(strings[i]);
        }
        return integers;
    }
}
