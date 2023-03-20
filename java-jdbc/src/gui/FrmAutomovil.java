package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import entidad.Automovil;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import negocio.NegocioAutomovil;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class FrmAutomovil extends JFrame {
	
	private NegocioAutomovil ObjNA= new NegocioAutomovil();
	private DefaultTableModel tabla;
	private int item=0;
	private final int FILAS=50;
	private String Columnas []= {"ID-AUTO","MARCA", "NRO-PLACA","PRECIO", "STOCK", "FECHA-FABRICACION","ESTADO"};
	private Object Filas [][];
	private ArrayList<Automovil> Lista= new ArrayList<Automovil>();
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtmarca;
	private JTextField txtplaca;
	private JTextField txtprecio;
	private JTextField txtstock;
	private JTextField txtfecha;
	private JRadioButton rdbtnDisp =null;
	private JRadioButton rdbtnNodisp =null;
	private ButtonGroup bg = new ButtonGroup();
	private JTable MiTabla;

	//CREATING THE TABLE TO LIST ALL THE RECORDS FROM THE AUTOMOVIL DATABASE 
	private void cargarTable() {
		int i=0;
		tabla= new DefaultTableModel();
		Lista= ObjNA.ListarAutomovil();
		for (String c: Columnas)tabla.addColumn(c);
		Filas= new Object[Lista.size()][7];
		for(Automovil a: Lista) {
			Filas [i][0]= a.getIdAutomovil();
			Filas [i][1]= a.getMARCA();
			Filas [i][2]= a.getNUMPLACA();
			Filas [i][3]= a.getPRECIO();
			Filas [i][4]= a.getSTOCK();
			Filas [i][5]= a.getFECHAFABRICACION();
			Filas [i][6]= a.getESTADO();
			tabla.addRow(Filas[i]);
			i++;		
		}
		MiTabla.setModel(tabla);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAutomovil frame = new FrmAutomovil();
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
	//GUI
	public FrmAutomovil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRO DE AUTOMOVILES");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(42, 36, 208, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID-AUTOMOVIL");
		lblNewLabel_1.setBounds(27, 105, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("MARCA");
		lblNewLabel_2.setBounds(27, 144, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("NUMERO DE PLACA");
		lblNewLabel_3.setBounds(27, 183, 115, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("PRECIO");
		lblNewLabel_4.setBounds(27, 226, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("STOCK");
		lblNewLabel_5.setBounds(27, 275, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("FECHA FABRICACION");
		lblNewLabel_6.setBounds(27, 324, 106, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("ESTADO");
		lblNewLabel_7.setBounds(27, 375, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		txtID = new JTextField();
		txtID.setBounds(164, 102, 86, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtmarca = new JTextField();
		txtmarca.setBounds(164, 141, 86, 20);
		contentPane.add(txtmarca);
		txtmarca.setColumns(10);
		
		txtplaca = new JTextField();
		txtplaca.setBounds(164, 180, 86, 20);
		contentPane.add(txtplaca);
		txtplaca.setColumns(10);
		
		txtprecio = new JTextField();
		txtprecio.setBounds(164, 223, 86, 20);
		contentPane.add(txtprecio);
		txtprecio.setColumns(10);
		
		txtstock = new JTextField();
		txtstock.setBounds(164, 272, 86, 20);
		contentPane.add(txtstock);
		txtstock.setColumns(10);
		
		txtfecha = new JTextField();
		txtfecha.setBounds(164, 321, 86, 20);
		contentPane.add(txtfecha);
		txtfecha.setColumns(10);
		
		bg= new ButtonGroup();
		
		JRadioButton rdbtnDisp = new JRadioButton("Disponible");
		rdbtnDisp.setBounds(141, 371, 73, 23);
		contentPane.add(rdbtnDisp);
		
		JRadioButton rdbtnNodisp = new JRadioButton("No disponible");
		rdbtnNodisp.setBounds(234, 371, 89, 23);
		contentPane.add(rdbtnNodisp);
		
		bg.add(rdbtnDisp);
		bg.add(rdbtnNodisp);
		
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// VALIDATIONS FOR ALL THE FIELDS
				// THE ID SHOULD BE 8 CHARACTER 
				String patron= "[a-zA-Z0-9]{8}";
				String idp=txtID.getText();
				if (!Pattern.matches(patron, idp)){
				JOptionPane.showMessageDialog(null,"ID incorrecto");
				}
				
				// BRAND BETWEEN 5 AND 20 CHARACTERS
				String patron1= "[a-zA-Z]{5,20}";
				String marcap=txtmarca.getText();
				if (!Pattern.matches(patron1, marcap)){
				JOptionPane.showMessageDialog(null,"Marca incorrecta. Mínimo 5 caracteres");
				}
				
				// CAR PLATES THE FOLLOWING FORMAT "ABC-1234"
				String patron2="[a-zA-Z]{3}-[0-9]{4}";
				String placap=txtplaca.getText();
				if (!Pattern.matches(patron2, placap)){
				JOptionPane.showMessageDialog(null,"Placa incorrecta. Formato “ABC-1234” ");
				}
				
				// CAR PRICE >=10000 AND <=99999
				String patron3= "([1-9][0-9][0-9][0-9][0-9])([.]\\d{1,2})";
				String preciop=txtprecio.getText();
				if (!Pattern.matches(patron3, preciop)){
				JOptionPane.showMessageDialog(null,"Precio incorrecto");
				}

				// VALIDATE DATE
				String patron4= "([0-9]{4})-([0-9]{2})-([0-9]{2})";
				String fechap=txtfecha.getText();
				if (!Pattern.matches(patron4, fechap)){
					JOptionPane.showMessageDialog(null,"Fecha incorrecta. Formato “YYYY-MM-DD”");
					}
				
				rdbtnDisp.setActionCommand("1");
				rdbtnNodisp.setActionCommand("0");
				
				// WE ARE GOING TO REGISTER ONLY IF ALL FIELDS MATCHES THE PATTERNS SPECIFIED ABOVE. IF NOT A MESSAGE SHOULD APPEAR
				if(Pattern.matches(patron, idp)&&
						Pattern.matches(patron1, marcap)&&
						Pattern.matches(patron2, placap)&&
						Pattern.matches(patron3, preciop)&&
						Pattern.matches(patron4, fechap)) {
				
				Automovil ObjA = new Automovil((idp).toUpperCase(),
					    (marcap).toUpperCase(),
						(placap).toUpperCase(),
						Double.parseDouble(preciop),
						Integer.parseInt(txtstock.getText()),
						(fechap),
						bg.getSelection().getActionCommand()
						);
				ObjNA.InsertarAutomvil(ObjA);
				cargarTable();
			}else {
				 JOptionPane.showMessageDialog(null, "Hacer correccioness");
			}
			
		}});
		btnNewButton.setBounds(184, 422, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(356, 38, 525, 493);
		contentPane.add(scrollPane);
		
		MiTabla = new JTable();
		scrollPane.setViewportView(MiTabla);
		
		
		cargarTable();
	}
}
