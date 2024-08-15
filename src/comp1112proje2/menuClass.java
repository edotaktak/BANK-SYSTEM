package comp1112proje2;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class menuClass {

    public static void main(String[] args) {

        CheckingAccount ca = new CheckingAccount();
        SavingsAccount sa = new SavingsAccount();
        IndividualCustomer ic = new IndividualCustomer();
        InstitutionalCustomer ic2 = new InstitutionalCustomer();
        financialPortfolio fp = new financialPortfolio() {
        };
        Transaction t = new Transaction();
        int attempts = 0;
        final int maxAttempts = 3;
        Date d1 = new Date();
        int attemptsphone = 0;
        final int maxAttemptsphone = 3;

        Scanner scn = new Scanner(System.in);
        System.out.print("Welcome to the Bank.\nPlease enter your name:");
        String name = scn.nextLine();

        System.out.print("Your gender:");
        String gender = scn.nextLine();

        System.out.print("Your phone number:");
        long phoneNum = scn.nextLong();

        String phoneNumS = Long.toString(phoneNum);

        if (phoneNumS.length() == 11) {
            System.out.println("Your phone number is valid.Accpeted.");
        } else {
            while (attemptsphone < maxAttemptsphone) {
                attemptsphone++;
                if (attemptsphone < maxAttemptsphone) {
                    System.out.println("Phone number must be 11 digits.You have" + (maxAttemptsphone - attemptsphone) + "more attempts");
                    phoneNum = scn.nextLong();
                    phoneNumS = Long.toString(phoneNum);
                }
            }
        }

        scn.nextLine();

        System.out.print("Your occupation:");
        String occupation = scn.nextLine();

        System.out.print("Your email:");
        String eMail = scn.nextLine();
        System.out.print("Now declare a password:");
        String pass = scn.nextLine();
        if (pass.length() != 4) {
            boolean passCheck = false;
            while (passCheck == false) {
                System.out.println("Password must be 4 digits try again:");
                pass = scn.nextLine();
                if (pass.length() == 4) {
                    passCheck = true;
                } else {
                    passCheck = false;
                }
            }
        }
        IndividualCustomer customer1 = new IndividualCustomer(name, pass, phoneNum, eMail, gender, occupation);
        System.out.println("Now creating one checking and two savings accounts and a portfolio with given informations...");
        ArrayList<Account> portfolio = new ArrayList<>();

        ArrayList<Account> checkingPortfolio = new ArrayList<>();
        ArrayList<Account> savingsPortfolio = new ArrayList<>();
        ArrayList<Transaction> transactionList = new ArrayList<>();
        ArrayList<ArrayList> portfolioList = new ArrayList<>();
        ArrayList<Account> allAccounts = new ArrayList<>();
        CheckingAccount checkingAccount1 = new CheckingAccount(1, 0, name, pass, false, false, false);
        SavingsAccount savingAccount1 = new SavingsAccount(1, 0, name, pass, "Active");
        SavingsAccount savingAccount2 = new SavingsAccount(1, 0, name, pass, "Active");
        portfolio.add(checkingAccount1);
        portfolio.add(savingAccount1);
        portfolio.add(savingAccount2);
        checkingPortfolio.add(checkingAccount1);
        savingsPortfolio.add(savingAccount1);
        savingsPortfolio.add(savingAccount2);
        portfolioList.add(portfolio);
         

  

    int systemExit = 0;
    while (systemExit== 0) {
            System.out.println("[1]Portfolio Menu"
                + "\n" + "[2]Money Management"
                + "\n" + "[3]Create New Accounts or Delete an Account"
                + "\n" + "[4]Account Management"
                + "\n" + "[5]Create a new istitutional customer"
                + "\n" + "[6]Exit System");

        int menu1 = scn.nextInt();
        switch (menu1) {
            case 1:
                System.out.println("Which portfolio you would like to display:");
                for (int i = 0; i < portfolioList.size(); i++) {
                    System.out.println("[" + (i + 1) + "] Portofolio " + (i + 1));
                }
                int choosenPort = scn.nextInt();
                System.out.println("--PORTFOLIO MENU--"
                        + "\n" + "[1]Display the accounts in the portfolio."
                        + "\n" + "[2]Add an account to a portfolio."
                        + "\n" + "[3]Delete an account from a portfolio."
                        + "\n" + "[4]Check the portfolios total balance. "
                        + "\n" + "[5]See  All Saving accounts."
                        + "\n" + "[6]See All Checking accounts"
                        + "\n" + "[7]Compare Portfolios");
                int menu1Choose = scn.nextInt();
                switch (menu1Choose) {
                    case 1:
                        for (int j = 0; j < portfolioList.get(choosenPort).size(); j++) {
                            System.out.println("[" + (j + 1) + "]" + portfolioList.get(choosenPort).get(j));
                        }
                        break;
                    case 2:
                        System.out.println("Select the type of account to add:");
                        System.out.println("[1] Checking Account\n[2] Saving Account");
                        int addAcc = scn.nextInt();
                        switch (addAcc) {
                            case 1:
                                System.out.println("Which portfolio you would like to display:");
                                for (int i = 0; i < portfolioList.size(); i++) {
                                    System.out.println("[" + (i + 1) + "] Portofolio " + (i + 1));
                                }
                                System.out.println("Which would you like to add:");
                                for (int i = 0; i < checkingPortfolio.size(); i++) {
                                    System.out.println("[" + (i + 1) + "]" + checkingPortfolio.get(i));
                                }
                                System.out.println("Which would you like to add:");
                                int selecetedChecking = scn.nextInt() - 1;
                                portfolioList.get(choosenPort).add(selecetedChecking);
                                break;
                            case 2:
                                System.out.println("Which would you like to add:");
                                for (int i = 0; i < savingsPortfolio.size(); i++) {
                                    System.out.println("[" + (i + 1) + "]" + savingsPortfolio.get(i));
                                }
                                System.out.println("Which would you like to add:");
                                int selecetedSaving = scn.nextInt() - 1;
                                portfolioList.get(choosenPort).add(selecetedSaving);
                                break;
                        }
                        break;
                    case 3:
                        for (int i = 0; i < portfolioList.get(choosenPort).size(); i++) {
                            System.out.println("[" + (i + 1) + "]" + portfolioList.get(choosenPort).get(i));
                        }
                        System.out.println("Pick an account to delete:");
                        int accountDelete = scn.nextInt() - 1;
                        portfolioList.get(choosenPort).remove(accountDelete);
                        System.out.println("Account deleted succesfully.");
                        break;

                    case 4:
                        System.out.println("Portfolios total balance:" + fp.allBalance(portfolioList.get(choosenPort)));
                        break;
                    case 5:
                        for (int i = 0; i < savingsPortfolio.size(); i++) {
                            System.out.println("--SAVING ACCOUNT[" + (i + 1) + "]--");
                            System.out.println(savingsPortfolio.get(i));
                        }
                        break;
                    case 6:

                        for (int i = 0; i < checkingPortfolio.size(); i++) {
                            System.out.println("--CHECKING ACCOUNT[" + (i + 1) + "]--");
                            System.out.println(checkingPortfolio.get(i));
                        }
                        break;
                    case 7:
                        System.out.println("Choose two portfolios");
                        for (int i = 0; i < portfolioList.size(); i++) {
                            System.out.println(portfolioList.get(i));

                        }
                        System.out.println("Choose first");
                        int choosenPortFirst = scn.nextInt() - 1;
                        System.out.println("Choose second");
                        int choosenPortSecond = scn.nextInt() - 1;
                        System.out.println(fp.compareWith(portfolioList.get(choosenPortFirst), portfolioList.get(choosenPortSecond)));
                        break;
                }
                break;
            case 2:
                System.out.println("--MONEY MENU--"
                        + "\n"
                        + "[1]Between Accounts"
                        + "\n" + "[2]Single Account" + "\n" + "[3]Transaction History");
                int moneyMenu = scn.nextInt();
                switch (moneyMenu) {
                    case 1:
                        System.out.println("Choose two accounts:");
                        for (int i = 0; i < allAccounts.size(); i++) {
                            System.out.println("[" + (i + 1) + "]" + "Owner:" + allAccounts.get(i).getAccountHolder() + " Balance:" + allAccounts.get(i).getBalance());
                        }
                        System.out.print("From:");
                        int from = scn.nextInt();
                        System.out.println("");
                        System.out.print("To:");
                        int to = scn.nextInt();
                        System.out.println("");
                        System.out.print("Amount:");
                        double amount1 = scn.nextDouble();
                        System.out.println("");
                        if (amount1 > allAccounts.get(from).getBalance()) {
                            System.out.println("Insufficicent balance");
                            break;
                        } else {
                            allAccounts.get(from).lowerToBalance(amount1);
                            allAccounts.get(to).addToBalance(amount1);
                            System.out.println("New balance of " + allAccounts.get(from).getBalance() + " Owner:" + allAccounts.get(from).getAccountNumber());
                            System.out.println("New balance of " + allAccounts.get(to).getBalance() + " Owner:" + allAccounts.get(to).getAccountNumber());
                            Transaction x1 = new Transaction(amount1, d1, "Transfer", t.generateAccountNumberLong(), transactionList);
                            break;
                        }
                    case 2:
                        System.out.println("--MONEY MANAGEMENT--");
                        for (int i = 0; i < allAccounts.size(); i++) {
                            System.out.println("[" + (i + 1) + "]" + allAccounts.get(i).getAccountNumber() + " Owner:" + allAccounts.get(i).getAccountHolder() + " Balance:" + allAccounts.get(i).getBalance());
                        }
                        int chosenAcc = scn.nextInt() - 1;
                        System.out.println("--DEPOSIT OR WITHDRAWAL--\n"
                                + "[1]Withdrawal\n[2]Deposit");
                        int withDep = scn.nextInt();
                        System.out.println("Enter the amount.");
                        double amount = scn.nextDouble();
                        switch (withDep) {
                            case 1:

                                if (allAccounts.get(chosenAcc).getBalance() < amount) {
                                    System.out.println("There is no balance for that withdrawal.");
                                } else {
                                    allAccounts.get(chosenAcc).lowerToBalance(amount);
                                }
                                System.out.println("Money withdrawn from the account.New balance is " + allAccounts.get(chosenAcc).getBalance());
                                Transaction x2 = new Transaction(amount, d1, "Withdrawal", t.generateAccountNumberLong(), transactionList);
                                break;
                            case 2:
                                allAccounts.get(chosenAcc).addToBalance(amount);
                                System.out.println("Money deposited into account.New balance is " + allAccounts.get(chosenAcc).getBalance());
                                Transaction x3 = new Transaction(amount, d1, "Deposit", t.generateAccountNumberLong(), transactionList);
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("--TRANSACTION LIST--");
                        for (int i = 0; i < transactionList.size(); i++) {
                            System.out.println(transactionList.get(i));
                            System.out.println("");
                        }
                        break;
                }
                break;

            case 3:
                System.out.println("--ACCOUNT CREATE OR DELELETE--\n[1]Create\n[2]Delete");
                int createDeletePick = scn.nextInt();
                switch (createDeletePick) {
                    case 1:
                        System.out.println("What type of account you want to create:\n[1]Checking \n[2]Saving");
                        int accChoose = scn.nextInt();
                        System.out.println("Which portfolio?");
                        for (int i = 0; i < portfolioList.size(); i++) {
                            System.out.println(portfolioList.get(i));
                        }
                        int choosenPortAdd = scn.nextInt() - 1;
                        switch (accChoose) {
                            case 1:
                                String nameNew = scn.nextLine();

                                System.out.print("Your gender:");
                                String genderNew = scn.nextLine();

                                System.out.print("Your phone number:");
                                long phoneNumNew = scn.nextLong();

                                String phoneNumSNew = Long.toString(phoneNumNew);

                                scn.nextLine();

                                System.out.print("Your occupation:");
                                String occupationNew = scn.nextLine();

                                System.out.print("Your email:");
                                String eMailNew = scn.nextLine();

                                System.out.print("Now declare a password:");
                                String passNew = scn.nextLine();
                                boolean passCheck = false;
                                if (passNew.length() != 4) {
                                    while (passCheck == false) {
                                        System.out.println("Password must be 4 digits try again:");
                                        passNew = scn.nextLine();
                                        if (passNew.length() == 4) {
                                            passCheck = true;
                                        } else {
                                            passCheck = false;
                                        }
                                    }
                                }
                        }

                        CheckingAccount x = new CheckingAccount(1, 0, name, pass, true, true, true);
                        portfolioList.get(choosenPortAdd).add(x);
                        checkingPortfolio.add(x);
                        System.out.println("Your checking account created and already added to portfolio.");

                        break;
                    case 2:
                        System.out.println("Which portfolio?");
                        for (int i = 0; i < portfolioList.size(); i++) {
                            System.out.println(portfolioList.get(i));
                        }
                        int choosenPortAdd2 = scn.nextInt() - 1;
                        String nameNew = scn.nextLine();

                        System.out.print("Your gender:");
                        String genderNew1 = scn.nextLine();

                        System.out.print("Your phone number:");
                        long phoneNumNew1 = scn.nextLong();

                        String phoneNumSNew1 = Long.toString(phoneNumNew1);
                        if (phoneNumS.length() == 11) {
                            System.out.println("Your phone number is valid.Accpeted.");
                        } else {
                            System.out.println("Hata: Telefon numaranız 11 basamaklı olmalıdır.");
                        }

                        scn.nextLine();

                        System.out.print("Your occupation:");
                        String occupationNew1 = scn.nextLine();

                        System.out.print("Your email:");
                        String eMailNew1 = scn.nextLine();

                        System.out.print("Now declare a password:");
                        String passNew = scn.nextLine();
                        boolean passCheck = false;
                        if (passNew.length() != 4) {
                            while (passCheck == false) {
                                System.out.println("Password must be 4 digits try again:");
                                passNew = scn.nextLine();
                                if (passNew.length() == 4) {
                                    passCheck = true;
                                } else {
                                    passCheck = false;
                                }
                            }
                        }
                        SavingsAccount x2 = new SavingsAccount(1, 0.0, nameNew, passNew, "Active");
                        portfolioList.get(choosenPortAdd2).add(x2);
                        savingsPortfolio.add(x2);
                        System.out.println("Your savings account created and already added to portfolio.");

                        break;
                }
                break;
            case 4:
                System.out.println("--ACCOUNT TYPE-- \n[1] Checking accounts \n[2] Savings accounts");
                int managementChoose = scn.nextInt();
                scn.nextLine(); // Bu satır, nextInt sonrasında kalan newline karakterini temizlemek için önemli.

                if (managementChoose == 1) {
                    System.out.println("Choose an account:");
                    for (int i = 0; i < checkingPortfolio.size(); i++) {
                        System.out.println("[" + (i + 1) + "] " + checkingPortfolio.get(i) + " Balance:" + checkingPortfolio.get(i).getBalance());
                    }
                    int chosenAcc = scn.nextInt() - 1;
                    scn.nextLine(); // Buffer temizleme
                    CheckingAccount chosenCheckingAccount = (CheckingAccount) checkingPortfolio.get(chosenAcc);
                    System.out.println("--ACCOUNT SETTINGS--\n[1]ATM Access\n[2]Online Access\n[3]Debit Card\n[4]Update Account Details\n[5]Go back");
                    int settingChoice = scn.nextInt();
                    scn.nextLine();

                    switch (settingChoice) {
                        case 1:
                            System.out.println("[1] Turn On\n[2] Turn Off");
                            int atmChoice = scn.nextInt();
                            scn.nextLine();
                            System.out.println("Enter your password:");
                            String password = scn.nextLine();
                            if (password.equals(chosenCheckingAccount.getPassword())) {
                                chosenCheckingAccount.setAtmAcces(atmChoice == 1);
                                System.out.println("ATM Access has been " + (atmChoice == 1 ? "enabled." : "disabled."));
                            } else {
                                System.out.println("Incorrect password, try again.");
                            }
                            break;
                        case 2:
                            System.out.println("[1] Turn On\n[2] Turn Off");
                            int onlineChoice = scn.nextInt();
                            scn.nextLine();
                            System.out.println("Enter your password:");
                            password = scn.nextLine();
                            if (password.equals(chosenCheckingAccount.getPassword())) {
                                chosenCheckingAccount.setOnlineAcces(onlineChoice == 1);
                                System.out.println("Online Access has been " + (onlineChoice == 1 ? "enabled." : "disabled."));
                            } else {
                                System.out.println("Incorrect password, try again.");
                            }
                            break;
                        case 3:
                            System.out.println("[1] Turn On\n[2] Turn Off");
                            int debitChoice = scn.nextInt();
                            scn.nextLine();
                            System.out.println("Enter your password:");
                            password = scn.nextLine();
                            if (password.equals(chosenCheckingAccount.getPassword())) {
                                chosenCheckingAccount.setDebit(debitChoice == 1);
                                System.out.println("Debit Card has been " + (debitChoice == 1 ? "enabled." : "disabled."));
                            } else {
                                System.out.println("Incorrect password, try again.");
                            }
                            break;
                        case 4:
                            // Update account details
                            System.out.println("What would you like to update?\n[1] Email\n[2] Phone Number");
                            int updateChoice = scn.nextInt();
                            scn.nextLine(); // input buffer'ı temizlemek için

                            if (updateChoice == 1) {
                                System.out.println("Please enter the new email:");
                                String newEmail = scn.nextLine();

                               // chosenCheckingAccount.setEmail(newEmail); // Örneğin, Account sınıfında setEmail metodu varsa
                                System.out.println("Email has been successfully updated to: " + newEmail);

                            } else if (updateChoice == 2) {
                                System.out.println("Please enter the new phone number (only numbers):");
                                String newPhone = scn.nextLine();

                                //chosenCheckingAccount.setPhoneNumber(newPhone); // Örneğin, Account sınıfında setPhoneNumber metodu varsa

                            } else {
                                System.out.println("Invalid choice. Returning to the previous menu.");
                            }
                            break;
                            
                        case 5:
                            System.out.println("Returning to main menu.");
                            break;
                    }
                } else if (managementChoose == 2) {
                    System.out.println("Choose an account:");
                    for (int i = 0; i < savingsPortfolio.size(); i++) {
                        System.out.println("[" + (i + 1) + "] " + savingsPortfolio.get(i));
                    }
                    int chosenAccSaving = scn.nextInt() - 1;
                    scn.nextLine();
                    SavingsAccount chosenSavingsAccount = (SavingsAccount) savingsPortfolio.get(chosenAccSaving);
                    System.out.println("[1] Update Account Details [2] Go Back to menu");
                    int choice = scn.nextInt();
                    scn.nextLine();
                    if (choice == 1) {
                        System.out.println("What would you like to update \n[1] Account Status \n[2] eMail \n[3] Phone Number");
                        int updateChoice = scn.nextInt();
                        scn.nextLine();
                        if (updateChoice == 1) {
                            System.out.println("[1] Close\n[2] Open\n[3] Dormant");
                            int statusChoice = scn.nextInt();
                            scn.nextLine();
                            String newStatus;
                            if (statusChoice == 1) {
                                newStatus = "Closed";
                            } else if (statusChoice == 2) {
                                newStatus = "Open";
                            } else {
                                newStatus = "Dormant";
                            }
                            chosenSavingsAccount.setAccountStatus(newStatus);
                            System.out.println("Account status updated to " + newStatus);

                        }
                    }
                }
                break;
            case 5:
                System.out.println("Creating an instituional customer:");
                System.out.println();

                System.out.println("Enter your name:");
                String newCustName = scn.nextLine();
                scn.nextLine();
                System.out.println("Enter your adress:");
                String newCustAdress = scn.nextLine();

                System.out.println("Enter your e-mail");
                String newCustMail = scn.nextLine();

                System.out.println("Enter your phone number:");
                long newCustNumInt = scn.nextLong();
                String newCustNum = Long.toString(newCustNumInt);
                System.out.println("Enter your institution type:");
                String instutuionType = scn.nextLine();
                scn.nextLine();
                System.out.println("Enter your sector:");
                String sector = scn.nextLine();
                System.out.println("Enter your annual revenue:");
                double revenue = scn.nextDouble();
                System.out.println("Enter your password");
                String newCustPass = scn.nextLine();
                scn.nextLine();
                System.out.println("Creating your new account and portfolios with 2 saving and 1 checking accounts.");
                CheckingAccount checkingAccountNew = new CheckingAccount(1, 0, newCustName, newCustPass, false, false, false);
                SavingsAccount savingAccountNew = new SavingsAccount(1, 0, newCustName, newCustPass, "Active");
                SavingsAccount savingAccountNew2 = new SavingsAccount(1, 0, newCustName, newCustPass, "Active");
                ArrayList<Account> newCustPortfolio = new ArrayList<>();
                newCustPortfolio.add(checkingAccountNew);
                newCustPortfolio.add(savingAccountNew);
                newCustPortfolio.add(savingAccountNew2);
                portfolioList.add(newCustPortfolio);
                savingsPortfolio.add(savingAccountNew2);
                savingsPortfolio.add(savingAccountNew);
                checkingPortfolio.add(checkingAccountNew);
                break;

            case 6:
                System.out.println("Closing the system have a good day.");
                System.exit(0);
                break;
            default:
                System.out.println("Unavailable option try again.");

        }
        for (int i = 0; i < checkingPortfolio.size(); i++) {
            checkingPortfolio.get(i).interestApply();
        }

        for (int i = 0; i < savingsPortfolio.size(); i++) {
            savingsPortfolio.get(i).interestApply();
        }

    }

}
    
}
