import java.util.ArrayList;
import java.util.List;

public class Q1239 {

    static int max = 0;

    public static void main(String[] args) {
        List<String> arr = new ArrayList<String>();

        arr.add("aa");
        arr.add("bb");

        System.out.println(maxLength(arr));
    }
    public static int maxLength(List<String> arr) {
        int result;
        boolean[] visited = new boolean[arr.size()];
        for(int i = 1; i <= arr.size(); i++){
            combi(arr, visited, 0, arr.size(),i);
        }

        return  max;

    }
    static void combi(List<String> arr, boolean[] visited, int stand, int n, int r) {
        // 원하는 개수 만큼 뽑았으면 뽑은 결과를 출력
        if (r == 0) {
           int l = findLength(arr,visited,n);
           if( max < l ) max = l;
            return;
        }
        for (int i = stand; i < n; i++) {
            // 뽑았다면 visited를 true로 변경
            visited[i] = true;
            // 다음 index로 기준을 바꾸고 뽑는 개수를 줄인다.
            combi(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }

    }
    
    static int findLength(List<String> arr, boolean[] visited, int n){
        String temp = "";

        for(int i = 0; i < n; i++){
            if(visited[i]){
                temp += arr.get(i);
            }
        }
        String answer="";
        for(int i=0; i<temp.length(); i++){
            //System.out.println(str.charAt(i)+" "+i+" "+str.indexOf(str.charAt(i)));
            if(temp.indexOf(temp.charAt(i))==i) answer+=temp.charAt(i);
        }
        if (temp.length() != answer.length()) return 0;
        else return temp.length();




    }
}
