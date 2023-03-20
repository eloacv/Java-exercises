package datos;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import entidad.Automovil;

// MYSQL DATABASE CONNECTION
public class BDventas {
	private String Driver = "com.mysql.jdbc.Driver";
	private String URL = "jdbc:mysql://localhost:3306/automovil";
	private String Usuario = "root";
	private String Contraseña = "";
	private Connection Cn;
	private Statement Cmd;
	private CallableStatement Stmt;
	private ResultSet Rs;
	private ArrayList<Automovil> MiLista;
	
	public BDventas() {
		try {
			Class.forName(Driver);
			Cn = DriverManager.getConnection(URL, Usuario, Contraseña);
			
		} catch (Exception e) {
			System.out.println("ERROR al conectar: " + e.getMessage());
			
		}
	}
//CALL STORE PROCEDURE "LISTAR" TO LIST ALL THE RECORDS FROM THE DATABASE "AUTOMOVIL"
    public ArrayList<Automovil> ListarAutomovil(){
    	String SQL ="call Listar()";
    	MiLista = new ArrayList<Automovil>();
    	try {
    		Stmt = Cn.prepareCall(SQL);
    		Rs = Stmt.executeQuery();
    		while(Rs.next()) {
    			MiLista.add(new Automovil(Rs.getString("IdAutomovil"),
    					Rs.getString("marca"),
    					Rs.getString("numeroplaca"),
    					Rs.getDouble("precio"),
    					Rs.getInt("stock"),
    					Rs.getString("fechafabricacion"),
    					Rs.getString("estado")
    					));
    		}
    		Rs.close();
    		
    	} catch (Exception e) {
    		System.out.println("ERROR en listar: "+ e.getMessage());
    		
    	}
    	
    	return MiLista;
    }
// CALL STORE PROCEDURE "INSERTAR"   
    public void InsertarAutomvil(Automovil ObjA){
    	String SQl ="call Insertar(?,?,?,?,?,?,?)";
    	try {
    		Stmt = Cn.prepareCall(SQl);
    		Stmt.setString(1, ObjA.getIdAutomovil());
    		Stmt.setString(2, ObjA.getMARCA());
    		Stmt.setString(3, ObjA.getNUMPLACA());
    		Stmt.setDouble(4, ObjA.getPRECIO());
    		Stmt.setInt(5, ObjA.getSTOCK());
    		Stmt.setString(6, ObjA.getFECHAFABRICACION());
    		Stmt.setString(7, ObjA.getESTADO()+"");
    		Stmt.executeUpdate();
    		JOptionPane.showMessageDialog(null, "Registro exitoso");
    		
    	} catch (Exception e) {
    		System.out.println("ERROR"+ e.getMessage());
    		
    	}
    	
    }
}
