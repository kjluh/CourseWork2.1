import java.time.LocalDate;

public class EveryMonthTask extends Task implements FrequencyTask {


    public EveryMonthTask(String name, String description, TypeTask personalTack) {
        super(name, description, personalTack);
    }

    @Override
    public LocalDate frequency(LocalDate localDate) {
        LocalDate x = getTimeDeadLine();
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
