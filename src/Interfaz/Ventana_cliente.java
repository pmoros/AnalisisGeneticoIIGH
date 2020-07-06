package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana_cliente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_cliente frame = new Ventana_cliente();
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
	public Ventana_cliente() {
		setTitle("An\u00E1lisis IIGH (Cliente)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblNewLabel.setBounds(60, 50, 101, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Qu\u00E9 desea hacer");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNewLabel_1.setBounds(60, 106, 165, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Pedir An\u00E1lisis");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pedir_análisis frame = new Pedir_análisis();
		        frame.setVisible (true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		btnNewButton.setBounds(90, 181, 101, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ver informes");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		btnNewButton_1.setBounds(242, 181, 101, 23);
		contentPane.add(btnNewButton_1);
	}

}
