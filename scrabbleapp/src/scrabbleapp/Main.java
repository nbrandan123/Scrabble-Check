package scrabbleapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

	// frame is generating the button
	// each lett represents a cell in which the user will input a character
	// Button to initiate function of app
	private JFrame frame;
	private JTextField lett1;
	private JTextField lett2;
	private JTextField lett3;
	private JTextField lett4;
	private JTextField lett5;
	private JTextField lett6;
	private JTextField lett7;
	private JButton btnGo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 446, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 411, 382);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel swOutput = new JLabel("Your list of scrabble words will appear here.");
		swOutput.setFont(new Font("Tahoma", Font.PLAIN, 14));
		swOutput.setVerticalAlignment(SwingConstants.TOP);
		swOutput.setBounds(10, 11, 391, 360);
		panel.add(swOutput);
		
		lett1 = new JTextField();
		lett1.setHorizontalAlignment(SwingConstants.CENTER);
		lett1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lett1.setBounds(10, 440, 50, 50);
		frame.getContentPane().add(lett1);
		lett1.setColumns(10);
		
		JButton btnGen = new JButton("Random Letters");
		btnGen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Lettergen lettergen = new Lettergen();
				char[] letters = lettergen.getLetters();
				lett1.setText(String.valueOf(letters[0]));
				lett2.setText(String.valueOf(letters[1]));
				lett3.setText(String.valueOf(letters[2]));
				lett4.setText(String.valueOf(letters[3]));
				lett5.setText(String.valueOf(letters[4]));
				lett6.setText(String.valueOf(letters[5]));
				lett7.setText(String.valueOf(letters[6]));
			}
		});
		btnGen.setBounds(10, 406, 200, 23);
		frame.getContentPane().add(btnGen);
		
		lett2 = new JTextField();
		lett2.setHorizontalAlignment(SwingConstants.CENTER);
		lett2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lett2.setColumns(10);
		lett2.setBounds(70, 440, 50, 50);
		frame.getContentPane().add(lett2);
		
		lett3 = new JTextField();
		lett3.setHorizontalAlignment(SwingConstants.CENTER);
		lett3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lett3.setColumns(10);
		lett3.setBounds(130, 440, 50, 50);
		frame.getContentPane().add(lett3);
		
		lett4 = new JTextField();
		lett4.setHorizontalAlignment(SwingConstants.CENTER);
		lett4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lett4.setColumns(10);
		lett4.setBounds(190, 440, 50, 50);
		frame.getContentPane().add(lett4);
		
		lett5 = new JTextField();
		lett5.setHorizontalAlignment(SwingConstants.CENTER);
		lett5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lett5.setColumns(10);
		lett5.setBounds(250, 440, 50, 50);
		frame.getContentPane().add(lett5);
		
		lett6 = new JTextField();
		lett6.setHorizontalAlignment(SwingConstants.CENTER);
		lett6.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lett6.setColumns(10);
		lett6.setBounds(310, 440, 50, 50);
		frame.getContentPane().add(lett6);
		
		lett7 = new JTextField();
		lett7.setHorizontalAlignment(SwingConstants.CENTER);
		lett7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lett7.setColumns(10);
		lett7.setBounds(371, 440, 50, 50);
		frame.getContentPane().add(lett7);
		
		btnGo = new JButton("Generate Words");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Get the letters from the JTextFields
				String letters = lett1.getText() + lett2.getText() + lett3.getText() + lett4.getText() + lett5.getText() + lett6.getText() + lett7.getText();
				// Check String for valid length
				if (letters.length() != 7) {
					swOutput.setText("Please enter exactly 7 letters.");
					return;
				}
				// Check String for valid characters
				if (!letters.matches("[a-zA-Z]+")) {
					swOutput.setText("Please enter only letters.");
					return;
				}
				
				// Create a new Wordgen object out of letters
				// Then run it against the dictionary.txt to pull valid words out based on the letters
				Wordgen wordgen = new Wordgen(letters);
				String[] words = wordgen.generateWords(letters);
				
				
				// Display the words in the JLabel, stopping when reaching first null value
				StringBuilder sb = new StringBuilder();
				for (String word : words) {
					if (word == null) {
						break;
					}
					sb.append(word).append(", ");
				}
				swOutput.setText("<html>" + sb.toString().replaceAll("\n", "<br>") + "</html>");
			}
		});
		btnGo.setBounds(221, 407, 200, 23);
		frame.getContentPane().add(btnGo);
		
		
		// Add a DocumentListener to each tile to automatically transfer focus to the next JTextField when a letter is entered
		lett1.getDocument().addDocumentListener(new DocumentListener() {
		    private void checkLength() {
		        
		        if (lett1.getText().length() == 1) {
		            // Transfer focus to the next component
		            lett2.requestFocusInWindow(); 
		        }
		    }
		    

		    @Override
		    public void insertUpdate(DocumentEvent e) { checkLength(); }

		    @Override
		    public void removeUpdate(DocumentEvent e) { checkLength(); }

		    @Override
		    public void changedUpdate(DocumentEvent e) { checkLength(); }
		});
		
		lett2.getDocument().addDocumentListener(new DocumentListener() {
		    private void checkLength() {
		        
		        if (lett2.getText().length() == 1) {
		            // Transfer focus to the next component
		            lett3.requestFocusInWindow(); 
		        }
		    }
		    

		    @Override
		    public void insertUpdate(DocumentEvent e) { checkLength(); }

		    @Override
		    public void removeUpdate(DocumentEvent e) { checkLength(); }

		    @Override
		    public void changedUpdate(DocumentEvent e) { checkLength(); }
		});
		
		lett3.getDocument().addDocumentListener(new DocumentListener() {
		    private void checkLength() {
		        
		        if (lett3.getText().length() == 1) {
		            // Transfer focus to the next component
		            lett4.requestFocusInWindow(); 
		        }
		    }
		    

		    @Override
		    public void insertUpdate(DocumentEvent e) { checkLength(); }

		    @Override
		    public void removeUpdate(DocumentEvent e) { checkLength(); }

		    @Override
		    public void changedUpdate(DocumentEvent e) { checkLength(); }
		});
		
		lett4.getDocument().addDocumentListener(new DocumentListener() {
		    private void checkLength() {
		        
		        if (lett4.getText().length() == 1) {
		            // Transfer focus to the next component
		            lett5.requestFocusInWindow(); 
		        }
		    }
		    

		    @Override
		    public void insertUpdate(DocumentEvent e) { checkLength(); }

		    @Override
		    public void removeUpdate(DocumentEvent e) { checkLength(); }

		    @Override
		    public void changedUpdate(DocumentEvent e) { checkLength(); }
		});
		
		lett5.getDocument().addDocumentListener(new DocumentListener() {
		    private void checkLength() {
		        
		        if (lett5.getText().length() == 1) {
		            // Transfer focus to the next component
		            lett6.requestFocusInWindow(); 
		        }
		    }
		    

		    @Override
		    public void insertUpdate(DocumentEvent e) { checkLength(); }

		    @Override
		    public void removeUpdate(DocumentEvent e) { checkLength(); }

		    @Override
		    public void changedUpdate(DocumentEvent e) { checkLength(); }
		});
		
		lett6.getDocument().addDocumentListener(new DocumentListener() {
		    private void checkLength() {
		        
		        if (lett6.getText().length() == 1) {
		            // Transfer focus to the next component
		            lett7.requestFocusInWindow(); 
		        }
		    }
		    

		    @Override
		    public void insertUpdate(DocumentEvent e) { checkLength(); }

		    @Override
		    public void removeUpdate(DocumentEvent e) { checkLength(); }

		    @Override
		    public void changedUpdate(DocumentEvent e) { checkLength(); }
		});
		
		// Set the initial focus to the first JTextField when the application starts
		frame.addWindowFocusListener(new WindowAdapter() {
		    @Override
		    public void windowGainedFocus(WindowEvent e) {
		        lett1.requestFocusInWindow();
		    }
		});
	}
}
