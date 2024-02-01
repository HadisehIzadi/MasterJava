import javax.swing.JOptionPane;

public class joptionUsage {
   public static void main(String[] args) {
        String Num1 = JOptionPane.showInputDialog("enter number 1 : ");
        int firstNumber = Integer.parseInt(Num1);


        String Num2 = JOptionPane.showInputDialog("enter number 2 : ");
        int secNumber = Integer.parseInt(Num2);

        int mul = firstNumber * secNumber;

        JOptionPane.showMessageDialog(null ,
                "multiply of two numbers are :"+mul

        );
    }
}
