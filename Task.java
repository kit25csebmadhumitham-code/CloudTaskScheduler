public class Task {
    int id;
    int priority;
    int executionTime;

    // Constructor
    public Task(int id, int priority, int executionTime) {
        this.id = id;
        this.priority = priority;
        this.executionTime = executionTime;
    }

    // Display Task Details
    public void display() {
        System.out.println("Task ID: " + id +
                " | Priority: " + priority +
                " | Execution Time: " + executionTime);
    }
}