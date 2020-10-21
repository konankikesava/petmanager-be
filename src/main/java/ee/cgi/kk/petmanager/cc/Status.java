package ee.cgi.kk.petmanager.cc;

public enum Status {

    OK(200),
    ERROR(400);

    private Integer status;

    Status(Integer status) {this.status = status;}

    @Override
    public String toString() {
        return status.toString();
    }

}
