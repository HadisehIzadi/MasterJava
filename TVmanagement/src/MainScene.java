import  javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainScene extends JFrame {
    //****************** subscriber details elements ****************
    JPanel subscriberPanel;
    JTextField subNameField;
    JTextField subLastNameField;
    JTextField subMobileField;
    JTextField subCityField;

    JLabel NamLabel;
    JLabel LastNamLabel;
    JLabel MobileLabel;
    JLabel cityLabel;
//****************** cycle details elements ****************
    JPanel cyclePanel;
    JTextField startCycleFLD;
    JLabel startLBL;
    JTextField endCycleFLD;
    JLabel endLBL;
    JTextField numberTVFLD;
    JLabel numberTvLBL;
    JLabel todayDate;
    SimpleDateFormat df;

    //****************** packages details elements ****************
    JCheckBox sportbx;
    JCheckBox moviebx;
    JCheckBox docbx;
    JPanel packagesPanel;
    //****************** available channels details elements ****************
    JTextArea channelsAreaSport;
    JTextArea channelsAreaMovie;
    JTextArea channelsAreaDocumnet;
    JPanel detailsPanel ;
    //****************** fee panel details elements ****************
    JLabel installFeeLBl;
    JLabel packageFeeLBL;
    JLabel totalFeeLBL;
    JPanel feePanel;
    //****************** tabel panel details elements ****************
    JTable table;
    DefaultTableModel tableModel;
    JPanel tablePanel;

    //****************** action panel details elements ****************
    JButton saveButton;
    JButton loadButton;
    JButton newButton;
    JPanel actionPanel;

    //**************** objects ************************************
    Subscriber subscriber;
    Subscription subscription;




    public MainScene(){
    //****************** subscriber details elements ****************
        subscriberPanel = new JPanel();
        Border panel1Tile = BorderFactory.createTitledBorder("Subscriber Details");
        subscriberPanel.setBorder(panel1Tile);
        subscriberPanel.setBounds(15 , 15 , 300 , 200);
        subscriberPanel.setLayout(new GridLayout(4,2));


        NamLabel = new JLabel("First Name :");
        LastNamLabel = new JLabel("Last Name :");
        MobileLabel = new JLabel("Mobile Number :");
        cityLabel = new JLabel("City :");

        subNameField = new JTextField();
        subNameField.setOpaque(false);
        subLastNameField = new JTextField();
        subLastNameField.setOpaque(false);
        subMobileField = new JTextField();
        subMobileField.setOpaque(false);
        subCityField = new JTextField();
        subCityField.setOpaque(false);



        subscriberPanel.add(NamLabel);
        subscriberPanel.add(subNameField);

        subscriberPanel.add(LastNamLabel);
        subscriberPanel.add(subLastNameField);

        subscriberPanel.add(MobileLabel);
        subscriberPanel.add(subMobileField);

        subscriberPanel.add(cityLabel);
        subscriberPanel.add(subCityField);
//****************** cycle panel ********************
        cyclePanel = new JPanel();
        cyclePanel.setBounds(15 , 230 , 300 , 500);
        cyclePanel.setLayout(new GridLayout(14 , 1));
        Border panel2Tile = BorderFactory.createTitledBorder("cycle Details");
        cyclePanel.setBorder(panel2Tile);

        todayDate = new JLabel();
        
        Date currentDate ;
        df = new SimpleDateFormat("dd/MM/yyyy");
        currentDate = new Date();

        todayDate.setText("toay : " + df.format(currentDate));

        startLBL = new JLabel("start : ");
        endLBL = new JLabel("end : ");
        numberTvLBL = new JLabel("number of TV : ");

        startCycleFLD = new JTextField();
        startCycleFLD.setOpaque(false);

        endCycleFLD = new JTextField();
        endCycleFLD.setOpaque(false);

        numberTVFLD = new JTextField();
        numberTVFLD.setOpaque(false);


        cyclePanel.add(todayDate);
        cyclePanel.add(startLBL);
        cyclePanel.add(startCycleFLD);
        cyclePanel.add(endLBL);
        cyclePanel.add(endCycleFLD);
        cyclePanel.add(numberTvLBL);
        cyclePanel.add(numberTVFLD);


        //****************** packages details elements ****************
        packagesPanel = new JPanel();
        packagesPanel.setBounds(330 , 15 , 300 , 200);
        packagesPanel.setLayout(new GridLayout(5 , 1));
        Border panel3Tile = BorderFactory.createTitledBorder("channel packages");
        packagesPanel.setBorder(panel3Tile);

        JLabel packagesLBL = new JLabel("select your packages");

        sportbx = new JCheckBox("Sport");
        moviebx = new JCheckBox("Movie");
        docbx = new JCheckBox("Documentary");

        JButton subscribe = new JButton("subscribe");
        subscribe.setBackground(Color.GREEN);

        packagesPanel.add(packagesLBL);
        packagesPanel.add(sportbx);
        packagesPanel.add(moviebx);
        packagesPanel.add(docbx);
        packagesPanel.add(subscribe);

        sportbx.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(sportbx.isSelected())
                {
                    DisplaySportChannels();
                }
            }
        });

        moviebx.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(moviebx.isSelected())
                    DisplayMovieChannels();
            }
        });

        docbx.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(docbx.isSelected())
                    DisplayDocumentChannels();
            }
        });
        subscribe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SubScribeChannelPackages();
            }
        });


        //****************** available channels details elements ****************
        detailsPanel = new JPanel();
        detailsPanel.setBounds(330 , 230 , 300 , 500);
        detailsPanel.setLayout(new GridLayout(3,1));
        Border panel4Tile = BorderFactory.createTitledBorder("available channel");
        detailsPanel.setBorder(panel4Tile);

        channelsAreaSport = new JTextArea(5,1);
        channelsAreaSport.setEditable(false);
        channelsAreaSport.setOpaque(false);
        channelsAreaSport.setLineWrap(true);

        channelsAreaMovie = new JTextArea(5,1);
        channelsAreaMovie.setEditable(false);
        channelsAreaMovie.setOpaque(false);
        channelsAreaMovie.setLineWrap(true);

        channelsAreaDocumnet = new JTextArea(5,1);
        channelsAreaDocumnet.setEditable(false);
        channelsAreaDocumnet.setOpaque(false);
        channelsAreaDocumnet.setLineWrap(true);




        detailsPanel.add(channelsAreaSport);
        detailsPanel.add(channelsAreaMovie);
        detailsPanel.add(channelsAreaDocumnet);

    //****************** fee panel details elements ****************
        feePanel = new JPanel();
        feePanel.setBounds(645 , 15 , 200 , 200);
        feePanel.setLayout(new GridLayout(3,1));
        Border panel5Tile = BorderFactory.createTitledBorder("Fee ");
        feePanel.setBorder(panel5Tile);

        installFeeLBl = new JLabel("installation fee :");
        packageFeeLBL = new JLabel("package fee :");
        totalFeeLBL = new JLabel("total fee :");

        feePanel.add(installFeeLBl);
        feePanel.add(packageFeeLBL);
        feePanel.add(totalFeeLBL);

        //****************** tabel panel details elements ****************
        tablePanel = new JPanel();
        tablePanel.setBounds(645 , 230 , 515 , 500);
        tablePanel.setLayout(new GridLayout(3,1));
        Border panel6Tile = BorderFactory.createTitledBorder("Table ");
        tablePanel.setBorder(panel6Tile);

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);

        tableModel.addColumn("first name");
        tableModel.addColumn("last name");
        tableModel.addColumn("phone number");
        tableModel.addColumn("start cycle");
        tableModel.addColumn("end cycle");
        tableModel.addColumn("total fee");


        JScrollPane scrollPane = new JScrollPane(table);



        tablePanel.add(scrollPane);

        //****************** action panel details elements ****************
        actionPanel = new JPanel();
        actionPanel.setBounds(860 ,15 ,300 , 200);
        actionPanel.setLayout(new GridLayout(3,1));
        Border panel7Tile = BorderFactory.createTitledBorder("action panel ");
        actionPanel.setBorder(panel7Tile);

        saveButton = new JButton("save");
        saveButton.setBackground(Color.GREEN);

        loadButton = new JButton("load");
        loadButton.setBackground(Color.ORANGE);

        newButton = new JButton("new");
        newButton.setBackground(Color.yellow);

        actionPanel.add(saveButton);
        actionPanel.add(loadButton);
        actionPanel.add(newButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveDataToDisk();
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadDataFromDisk();
            }
        });
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newData();
            }
        });









        //*************** jframe elements ***************
        add(subscriberPanel);
        add(cyclePanel);
        add(packagesPanel);
        add(detailsPanel);
        add(feePanel);
        add(tablePanel);
        add(actionPanel);

    }

    public  void DisplaySportChannels()
    {
        SportChannel s1 = new SportChannel("AFN Sports", "EN", "SPRT",5);
        SportChannel s2 = new SportChannel("beIN Sports", "FR", "SPRT",3);
        SportChannel s3 = new SportChannel("Eleven Sports", "EN", "SPRT",8);
        SportChannel s4 = new SportChannel("NBA TV", "EN", "SPRT",6);
        SportChannel s5 = new SportChannel("NFL Network", "AR", "SPRT",3);
        SportChannel s6 = new SportChannel("The Ski Channel", "USA", "SPRT",1);


        ArrayList<SportChannel> sportList = new ArrayList<>();
        sportList.add(s1);
        sportList.add(s2);
        sportList.add(s3);
        sportList.add(s4);
        sportList.add(s5);
        sportList.add(s6);

        String sprtChannelString = "";
        for (int i= 0; i < sportList.size() ; i++){
            sprtChannelString +=
                    "     "+ sportList.get(i).getChannelName()
                            + "     "+ sportList.get(i).getLanguage()
                            + "     " + sportList.get(i).getPrice()
                            + "\n";

        }
        channelsAreaSport.setText(sprtChannelString);




    }
    public  void DisplayMovieChannels()
    {

        MovieChannel m1 = new MovieChannel("MBC Bundle", "EN", "MOV", 4);
        MovieChannel m2 = new MovieChannel("Cinema One", "EN", "MOV",5);
        MovieChannel m3 = new MovieChannel("Cinema Pro", "RU", "MOV",6);
        MovieChannel m4 = new MovieChannel("Cinema 1", "AR", "MOV",2);
        MovieChannel m5 = new MovieChannel("Movie Home", "GR", "MOV",4);
        MovieChannel m6 = new MovieChannel("Film4", "FR", "MOV",2);

        ArrayList<MovieChannel> movieList = new ArrayList<>();
        movieList.add(m1);
        movieList.add(m2);
        movieList.add(m3);
        movieList.add(m4);
        movieList.add(m5);
        movieList.add(m6);

        String movChannelString = "";
        int packagePrice =0;

        for (int i= 0; i < movieList.size() ; i++){
            movChannelString +=
                    "     "+ movieList.get(i).getChannelName()
                            + "     "+ movieList.get(i).getLanguage()
                            + "     " + movieList.get(i).getPrice()
                            + "\n";

        }
        channelsAreaMovie.setText(movChannelString);


    }
    public  void DisplayDocumentChannels()
    {
        DocumentaryChannel d1 = new DocumentaryChannel("NAT GEO", "SP", "DOC", 3);
        DocumentaryChannel d2 = new DocumentaryChannel("PBS America", "EN", "DOC", 2);
        DocumentaryChannel d3 = new DocumentaryChannel("Al Jazeera Documentary", "IN", "DOC",3);
        DocumentaryChannel d4 = new DocumentaryChannel("Canal D", "USA", "EN", 4);
        DocumentaryChannel d5 = new DocumentaryChannel("Discovery Historia", "AR", "DOC", 5);
        DocumentaryChannel d6 = new DocumentaryChannel("World Documentary", "GR", "DOC", 1);


        ArrayList<DocumentaryChannel> documentaryChannels = new ArrayList<>();
        documentaryChannels.add(d1);
        documentaryChannels.add(d2);
        documentaryChannels.add(d3);
        documentaryChannels.add(d4);
        documentaryChannels.add(d5);
        documentaryChannels.add(d6);

        String docString = "";
        for(int i = 0 ;  i < documentaryChannels.size() ; i++)
        {
            docString +=
                    "     "+ documentaryChannels.get(i).getChannelName()
                            + "     "+ documentaryChannels.get(i).getLanguage()
                            + "     " + documentaryChannels.get(i).getPrice()
                            + "\n";
        }

        channelsAreaDocumnet.setText(docString);

    }

    public  void SubScribeChannelPackages()
    {

    }

    public  void SaveDataToDisk()
    {

    }
    public  void loadDataFromDisk()
    {

    }
    public void newData()
    {

    }

    private void GetSubsciberData() throws ParseException {
        Date currentDate = new Date();

        //Subscriber Data:
        subscriber = new Subscriber(
                subNameField.getText(),
                subLastNameField.getText(),
                subCityField.getText(),
                Integer.parseInt(subMobileField.getText()));

        // Cycle
        Date startCycle = df.parse(startCycleFLD.getText());
        Date endCycle   = df.parse(endCycleFLD.getText());

        SubscriptionCycle cycle = new SubscriptionCycle(
                df.format(startCycle),
                df.format(endCycle)
        );

        // Subscription
        subscription = new Subscription(
                Integer.parseInt(numberTVFLD.getText()),
                subscriber,
                cycle,
                df.format(currentDate)
        );

        installFeeLBl.setText("Installation Fee: "+
                subscription.getTotalFee() + " $");

        ShowPrice();


    }

    private void ShowPrice() {
    }


    public static void main(String[] args) {
        MainScene mainScene = new MainScene();
        mainScene.setLayout(null);
        mainScene.setVisible(true);
        mainScene.setBounds(20 , 10 , 1200 , 800);


    }
}
