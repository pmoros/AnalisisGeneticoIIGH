package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Actualizar extends JFrame {

	private JPanel contentPane;
	private JTextField textField_cod;
	private JTextField textField_1_nom;
	private JTextField textField_2_date;
	private JTextField textField_3_col;
	private JTextField textField_4_sex;
	private JTextField textField_5_micro;
	private JTextField textField_6_gen;
	private JTextField textField_7_and;
	private JTextField textField_8_codp;
	private JTextField textField_9_codm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Actualizar frame = new Actualizar();
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
	public Actualizar() {
		setTitle("Actualizar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Actualizar");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		lblNewLabel.setBounds(60, 40, 107, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_1.setBounds(90, 115, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_2.setBounds(90, 140, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblColor.setBounds(90, 190, 46, 14);
		contentPane.add(lblColor);
		
		JLabel lblFechaDeNacimineto = new JLabel("Fecha de nacimineto");
		lblFechaDeNacimineto.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblFechaDeNacimineto.setBounds(90, 165, 107, 14);
		contentPane.add(lblFechaDeNacimineto);
		
		JLabel lblMicrochip = new JLabel("Microchip");
		lblMicrochip.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblMicrochip.setBounds(90, 240, 68, 14);
		contentPane.add(lblMicrochip);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblSexo.setBounds(90, 215, 46, 14);
		contentPane.add(lblSexo);
		
		textField_cod = new JTextField();
		textField_cod.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		textField_cod.setBounds(217, 109, 142, 20);
		contentPane.add(textField_cod);
		textField_cod.setColumns(10);
		
		textField_1_nom = new JTextField();
		textField_1_nom.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		textField_1_nom.setBounds(217, 134, 142, 20);
		contentPane.add(textField_1_nom);
		textField_1_nom.setColumns(10);
		
		textField_2_date = new JTextField();
		textField_2_date.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		textField_2_date.setBounds(217, 159, 142, 20);
		contentPane.add(textField_2_date);
		textField_2_date.setColumns(10);
		
		textField_3_col = new JTextField();
		textField_3_col.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		textField_3_col.setBounds(217, 184, 142, 20);
		contentPane.add(textField_3_col);
		textField_3_col.setColumns(10);
		
		textField_4_sex = new JTextField();
		textField_4_sex.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		textField_4_sex.setBounds(217, 209, 142, 20);
		contentPane.add(textField_4_sex);
		textField_4_sex.setColumns(10);
		
		textField_5_micro = new JTextField();
		textField_5_micro.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		textField_5_micro.setBounds(217, 234, 142, 20);
		contentPane.add(textField_5_micro);
		textField_5_micro.setColumns(10);		
		
		JLabel lblGenotipo = new JLabel("Genotipo");
		lblGenotipo.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblGenotipo.setBounds(90, 265, 46, 14);
		contentPane.add(lblGenotipo);
		
		JLabel lblAndar = new JLabel("Andar");
		lblAndar.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblAndar.setBounds(90, 290, 46, 14);
		contentPane.add(lblAndar);
		
		JLabel lblCdigoPadre = new JLabel("C\u00F3digo padre");
		lblCdigoPadre.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblCdigoPadre.setBounds(90, 315, 89, 14);
		contentPane.add(lblCdigoPadre);
		
		JLabel lblCdigoMadre = new JLabel("C\u00F3digo madre");
		lblCdigoMadre.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblCdigoMadre.setBounds(90, 340, 89, 14);
		contentPane.add(lblCdigoMadre);
		
		textField_6_gen = new JTextField();
		textField_6_gen.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		textField_6_gen.setColumns(10);
		textField_6_gen.setBounds(217, 259, 142, 20);
		contentPane.add(textField_6_gen);
		
		textField_7_and = new JTextField();
		textField_7_and.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		textField_7_and.setColumns(10);
		textField_7_and.setBounds(217, 284, 142, 20);
		contentPane.add(textField_7_and);
		
		textField_8_codp = new JTextField();
		textField_8_codp.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		textField_8_codp.setColumns(10);
		textField_8_codp.setBounds(217, 309, 142, 20);
		contentPane.add(textField_8_codp);
		
		textField_9_codm = new JTextField();
		textField_9_codm.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		textField_9_codm.setColumns(10);
		textField_9_codm.setBounds(217, 334, 142, 20);
		contentPane.add(textField_9_codm);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Bienvenida.app.add_horse(Long.parseLong(textField_cod.getText()), textField_1_nom.getText(), textField_2_date.getText(), textField_3_col.getText(), textField_4_sex.getText(), textField_5_micro.getText(), textField_6_gen.getText(), textField_7_and.getText(), Long.parseLong(textField_8_codp.getText()), Long.parseLong(textField_9_codm.getText()));
					JOptionPane.showMessageDialog(null,"Insercion correcta");
				} catch (NumberFormatException e1) {					
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		btnNewButton.setBounds(123, 403, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_capturista frame = new Ventana_capturista();
		        frame.setVisible (true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		btnNewButton_1.setBounds(249, 403, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
