import java.time.LocalDate;

public class EveryYaerTask extends Task implements FrequencyTask {


    public EveryYaerTask(String name, String description, TypeTask personalTack) {
        super(name, description, personalTack);
    }

    @Override
    public LocalDate frequency(LocalDate localDate) {
        LocalDate x = getTimeDeadLine();
        while (localDate.isAfter(x)) {
            x = x.plusYears(1);
        }

        return x;
    }

    @Override
    public String toString() {
        return super.toString() +" ежегодная ";
    }
}
