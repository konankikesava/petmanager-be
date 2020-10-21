package ee.cgi.kk.petmanager.cc;

public enum Action {

    CREATE("create"),
    READ("read"),
    UPDATE("update"),
    DELETE("delete");

    private String action;

    Action(String action) {
        this.action = action;
    }


    @Override
    public String toString() {
        return action;
    }
}
