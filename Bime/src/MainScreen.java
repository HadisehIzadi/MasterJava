import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.List;
import Plan.*;
import Policy.*;

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
    //*************** panel 5 **********
    JTextField searchTXT;
    //***************panel 6 *************
    JTextArea riskText;
    //**************** panel 7 **********
    JTextArea polictText;
    //****************panel 8 **********
    JTextArea customerTxt;
    //************ Panel 9 *********
    JLabel claimingTXT;
    JLabel claimingTXT2;
    JTextField claimingCustomerField;
    // Panel 10
    JLabel claimingCustomerNameLBL;
    JLabel claimStatusLBL2;
    JTextArea claimingCustomerRisksCoveredAREA;
    JLabel claimingCustomerValidDateLBL;
    boolean cond1;
    boolean cond2;
    boolean cond3;

    // ***************** panel 11 ************
    JTextArea settlementArea;
    float totalPremium = 0f;
    float totalCoverage = 0f;
    float totalCeiling = 0f;

    //******************** Panel 12 ****************
    JTextArea settlementArea2;


    public  MainScreen()
    {

        CustomizePanel1();
        CustomizePanel2();
        CustomizePanel3();
        CustomizePanel4();
        CustomizePanel5();
        CustomizePanel6();
        CustomizePanel7();
        CustomizePanel8();
        CustomizePanel19();
        CustomizePanel10();
        CustomizePanel11();
        CustomizePanel12();
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




        p1.setBounds(15 , 15 , 200 , 200);
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
       // p2.add(spaceLBL);
        p2.add(damageLBL);
        p2.add(damageRadio1);
        p2.add(damageRadio2);
        p2.add(damageRadio3);
        p2.add(damageRadio4);


        p2.setBounds(15,240,200,500);
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
        p3.setBounds(230,15,200,200);
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
        p4.setBounds(230,240,200,250);
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
        p5.setBounds(230,510,200,230);
        p5.setBorder(titledBorder);
        p5.setLayout(new GridLayout(7,1));
        JButton saveBTN = new JButton("Save Customer");
        JButton showBTN = new JButton("Show Plan Details");
        JButton loadBTN = new JButton("Load Customer");
        JButton newBTN = new JButton("New Customer");

         searchTXT = new JTextField("Enter Car Plate Nb");
        searchTXT.setOpaque(false);

        showBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = "";
                for (int i =0; i< coveredRisksList.size();i++){
                    str += coveredRisksList.get(i) + "\n";
                }
                riskText.setText(str);


                try{
                    polictText.setText(GetPolicyData().toString());
                    DisplayPaymentsOfPolicy();
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
            }
        });
        saveBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // add next
                try {
                    SaveCustomerMapToDisk();


                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        loadBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // add next
                SearchCustomerByMobileNB();
            }
        });
        newBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // add next
                NewCustomer();
            }
        });


        JLabel spacer5 = new JLabel(" ");
        spacer5.setOpaque(false);
        JLabel spacer6 = new JLabel(" ");
        spacer6.setOpaque(false);

        //p5.add(spacer6);
        p5.add(showBTN);
        p5.add(saveBTN);
        p5.add(newBTN);
        p5.add(spacer5);
        p5.add(searchTXT);
        p5.add(loadBTN);

        add(p5);

    }
    private void CustomizePanel6()
    {
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "  Covered Risks  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);

        JPanel p6 = new JPanel();
        p6.setBorder(titledBorder);
        p6.setBounds(445,15,200,200);

        riskText = new JTextArea(7, 1);
        riskText.setEditable(false);
        riskText.setOpaque(false);
        riskText.setLineWrap(true);


        Font font = riskText.getFont();
        float size = font.getSize() + 3.0f;
        riskText.setFont( font.deriveFont(size) );

        p6.add(riskText);

        p6.setLayout(new GridLayout(1,1));
        add(p6);
    }
    private void CustomizePanel7()
    {
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "  Policy Details  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);

        JPanel p7 = new JPanel();
        p7.setBounds(445,240,200,250);
        p7.setBorder(titledBorder);
        p7.setLayout(new GridLayout(6,1));

        polictText = new JTextArea(20,1);
        polictText.setEditable(false);
        polictText.setOpaque(false);
        polictText.setLineWrap(true);

        Font font = polictText.getFont();
        float size  = font.getSize() + 3.0f;
        polictText.setFont(font.deriveFont(size));


        p7.add(polictText);
        p7.setLayout(new GridLayout(1,1));
        add(p7);
    }
    private void CustomizePanel8()
    {
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "  Customer Details  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);

        JPanel p8 = new JPanel();
        p8.setBorder(titledBorder);
        p8.setBounds(445, 510, 200, 230);
        p8.setLayout(new GridLayout(6, 1));

        customerTxt = new JTextArea(20, 1);
        customerTxt.setEditable(false);
        customerTxt.setOpaque(false);
        customerTxt.setLineWrap(true);

        // increase the size of font for the jtextarea
        Font font = customerTxt.getFont();
        float size = font.getSize() + 3.0f;
        customerTxt.setFont( font.deriveFont(size) );

        p8.add(customerTxt);

        p8.setLayout(new GridLayout(1,1));
        add(p8);
    }
    private void CustomizePanel19()
    {
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "  Claims  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);


        JPanel p9 = new JPanel();
        p9.setBorder(titledBorder);
        p9.setBounds(680, 15, 300, 330);

        claimingTXT = new JLabel("Enter Plate Nb. for the Claiming Customer");
        JLabel spacer99 = new JLabel("                                             ");
        claimingTXT2 = new JLabel("Select the Type of Damage or Assistance Needed");

        claimingCustomerField = new JTextField();
        claimingCustomerField.setPreferredSize(new Dimension(220, 30));
        claimingCustomerField.setOpaque(false);

        String[] items = { "Fire", "Robbery",
                "Third Party Damage",
                "Vehicle Damage"
                ,"Driver Damage",
                "Transport",
                "Car Replacement"};

        final JList claimList = new JList(items);
        claimList.setSelectionMode(
                ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        claimList.setOpaque(false);

        claimList.setPreferredSize(new Dimension(220, 150));
        JButton searchClaimer = new JButton("   Search Customer");
        List<String> coveredRisksByUserLIST = new ArrayList<>();
        JButton confirmClaimBTN = new JButton("   Confirm Claim");


        searchClaimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cond1 = false;          // Customer is registered before in on our db??
                cond2 = false;          // Is the customer's policy cover the claimed risk?
                cond3 = false;          // Is the policy date is valid?

                try{
                    coveredRisksByUserLIST.clear();
                    Customer c = ClaimsSearchCustomerByMobileNb();
                    claimingCustomerNameLBL.setText("Claiming Customer: "+ c.getFname() + " " +c.getLname());
                    cond1 = true;


                    String str7 = "";
                    for (int i=0 ; i<c.getPolicy().getRisksCoverdList().size();i++){
                        str7 += c.getPolicy().getRisksCoverdList().get(i) + " \n";
                        coveredRisksByUserLIST.add(c.getPolicy().getRisksCoverdList().get(i));
                    }

                    LocalDate v_validityofPolicy = c.getPolicy().getPolicyDate();
                    int v_policyVaslidityYears = c.getPolicy().getValidityYear();
                    v_validityofPolicy = v_validityofPolicy.plusYears(v_policyVaslidityYears);

                    CheckPolicyValidity(v_validityofPolicy);

                    claimingCustomerRisksCoveredAREA.setText("Covered Risks by Customer plan:\n"+str7);
                    claimingCustomerValidDateLBL.setText("Date Validity of Policy: " +v_validityofPolicy+"  || " +CheckPolicyValidity(v_validityofPolicy));

                    if (c.getPolicy().getRisksCoverdList().size() >=5){
                        // if the user has a all-risks plan
                        cond2 = true;
                    }

                }catch (Exception re){
                    claimingCustomerNameLBL.setText("Claiming Customer: Not Found");
                }

            }
        });
        confirmClaimBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the index of all the selected items
                int[] selectedIx = claimList.getSelectedIndices();
                List<String> claimed_list = new ArrayList<>();


                if (claimList.getSelectedIndex() != -1) {
                    for (int i= 0; i< selectedIx.length; i++) {
                        String k = "" + claimList.getModel().getElementAt(selectedIx[i]) + " ";
                        claimed_list.add(""+claimList.getModel().getElementAt(selectedIx[i]));
                        System.out.print("" + k);
                    }
                }

                if (cond2 == false){
                    cond2 = claimed_list.containsAll(coveredRisksByUserLIST);
                }



                ClaimIsValid();


                Customer c = ClaimsSearchCustomerByMobileNb();
                if (ClaimIsValid()){
                    int claims_nb = claimed_list.size();
                    if (claimed_list.contains("Fire")){
                        settlementArea2.setText("Fire Department: " +
                                c.getPolicy().getVehicle().getEstimatedValue()*0.25 + " $");

                    }else if (claimed_list.contains("Robbery")){
                        settlementArea2.setText("ProSec Company: " +
                                c.getPolicy().getVehicle().getEstimatedValue()*0.5 + " $" +
                                "Pay for Customer: " +
                                c.getPolicy().getVehicle().getEstimatedValue()*1 + " $");

                    }else if  (claimed_list.contains("Third Party Damage")){
                        settlementArea2.setText("Driver in other Car: " + 2000 + "$");

                    }else if (claimed_list.contains("Vehicle Damage")){
                        settlementArea2.setText("Pay for Customer: " +
                                c.getPolicy().getVehicle().getEstimatedValue()*1+ " $");

                    }else if (claimed_list.contains("Driver Damage")) {
                        settlementArea2.setText("Pay for Customer: " +
                                c.getPolicy().getVehicle().getEstimatedValue()*10+ " $");

                    }else if (claimed_list.contains("Transport")){
                        settlementArea2.setText("Transport Company " +
                                c.getPolicy().getVehicle().getEstimatedValue()*0.5+ " $");

                    }else if (claimed_list.contains("Car Replacement")){
                        settlementArea2.setText("Car Rental Company " +
                                c.getPolicy().getVehicle().getEstimatedValue()*0.2+ " $");

                    }else if (claims_nb > 2){
                        settlementArea2.setText("Driver "
                                + c.getPolicy().getVehicle().getEstimatedValue()*4+ " $"+
                                "Hospital " + c.getPolicy().getVehicle().getEstimatedValue()*4
                                + " $ "+

                                "Car Rental Company "
                                + c.getPolicy().getVehicle().getEstimatedValue()*0.2 + " $ "+
                                "Third Party Driver " +
                                c.getPolicy().getVehicle().getEstimatedValue()*2
                        );

                    }else{

                    }
                }

            }
        });

        p9.add(claimingTXT);
        p9.add(claimingCustomerField);
        p9.add(searchClaimer);
        p9.add(spacer99);
        p9.add(claimingTXT2);
        p9.add(claimList);
        p9.add(confirmClaimBTN);

        add(p9);




    }
    private void CustomizePanel10(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "  Claim Status", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);

        JPanel p10 = new JPanel();
        p10.setBorder(titledBorder);
        p10.setBounds(680, 360, 300, 230);
        p10.setLayout(new GridLayout(4, 1));
        //************************
        // this code updated today
        //***********************


        claimingCustomerNameLBL = new JLabel("Claiming Customer: ");
        claimingCustomerValidDateLBL = new JLabel("Date Validity of Policy: ");
        claimStatusLBL2 = new JLabel("Claiming Status: ");

        // JTextArea
        claimingCustomerRisksCoveredAREA = new JTextArea();
        JScrollPane pictureScrollPane = new JScrollPane(claimingCustomerRisksCoveredAREA);
        claimingCustomerRisksCoveredAREA.setOpaque(false);


        p10.add(claimingCustomerNameLBL);
        p10.add(claimingCustomerValidDateLBL);
        p10.add(pictureScrollPane);
        p10.add(claimStatusLBL2);

        add(p10);

    }
    private void CustomizePanel11()
    {
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "  Payments  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);

        JPanel p11 = new JPanel();
        p11.setBorder(titledBorder);
        p11.setBounds(1020, 15, 200, 230);
        p11.setLayout(new GridLayout(2, 1));

        settlementArea = new JTextArea();
        settlementArea.setOpaque(false);

        Font font = settlementArea.getFont();
        float size = font.getSize() + 4.0f;
        settlementArea.setFont( font.deriveFont(size) );

        p11.add(settlementArea);
        add(p11);


    }
    public void CustomizePanel12(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "  Settlements  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);

        JPanel  p12 = new JPanel();
        p12.setBorder(titledBorder);
        p12.setBounds(1020,250,200,500);
        p12.setLayout(new GridLayout());

        settlementArea2 = new JTextArea();
        settlementArea2.setOpaque(false);
        p12.add(settlementArea2);

        Font font = settlementArea2.getFont();
        float size = font.getSize() + 4.0f;
        settlementArea2.setFont(font.deriveFont(size));

        add(p12);

    }

    //****************************************************
    /****************************************************/
    //****************************************************
    public Customer GetCustomerData() throws ParseException {
        Customer customer = new Customer(
                subFname.getText(),
                subLname.getText(),
                subCity.getText(),
                Integer.parseInt(subPhone.getText()),
                GetPolicyData()
        );
        return  customer;
    }

    private Policy GetPolicyData() throws ParseException {
        currentDate = new Date();
        LocalDate now = LocalDate.now();

        return new Policy(
                GetVehicleData(),
                coveredRisksList,
                premiumRisksList,
                coverageRisksList,
                ceilingRiskList,
                validityYEAR,
                now );
    }

    // Vehicle Data
    public Vehicle GetVehicleData() throws  ParseException{
        return new Vehicle(
                Integer.parseInt(plateNb.getText()),
                Integer.parseInt(modelYear.getText()),
                manufacurer.getText(),
                Integer.parseInt(estimated.getText()),
                GetDamageState());
    }
    public int GetDamageState(){

        if (damageRadio1.isSelected()){
            return 1;
        }else if (damageRadio2.isSelected()){
            return 2;
        }else if (damageRadio3.isSelected()){
            return 3;
        }else
            return 0;

    };

    private void GetRisksCoveredByPlan() {

            AllRisks allRisk = new AllRisks();
            Obligatory obligatoryRisk = new Obligatory();
            allRiskCHKBX.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dDamageCHKBX.setEnabled(false);
                    vDamageCHKBX.setEnabled(false);
                    assisCHKBX.setEnabled(false);
                    obligatoryCHKBX.setEnabled(false);


                    for (int i = 0; i< allRisk.AllRiskCoverd.length;i++){
                        coveredRisksList.add(allRisk.AllRiskCoverd[i]);
                    }
                    premiumRisksList.add(allRisk.getPrimuim());
                    coverageRisksList.add(allRisk.getCoverage());
                    ceilingRiskList.add(allRisk.getCeilling());
                }
            });

            obligatoryCHKBX.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    coveredRisksList.add(obligatoryRisk.ObligatoryRiskCoverd[0]);
                    premiumRisksList.add(obligatoryRisk.getPrimuim());
                    coverageRisksList.add(obligatoryRisk.getCoverage());
                    ceilingRiskList.add(obligatoryRisk.getCeilling());

                }
            });

            vDamageCHKBX.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    VehicleRisk vehicleRisk = new VehicleRisk();

                    coveredRisksList.add(vehicleRisk.vehicleRiskCoverd[0]);
                    premiumRisksList.add(vehicleRisk.getPrimuim());
                    coverageRisksList.add(vehicleRisk.getCoverage());
                    ceilingRiskList.add(vehicleRisk.getCeilling());

                }
            });

            dDamageCHKBX.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DriverDamage driverRisk = new DriverDamage();
                    coveredRisksList.add(driverRisk.DriverRiskCoverd[0]);
                    premiumRisksList.add(driverRisk.getPrimuim());
                    coverageRisksList.add(driverRisk.getCoverage());
                    ceilingRiskList.add(driverRisk.getCeilling());

                }
            });

            assisCHKBX.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AssistanceRisk assistanceRisk = new AssistanceRisk();

                    for (int i = 0; i< assistanceRisk.AssistanceRiskCoverd.length; i++) {
                        coveredRisksList.add(assistanceRisk.AssistanceRiskCoverd[i]);
                    }
                    premiumRisksList.add(assistanceRisk.getPrimuim());
                    coverageRisksList.add(assistanceRisk.getCoverage());
                    ceilingRiskList.add(assistanceRisk.getCeilling());
                }
            });


    }

    private void NewCustomer(){
        coverageRisksList.clear();
        coveredRisksList.clear();
        premiumRisksList.clear();
        ceilingRiskList.clear();
        cond1= false;
        cond2= false;
        cond3= false;

        subFname.setText("");
        subLname.setText("");
        subCity.setText("");
        subPhone.setText("");
        plateNb.setText("");
        modelYear.setText("");
        manufacurer.setText("");
        estimated.setText("");

        G1.clearSelection();
        G2.clearSelection();

        obligatoryCHKBX.setSelected(false);
        allRiskCHKBX.setSelected(false);
        vDamageCHKBX.setSelected(false);
        dDamageCHKBX.setSelected(false);
        assisCHKBX.setSelected(false);

        dDamageCHKBX.setEnabled(true);
        vDamageCHKBX.setEnabled(true);
        assisCHKBX.setEnabled(true);
        obligatoryCHKBX.setEnabled(true);


    }

    public void SaveCustomerMapToDisk() throws IOException, ClassNotFoundException, ParseException {
        File file = new File("D:/myfile.dat");
        int platenbmr = Integer.parseInt(plateNb.getText());

        if (!file.exists()) {
            // Creating a new file
            System.out.println("Not Existed");
            file.createNewFile();

            SaveCustomerMaptoNewFile(platenbmr, file);
        } else {
            // file exists
            TreeMap<Integer, Customer> newMaptoSave = new TreeMap<>();
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);

            TreeMap<Integer, Customer> mapInFile = (TreeMap<Integer, Customer>) ois.readObject();
            ois.close();
            is.close();

            // Get old map
            for (Map.Entry<Integer, Customer> m : mapInFile.entrySet()) {
                newMaptoSave.put(m.getKey(), m.getValue());
            }

            // Updating the map: Adding new Customer to map
            newMaptoSave.put(platenbmr, GetCustomerData());

            // Saving the updates to file
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(newMaptoSave);
            oos.flush();
            oos.close();

        }

    }

    private void SaveCustomerMaptoNewFile(int platenbmr, File file) throws ParseException, IOException {

        TreeMap<Integer, Customer> newMaptoSave = new TreeMap<>();

        // Adding new CUstomer to map
        newMaptoSave.put(platenbmr,GetCustomerData());

        OutputStream os = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(newMaptoSave);
        oos.flush();
        oos.close();
    }

    private void SearchCustomerByMobileNB(){
        File file = new File("D:/myfile.dat");

        try{
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);

            TreeMap<Integer,Customer> mapInFile = (TreeMap<Integer,Customer>)ois.readObject();



            Customer c_finded = mapInFile.get(Integer.parseInt(searchTXT.getText()));
            customerTxt.setText(c_finded.toString());
            ois.close();
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private Customer ClaimsSearchCustomerByMobileNb(){
        Customer customer = new Customer();
        File file = new File("D:/myfile.dat");

        try{
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);

            TreeMap<Integer, Customer> mapInFile =  (TreeMap<Integer,Customer>)ois.readObject();

            ois.close();
            is.close();

            customer = mapInFile.get(Integer.parseInt(claimingCustomerField.getText()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return customer;
    }


    private boolean CheckPolicyValidity(LocalDate v_validityofPolicy){
        LocalDate now = LocalDate.now();

        if (now.isBefore(v_validityofPolicy)){
            cond3 = true;
            return true;
        }else{
            cond3 = false;
            return false;
        }
    }

    private boolean ClaimIsValid(){
        if (cond1 == true && cond2 == true && cond3 == true){
            claimStatusLBL2.setText("Claiming Status: You can register the Claim");
            return true;
        }else{
            claimStatusLBL2.setText("Claiming Status: Not Able to register the Claim");
            return false;
        }
    }

    private void DisplayPaymentsOfPolicy(){
        for (int i = 0; i< premiumRisksList.size(); i++){
            totalPremium += premiumRisksList.get(i);
            totalCoverage += coverageRisksList.get(i);
            totalCeiling += ceilingRiskList.get(i);
        }

        settlementArea.setText(
                "Total Premium: "+totalPremium*Integer.parseInt(estimated.getText()) + " $ \n "+
                        "Risks Coverage: " + totalCoverage*Integer.parseInt(estimated.getText())*10 + " $ \n"+
                        "Max Ceiling: "+totalCeiling*Integer.parseInt(estimated.getText()) + 100000 + " $ \n"
        );
    }





    public static void main(String[] args) {

        MainScreen mainScreen = new MainScreen();
        mainScreen.setVisible(true);
        mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainScreen.setTitle("Bime");
        mainScreen.setBounds(0 , 0 , 1920 , 1080);
    }
}