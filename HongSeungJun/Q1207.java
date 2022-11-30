import java.util.*;

public class Q1207 {
    final int K = 1000;

    public boolean uniqueOccurrences(int[] arr) {
        int freq[] = new int[2 * K + 1];

        // 배열을 돌면서 등장 횟수를 저장한다.
        for (int num : arr) {
            freq[num + K]++;
        }

        // 정렬
        Arrays.sort(freq);

        // 이전값과 같다면 false를 리턴
        for (int i = 0; i < 2 * K; i++) {
            if (freq[i] != 0 && freq[i] == freq[i + 1]) {
                return false;

            }

        }
                return true;
    }
}
