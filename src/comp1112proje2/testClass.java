/*package comp1112proje2;

import java.util.ArrayList;
import java.util.Scanner;

public class testClass {

    public static void main(String[] args) {
        financialPortfolio a = new financialPortfolio();
        Account b = new Account();
        Scanner scn = new Scanner(System.in);
        System.out.println("Hello to the Isik Bank.Create an account");
        System.out.print("Your name and surname:");
        String name = scn.nextLine();
        ArrayList<Account> portfolio = new ArrayList<>();
        ArrayList<Account> portfolio2 = new ArrayList<>();
        
        Account acc1 = new Account(1, 150, "Erdem Celtek", 123);
        Account acc2 = new Account(2, 331, "Ali Celtek", 122);
        Account acc3 = new Account(3, 245, "Seyma Celtek", 3525);
        Account acc4 = new Account(4, 500, "Mina Celebi", 4034);
       
            Account acc5 = new Account(1, 150, "Erdem Celtek", 123);
        Account acc6 = new Account(2, 331, "Ali Celtek", 122);
        Account acc7 = new Account(3, 245, "Seyma Celtek", 3525);
        Account acc8 = new Account(4, 500, "Mina Celebi", 4034);
       
        a.addToPortfolio(acc1, portfolio);  
        a.addToPortfolio(acc2, portfolio);
        a.addToPortfolio(acc3, portfolio);
        a.addToPortfolio(acc4, portfolio);
        
        a.addToPortfolio(acc5, portfolio2);  
        a.addToPortfolio(acc6, portfolio2);
        a.addToPortfolio(acc7, portfolio2);
        a.addToPortfolio(acc8, portfolio2);
        
        System.out.println(a.allBalance(portfolio));;
        System.out.println(a.toString(portfolio));

    }

}
/*
import java.util.Scanner;

public class testClass {

    public static void main(String[] args) {
        Account a = new Account();
        Scanner sc = new Scanner(System.in);
        System.out.println("Bankamıza hoşgeldiniz");

        int menuAc = 0;
        while (menuAc != 1) {
            System.out.println("Menüyü açmak için 1 tuşuna basınız");
            menuAc = sc.nextInt();
            sc.nextLine(); // İnt'ten sonra gelen yeni satırı temizlemek için
        }

        System.out.println("Adınızı girin");
        String isim = sc.nextLine();

        System.out.println("Soyadınızı girin");
        String soyisim = sc.nextLine();

        a.toString(); // Kullanıcının hesap bilgilerini göster

        String secim = "";
        boolean displayMenu = true;
        do {
            if (displayMenu) {
                
                System.out.println("Bir işlem seçin:");
                System.out.println("'T' - Para transferi");
                System.out.println("'D' - Para yatırma");
                System.out.println("'W' - Para çekme");
                System.out.println("'H' - Transfer geçmişini görüntüle");
                 System.out.println("Başka bir tuşa basarsanız menüye tekrar gönderilrisiniz.");
                
              
            }

            secim = sc.nextLine().toUpperCase();
            displayMenu = false; // Varsayılan olarak menüyü tekrar gösterme

            switch (secim) {
                case "T":
                    System.out.println("Transfer between accounts");
                    // Para transferi kodu buraya
                    break;
                case "D":
                    System.out.println("Deposit");
                    // Para yatırma kodu buraya
                    break;
                case "W":
                    System.out.println("Withdrawal");
                    // Para çekme kodu buraya
                    break;
                case "H":
                    System.out.println("Transfer History");
                    // Transfer geçmişi görüntüleme kodu buraya
                    break;
               
                default:
                    System.out.println("Geçersiz işlem.");
                    displayMenu = true; // Kullanıcıya menüyü tekrar göster
                    break;
            }
        } while (!secim.equals("Q")); // 'Q' basılıncaya kadar döngüyü tekrarla

        sc.close();
    }
}*/
