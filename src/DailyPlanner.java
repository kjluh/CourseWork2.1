import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DailyPlanner {
    private final static Map<Integer, Task> PLANNER = new HashMap<>();

    public DailyPlanner() {  }
    protected static void getRemoteTask() {
        Collection<Task> baseRemoteTask = PLANNER.values();
        System.out.println("Список удаленных задач: ");
        for (Task task : baseRemoteTask) {
            if (task.getRemote()) {
                System.out.println(task);
            }
        }
    }

    protected void getTaskForDate(Scanner scanner) {
        LocalDate taskDate = LocalDate.parse(scanner.next());
        for (Task task : PLANNER.values()) {
            if (task.frequency(taskDate).equals(taskDate) && !task.getRemote()){
                System.out.println(task);
            }
        }
    }

    //    protected static void getDate(LocalDate localDate) {
//        Collection<Task> baseTaskForDate = DailyPlanner.planer.values();
//        for (Task task : baseTaskForDate) {
//            if (task.getRepeatability().equals(Repeatability.single) && task.getTimeCreateTask().equals(localDate) && !task.getRemote()) {
//                System.out.println("На эту дату есть задачи: " + task);
//            } else if (task.getRepeatability().equals(Repeatability.daily) && getDay(localDate, task) && !task.getRemote()) {
//                System.out.println("На эту дату есть задачи: " + task);
//            } else if (task.getRepeatability().equals(Repeatability.weekly) && EveryWeekTask.frequency(localDate, task) && !task.getRemote()) {
//                System.out.println("На эту дату есть задачи: " + task);
//            } else if (task.getRepeatability().equals(Repeatability.monthly) && getMonth(localDate, task) && !task.getRemote()) {
//                System.out.println("На эту дату есть задачи: " + task);
//            } else if (task.getRepeatability().equals(Repeatability.annual) && getYear(localDate, task) && !task.getRemote()) {
//                System.out.println("На эту дату есть задачи: " + task);
//            }
//        }
//    }
    protected void addDailyPlanner(Task task) throws TaskExeption {
        if (PLANNER.containsKey(task.getId())) {
            throw new TaskExeption("проверьте ключ к задаче " + task.getId() + " задача с данным номером уже присутствует в ежедневнике");
        } else {
            PLANNER.put(task.getId(), task);
        }
    }

    private static void removeTask(int count) {
        try {
            Task x = DailyPlanner.PLANNER.get(count);
            x.setRemote(true);
            DailyPlanner.PLANNER.put(count, x);
        }catch (NullPointerException e){
            System.out.println("задачи под таким номером нет");
        }
    }


    protected static void remove(Scanner scanner) {
        System.out.println("Введите номер задачи которую нужно удалить (нумерация с 1) ");
        int taskId = scanner.nextInt();
        removeTask(taskId);
    }

    protected static void editTask(Scanner scanner) {
        try {
            int x = scanner.nextInt();
            Task example = PLANNER.get(x);
            if (!example.equals(null)) {
                example.setName("Подскажи вот тут");
            }
            System.out.println("текущее значение: " + example);
            System.out.println("Введите новое название задачи: ");
            String name = scanner.next();
            example.setName(name);
            System.out.println("Введите новое описание задачи: ");
            String description = scanner.next();
            example.setDescription(description);
            PLANNER.put(x, example);
        } catch (NullPointerException e){
            System.out.println("задачи под таким номером нет");
        }
    }

    protected void inputTask(Scanner scanner) {
        try {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();
        System.out.print("Введите описание задачи задачи: ");
        String taskDescription = scanner.next();
        TypeTask personalTack;
        System.out.print("Если задача личная ведите - 1 \nесли по работе введите - 2\n");
        int scannerPersonalTack = scanner.nextInt();
        if (scannerPersonalTack <= 1) {
            personalTack = TypeTask.personal;
        } else {
            personalTack = TypeTask.working;
        }
        System.out.println("Введите желаемую дату задачи в формате год-месяц-день ");
        String dateCreate = scanner.next();

        System.out.print("Если задача единоразовая введите - 1\nесли ежедневная введите - 2\n" +
                "если еженедельная введите - 3 \nесли ежемесячная введите - 4 " +
                "\nесли ежегодная введите - 5\n");

            int repeatability = scanner.nextInt();
            Task example = null;
            if (repeatability == 1) {
                example = new SingleTask(taskName, taskDescription, personalTack,dateCreate);
            } else if (repeatability == 2) {
                example = new EveryDayTask(taskName, taskDescription, personalTack,dateCreate);
            }else if (repeatability == 3) {
                example = new EveryWeekTask(taskName, taskDescription, personalTack,dateCreate);
            }else if (repeatability == 4) {
                example = new EveryMonthTask(taskName, taskDescription, personalTack,dateCreate);
            }else if (repeatability == 5) {
                example = new EveryYaerTask(taskName, taskDescription, personalTack,dateCreate);
            }
            addDailyPlanner(example);
        } catch (TaskExeption e) {
            System.out.println("У нас проблемы ");
        } catch (DateTimeException e){
            System.out.println("У задачи введено неверное время!");
        }
    }


    @Override
    public String toString() {
        return "Список задач: \n" + PLANNER.values();
    }
}