import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author ${USER}
 * @date ${DATE}
 * @description
 */
public class Main {
    public static void main(String[] args) {

        int[] nums = new int[]{1, -3, 5};

        Arrays.sort(nums, (Comparator<Integer>) Comparator.comparingInt((Integer a) -> Math.abs(a)));

    }