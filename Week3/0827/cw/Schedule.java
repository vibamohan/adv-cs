
import java.util.ArrayList;

public class Schedule {
    public ArrayList<Pair<Integer, String>> mySchedule;

    public Schedule() {
        mySchedule = new ArrayList<>();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Pair<Integer, String> pair : mySchedule) {
            sb.append(pair.getKey()).append(" : ").append(pair.getValue()).append("\n");
        }
        return sb.toString();
    }

    public void addClass(int pd, String className) {
        mySchedule.add(new Pair<>(pd, className));
    }

}