import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        System.out.println("this is my first project");
        // JOptionpane usage
        //JOptionPane.showMessageDialog(null , "this is a pane");


        //JFrame usage
        JFrame jFrame = new JFrame();
        jFrame.setBounds(100 , 100 , 1000 , 300);
        jFrame.setLayout(new GridLayout(1 , 2));
        jFrame.setVisible(true);

        //JtextField usage
        JTextField jTextField = new JTextField();
        jTextField.setBounds(40 , 10 , 100 , 60);
        jFrame.add(jTextField);


        //Jbutton usage
        JButton jButton = new JButton("Find");
        jButton.setBounds(10 , 10 , 100 , 60);

        // button click event function
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = jTextField.getText();
                try {
                    InetAddress  ia = InetAddress.getByName(url);
                    String ip = ia.getHostAddress();

                    JOptionPane.showMessageDialog(jFrame ,ip);
                } catch (UnknownHostException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });



        jFrame.add(jButton);

    }
}