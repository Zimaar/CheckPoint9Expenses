import java.util.*;

/**
 * Raamiz Ali & Luming Li
 * 2020
 * Expense System - An Expense Tracker that adds, edits, deletes, and analyzes inputted
 */

class ExpenseSystem {
    static Scanner scan = new Scanner(System.in);
    static List<Expense> expenseList = new ArrayList<>(); //using ArrayLists to store the expenses as they are resizable

    /**
     * Main method runs the main loop with input check
     * @param args
     */
    public static void main(String[] args) { //the main method has the main loop which redirects to other methods
        int choice; //initializing choice outside while loop so it's not re-initialized everytime the loop runs

        while (true) {
            System.out.println("EXPENSE TRACKER");
            System.out.println("====================");
            System.out.println("1) Edit Mode");
            System.out.println("2) Analysis Mode");
            System.out.println("3) Quit");
            System.out.println("====================");

            choice = scan.nextInt();

            if (choice < 1 || choice > 3) {
                System.out.println("Invalid Input, please select an integer from 1 - 3");
            }

            else if (choice == 1) {
                editMode();
                System.out.println(expenseList);
            }

            else if (choice == 2) {
                analysisMode();
            }

            else if (choice == 3) {
                System.out.println("Goodbye.");
                break;
            }
        }

    }

    /**
     * editMode is the first of two options, it allows user to add an expense
     * (description, category, and amount) as well as delete a whole expense
     */
    public static void editMode() { //edit mode allows the user to add/delete an expense
        int choice;
        while (true) {
            System.out.println("====================");
            System.out.println("1) Add an Expense");
            System.out.println("2) Delete an Expense");
            System.out.println("3) Quit");
            System.out.println("====================");

            choice = scan.nextInt();

            if (choice < 1 || choice > 3) {
                System.out.println("Invalid Input, please select an integer from 1 - 3");
            }

            else if (choice == 1) {
                System.out.print("Enter the expense description: ");
                String description = scan.next();
                System.out.print("Enter the expense category: ");
                String category = scan.next();
                System.out.print("Enter the expense amount: ");
                int amount = scan.nextInt();
                Expense newExp = new Expense(description,category,amount);
                expenseList.add(newExp);
            }

            if (choice == 2) { //first the added expenses are shown in an ordered list and one is selected to be deleted
                System.out.println("Pick the number of the expense you would like to delete: ");
                for (int i = 0; i < expenseList.size(); i++) {
                    System.out.println(i + ") " + expenseList.get(i));
                }

                int delete = scan.nextInt();
                expenseList.remove(delete);
                System.out.println("Expense No." + delete + " has been deleted.");
            }
            else if (choice == 3){
                break;
            }
        }
    }

    /**
     * analysis mode gives the user an option to receive processed data (average spend per item, spending per category, total expenditure)
     */
    public static void analysisMode() {
        ArrayList<ArrayList<Expense>> newList = new ArrayList<ArrayList<Expense>>();
        ArrayList<String> categoryList = new ArrayList<>();
        for (Expense var : expenseList) {
            if (categoryList.contains(var.getCategory())) {
                int j = categoryList.indexOf(var.getCategory());
                (newList.get(j)).add(var);
            } else {
                ArrayList<Expense> tempList = new ArrayList<>();
                tempList.add(var);
                newList.add(tempList);
                categoryList.add(var.getCategory());
            }
        }
        for (String s : categoryList) {
            System.out.println("Category " + s);
            for (ArrayList<Expense> expenses : newList) {
                System.out.println(expenses);
            }
        }
        int totalSum = 0;
        int count = 0;
        for (int k = 0; k<newlist.size(); k++){
            int sum = 0;
            float average = 0;
            for (int c = 0;c<newlist.get(k).size(); c++){
                sum = sum+newlist.get(k).get(c).getAmount();
            }
            average = (float)sum/newlist.get(k).size();
            System.out.println("Sum expense on " + categoryList.get(k)+" is: "+sum);
            System.out.println("Average expense on "+categoryList.get(k)+" is: "+average);
            totalSum = totalSum+sum;
            count = count+newlist.get(k).size();
        }
        System.out.println("Total sum of all expense is: "+totalSum);
        System.out.println("Average of all expense is: "+((float)totalSum/count));
    }
}



