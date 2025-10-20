import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TaskHandler {

    private static List<Tasks> tasks= new ArrayList<>();
    private static final Path filePath = Path.of("tasks.json");

    public TaskHandler() throws IOException {
        tasks = loadTasks();
    }

    private List<Tasks> loadTasks() throws IOException {
        return tasks;
    }

    public static void addTask(String description) {
        Tasks newTask = new Tasks(description);
        tasks.add(newTask);
    }


    public void updateTask(String id, String newDescription) {
        findTask(id).setDescription(newDescription);
    }

    public static void markInProgress(String id) {
        findTask(id).setStatus(Status.INPROGRESS);
    }

    public static void markDone(String id) {
        findTask(id).setStatus(Status.DONE);
    }

    public static void listTasks(String filter) {
        for (Tasks task : tasks){
            String status = task.getStatus().toString().strip();
            if (filter.equals("All") || status.equals(filter)){
                System.out.println(task.toString());
            }
        }
    }

    public static void deleteTask(String id) {
        tasks.remove(findTask(id));
    }

    public static void saveTasks() throws IOException {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\n");
        for (int i = 0; i < tasks.size(); i++) {
            jsonBuilder.append(tasks.get(i).toString());
        }
        jsonBuilder.append("}\n");
        Files.writeString(filePath,jsonBuilder.toString() );
    }

    private static Tasks findTask(String id){
        for (Tasks task : tasks){
            if (task.getID() == Integer.parseInt(id)){
                return task;
            }
        }
        throw new NullPointerException("Task not found");
    }
}
