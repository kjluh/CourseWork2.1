import java.time.LocalDate;

public class EveryMonthTask extends Task implements FrequencyTask {


    public EveryMonthTask(String name, String description, TypeTask personalTack, String dateCreate) {
        super(name, description, personalTack,dateCreate);
    }

    @Override
    public LocalDate frequency(LocalDate localDate) {
        LocalDate x = getDateOfCompletion();
        while (localDate.isAfter(x)) {
            x = x.plusMonths(1);
        }

        return x;
    }

    @Override
    public String toString() {
        return super.toString()+" ежемесячная ";
    }
}
