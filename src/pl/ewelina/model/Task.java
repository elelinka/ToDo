package pl.ewelina.model;

public class Task {

    private int id;
    private String title;
    private boolean status = false;

    public Task(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public void changeStatus() {
        if (!status) {
            status = true;
        } else {
            status = false;
        }
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean getStatus() {
        return status;
    }
}
