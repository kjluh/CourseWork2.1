import java.util.HashMap;
import java.util.Map;

public class DailyPlanner {
    protected final static Map<Integer, Task> planer = new HashMap<>();

    public DailyPlanner() {
    }

    public void addDailyPlanner(Integer integer, Task task) throws TaskExeption {
        if (integer < 0 || task == null) {
            throw new TaskExeption("проверьте правильность добавления задачи");
        }  else if (planer.containsKey(integer)) {
            throw new TaskExeption("проверьте ключ к задаче " + integer + " задача с данным номером уже присутствует в ежедневнике");
        } else {
            planer.put(integer, task);
        }
    }

    public void removeTask ( int count){
        Task x = planer.get(count);
        x.setRemote(true);
        planer.put(count,x);
    }

    @Override
    public String toString () {
        return "planer = " + planer.values();
    }
}