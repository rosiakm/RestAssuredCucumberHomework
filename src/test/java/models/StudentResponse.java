package models;

public class StudentResponse {

    private String status;
    private models.Data data;

    public StudentResponse() {
    }

    public StudentResponse(String status, Data data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
