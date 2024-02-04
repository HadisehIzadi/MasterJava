import javax.swing.*;
import java.awt.*;

public class Frame {
    public static void main(String[] args)
    {
        JFrame jFrame = new JFrame("GUI COURSE");
        jFrame.setLayout(null);
        jFrame.setBounds(100,100,600,600);
        jFrame.setVisible(true);
/*
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        jPanel.setBackground(Color.blue);
        jPanel.setBounds(50 , 50 , 100 , 100);
        jPanel.setVisible(true);

        jFrame.add(jPanel);

*/

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBackground(Color.GREEN);
        scrollPane.setEnabled(true);
        scrollPane.setPreferredSize(new Dimension(100,100));
        scrollPane.setVisible(true);



        jFrame.add(scrollPane);

    }
}
