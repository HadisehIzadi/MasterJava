import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class MainScreen extends JFrame {

Font myFont = new Font("sanSerif" , Font.BOLD , 20);
Color myColor = (Color.GRAY);

//*************** panel 1 ********************
JTextField subFname = new JTextField();
JTextField subLname = new JTextField();
JTextField subCity = new JTextField();
JTextField subPhone = new JTextField();


//**************** panel 2 ******************
    JTextField modelYear;
    JTextField manufacurer;
    JTextField plateNb;
    JTextField estimated;
    JRadioButton damageRadio1;
    JRadioButton damageRadio2;
    JRadioButton damageRadio3;
    JRadioButton damageRadio4;
    ButtonGroup G1;

    //**************** panel 3 ******************
    JCheckBox obligatoryCHKBX;
    JCheckBox allRiskCHKBX;
    JCheckBox vDamageCHKBX;
    JCheckBox dDamageCHKBX;
    JCheckBox assisCHKBX;
    List<String> coveredRisksList = new ArrayList<>();
    List<Float> premiumRisksList = new ArrayList<>();
    List<Float> coverageRisksList = new ArrayList<>();
    List<Float> ceilingRiskList = new ArrayList<>();

    //***************panel 4 ********************
    JRadioButton yearRadio;
    JRadioButton yearsRadio2;
    JRadioButton yearRadio3;
    ButtonGroup G2;
    JLabel todayLBL;
    int validityYEAR = 0;
    SimpleDateFormat df;
    Date currentDate;


    public  MainScreen()
    {

        CustomizePanel1();
        CustomizePanel2();
        CustomizePanel3();
        CustomizePanel4();
        CustomizePanel5();
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
    private void CustomizePanel2() {
        JPanel p2 = new JPanel();
        TitledBorder titledBorder =BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY , 1) ,
                "Vehicle" , TitledBorder.CENTER ,
                TitledBorder.DEFAULT_POSITION , myFont , myColor);
        p2.setBorder(titledBorder);

        JLabel plateNbLBL = new JLabel(" Plate Nb");
        JLabel modelLBL = new JLabel(" Model Year");
        JLabel manufacturerLBL = new JLabel(" Manufacturer");
        JLabel estimatedLBL = new JLabel(" Estimated Value");
        JLabel spaceLBL = new JLabel(" ");
        JLabel damageLBL = new JLabel(" Major Damage");

        plateNb = new JTextField();
        plateNb.setOpaque(false);

        modelYear = new JTextField();
        modelYear.setOpaque(false);

        manufacurer = new JTextField();
        manufacurer.setOpaque(false);

        estimated = new JTextField();
        estimated.setOpaque(false);

        damageRadio1 = new JRadioButton();
        damageRadio1.setText(" Motor");
        damageRadio2 = new JRadioButton();
        damageRadio2.setText(" Wheels");
        damageRadio3 = new JRadioButton();
        damageRadio3.setText(" Body");
        damageRadio4 = new JRadioButton();
        damageRadio4.setText(" None");

        G1 = new ButtonGroup();
        G1.add(damageRadio1);
        G1.add(damageRadio2);
        G1.add(damageRadio3);
        G1.add(damageRadio4);


        p2.add(plateNbLBL);
        p2.add(plateNb);
        p2.add(modelLBL);
        p2.add(modelYear);
        p2.add(manufacturerLBL);
        p2.add(manufacurer);
        p2.add(estimatedLBL);
        p2.add(estimated);
        p2.add(spaceLBL);
        p2.add(damageLBL);
        p2.add(damageRadio1);
        p2.add(damageRadio2);
        p2.add(damageRadio3);
        p2.add(damageRadio4);


        p2.setBounds(15,250,300,500);
        p2.setLayout(new GridLayout(14,1));
        add(p2);





    }
    private void CustomizePanel3()
    {
        JPanel p3 = new JPanel();
        TitledBorder titledBorder =BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY , 1) ,
                "Plan" , TitledBorder.CENTER ,
                TitledBorder.DEFAULT_POSITION , myFont , myColor);
        p3.setBorder(titledBorder);

        JLabel packageLBL = new JLabel("Please Select your Plan");


        obligatoryCHKBX = new JCheckBox("Obligatory");
        allRiskCHKBX = new JCheckBox("All Risk");
        vDamageCHKBX = new JCheckBox("Vehicle Damage");
        dDamageCHKBX = new JCheckBox("Driver Damage");
        assisCHKBX = new JCheckBox("Assistance");

        GetRisksCoveredByPlan();
        p3.setBounds(330,15,300,200);
        p3.setLayout(new GridLayout(6,1));


        p3.add(packageLBL);
        p3.add(obligatoryCHKBX);
        p3.add(allRiskCHKBX);
        p3.add(vDamageCHKBX);
        p3.add(dDamageCHKBX);
        p3.add(assisCHKBX);

        add(p3);

    }

    private void CustomizePanel4()
    {
        JPanel p4 = new JPanel();
        TitledBorder titledBorder =BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY , 1) ,
                "Validity" , TitledBorder.CENTER ,
                TitledBorder.DEFAULT_POSITION , myFont , myColor);
        p4.setBorder(titledBorder);

        p4.setBorder(titledBorder);
        p4.setBounds(330,250,300,250);
        p4.setLayout(new GridLayout(6,1));

        JLabel spacer2 = new JLabel(" ");
        spacer2.setOpaque(false);
        yearRadio = new JRadioButton();
        yearRadio.setText(" 1 Year");
        yearsRadio2 = new JRadioButton();
        yearsRadio2.setText(" 2 Years");
        yearRadio3 = new JRadioButton();
        yearRadio3.setText(" 3 Years");


        yearRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYEAR = 1 ;

            }
        });

        yearsRadio2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYEAR = 2;
            }
        });

        yearRadio3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYEAR = 3 ;
            }
        });

        G2 = new ButtonGroup();
        G2.add(yearRadio);
        G2.add(yearsRadio2);
        G2.add(yearRadio3);

        todayLBL = new JLabel();
        df = new SimpleDateFormat("dd/MM/yyyy");
        currentDate = new Date();
        todayLBL.setText("    today : " + df.format(currentDate));
        todayLBL.setOpaque(false);

        Font font = todayLBL.getFont();
        float size = font.getSize() + 3.0f;
        todayLBL.setFont( font.deriveFont(size) );


        p4.add(spacer2);
        p4.add(spacer2);
        p4.add(todayLBL);
        p4.add(spacer2);
        p4.add(yearRadio);
        p4.add(yearsRadio2);
        p4.add(yearRadio3);

        add(p4);
    }
    private void CustomizePanel5()
    {
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "  Actions  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);

        JPanel p5 = new JPanel();
        p5.setBounds(330,520,300,230);
        p5.setBorder(titledBorder);
        p5.setLayout(new GridLayout(7,1));
        JButton saveBTN = new JButton("Save Customer");
        JButton showBTN = new JButton("Show Plan Details");
        JButton loadBTN = new JButton("Load Customer");
        JButton newBTN = new JButton("New Customer");

        JTextField searchTXT = new JTextField("Enter Car Plate Nb");
        searchTXT.setOpaque(false);

        showBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // add next session
            }
        });
        saveBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // add next
            }
        });
        loadBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // add next
            }
        });
        newBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // add next
            }
        });


        JLabel spacer5 = new JLabel(" ");
        spacer5.setOpaque(false);
        JLabel spacer6 = new JLabel(" ");
        spacer6.setOpaque(false);

        p5.add(spacer6);
        p5.add(showBTN);
        p5.add(saveBTN);
        p5.add(newBTN);
        p5.add(spacer5);
        p5.add(searchTXT);
        p5.add(loadBTN);

        add(p5);

    }

    private void GetRisksCoveredByPlan() {
    }

    public static void main(String[] args) {

        MainScreen mainScreen = new MainScreen();
        mainScreen.setVisible(true);
        mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainScreen.setTitle("Bime");
        mainScreen.setBounds(0 , 0 , 1920 , 1080);
    }
}