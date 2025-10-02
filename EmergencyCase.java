package labb;

public class EmergencyCase {
    String description;
    int priority;

    public EmergencyCase(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "[Priority: " + priority + "] " + description;
    }
}
