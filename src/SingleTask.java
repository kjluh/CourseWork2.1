import java.time.LocalDate;

public class SingleTask extends Task implements FrequencyTask {


    public SingleTask(String name, String description, TypeTask personalTack) {
        super(name, description, personalTack);
    }

    @Override
    public LocalDate frequency(LocalDate localDate) {
        LocalDate x = getTimeDeadLine();
        if (localDate.equals(x)) {
            x = localDate;
        }
        return x;
    }

    @Override
    public String toString() {
        return super.toString() + " единоразовая ";
    }
}