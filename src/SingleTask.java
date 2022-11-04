import java.time.LocalDate;

public class SingleTask extends Task implements FrequencyTask {


    public SingleTask(String name, String description, TypeTask personalTack, String dateCreate) {
        super(name, description, personalTack,dateCreate);
    }

    @Override
    public LocalDate frequency(LocalDate localDate) {
        LocalDate x = getDateOfCompletion();
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