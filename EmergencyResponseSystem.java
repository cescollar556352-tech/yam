package labb;

import java.util.Scanner;

public class EmergencyResponseSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MinHeap pq = new MinHeap(5); // Start small to test resizing

        while (true) {
            System.out.println("\n--- City Emergency Response System ---");
            System.out.println("1. Add Emergency Case");
            System.out.println("2. Process Highest Priority Case");
            System.out.println("3. View All Cases");
            System.out.println("4. Peek at Highest Priority Case");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter emergency description: ");
                    String desc = sc.nextLine();
                    System.out.print("Enter priority number (smaller = more urgent): ");
                    int pr = sc.nextInt();
                    pq.insert(new EmergencyCase(desc, pr));
                    break;

                case 2:
                    EmergencyCase caseHandled = pq.extractMin();
                    if (caseHandled != null)
                        System.out.println("Processing case: " + caseHandled);
                    break;

                case 3:
                    pq.display();
                    break;

                case 4:
                    EmergencyCase peeked = pq.peek();
                    if (peeked != null)
                        System.out.println("Highest priority case (next to be processed): " + peeked);
                    break;

                case 5:
                    System.out.println("Exiting system. Stay safe!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
