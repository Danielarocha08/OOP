import javax.swing.JOptionPane;

public class Java2 {

    public static void main(String[] args) {
        String firstNumber;
        String secondNumber;
        int number1;
        int number2 = 0;
        int sum;
        
        firstNumber = JOptionPane.showInputDialog("Enter first integer");
        
        secondNumber = JOptionPane.showInputDialog("Enter second integer");
        
        number1 = Integer.parseInt(firstNumber);
        number2 = Integer.parseInt(secondNumber);
        
        sum = number1 + number2;
        
        JOptionPane.showMessageDialog(null,"the sum is"+ sum, "Results",JOptionPane.PLAIN_MESSAGE);
        
         System.exit(0);

    }
    
}
