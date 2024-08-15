
package comp1112proje2;


public abstract class Customer {
    protected String name;
    protected String adress;
    protected long phoneNumber;
    protected String eMail;
    
    Customer(){}
    Customer(String name,String adress,long phoneNum,String mail){
    this.name=name;
    this.adress=adress;
    this.phoneNumber=phoneNum;
    this.eMail=mail;
    }
    String getName(){
    return this.name;
    }
    String getAdress(){
    return this.adress;
    }
    long getPhoneNumber(){
    return this.phoneNumber;
    }
    String getMail(){
    return this.eMail;
    }
    void setName(String name){
    this.name=name;          
    }
    void setAdress(String adress){
    this.adress=adress;
    }
    void setPhoneNumber(int phoneNum){
    this.phoneNumber=phoneNum;
    }
    void setMail(String mail){
    this.eMail=mail;
    }
    @Override
    public String toString(){
    return "Name:"+ this.name+"\nAdress:"+this.adress+"\nPhone Number:"+this.phoneNumber+"\nMail:"+this.eMail
            ;
    }
}

