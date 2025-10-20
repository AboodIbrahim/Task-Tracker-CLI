import java.time.LocalDateTime;

public class TaskData {

    private int id = 0;
    private String description;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public TaskData(String description){
        this.description= description;
        id++;
        this.createdAt = LocalDateTime.now();
        this.status= Status.TODO;
    }

    public int getID() {
        return this.id;
    }

    public String getDesc(){
        return this.description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
