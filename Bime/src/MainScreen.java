import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MainScreen extends JFrame {

Font myFont = new Font("sanSerif" , Font.BOLD , 20);
Color myColor = (Color.GRAY);

//*************** panel 1 ********************
JTextField subFname = new JTextField();
JTextField subLname = new JTextField();
JTextField subCity = new JTextField();
JTextField subPhone = new JTextField();


    public  MainScreen()
    {
        CustomizePanel1();
    }

    private void CustomizePanel1() {
        JPanel p1 = new JPanel();
        TitledBorder titledBorder =BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY , 1) ,
                "Customer" , TitledBorder.CENTER ,
                TitledBorder.DEFAULT_POSITION , myFont , myColor);

        p1.setBorder(titledBorder);
        JLabel subfnamLBL = new JLabel("first name :");
        JLabel sublnamLBL = new JLabel("last name :");
        JLabel subCityLBL = new JLabel("city :");
        JLabel subPhoneLBL = new JLabel("phone number :");

        subFname = new JTextField();
        subFname.setOpaque(false);

        subLname= new JTextField();
        subLname.setOpaque(false);

        subCity = new JTextField();
        subCity.setOpaque(false);

        subPhone = new JTextField();
        subPhone.setOpaque(false);

        p1.add(subfnamLBL);
        p1.add(subFname);

        p1.add(sublnamLBL);
        p1.add(subLname);

        p1.add(subCityLBL);
        p1.add(subCity);

        p1.add(subPhoneLBL);
        p1.add(subPhone);




        p1.setBounds(15 , 15 , 300 , 200);
        p1.setLayout(new GridLayout(4 , 2));

        // add to whole panel
        setLayout(null);
        add(p1);

    }

    public static void main(String[] args) {

        MainScreen mainScreen = new MainScreen();
        mainScreen.setVisible(true);
        mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainScreen.setTitle("Bime");
        mainScreen.setBounds(0 , 0 , 1920 , 1080);
    }
}