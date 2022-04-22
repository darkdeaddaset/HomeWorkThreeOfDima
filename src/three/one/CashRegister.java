package three.one;

public class CashRegister {
    private double purchase;
    private double payment;
    private double percentTax;
    private double allTax;
    private int item;

    public CashRegister(double tax){
        this.percentTax = tax/100;
    }

    public CashRegister(){}

    public void recordPurchase(double amount){
        purchase = purchase + amount;
        countItems();
    }

    public void receivePayment(double amount){
        payment = payment + amount;
    }

    private void countItems(){
        item += 1;
    }

    public int getItem(){
        return item;
    }

    public void recordTaxablePurchase(double amount){
        allTax += (amount * percentTax);
        purchase = purchase + amount + (amount * percentTax);
        countItems();
    }

    public double getTotalTax(){
        return allTax;
    }

    public double giveChange(){
        double change = payment - purchase;
        purchase = 0;
        payment = 0;
        item = 0;
        allTax = 0;
        return change;
    }
}
