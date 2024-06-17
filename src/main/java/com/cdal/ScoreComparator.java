import java.util.Comparator;
import java.util.Map;

public class ScoreComparator implements Comparator<Map.Entry<Participant, Integer>> {
    @Override
    public int compare(Map.Entry<Participant, Integer> o1, Map.Entry<Participant, Integer> o2) {
        return o2.getValue().compareTo(o1.getValue());
    }
}
