package passwordstrength;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class passapp {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					passapp window = new passapp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public passapp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(36, 42, 200, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(280, 11, 244, 139);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Its Strength is:");
		lblNewLabel_1.setBounds(10, 11, 109, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblScore = new JLabel("[SCORE]");
		lblScore.setBounds(125, 11, 109, 14);
		panel.add(lblScore);
		
		JLabel lblNewLabel_2 = new JLabel(":|");
		lblNewLabel_2.setFont(new Font("Viner Hand ITC", Font.PLAIN, 25));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 36, 224, 92);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Enter Password Here:");
		lblNewLabel.setBounds(36, 28, 200, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnCheck = new JButton("Check Strength");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pw = textField.getText();
				lblScore.setText(testScore(pw));
				if (lblScore.getText() == "DECENT") {
					lblNewLabel_2.setText(":)");
				}
				else {
					lblNewLabel_2.setText(":(");
				}
			}
		});
		btnCheck.setBounds(59, 73, 154, 38);
		frame.getContentPane().add(btnCheck);
	}
	
	public String testScore(String pass) {
		// METHOD TO TEST STRENGTH OF PASSWORD
		// First checks that password is not too long
		if (pass.length() > 12) {
			return "TOO LONG";
		}
		// Then check for too short
		else if (pass.length() < 8) {
			return "TOO SHORT";
		}
		// Then make sure it has no spaces
		else if (pass.indexOf(" ") >= 0) {
			return "NO SPACES";
		}
		// Finally, detects if there's any letters that repeat back-to-back more than once;
		else {
			for (int i = 0; i < pass.length()-2; i++) {
				char temp1 = pass.charAt(i);
				char temp2 = pass.charAt(i+1);
				char temp3 = pass.charAt(i+2);
				
				if (temp1 == temp2 && temp2 == temp3) {
					return "WEAK";
				}
			}
		}
		return "DECENT";
	}
}
