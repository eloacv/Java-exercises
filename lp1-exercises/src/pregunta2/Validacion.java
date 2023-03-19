package pregunta3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class Validacion extends JFrame {

	private JPanel contentPane;
	private JTextField txtWeb;
	private JTextField txtArea;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Validacion frame = new Validacion();
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
	public Validacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VALIDACI\u00D3N DE FORMATOS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(230, 33, 266, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("INGRESE DIRECCI\u00D3N WEB");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(59, 116, 161, 16);
		contentPane.add(lblNewLabel_1);
		
		
		JTextArea txtArea = new JTextArea();
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		txtArea.setBorder(BorderFactory.createCompoundBorder(border, 
	            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		txtArea.setBounds(59, 244, 586, 153);
		contentPane.add(txtArea);
		
		txtWeb = new JTextField();
		txtWeb.setBounds(254, 113, 390, 22);
		contentPane.add(txtWeb);
		txtWeb.setColumns(10);
		
		JButton btnValidar = new JButton("Validar");
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String patron = "(http://)(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?";
				String texto=txtWeb.getText();
				if (Pattern.matches(patron, texto)){
					txtArea.setText("URL correcta");
				}
				else {
					txtArea.setText("URL incorrecta");
				}	
		}
		}
		);
		btnValidar.setBounds(123, 185, 97, 25);
		contentPane.add(btnValidar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtWeb.setText("");
				txtArea.setText("");
			}
		});
		btnLimpiar.setBounds(486, 185, 97, 25);
		contentPane.add(btnLimpiar);

		
	}

}
