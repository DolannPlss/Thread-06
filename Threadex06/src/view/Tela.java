package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ThreadCassino;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela extends JFrame {

	private JPanel contentPane;
	private JTextField tfNumero1;
	private JTextField tfNumero3;
	private JTextField tfNumero2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnjogar = new JButton("jogar");
		btnjogar.setBounds(335, 153, 89, 23);
		contentPane.add(btnjogar);
		
		tfNumero1 = new JTextField();
		tfNumero1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		tfNumero1.setBounds(39, 82, 86, 65);
		contentPane.add(tfNumero1);
		tfNumero1.setColumns(10);
		
		tfNumero3 = new JTextField();
		tfNumero3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		tfNumero3.setColumns(10);
		tfNumero3.setBounds(231, 82, 86, 65);
		contentPane.add(tfNumero3);
		
		tfNumero2 = new JTextField();
		tfNumero2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		tfNumero2.setColumns(10);
		tfNumero2.setBounds(135, 82, 86, 65);
		contentPane.add(tfNumero2);
	ActionListener jogar = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			btnjogar.setVisible(false);
			for (int op = 0; op < 3; op++) {
				Thread ThreadCassino = new ThreadCassino(tfNumero1,tfNumero2,tfNumero3,op,btnjogar);
				ThreadCassino.start();
			}
		}
	};
	
	btnjogar.addActionListener(jogar);
	}
	
}
