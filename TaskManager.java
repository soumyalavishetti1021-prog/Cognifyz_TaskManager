import java.util.ArrayList;
import java.util.Scanner;

class Task {
    int id;
    String name;

    Task(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "Task ID: " + id + ", Task Name: " + name;
    }
}

public class TaskManager {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Task Manager ---");
            System.out.println("1. Create Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();
                    tasks.add(new Task(id, name));
                    System.out.println("Task Added Successfully!");
                    break;

                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("No Tasks Available.");
                    } else {
                        for (Task task : tasks) {
                            System.out.println(task);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Task ID to Update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    for (Task task : tasks) {
                        if (task.id == updateId) {
                            System.out.print("Enter New Task Name: ");
                            task.name = sc.nextLine();
                            System.out.println("Task Updated Successfully!");
                            break;
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter Task ID to Delete: ");
                    int deleteId = sc.nextInt();

                    tasks.removeIf(task -> task.id == deleteId);
                    System.out.println("Task Deleted Successfully!");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}