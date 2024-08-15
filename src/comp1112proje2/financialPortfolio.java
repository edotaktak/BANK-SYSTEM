package comp1112proje2;

import java.util.ArrayList;

public abstract class financialPortfolio {
    financialPortfolio(){}
    
    public void addToPortfolio(Account x, ArrayList portfolio) {
        portfolio.add(x);
    }

  public  void removeFromPortfolio(Account x, ArrayList portfolio) {
        portfolio.remove(x);
    }
  
      public static double allBalance(ArrayList<Account> portfolio) {
        double sum = 0;
        for (int i = 0; i < portfolio.size(); i++) {
            Account account = portfolio.get(i);
            sum += account.getBalance();
        }
        return sum;
    }
      public String compareWith(ArrayList portfolio1,ArrayList portfolio2) {
          double myValue = allBalance(portfolio1);
          double otherValue = allBalance(portfolio2);
          if (myValue < otherValue) {
              return "The second portfolio has more balance than the first with"+ (otherValue-myValue); 
          } else if (myValue > otherValue) {
              return "Portfolio one has more balance than the second with "+(myValue-otherValue); 
          } else {
              return "Portfolios balances are equal"; 
          }
      }
  
      public String toString(ArrayList<Account> portfolio) {
          String result = "";
          for (Account account : portfolio) {
              result += account.toString() + "\n"; // Concatenate account details with a newline
          }
          return result;
      }
}