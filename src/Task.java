import java.time.LocalDate;
import java.util.Objects;

public class Task {
    private String name; //название задачи
    private String description; //описане задачи
    private static int counter; //счетчик

    private TypeTask typeTask;
    private LocalDate timeCreateTask; //время и дата постановки задачи
    private Repeatability repeatability; //енам по повторяемости

    private boolean remote = false;

    public void setTimeCreateTask(LocalDate timeCreateTask) {
        this.timeCreateTask = timeCreateTask;
    }

    public Task(String name, String description, TypeTask personalTack, Repeatability repeatability) {
        counter = counter + 1;
        setName(name);
        setDescription(description);
        setTypeTask(personalTack);
        setLocalDateTime();
        setRepeatability(repeatability);
    }

    public boolean getRemote() {
        return remote;
    }

    public void setRemote(boolean remote) {
        this.remote = remote;
    }

    public LocalDate getTimeCreateTask() {
        return timeCreateTask;
    }

    public int getId() {
        int id = counter;
        return id;
    }

    public TypeTask getTypeTask() {
        return typeTask;
    }

    public Repeatability getRepeatability() {
        return repeatability;
    }

    public void setName(String name) {
        this.name = Objects.requireNonNullElse(name, "Задача " + counter);
    }

    public void setDescription(String description) {
        this.description = Objects.requireNonNullElse(description, "o_o");
    }

    public void setTypeTask(TypeTask typeTask) {
        this.typeTask = typeTask;
    }

    public void setLocalDateTime() {
        this.timeCreateTask = LocalDate.now();
    }

    public void setRepeatability(Repeatability repeatability) {
        this.repeatability = repeatability;
    }


    @Override
    public String toString() {
        return "Название задачи " + name + ", описание " + description +
                ", тип:" + typeTask + ", время постановки " + timeCreateTask +
                ", повторямость " + repeatability.getInfo() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return typeTask == task.typeTask && Objects.equals(name, task.name) && Objects.equals(description, task.description) && Objects.equals(timeCreateTask, task.timeCreateTask) && repeatability == task.repeatability;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, counter, typeTask, timeCreateTask, repeatability);
    }

    public boolean getWeek(LocalDate localDate) {
        boolean q = false;
        LocalDate y = timeCreateTask;
        int i = 0;
        while (i < (100 * 12 * 4)) {
            if (y.equals(localDate)) {
                q = true;
                break;
            } else {
                y = y.plusWeeks(1);
                i = i + 1;
            }
        }
        return q;
    }

    public boolean getMonth(LocalDate localDate) {
        boolean q1 = false;
        LocalDate x = timeCreateTask;
        int i = 0;
        while (i < (100 * 12)) {
            if (x.equals(localDate)) {
                q1 = true;
                break;
            } else {
                x = x.plusMonths(1);
                i = i + 1;
            }
        }
        return q1;
    }

    public boolean getYear(LocalDate localDate) {
        boolean q2 = false;
        LocalDate z = timeCreateTask;
        int i = 0;
        while (i < 100) {
            if (z.equals(localDate)) {
                q2 = true;
                break;
            } else {
                z = z.plusYears(1);
                i = i + 1;
            }
        }
        return q2;
    }

    public boolean getDay(LocalDate localDate) {
        boolean q3 = false;
        LocalDate z = timeCreateTask;
        int i = 0;
        if (localDate.isAfter(z)) {
            q3 = true;
        }
        return q3;
    }
}
