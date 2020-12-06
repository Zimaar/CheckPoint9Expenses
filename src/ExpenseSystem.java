import java.util.*;

class Expense {

    private String description;
    private String category;
    private int amount;

    public Expense(String description, String category, int amount) {
        this.description = description;
        this.category = category;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }
    public String getCategory() {
        return category;
    }
    public int getAmount() {
        return amount;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }
    public void setCategory(String newCategory) {
        this.category = newCategory;
    }
    public void setAmount(int newAmount) {
        this.amount = newAmount;
    }

    public String toString() {
        return ("Description: " + description + " Catagory:" + category + " Amount: " + amount);
    }
}
public class ExpenseSystem {
    static Scanner scan = new Scanner(System.in);
    static List<Expense> expenselist = new ArrayList<>();

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
                System.out.println(expenselist);
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

    public static void editMode() {
        int choice = 0;
        while (true) {
            System.out.println("====================");
            System.out.println("1) Add an Expense");
            System.out.println("2) Delete an Expense");
            System.out.println("3) Quit");
            System.out.println("====================");

            choice = scan.nextInt();


            if (choice == 1) {
                System.out.print("Enter the expense description: ");
                String description = scan.next();
                System.out.print("Enter the expense category: ");
                String category = scan.next();
                System.out.print("Enter the expense amount: ");
                int amount = scan.nextInt();
                Expense free = new Expense(description,category,amount);
                expenselist.add(free);
                //Expense.setDescription(description);
                //Expense.setCategory(category);
                //Expense.setAmount(amount);
            }
            else if (choice == 3){
                break;
            }
        }
    }

    public static void analysisMode() {
        ArrayList<ArrayList<Expense>> newlist = new ArrayList<ArrayList<Expense>>();
        ArrayList<String> categoryList = new ArrayList<>();
        for (int i = 0; i<expenselist.size(); i++){
            Expense var = expenselist.get(i);
            if (categoryList.contains(var.getCategory())){
                int j = categoryList.indexOf(var.getCategory());
                (newlist.get(j)).add(var);
            }
            else{
                ArrayList<Expense> tempList = new ArrayList<>();
                tempList.add(var);
                newlist.add(tempList);
                categoryList.add(var.getCategory());
            }
        }
        for (int i = 0; i<categoryList.size(); i++){
            System.out.println("Category "+categoryList.get(i));
            for (int k = 0; k<newlist.size(); k++){
                System.out.println(newlist.get(k));
            }
        }
        int totalsum = 0;
        for (int k = 0; k<newlist.size(); k++){
            int sum = 0;
            float average = 0;
            for (int c = 0;c<newlist.get(k).size(); c++){
                sum = sum+newlist.get(k).get(c).getAmount();
            }
            average = (float)sum/newlist.get(k).size();
            System.out.println("Sum expense of category "+categoryList.get(k)+" is: "+sum);
            System.out.println("Average expense of category "+categoryList.get(k)+" is: "+average);
            totalsum = totalsum+sum;
        }
        System.out.println("Total sum of all expense is: "+totalsum);
    }
}












