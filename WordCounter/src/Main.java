import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

        //jFrame usage
        JFrame jFrame = new JFrame();
        jFrame.setLayout(new GridLayout(4 , 4));
        jFrame.setBounds(100 , 10 , 600 , 300);
        jFrame.setVisible(true);

        //JtextField usage
        JTextField jTextField = new JTextField();
        jTextField.setBounds(160 , 15 , 100 , 50);

        jFrame.add(jTextField);

        //Jbutton
        JButton jButton =  new JButton("COUNT");
        jButton.setBounds(300 , 15 , 100 , 50);
        jFrame.add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt = jTextField.getText();
                String words[] = txt.split("\\s");
                JOptionPane.showMessageDialog(jFrame , "it has " + words.length + " words");
            }
        });


    }
}