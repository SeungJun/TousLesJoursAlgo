import java.util.*;

public class Q433 {
        public int minMutation(String start, String end, String[] bank) {
            // BFS 이용
            Queue<String> queue = new LinkedList<>();
            // 중복을 확인하기 위해 HashSet 이용
            Set<String> seen = new HashSet<>();
            queue.add(start);
            seen.add(start);

            int steps = 0;

            while (!queue.isEmpty()) {
                int nodesInQueue = queue.size();
                for (int j = 0; j < nodesInQueue; j++) {
                    String node = queue.remove();
                    if (node.equals(end)) {
                        return steps;
                    }
                    // 유전자 문자열을 구성하는 문자는 4가지 밖에 없으니 모든 경우의수를 따져 본다.
                    for (char c: new char[] {'A', 'C', 'G', 'T'}) {
                        for (int i = 0; i < node.length(); i++) {
                            String neighbor = node.substring(0, i) + c + node.substring(i + 1);
                            // hashset 집합에 포함되어 있다면 생략, bank에 들어 있다면 queue에 넣어준다.
                            if (!seen.contains(neighbor) && Arrays.asList(bank).contains(neighbor)) {
                                queue.add(neighbor);
                                seen.add(neighbor);
                            }
                        }
                    }
                }

                steps++;
            }

            return -1;
        }

}
