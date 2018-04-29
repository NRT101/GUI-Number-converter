import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class ConverterMain implements ActionListener {
	private String output="";
	private JLabel label = new JLabel("Output: "+output);
	private JFrame frame = new JFrame();
	private JTextField input;
    private ButtonGroup group = new ButtonGroup();
    private numConverter num = new numConverter();
	
	/*
	 * Button actions and output change
	 */
	public void actionPerformed(ActionEvent e) {
		String type =group.getSelection().getActionCommand().toString();
		num.setNumber(input.getText());
		if(e.getActionCommand().equals("Convert To Binary")){
			num.getBinary(type);
			output=num.getNumber();
			label.setText("Output: "+output);
		}
		else if(e.getActionCommand().equals("Convert To Decimal")){
			num.getDecimal(type);
			output=num.getNumber();
			label.setText("Output: "+output);
		}
		else if(e.getActionCommand().equals("Convert To Hexadecimal")){
			num.getHexadecimal(type);
			output=num.getNumber();
			label.setText("Output: "+output);
		}
	}
	public ConverterMain(){
		 // the clickable buttons
        JButton toBinary = new JButton("Convert To Binary");
        toBinary.addActionListener(this);
        JButton toDecimal = new JButton("Convert To Decimal");
        toDecimal.addActionListener(this);
        JButton toHexidecimal = new JButton("Convert To Hexadecimal");
        toHexidecimal.addActionListener(this);
        
        // The text field for input
        input=new JTextField(10);
        input.addActionListener(this);
        
        // the radio buttons
      //Create the radio buttons.
        JRadioButton deciButton = new JRadioButton("Decimal");
        deciButton.setMnemonic(KeyEvent.VK_B);
        deciButton.setActionCommand("Decimal");
        deciButton.setSelected(true);

        JRadioButton binButton = new JRadioButton("Binary");
        binButton.setMnemonic(KeyEvent.VK_C);
        binButton.setActionCommand("Binary");

        JRadioButton hexiButton = new JRadioButton("Hexadecimal");
        hexiButton.setMnemonic(KeyEvent.VK_D);
        hexiButton.setActionCommand("Hexadecimal");


        //Group the radio buttons.
        group.add(deciButton);
        group.add(binButton);
        group.add(hexiButton);
        
        //Register a listener for the radio buttons.
        deciButton.addActionListener(this);
        binButton.addActionListener(this);
        hexiButton.addActionListener(this);
        
      //Put the radio buttons in a row in a panel.
        JPanel radioPanel = new JPanel(new GridLayout(1, 4));
        JLabel inputTypeLabel = new JLabel("Input Type:");
        radioPanel.add(inputTypeLabel);
        radioPanel.add(deciButton);
        radioPanel.add(binButton);
        radioPanel.add(hexiButton);
        
        // the panels with the button and text
        JPanel MainPanel = new JPanel();
        MainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        MainPanel.setLayout(new GridLayout(7, 1));
        
        JPanel ButtonPanel=new JPanel();
        ButtonPanel.add(toBinary);
        ButtonPanel.add(toDecimal);
        ButtonPanel.add(toHexidecimal);
        
        JPanel TextPanel=new JPanel();
        JLabel inputLabel = new JLabel("Input:  ");
        TextPanel.add(inputLabel,BorderLayout.WEST);
        TextPanel.add(input,BorderLayout.CENTER);
        
        JPanel OutputPanel=new JPanel();
        OutputPanel.add(label);
        
        // The program description
        JLabel DefLabel1 = new JLabel("Welcome to the Number Converter.");
        JLabel DefLabel2 = new JLabel("This program converts any binary, hexadecimal, positive integer to binary, hexadecimal, or positive integer.");
        JLabel DefLabel3 = new JLabel("Note that the hexadecimal number does not have the prefix '0x'.");
        
        // Creating the main panel
        MainPanel.add(DefLabel1);
        MainPanel.add(DefLabel2);
        MainPanel.add(DefLabel3);
        MainPanel.add(ButtonPanel);
        MainPanel.add(radioPanel);
        MainPanel.add(TextPanel);
        MainPanel.add(OutputPanel);
        
        // set up the frame and display it
        frame.add(MainPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Number Format Converter");
        frame.pack();
        frame.setVisible(true);

	}
	public static void main(String[] args){
		new ConverterMain();
	}
}
