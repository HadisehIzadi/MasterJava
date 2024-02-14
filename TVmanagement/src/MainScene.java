import  javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
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
        SimpleDateFormat df;
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

}
    public  void DisplayMovieChannels()
    {

    }
    public  void DisplayDocumentChannels()
    {

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




    public static void main(String[] args) {
        MainScene mainScene = new MainScene();
        mainScene.setLayout(null);
        mainScene.setVisible(true);
        mainScene.setBounds(20 , 10 , 1200 , 800);


    }
}
