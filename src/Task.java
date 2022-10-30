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
}
