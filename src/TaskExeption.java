public class TaskExeption extends Exception{
    public TaskExeption() {
        System.out.println("ошибка");
    }

    public TaskExeption(String message) {
        super(message);
    }
}
