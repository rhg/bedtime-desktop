package com.rhg135.bedtime.desktop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.rhg135.bedtime.utils.IterableBedtimes;

public class BedtimesGUI implements Runnable {

	public static final String APP_NAME = "Bedtimes";
	public static final Color RED = new Color(255, 0, 0);
	public static final Color GREEN = new Color(0, 255, 0);
	public static Dimension preferedDimension = new Dimension(300, 100);
	public Integer minimum = 6;
	public Integer length = 4;
	
	public static boolean isNumber(String tehText) {
		try {
			Double.parseDouble(tehText);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public static void main(String[] args) {
		if (args.length != 0) {
			System.err.println("USAGE: java BedtimesGUI");
			System.exit(2);
		}
		SwingUtilities.invokeLater(new BedtimesGUI());
	}
	
	public void run() {
		JFrame frame = new JFrame(APP_NAME);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		final JTextField textField = new JTextField();
		textField.setOpaque(true);
		textField.setBackground(RED);
		
		JButton button = new JButton("Calculate");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (BedtimesGUI.isNumber(textField.getText())) {
					textField.setBackground(GREEN);
					Number num = Double.parseDouble(textField.getText());
					for (Number t: new IterableBedtimes(minimum, length, num)) {
						System.err.println("Time: " + t);
					}
					} else {
					textField.setBackground(RED);
				}
			}
		});
		frame.getContentPane().add(textField, BorderLayout.NORTH);
		frame.getContentPane().add(button);
		
		frame.setPreferredSize(preferedDimension);
		frame.pack();
		frame.setVisible(true);
	}

}