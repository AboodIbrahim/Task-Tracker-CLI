public class TaskCLI {
    public static void main(String[] args) {

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
                System.out.println("Task was added. (ID: "+TaskHandler.getID()+")");
                break;

            case "update":
                if (args.length < 3){
                    System.out.println("TaskCLI update [ID] [argument]");
                    return;
                }
                TaskHandler.updateTask(args[2]);
                System.out.println("Task was updated. (ID: "+TaskHandler.getID()+", description: "+TaskHandler.getDesc()+")");
                break;

            case "delete":
                if (args.length < 2){
                    System.out.println("TaskCLI delete [ID]");
                    return;
                }
                TaskHandler.deleteTask(args[2]);
                System.out.println("Task was deleted. (ID: "+TaskHandler.getID()+")");
                break;

            case "mark-in-progress":
                if (args.length < 2){
                    System.out.println("TaskCLI mark-in-progress [ID]");
                    return;
                }
                TaskHandler.markInProgress(args[1]);
                System.out.println("marked as in-progress.");
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
