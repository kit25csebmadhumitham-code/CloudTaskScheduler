import java.util.*;

// Task Class
class Task {
    int id;
    int priority;
    int executionTime;

    public Task(int id, int priority, int executionTime) {
        this.id = id;
        this.priority = priority;
        this.executionTime = executionTime;
    }

    public void display() {
        System.out.println("Task ID: " + id +
                " | Priority: " + priority +
                " | Execution Time: " + executionTime);
    }
}

// Scheduler Class
class Scheduler {

    private PriorityQueue<Task> queue;

    public Scheduler() {
        // Max Heap (Higher priority first)
        queue = new PriorityQueue<>((a, b) -> b.priority - a.priority);
    }

    // Add Task
    public void addTask(Task t) {
        queue.add(t);
        System.out.println("✅ Task Added Successfully!");
    }

    // Execute Task
    public void executeTask() {
        if (queue.isEmpty()) {
            System.out.println("❌ No tasks available!");
            return;
        }

        Task t = queue.poll();
        System.out.println("🚀 Executing Task:");
        t.display();
    }

    // Display Tasks
    public void displayTasks() {
        if (queue.isEmpty()) {
            System.out.println("❌ No tasks to display!");
            return;
        }

        List<Task> list = new ArrayList<>(queue);

        // Sort by priority (descending)
        list.sort((a, b) -> b.priority - a.priority);

        System.out.println("\n📋 Task List:");
        for (Task t : list) {
            t.display();
        }
    }

    // Search Task (Binary Search)
    public Task searchTask(int id) {
        List<Task> list = new ArrayList<>(queue);

        // Sort by ID
        list.sort((a, b) -> a.id - b.id);

        int low = 0, high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (list.get(mid).id == id) {
                return list.get(mid);
            } else if (list.get(mid).id < id) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }
}

// Main Class
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
