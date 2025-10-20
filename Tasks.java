import java.time.LocalDateTime;

public class Tasks {

    private int id = 0;
    private String description;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public Tasks(String description){
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

    public void setDescription(String newDesc){
        this.description=newDesc;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
    @Override
    public String toString(){
        return "id: " + id + ", description: " + description.strip() + ", status: " + status.toString() +
                ", createdAt: " + createdAt + ", updatedAt: " + updatedAt;
    }
}
