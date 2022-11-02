import java.util.HashMap;
import java.util.Map;

public class DailyPlanner {
    protected final static Map<Integer, Task> planer = new HashMap<>();

    public DailyPlanner() {  }

    @Override
    public String toString() {
        return "Список задач: \n" + planer.values();
    }
}