import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Scheduler scheduler = new Scheduler();

        while (true) {
            System.out.println("\n====== CLOUD TASK SCHEDULER ======");
            System.out.println("1. Add Task");
            System.out.println("2. Execute Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Search Task");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Priority: ");
                    int priority = sc.nextInt();

                    System.out.print("Enter Execution Time: ");
                    int time = sc.nextInt();

                    scheduler.addTask(new Task(id, priority, time));
                    break;

                case 2:
                    scheduler.executeTask();
                    break;

                case 3:
                    scheduler.displayTasks();
                    break;

                case 4:
                    System.out.print("Enter Task ID to search: ");
                    int searchId = sc.nextInt();

                    Task result = scheduler.searchTask(searchId);

                    if (result != null) {
                        System.out.println("✅ Task Found:");
                        result.display();
                    } else {
                        System.out.println("❌ Task Not Found!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("⚠️ Invalid choice!");
            }
        }
    }
}