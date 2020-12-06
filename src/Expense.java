public class Expense {

    private String description;
    private String category;
    private int amount;

    public Expense(String description, String category, int amount) {
        this.description = description;
        this.category = category;
        this.amount = amount;
    }

    public String getDescription() {
        return this.description;
    }
    public String getCategory() {
        return this.category;
    }
    public int getAmount() {
        return this.amount;
    }

    public void setDescription(String newDescription) {this.description = newDescription;}
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
