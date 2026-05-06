import java.util.*;

public class Scheduler {

    private PriorityQueue<Task> queue;

    public Scheduler() {
        queue = new PriorityQueue<>();
    }

    // Add Task
    public void addTask(Task task) {
        queue.add(task);
        System.out.println("✅ Task Added Successfully!");
    }

    // Execute Task
    public void executeTask() {
        if (queue.isEmpty()) {
            System.out.println("❌ No tasks available!");
            return;
        }

        Task task = queue.poll();
        System.out.println("🚀 Executing Task:");
        task.display();
    }

    // Display Tasks
    public void displayTasks() {
        if (queue.isEmpty()) {
            System.out.println("❌ No tasks available!");
            return;
        }

        List<Task> list = new ArrayList<>(queue);
        list.sort(null); // uses compareTo

        System.out.println("\n📋 Task List:");
        for (Task t : list) {
            t.display();
        }
    }

    // Search Task using Binary Search
    public Task searchTask(int id) {
        List<Task> list = new ArrayList<>(queue);

        // Sort by ID
        list.sort(Comparator.comparingInt(Task::getId));

        int low = 0, high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (list.get(mid).getId() == id)
                return list.get(mid);
            else if (list.get(mid).getId() < id)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return null;
    }
}