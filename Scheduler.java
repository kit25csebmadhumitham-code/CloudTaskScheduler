import java.util.*;

public class Scheduler {

    // Priority Queue (Max Heap based on priority)
    private PriorityQueue<Task> queue;

    public Scheduler() {
        queue = new PriorityQueue<>((a, b) -> b.priority - a.priority);
    }

    // Add Task
    public void addTask(Task t) {
        queue.add(t);
        System.out.println("✅ Task Added Successfully!");
    }

    // Execute Task (Highest Priority)
    public void executeTask() {
        if (queue.isEmpty()) {
            System.out.println("❌ No tasks available!");
            return;
        }

        Task t = queue.poll();
        System.out.println("🚀 Executing Task:");
        t.display();
    }

    // Display All Tasks (Sorted)
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

    // Binary Search (by ID)
    public Task searchTask(int id) {
        List<Task> list = new ArrayList<>(queue);

        // Sort by ID for binary search
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