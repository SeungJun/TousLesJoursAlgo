public class Q345 {

    // OR 연산을 통해 원하는 문자인지 확인 할 수 있다.
    boolean isVowel(char c) {
        return c == 'a' || c == 'i' || c == 'e' || c == 'o' || c == 'u'
                || c == 'A' || c == 'I' || c == 'E' || c == 'O' || c == 'U';
    }


    // 두 문자 위치 교환
    void swap(char[] chars, int x, int y) {
        char temp = chars[x];
        chars[x] = chars[y];
        chars[y] = temp;
    }

    public String reverseVowels(String s) {
        int start = 0;
        int end = s.length() - 1;

        char[] sChar = s.toCharArray();


        while (start < end) {

            // 왼쪽 부터 모음 찾기
            while (start < s.length() && !isVowel(sChar[start])) {
                start++;
            }
            // 오른쪽 부터 모음 찾기
            while (end >= 0 && !isVowel(sChar[end])) {
                end--;
            }

            if (start < end) {
                swap(sChar, start++, end--);
            }
        }
        // Converting char array back to String
        return new String(sChar);
    }
}
