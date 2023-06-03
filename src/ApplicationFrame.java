import model.AirCompany;
import model.CargoPlane;
import model.PassengerPlane;
import model.Plane;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;


public class ApplicationFrame extends JFrame{
    private static AirCompany airCompany;
    private static final DefaultListModel<Plane> listModel = new DefaultListModel<>();

    private static JLabel totalCapacityLabel = null;

    public ApplicationFrame(AirCompany airCompany) {
        super("Air Company");
        ApplicationFrame.airCompany = airCompany;
        totalCapacityLabel = new JLabel("Total capacity:  " + airCompany.getTotalCapacity());
        totalCapacityLabel.setBounds(30,260,150,30);
        add(totalCapacityLabel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 350);
        setLocationRelativeTo(null);
        initComponents();
        setLayout(null);
        setVisible(true);
    }


    private void initComponents() {
        Arrays.stream(airCompany.getPlanes()).forEach(listModel::addElement);
        JList<Plane> planeList = new JList<>(listModel);
        planeList.setBounds(155,45,170,200);
        add(planeList);


        JButton addButton = new JButton("add");
        addButton.setBounds(30,110,80,20);
        addButton.addActionListener(e -> new AddButtonDialog(this));
        add(addButton);

        JButton editButton = new JButton("edit");
        editButton.setBounds(30,140,80,20);
        editButton.addActionListener(e -> new EditButtonDialog(this, planeList.getSelectedIndex()));
        add(editButton);

        JButton deleteButton = new JButton("delete");
        deleteButton.setBounds(30,170,80,20);
        deleteButton.addActionListener(e -> {
            int selectedIndex = planeList.getSelectedIndex();
            int optionIndex = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure?",
                    "Your final choice",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
            if(optionIndex == 0){
                airCompany.deletePlane(selectedIndex);
                listModel.remove(selectedIndex);
                totalCapacityLabel.setText("Total capacity:  " + airCompany.getTotalCapacity());
            }
        });
        add(deleteButton);

    }

    public static class AddButtonDialog extends JDialog {
        public AddButtonDialog(Frame owner) {
            super(owner,"add");
            setSize(200,250);
            setLocationRelativeTo(null);
            setLayout(null);
            initComponents();
            setVisible(true);

        }

        private void initComponents() {
            JLabel planesLabel = new JLabel("Select type:");
            planesLabel.setBounds(30,15,100,15);
            add(planesLabel);

            String[] planes = {"Passenger","Cargo"};

            JComboBox<String> planesComboBox = new JComboBox<>(planes);
            planesComboBox.setBounds(30,33,110,20);
            add(planesComboBox);

            JLabel seatingCapacityLabel = new JLabel("Input seating capacity:");
            seatingCapacityLabel.setBounds(30,60,150,15);
            add(seatingCapacityLabel);

            JTextField seatingCapacityTxtField = new JTextField();
            seatingCapacityTxtField.setBounds(30,80,90,18);
            add(seatingCapacityTxtField);

            JLabel modelLabel = new JLabel("Input model:");
            modelLabel.setBounds(30,105,150,15);
            add(modelLabel);

            JTextField modelTxtField = new JTextField();
            modelTxtField.setBounds(30,120,90,18);
            add(modelTxtField);


            JButton cancel = new JButton("cancel");
            cancel.setBounds(105,190,80,20);
            cancel.addActionListener(e -> dispose());
            add(cancel);

            JButton confirm = new JButton("confirm");
            confirm.setBounds(15,190,80,20);
            confirm.addActionListener(e -> {
                int seatingCapacity = Integer.parseInt(seatingCapacityTxtField.getText());
                String type = planes[planesComboBox.getSelectedIndex()];
                String model = modelTxtField.getText();
                Plane plane = null;
                switch (type) {
                    case "Passenger" ->  plane = new PassengerPlane(seatingCapacity,model);
                    case "Cargo" -> plane = new CargoPlane(seatingCapacity,model);
                }

                airCompany.addPlane(plane);
                listModel.addElement(plane);
                totalCapacityLabel.setText("Total capacity: " + airCompany.getTotalCapacity());
                dispose();
            });
            add(confirm);

        }
    }

    public static class EditButtonDialog extends JDialog {
        private final int selectedIndex;
        public EditButtonDialog(Frame owner, int selectedIndex) {
            super(owner,"edit");
            this.selectedIndex = selectedIndex;
            setSize(200,250);
            setLocationRelativeTo(null);
            setLayout(null);
            initComponents();
            setVisible(true);
        }

        private void initComponents() {
            JLabel seatingCapacityLabel = new JLabel("Input seating capacity:");
            seatingCapacityLabel.setBounds(30,30,150,15);
            add(seatingCapacityLabel);

            JTextField seatingCapacityTxtField = new JTextField();
            seatingCapacityTxtField.setBounds(30,50,90,18);
            add(seatingCapacityTxtField);

            JLabel modelLabel = new JLabel("Input model:");
            modelLabel.setBounds(30,80,150,15);
            add(modelLabel);

            JTextField modelTxtField = new JTextField();
            modelTxtField.setBounds(30,100,90,18);
            add(modelTxtField);


            JButton cancel = new JButton("cancel");
            cancel.setBounds(105,190,80,20);
            cancel.addActionListener(e -> dispose());
            add(cancel);

            JButton confirm = new JButton("confirm");
            confirm.setBounds(15,190,80,20);
            confirm.addActionListener(e -> {
                int seatingCapacity = Integer.parseInt(seatingCapacityTxtField.getText());
                String model = modelTxtField.getText();
                airCompany.getPlane(selectedIndex).setSeatingCapacity(seatingCapacity);
                airCompany.getPlane(selectedIndex).setModel(model);
                listModel.getElementAt(selectedIndex).setSeatingCapacity(seatingCapacity);
                listModel.getElementAt(selectedIndex).setModel(model);
                totalCapacityLabel.setText("Total capacity: " + airCompany.getTotalCapacity());
                dispose();
            });
            add(confirm);
        }

    }


}
