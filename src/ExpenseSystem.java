import java.util.*;

public class ExpenseSystem {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;

        while (true) {
            System.out.println("EXPENSE TRACKER");
            System.out.println("====================");
            System.out.println("1) Edit Mode");
            System.out.println("2) Analysis Mode");
            System.out.println("3) Quit");
            System.out.println("====================");

            choice = scan.nextInt();

            if (choice == 1) {
                editMode();
            }

            else if (choice == 2) {
                analysisMode();
            }

            else if (choice == 3) {
                System.out.println("Goodbye.");
                break;
            }

            else {
                System.out.println("Invalid Choice! Please try again.");
            }
        }

    }

    public void editMode() {
        int choice = 0;
        while (true) {
            System.out.println("====================");
            System.out.println("1) Add an Expense");
            System.out.println("2) Delete an Expense");
            System.out.println("====================");

            choice = scan.nextInt();


            if (choice == 1) {
                System.out.print("Enter the expense description: ");
                String description = scan.next();
                System.out.print("Enter the expense category: ");
                String category = scan.next();
                System.out.print("Enter the expense amount: ");
                int amount = scan.nextInt();

                Expense.setDescription(description);
                Expense.setCategory(category);
                Expense.setAmount(amount);
            }
        }
    }

    public static void analysisMode() {

    }
}
