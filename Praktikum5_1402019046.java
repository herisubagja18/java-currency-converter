import java.util.regex.Pattern;
import java.awt.event.*;
import java.awt.*;
import java.text.DecimalFormat;
import javax.swing.*;

public class Praktikum5_1402019046 extends JFrame implements ActionListener {
    
    JPanel mainPanel, panel1, panel2, panel3, panel4;
    JLabel lblInput, lblFrom, lblTo, lblResult;
    JTextField txtInput, txtResult;
    JComboBox mataUang;
    JRadioButton radioIdr, radioUsd, radioEuro, radioDinar;
    JButton btnSubmit;
    ButtonGroup groupRadio;
    DefaultListCellRenderer listRenderer;
    
    final double usd = 14513;
    final double euro = 16388;
    final double dinar = 48020;
    String[] mataUangNegara = new String[]{"IDR", "USD", "EURO", "DINAR"};
    
    public Praktikum5_1402019046() {
        super("1402019046");
        setSize(350, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setBackground(new Color(51, 153, 255));
        
        init();
        panel1.add(lblInput);
        panel1.add(txtInput);
        panel1.add(lblFrom);
        panel1.add(mataUang);
        panel1.add(lblTo);
        
        panel2.add(radioIdr);
        panel2.add(radioUsd);
        panel2.add(radioEuro);
        panel2.add(radioDinar);
        
        panel3.add(lblResult);
        panel3.add(txtResult);
        panel3.add(btnSubmit);
        
        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.add(panel3);

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // check number
                if (Pattern.matches("^[0-9]+$", txtInput.getText())) {
                    if (mataUang.getSelectedIndex() == 1 && radioIdr.isSelected()) {
                        double result = (Double.parseDouble(txtInput.getText()) * 14513);
                        txtResult.setText("Rp. " + (int) result);
                    } else if (mataUang.getSelectedIndex() == 1 && radioEuro.isSelected()) {
                        double result = (Double.parseDouble(txtInput.getText()) * 0.89);
                        txtResult.setText("Euro " + result);
                    } else if (mataUang.getSelectedIndex() == 1 && radioDinar.isSelected()) {
                        double result = (Double.parseDouble(txtInput.getText()) * 0.30);
                        txtResult.setText("Dinar " + result);
                    } else if (mataUang.getSelectedIndex() == 0 && radioUsd.isSelected()) {
                        double result = (Double.parseDouble(txtInput.getText()) / 14513);
                        txtResult.setText("USD " + new DecimalFormat("#######.##").format(result));
                    } else if (mataUang.getSelectedIndex() == 0 && radioEuro.isSelected()) {
                        double result = (Double.parseDouble(txtInput.getText()) / 16143.45);
                        txtResult.setText("Euro " + new DecimalFormat("#######.##").format(result));
                    } else if (mataUang.getSelectedIndex() == 0 && radioDinar.isSelected()) {
                        double result = (Double.parseDouble(txtInput.getText()) / 47236.85);
                        txtResult.setText("Dinar " + new DecimalFormat("#######.##").format(result));
                    } else if (mataUang.getSelectedIndex() == 2 && radioIdr.isSelected()) {
                        double result = (Double.parseDouble(txtInput.getText()) * 16148.96);
                        txtResult.setText("Rp. " + (int) result);
                    } else if (mataUang.getSelectedIndex() == 2 && radioUsd.isSelected()) {
                        double result = (Double.parseDouble(txtInput.getText()) * 1.13);
                        txtResult.setText("Usd " + new DecimalFormat("#######.##").format(result));
                    } else if (mataUang.getSelectedIndex() == 2 && radioDinar.isSelected()) {
                        double result = (Double.parseDouble(txtInput.getText()) * 1.13);
                        txtResult.setText("Dinar " + new DecimalFormat("#######.##").format(result));
                    } else if (mataUang.getSelectedIndex() == 3 && radioIdr.isSelected()) {
                        double result = (Double.parseDouble(txtInput.getText()) * 47248.86);
                        txtResult.setText("Rp. " + result);
                    } else if (mataUang.getSelectedIndex() == 3 && radioUsd.isSelected()) {
                        double result = (Double.parseDouble(txtInput.getText()) * 3.30);
                        txtResult.setText("USD " + new DecimalFormat("#######.##").format(result));
                    } else if (mataUang.getSelectedIndex() == 3 && radioEuro.isSelected()) {
                        double result = (Double.parseDouble(txtInput.getText()) * 2.92);
                        txtResult.setText("Euro " + new DecimalFormat("#######.##").format(result));
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Input harus angka!", "Gagal", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        add(mainPanel);
        setVisible(true);
    }
    
    private void init() {
        panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(270, 120));
        panel1.setBackground(new Color(51, 153, 255));
        panel1.setLayout(new FlowLayout(FlowLayout.LEADING));
        
        panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(293, 40));
        panel2.setBackground(new Color(51, 153, 255));
        panel2.setLayout(new FlowLayout(FlowLayout.LEADING, 14, 0));
        
        panel3 = new JPanel();
        panel3.setPreferredSize(new Dimension(180, 119));
        panel3.setBackground(new Color(51, 153, 255));
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 18));
        
        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(350, 350));
        mainPanel.setBackground(new Color(51, 153, 255));
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        lblInput = new JLabel("INPUT");
        lblFrom = new JLabel("FROM");
        lblTo = new JLabel("TO");
        lblResult = new JLabel("Result");
        
        txtInput = new JTextField(28);
        txtInput.setHorizontalAlignment(JTextField.CENTER);
        
        txtResult = new JTextField(18);
        txtResult.setBackground(Color.white);
        txtResult.setForeground(Color.black);
        txtResult.setHorizontalAlignment(JTextField.CENTER);
        txtResult.setEditable(false);
        
        mataUang = new JComboBox(mataUangNegara);
        mataUang.setSelectedIndex(1);

        listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        mataUang.setRenderer(listRenderer);
        mataUang.setBackground(Color.white);
        mataUang.setPreferredSize(new Dimension(255, 23));
        
        radioIdr = new JRadioButton("IDR");
        radioIdr.setBackground(new Color(51, 153, 255));
        radioUsd = new JRadioButton("USD");
        radioUsd.setBackground(new Color(51, 153, 255));
        radioEuro = new JRadioButton("EURO");
        radioEuro.setBackground(new Color(51, 153, 255));
        radioDinar = new JRadioButton("DINAR");
        radioDinar.setBackground(new Color(51, 153, 255));
        
        groupRadio = new ButtonGroup();
        groupRadio.add(radioIdr);
        groupRadio.add(radioUsd);
        groupRadio.add(radioEuro);
        groupRadio.add(radioDinar);
        
        btnSubmit = new JButton("SUBMIT");
        btnSubmit.setBackground(Color.white);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
        new Praktikum5_1402019046();
    }
    
}