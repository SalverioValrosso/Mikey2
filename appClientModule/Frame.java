
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Frame implements ActionListener {
	JButton button = new JButton("START");
	JButton status = new JButton("");
	
	int WINDOW_SIZE_X = 400;
	int WINDOW_SIZE_Y = 130;
	
	
	Frame() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		button.addActionListener(this);
		
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		Dimension size = button.getPreferredSize();
									//lunghezza altezza
		button.setBounds(20, 25, size.width+10, size.height);
		status.setBounds(220, 25, 140, size.height);
		status.setBorderPainted(false);
		status.setBackground(Color.RED);
		status.setFocusPainted(false);
		status.setVisible(false);
		
		panel.setLayout(null);
		panel.add(button);
		panel.add(status);
		//panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		frame.add(panel);
		frame.getRootPane().setDefaultButton(button); // sets default button
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					//lunghezza , altezza
		frame.setSize(WINDOW_SIZE_X, WINDOW_SIZE_Y);
		frame.setLocationRelativeTo(null);
		//frame.setUndecorated(true);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/res/icon.png")));
		frame.setVisible(true);

	}
	


	public void actionPerformed(ActionEvent e) {
		status.setVisible(true);
		if (!Main.active) {
			Main.active = true;
			try {
				button.setText("STOP");
				status.setBackground(Color.GREEN);
				status.setText("Running...");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else {
			Main.active = false;
			try {
				button.setText("START");
				status.setBackground(Color.RED);
				status.setText("Stopped");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}

}