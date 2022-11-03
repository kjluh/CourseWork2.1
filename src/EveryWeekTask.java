import java.time.LocalDate;

public class EveryWeekTask extends Task implements FrequencyTask {


    public EveryWeekTask(String name, String description, TypeTask personalTack, String dateCreate) {
        super(name, description, personalTack,dateCreate);
    }

    @Override
    public LocalDate frequency(LocalDate localDate) {
        LocalDate x = getDateOfCompletion();
        while (localDate.isAfter(x)) {
            x = x.plusWeeks(1);
            }

        return x;
    }

    @Override
    public String toString() {
        return super.toString() +" еженедельная ";
    }
}
