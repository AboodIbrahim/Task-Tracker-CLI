public enum Status {
    TODO("Todo"),
    INPROGRESS("In progress"),
    DONE("Done");

    private final String name;

    Status(String name){
        this.name=name;
    }

    @Override
    public String toString(){
        return name;
    }


}
