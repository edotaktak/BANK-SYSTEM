package comp1112proje2;

public class InstitutionalCustomer extends Customer {
    private String institutionType;
    private String sector;
    private double annualRevenue;
InstitutionalCustomer(){}

    public InstitutionalCustomer(String name,String adress, int phoneNum , String mail ,  String id, String institutionType, String sector, double annualRevenue) {
        super(name, adress, phoneNum, mail);  // Call the superclass constructor
        this.institutionType = institutionType;
        this.sector = sector;
        this.annualRevenue = annualRevenue;
    }


    public String getInstitutionType() {
        return institutionType;
    }

    public void setInstitutionType(String institutionType) {
        this.institutionType = institutionType;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public double getAnnualRevenue() {
        return annualRevenue;
    }

    public void setAnnualRevenue(double annualRevenue) {
        this.annualRevenue = annualRevenue;
    }

    // toString method
@Override
public String toString() {
    return super.toString()+"\nInstitution Type:"+this.institutionType+"\nSector:"+this.sector+"\nAnnual Revenue:"+this.annualRevenue;
    
}
}