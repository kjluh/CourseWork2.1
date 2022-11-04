import java.time.LocalDate;
import java.util.Objects;

public class Task implements FrequencyTask {
    private String name; //название задачи
    private String description; //описание задачи
    private static int counter; //счетчик

    private TypeTask typeTask;//персональность
    private LocalDate dateOfCompletion; //время и дата постановки задачи


    private boolean remote = false; // удалена ли задача

    public void setDateOfCompletion(String dateOfCompletion) {
        this.dateOfCompletion = LocalDate.parse(dateOfCompletion);
    }

    public Task(String name, String description, TypeTask personalTack, String dateCreate) {
        try {
            counter = counter + 1;
            setName(name);
            setDescription(description);
            setTypeTask(personalTack);
            setDateOfCompletion(dateCreate);
        } catch (IllegalArgumentException e) {
            System.out.println("Не правильно введены данные");
        }
    }

    public boolean getRemote() {
        return remote;
    }

    public void setRemote(boolean remote) {
        this.remote = remote;
    }

    public LocalDate getDateOfCompletion() {
        return dateOfCompletion;
    }

    public int getId() {
        int id = counter;
        return id;
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


    @Override
    public String toString() {
        return "Название задачи " + name + ", описание " + description +
                ", тип:" + typeTask + ", время постановки " + dateOfCompletion
                + ", помечена как удаленная: " + getRemote();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return typeTask == task.typeTask && Objects.equals(name, task.name) && Objects.equals(description, task.description) && Objects.equals(dateOfCompletion, task.dateOfCompletion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, counter, typeTask, dateOfCompletion);
    }

    @Override
    public LocalDate frequency(LocalDate localDate) {
        return null;
    }
}
