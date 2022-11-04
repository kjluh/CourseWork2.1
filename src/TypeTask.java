public enum TypeTask {
    personal(" личная "),
    working(" рабочая ");
    private final String info;

    TypeTask(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return info;
    }
}
