public class TaskExeption extends Exception{

    public TaskExeption(String message) {
        super(message);
    }
    public void DateTimeParseException(){
        System.out.println("время введено некорректно");
    }
}
