package comp1112proje2;

public class SavingsAccount extends Account {

    protected static double interestRate = 0.1;
    protected String status = "Active";


    SavingsAccount() {};
    
    SavingsAccount(int accNum, double bal, String own, String pass, String accStatus) {
        super(accNum, bal, own, pass);
        if (accStatus != "Active " || accStatus != "Closed" || accStatus != "Dormant") {

        } else {
            this.status = accStatus;
        }
    }

  public  String getAccentStatuts() {
        return this.status;
    }

   public double getInterestRate() {
        return this.interestRate;
    }
public void setAccountStatus(String newStatus) {
    this.status = newStatus;
}
  public void setInterestRate(double newRate) {
        this.interestRate = newRate;
    }
    @Override
    public String toString() {
        return super.toString()+"\nInterest Rate:"+this.interestRate + "\nStatus:"+this.status;
    }

    @Override
    public void interestApply() {
        this.balance=this.balance*(1+getInterestRate());
    }
     public String getPassword(){
    return this.password;
    }
     
    }

