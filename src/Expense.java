/**
 * Creates Expense Object with Description, Category and Amount
 */
public class Expense {

    private String description; //member variables
    private String category;
    private int amount;

    /**
     * Class Constructor
     * @param description
     * @param category
     * @param amount
     */
    public Expense(String description, String category, int amount) { //constructors
        this.description = description;
        this.category = category;
        this.amount = amount;
    }

    /**
     * Getters
     * @return
     */
    public String getDescription() {
        return this.description;
    } //accessor methods
    public String getCategory() {
        return this.category;
    }
    public int getAmount() {
        return this.amount;
    }

    /**
     * Setters
     * @param newDescription
     */
    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    /**
     *
     * @param newCategory
     */
    public void setCategory(String newCategory) {
        this.category = newCategory;
    }

    /**
     *
     * @param newAmount
     */
    public void setAmount(int newAmount) {
        this.amount = newAmount;
    }

    public String toString() { //overriding toString() method
        return ("Description: " + description + " Category:" + category + " Amount: " + amount);
    }
}
