package ee.cgi.kk.petmanager.cc;

public enum Message {

    OK("OK"),
    NOT_FOUND("Not found");

    private String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

}
