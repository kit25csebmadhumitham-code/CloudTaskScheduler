public class Task implements Comparable<Task> {

    private int id;
    private int priority;
    private int executionTime;

    // Constructor
    public Task(int id, int priority, int executionTime) {
        this.id = id;
        this.priority = priority;
        this.executionTime = executionTime;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    // Compare (for Priority Queue - Max Heap)
    @Override
    public int compareTo(Task other) {
        return Integer.compare(other.priority, this.priority);
    }

    // Display
    public void display() {
        System.out.println("Task ID: " + id +
                " | Priority: " + priority +
                " | Execution Time: " + executionTime);
    }
}