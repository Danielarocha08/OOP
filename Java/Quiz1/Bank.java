package bank;
public class Bank{
  private CheckingAccount accountOne;
  private CheckingAccount accountTwo;

  public Bank(){
    accountOne = new CheckingAccount("Zeus",0, "1");
    accountTwo = new CheckingAccount("Hades", 0 , "2");
  }

  public static void main(String[] args){
    Bank bankOfGods = new Bank();
    System.out.println("Saldo cuenta1"+bankOfGods.accountOne.getBalance());
    bankOfGods.accountOne.setBalance(0);
    //5 consignaciones
    System.out.println(bankOfGods.accountOne.getBalance());
    //System.out.println(bankOfGods.accountOne.getMonthlyInterest());
    bankOfGods.accountOne.consignar(3000);
    System.out.println(bankOfGods.accountOne.getBalance());
    
    bankOfGods.accountOne.consignar(1000);
    System.out.println(bankOfGods.accountOne.getBalance());
    
    bankOfGods.accountOne.consignar(200);
    System.out.println(bankOfGods.accountOne.getBalance());
    
    bankOfGods.accountOne.consignar(5000);
    System.out.println(bankOfGods.accountOne.getBalance());
    
    bankOfGods.accountOne.consignar(10000);
    System.out.println(bankOfGods.accountOne.getBalance());
        
    bankOfGods.accountOne.retirar(200);
    System.out.println(bankOfGods.accountOne.getBalance());
    
    bankOfGods.accountOne.retirar(500);
    System.out.println(bankOfGods.accountOne.getBalance());
    
    bankOfGods.accountOne.retirar(600);
    System.out.println(bankOfGods.accountOne.getBalance());
    
    bankOfGods.accountOne.retirar(1000);
    System.out.println(bankOfGods.accountOne.getBalance());
    
    bankOfGods.accountOne.retirar(4000);
    System.out.println(bankOfGods.accountOne.getBalance());
   
    //cuenta2 
    System.out.println("sando cuenta2"+bankOfGods.accountTwo.getBalance());
    bankOfGods.accountTwo.setBalance(0);
    System.out.println(bankOfGods.accountTwo.getBalance());
    //System.out.println(bankOfGods.accountOne.getMonthlyInterest());
    bankOfGods.accountTwo.consignar(10000);
    System.out.println(bankOfGods.accountTwo.getBalance());
    
    bankOfGods.accountTwo.consignar(1000);
    System.out.println(bankOfGods.accountTwo.getBalance());
    
    bankOfGods.accountTwo.consignar(200);
    System.out.println(bankOfGods.accountTwo.getBalance());
    
    bankOfGods.accountTwo.consignar(500);
    System.out.println(bankOfGods.accountTwo.getBalance());
    
    bankOfGods.accountTwo.consignar(1000);
    System.out.println(bankOfGods.accountTwo.getBalance());
        
    bankOfGods.accountTwo.retirar(500);
    System.out.println(bankOfGods.accountTwo.getBalance());
    
    bankOfGods.accountTwo.retirar(100);
    System.out.println(bankOfGods.accountTwo.getBalance());
    
    bankOfGods.accountTwo.retirar(1000);
    System.out.println(bankOfGods.accountTwo.getBalance());
    
    bankOfGods.accountTwo.retirar(2000);
    System.out.println(bankOfGods.accountTwo.getBalance());
    
    bankOfGods.accountTwo.retirar(2000);
    System.out.println(bankOfGods.accountTwo.getBalance());
  }
}