import java.time.LocalDate;

public class EveryDayTask extends Task implements FrequencyTask {


    public EveryDayTask(String name, String description, TypeTask personalTack, String dateCreate) {
        super(name, description, personalTack,dateCreate);
    }

    @Override
    public LocalDate frequency(LocalDate localDate) {
        LocalDate x = getDateOfCompletion();
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
