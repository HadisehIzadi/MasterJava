import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class testGUI {

    public  static void main(String[] args)
    {
        JFrame jFrame = new JFrame("GUI COURSE");
        //jFrame.setLayout(null);
        jFrame.setLayout(new FlowLayout());
        jFrame.setBounds(150,200,1300,400);
        jFrame.setVisible(true);

        // jsplitpane
/*
        Panel p1 = new Panel();
        p1.setBounds(20 , 20 , 200 , 200);
        p1.setBackground(Color.cyan);

        Panel p2 = new Panel();
        p2.setBounds(40 , 40 , 200 , 200);
        p2.setBackground(Color.black);

        JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT , p1 , p2);

        jFrame.add(jSplitPane);
*/


        // jtabbedoane
        /*
        JTabbedPane jTabbedPane = new JTabbedPane();
        jTabbedPane.setBounds(20 , 20 , 200 , 200);

        Panel p1 = new Panel();
        p1.setBackground(Color.GRAY);

        Panel p2 = new Panel();
        p2.setBackground(Color.red);

        Panel p3 = new Panel();
        p3.setBackground(Color.green);

        jTabbedPane.add("first" , p1);
        jTabbedPane.add("second" , p2);
        jTabbedPane.add("third" , p3);

        jFrame.add(jTabbedPane);
*/

        // JToolbar
        JToolBar jToolBar = new JToolBar();
        jToolBar.setRollover(true);

        JButton b1 =  new JButton("changeColor");
        JButton b2 =  new JButton("changeText");
        JButton b3 =  new JButton("get your name");

        // button action
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // implement what you want to be acted by clicking button
                jFrame.getContentPane().setBackground(Color.pink);
            }
        });

        jToolBar.add(b1);
        jToolBar.add(b2);
        jToolBar.add(b3);
        jToolBar.addSeparator();

        jToolBar.setBounds(20 , 20 , 600 , 200);
        jFrame.add(jToolBar);


    // jlabel
        JLabel jLabel = new JLabel("first text");

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // my implementaion of action
                jLabel.setText("this is second !!");

            }
        });
        jFrame.add(jLabel);


        JTextField jTextField = new JTextField();
        jTextField.setBounds(30 , 30 , 100 , 100);

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // my implemetion
                String YoutName = jTextField.getText();
                jLabel.setText(YoutName);
            }
        });
        jFrame.add(jTextField);

    }
}
