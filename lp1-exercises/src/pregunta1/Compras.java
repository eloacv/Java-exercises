package pregunta1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Compras extends JFrame {

	private JPanel contentPane;
	private JTextField txtCantidad;
	private JTextField txtPrecio;
	private JTextField txtTotal;
	private JTextField txtFecha;
	private JTable MiTabla;
	private DefaultTableModel tabla = new DefaultTableModel();
	private int item=0;
	private double Total=0;
	private final int FILAS =10;
	private String columnas [] = {"ITEM","PRODUCTO", "CANTIDAD","PRECIO","SUB-TOTAL"};
	private Object filas [][] = new Object [FILAS][5];
	public void CargarTabla(){
		MiTabla.setModel(tabla);
		for(String c:columnas)tabla.addColumn(c);
	}
	
	//Fecha a String	
	String txtfecha = new SimpleDateFormat("dd-MMMM-yyyy").format(new Date());
    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Compras frame = new Compras();
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
	public Compras() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRO DE COMPRAS");
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 16));
		lblNewLabel.setBounds(235, 41, 227, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblFecha = new JLabel("FECHA:");
		lblFecha.setBounds(570, 43, 56, 16);
		contentPane.add(lblFecha);
		
		JLabel lblProducto = new JLabel("PRODUCTO");
		lblProducto.setBounds(43, 108, 74, 16);
		contentPane.add(lblProducto);
		
		JComboBox cboProducto = new JComboBox();
		cboProducto.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				if(cboProducto.getSelectedItem() =="TELEVISOR"){
					txtPrecio.setText("1500");}
				else
					if(cboProducto.getSelectedItem() =="DVD"){
						txtPrecio.setText("250");}
					else
						if(cboProducto.getSelectedItem() =="LAVADORA"){
							txtPrecio.setText("1800");}
						else
							if(cboProducto.getSelectedItem() =="VENTILADOR"){
								txtPrecio.setText("50");}
							else
								if(cboProducto.getSelectedItem() =="COCINA"){
									txtPrecio.setText("600");}
								else
									if(cboProducto.getSelectedItem() =="LICUADORA"){
										txtPrecio.setText("120");}
									else
										if(cboProducto.getSelectedItem() =="EQUIPO DE SONIDO"){
											txtPrecio.setText("1100");}
						
			}
		});
		cboProducto.setModel(new DefaultComboBoxModel(new String[] {"", "TELEVISOR", "DVD", "LAVADORA", "VENTILADOR", "COCINA", "LICUADORA", "EQUIPO DE SONIDO"}));
		cboProducto.setBounds(144, 105, 129, 22);
		contentPane.add(cboProducto);
		
		JLabel lblCantidad = new JLabel("CANTIDAD");
		lblCantidad.setBounds(328, 108, 74, 16);
		contentPane.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(418, 105, 116, 22);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JLabel lblPrecio = new JLabel("PRECIO");
		lblPrecio.setBounds(570, 108, 56, 16);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(631, 105, 116, 22);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JButton btnNewButton = new JButton("REGISTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Subtotal =0;
				if(item < FILAS){
					filas [item][0]=item+1;
					filas [item][1]= cboProducto.getSelectedItem();
					filas [item][2]=txtCantidad.getText();
					filas [item][3]="$"+ txtPrecio.getText();
					Subtotal =Integer.parseInt(txtCantidad.getText())*Double.parseDouble(txtPrecio.getText());
					filas [item][4]= "$"+Subtotal;
					Total= Total+Subtotal;
					tabla.addRow(filas [item]);
					txtTotal.setText("$"+Total);
					item++;
				
			}
			}
			
		});
		btnNewButton.setBounds(338, 169, 116, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setBounds(570, 428, 56, 16);
		contentPane.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTotal.setForeground(Color.RED);
		txtTotal.setBounds(649, 425, 116, 22);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtFecha.setBounds(631, 40, 116, 22);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		txtFecha.setText(""+txtfecha);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 233, 672, 158);
		contentPane.add(scrollPane);
		
		MiTabla = new JTable();
		scrollPane.setViewportView(MiTabla);
		
		JLabel lbPic = new JLabel("New labelPic");
		lbPic.setIcon(new ImageIcon(Compras.class.getResource("/IMG/cart.png")));
		lbPic.setBounds(30, 30, 129, 60);
		contentPane.add(lbPic);
		CargarTabla();
	}
}
