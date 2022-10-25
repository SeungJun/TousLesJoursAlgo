import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q1662 {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        String w1 = "";
        for (String s : word1) {
            w1 += s;
        }
        String w2 = "";
        for (String s : word2) {
            w2 += s;
        }
//        w1 = Stream.of(w1.split("")).sorted().collect(Collectors.joining());
//        w2 = Stream.of(w2.split("")).sorted().collect(Collectors.joining());

        return w1.equals(w2);

    }
}
