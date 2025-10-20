import java.io.IOException;

public class TaskCLI {
    public static void main(String[] args) throws IOException {
        TaskHandler taskHandler = new TaskHandler();
        while (true) {
            if (args.length < 1){
                System.out.println("TaskCLI <command> [argument]");
                return;
            }

            String command = args[0];

            switch (command){
                case "add":
                    if (args.length < 2){
                        System.out.println("TaskCLI add [argument]");
                        return;
                    }
                    TaskHandler.addTask(args[1]);
                    System.out.println("Task was added. ("+args[1]+")");
                    break;

                case "update":
                    if (args.length < 3){
                        System.out.println("TaskCLI update [ID] [argument]");
                        return;
                    }
                    taskHandler.updateTask(args[1] ,args[2]);
                    System.out.println("Task was updated. (ID: "+args[1]+", new description: "+args[2]+")");
                    break;

                case "delete":
                    if (args.length < 2){
                        System.out.println("TaskCLI delete [ID]");
                        return;
                    }
                    TaskHandler.deleteTask(args[2]);
                    System.out.println("Task was deleted. (ID: "+args[2]+")");
                    break;

                case "mark-in-progress":
                    if (args.length < 2){
                        System.out.println("TaskCLI mark-in-progress [ID]");
                        return;
                    }
                    TaskHandler.markInProgress(args[1]);
                    System.out.println("Successfully marked as in-progress.");
                    break;

                case "mark-done":
                    if (args.length < 2){
                        System.out.println("TaskCLI mark-done [ID]");
                        return;
                    }
                    TaskHandler.markDone(args[1]);
                    System.out.println("marked as done.");
                    break;

                case "list":
                    if (args.length < 2){
                        TaskHandler.listTasks("All");
                        System.out.println("Listing completed!");
                    } else {
                        Status filterStatus;

                        filterStatus= Status.valueOf(args[1].toUpperCase().replace("-", ""));
                        TaskHandler.listTasks(filterStatus.toString());
                        break;
                    }
                default:
                    System.out.println("Unknown command");
                    break;
            }

            TaskHandler.saveTasks();
        }



    }
}
