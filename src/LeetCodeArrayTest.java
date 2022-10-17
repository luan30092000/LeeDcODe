import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCodeArrayTest {

    @Test
    void basic_case() {
        int[] arr = new int[9];
        arr[0] = 1;
        arr[1] = 8;
        arr[2] = 6;
        arr[3] = 2;
        arr[4] = 5;
        arr[5] = 4;
        arr[6] = 8;
        arr[7] = 3;
        arr[8] = 7;
        assertEquals(49, LeetCodeArray.maxArea(arr));

    }
}