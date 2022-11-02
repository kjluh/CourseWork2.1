import java.time.LocalDate;

public class EveryDayTask extends Task implements FrequencyTask {


    public EveryDayTask(String name, String description, TypeTask personalTack) {
        super(name, description, personalTack);
    }

    @Override
    public LocalDate frequency(LocalDate localDate) {
        LocalDate x = getTimeDeadLine();
        if (localDate.isAfter(x)) {
            x = localDate;
        }
        return x;
    }

    @Override
    public String toString() {
        return super.toString() + " ежедневная ";
    }
}
