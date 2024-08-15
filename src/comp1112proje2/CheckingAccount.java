package comp1112proje2;

public class CheckingAccount extends Account {

    private static final double checkingInterest = 3.0;
    private boolean atmAcces = true;
    private boolean onlineAccess = false;
    private boolean Debit = false;

    CheckingAccount() {
        
    }

    CheckingAccount(int accNum, double bal, String own, String pass, boolean atm, boolean onlineAccess, boolean debit) {
        super(accNum, bal, own, pass);
        this.atmAcces = atm;
        this.onlineAccess = onlineAccess;
        this.Debit = debit;
    }

    boolean getAtmAccess() {
        return this.atmAcces;
    }

    boolean getOnlineAcces() {
        return this.onlineAccess;
    }

    boolean getDebit() {
        return this.Debit;
    }

    public void setAtmAcces(boolean newAcces) {
        this.atmAcces = newAcces;
    }

    public void setOnlineAcces(boolean newAcces) {
        this.onlineAccess = newAcces;
    }

    public void setDebit(boolean newDebit) {
        this.Debit = newDebit;
    }
     @Override
   public String toString() {
        return super.toString()+"\n"+"ATM Access:"+this.atmAcces +"\n"+"Online Access:"+this.onlineAccess+"\n"
                +"Debit Card:"+this.Debit;
    }

    @Override
    public void interestApply() {
        this.balance=this.balance*1.03;
    }
    public String getPassword(){
    return this.password;
    }
    
   
}
