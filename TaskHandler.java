import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TaskHandler {

    private List<TaskData> tasks;
    private final Path FilePath = Path.of("tasks.josn");

    public TaskHandler(){
        this.tasks = loadTasks();
    }

    private List<TaskData> loadTasks(){



        return tasks;
    }

    public static void addTask(String arg) {
    }


    public static void updateTask(String arg) {
    }

    public static void markInProgress(String arg) {
    }

    public static void markDone(String arg) {
    }

    public static void listTasks(String filter) {

    }

    public static void deleteTask(String arg) {
    }

    public static void saveTasks() {
    }
}
