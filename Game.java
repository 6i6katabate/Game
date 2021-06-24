package com.elsys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class Game {

	private JFrame frmMagesVsArchers;
	private JButton mageEndTurnBtn;
	private JButton archerEndTurnBtn;
	private Mage mage;
	private Archer archer;
	private Bow bow;
	private Scroll scroll;
	private Potion potion;
	private Note note;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game window = new Game();
					window.frmMagesVsArchers.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Game() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMagesVsArchers = new JFrame();
		frmMagesVsArchers.getContentPane().setBackground(new Color(102, 102, 153));
		frmMagesVsArchers.setTitle("Mages&Archers");
		frmMagesVsArchers.setBounds(100, 100, 957, 577);
		frmMagesVsArchers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMagesVsArchers.setResizable(false);
		frmMagesVsArchers.getContentPane().setLayout(null);
		

		TextArea textArea = new TextArea();
//		textArea.setWrapStyleWord(true);
//		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));
		textArea.setForeground(new Color(255, 255, 0));
		textArea.setBackground(new Color(102, 102, 102));
		textArea.setBounds(409, 88, 509, 423);
		frmMagesVsArchers.getContentPane().add(textArea);
		
	
		
		JLabel lblNewLabel = new JLabel("Game Overview");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setBackground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(589, 54, 162, 23);
		frmMagesVsArchers.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mage");
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(23, 134, 43, 23);
		frmMagesVsArchers.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Health:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setForeground(new Color(255, 255, 0));
		lblNewLabel_2.setBounds(23, 168, 53, 23);
		frmMagesVsArchers.getContentPane().add(lblNewLabel_2);
		
		JLabel mageHealthLabel = new JLabel("60");
		mageHealthLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mageHealthLabel.setBounds(82, 172, 48, 14);
		frmMagesVsArchers.getContentPane().add(mageHealthLabel);
		
		JLabel lblNewLabel_4 = new JLabel("/ 60");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(114, 170, 48, 18);
		frmMagesVsArchers.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_2_1 = new JLabel("Mana: ");
		lblNewLabel_2_1.setForeground(Color.YELLOW);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(163, 168, 53, 23);
		frmMagesVsArchers.getContentPane().add(lblNewLabel_2_1);
		
		JLabel mageManaLabel = new JLabel("80");
		mageManaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mageManaLabel.setBounds(214, 172, 48, 14);
		frmMagesVsArchers.getContentPane().add(mageManaLabel);
		
		JLabel lblNewLabel_4_1 = new JLabel("/ 80");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(230, 170, 48, 18);
		frmMagesVsArchers.getContentPane().add(lblNewLabel_4_1);
		
		JRadioButton mageAttackRdbtn = new JRadioButton("Attack with Scroll");
		mageAttackRdbtn.setEnabled(false);
		mageAttackRdbtn.setBackground(new Color(102, 102, 153));
		mageAttackRdbtn.setBounds(21, 198, 141, 23);
		frmMagesVsArchers.getContentPane().add(mageAttackRdbtn);
		
		JRadioButton magePotionRdbtn = new JRadioButton("Use Potion");
		magePotionRdbtn.setEnabled(false);
		magePotionRdbtn.setBackground(new Color(102, 102, 153));
		magePotionRdbtn.setBounds(163, 198, 94, 23);
		frmMagesVsArchers.getContentPane().add(magePotionRdbtn);
		
		JRadioButton mageNoteRdbtn = new JRadioButton("Use Note");
		mageNoteRdbtn.setEnabled(false);
		mageNoteRdbtn.setBackground(new Color(102, 102, 153));
		mageNoteRdbtn.setBounds(263, 198, 124, 23);
		frmMagesVsArchers.getContentPane().add(mageNoteRdbtn);
		
		ButtonGroup mageRadioButtons = new ButtonGroup();
		mageRadioButtons.add(mageAttackRdbtn);
		mageRadioButtons.add(magePotionRdbtn);
		mageRadioButtons.add(mageNoteRdbtn);
		
		JLabel archerHealthLabel = new JLabel("100");
		archerHealthLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		archerHealthLabel.setBounds(82, 343, 48, 14);
		frmMagesVsArchers.getContentPane().add(archerHealthLabel);
		
		JRadioButton archerAttackRdbtn = new JRadioButton("Attack with Bow");
		archerAttackRdbtn.setEnabled(false);
		archerAttackRdbtn.setBackground(new Color(102, 102, 153));
		archerAttackRdbtn.setBounds(21, 369, 124, 23);
		frmMagesVsArchers.getContentPane().add(archerAttackRdbtn);
		
		JRadioButton archerPotionRdbtn = new JRadioButton("Use Potion");
		archerPotionRdbtn.setEnabled(false);
		archerPotionRdbtn.setBackground(new Color(102, 102, 153));
		archerPotionRdbtn.setBounds(163, 369, 94, 23);
		frmMagesVsArchers.getContentPane().add(archerPotionRdbtn);
		
		JRadioButton archerNoteRdbtn = new JRadioButton("Use Note");
		archerNoteRdbtn.setEnabled(false);
		archerNoteRdbtn.setBackground(new Color(102, 102, 153));
		archerNoteRdbtn.setBounds(263, 369, 124, 23);
		frmMagesVsArchers.getContentPane().add(archerNoteRdbtn);
		
		ButtonGroup archerRadioButtons = new ButtonGroup();
		archerRadioButtons.add(archerAttackRdbtn);
		archerRadioButtons.add(archerPotionRdbtn);
		archerRadioButtons.add(archerNoteRdbtn);
		
		mageEndTurnBtn = new JButton("END TURN");
		mageEndTurnBtn.setForeground(new Color(255, 255, 0));
		mageEndTurnBtn.setBackground(new Color(102, 102, 102));
		mageEndTurnBtn.setEnabled(false);
		mageEndTurnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				archerEndTurnBtn.setEnabled(true);
				mageEndTurnBtn.setEnabled(false);
				
				if(mageAttackRdbtn.isSelected()) {
					textArea.append(scroll.use(mage, archer));
					if(mage.getCurrentMana() <= 0) {
						textArea.append("\n0 MANA LEFT!");
					}
				}else if(magePotionRdbtn.isSelected()) {
					textArea.append(potion.consume(mage));
				}else if(mageNoteRdbtn.isSelected()){
					textArea.append(note.use(mage, archer));
				}
				mageRadioButtons.clearSelection();
				
				mageHealthLabel.setText(String.valueOf(mage.getCurrentHP()));
				mageManaLabel.setText(String.valueOf(mage.getCurrentMana()));
				archerHealthLabel.setText(String.valueOf(archer.getCurrentHP()));

				mageAttackRdbtn.setEnabled(false);
				magePotionRdbtn.setEnabled(false);
				mageNoteRdbtn.setEnabled(false);
				archerAttackRdbtn.setEnabled(true);
				archerPotionRdbtn.setEnabled(true);
				archerNoteRdbtn.setEnabled(true);
				
				
				if(archer.getCurrentHP() <= 0 || mage.getCurrentHP() <= 0) {
					textArea.append("\nGAME OVER! You can exit now!");
					mageEndTurnBtn.setEnabled(false);
					archerEndTurnBtn.setEnabled(false);
				}
			}
		});
		mageEndTurnBtn.setBounds(143, 237, 100, 34);
		frmMagesVsArchers.getContentPane().add(mageEndTurnBtn);
		
		JLabel lblNewLabel_1_1 = new JLabel("Archer");
		lblNewLabel_1_1.setForeground(Color.YELLOW);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(23, 305, 43, 23);
		frmMagesVsArchers.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Health:");
		lblNewLabel_2_2.setForeground(Color.YELLOW);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(23, 339, 53, 23);
		frmMagesVsArchers.getContentPane().add(lblNewLabel_2_2);
		
		
		
		JLabel lblNewLabel_4_2 = new JLabel("/ 100");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_2.setBounds(114, 341, 48, 18);
		frmMagesVsArchers.getContentPane().add(lblNewLabel_4_2);
		
		

		archerEndTurnBtn = new JButton("END TURN");
		archerEndTurnBtn.setForeground(new Color(255, 255, 0));
		archerEndTurnBtn.setBackground(new Color(102, 102, 102));
		archerEndTurnBtn.setEnabled(false);
		archerEndTurnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				archerEndTurnBtn.setEnabled(false);
				mageEndTurnBtn.setEnabled(true);
				
				if(archerAttackRdbtn.isSelected()) {
					textArea.append(bow.use(archer, mage));
				}else if(archerPotionRdbtn.isSelected()) {
					textArea.append(potion.consume(archer));
				}else if(archerNoteRdbtn.isSelected()) {
					textArea.append(note.use(archer, mage));
				}
				
				archerRadioButtons.clearSelection();
				
				archerHealthLabel.setText(String.valueOf(archer.getCurrentHP()));
				mageHealthLabel.setText(String.valueOf(mage.getCurrentHP()));
				mageManaLabel.setText(String.valueOf(mage.getCurrentMana()));
				
				archerAttackRdbtn.setEnabled(false);
				archerPotionRdbtn.setEnabled(false);
				archerNoteRdbtn.setEnabled(false);

				mageAttackRdbtn.setEnabled(true);
				magePotionRdbtn.setEnabled(true);
				mageNoteRdbtn.setEnabled(true);
				
				if(archer.getCurrentHP() <= 0 || mage.getCurrentHP() <= 0) {
					textArea.append("\nGAME OVER! You can exit now!");
					mageEndTurnBtn.setEnabled(false);
					archerEndTurnBtn.setEnabled(false);
				}
			}
		});
		archerEndTurnBtn.setBounds(143, 404, 100, 33);
		frmMagesVsArchers.getContentPane().add(archerEndTurnBtn);
		
		JLabel lblNewLabel_6 = new JLabel("Mages vs. Archers");
		lblNewLabel_6.setForeground(new Color(255, 255, 0));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(126, 54, 248, 23);
		frmMagesVsArchers.getContentPane().add(lblNewLabel_6);
		
		JButton startGameBtn = new JButton("START GAME");
		startGameBtn.setForeground(new Color(255, 255, 0));
		startGameBtn.setBackground(new Color(102, 102, 102));
		startGameBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				startGameBtn.setEnabled(false);
				startGameBtn.setText("GAME STARTED");
				textArea.append("GAME STARTED! It's Mage's turn first!");
				mageEndTurnBtn.setEnabled(true);
				
				mage = new Mage();
				archer = new Archer();
				
				potion = new Potion(20, 30);
				note = new Note("Come here and fight me!");
				
				scroll = new Scroll(35, 40);
				bow = new Bow(15);
				
				mageAttackRdbtn.setEnabled(true);
				magePotionRdbtn.setEnabled(true);
				mageNoteRdbtn.setEnabled(true);
			}
		});
		startGameBtn.setBounds(126, 485, 152, 42);
		frmMagesVsArchers.getContentPane().add(startGameBtn);
		
		
		JLabel lblNewLabel_5_1 = new JLabel("_________________________________________________");
		lblNewLabel_5_1.setForeground(Color.YELLOW);
		lblNewLabel_5_1.setBounds(23, 93, 362, 14);
		frmMagesVsArchers.getContentPane().add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("_________________________________________________");
		lblNewLabel_5_1_1.setForeground(Color.YELLOW);
		lblNewLabel_5_1_1.setBounds(25, 282, 362, 14);
		frmMagesVsArchers.getContentPane().add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_5_1_2 = new JLabel("_________________________________________________");
		lblNewLabel_5_1_2.setForeground(Color.YELLOW);
		lblNewLabel_5_1_2.setBounds(23, 444, 362, 14);
		frmMagesVsArchers.getContentPane().add(lblNewLabel_5_1_2);
		
		
	}
}
