package negocio;
import java.util.ArrayList;
import entidad.Automovil;
import datos.BDventas;
public class NegocioAutomovil {
	private BDventas ObjBD;

	public NegocioAutomovil() {
		//OBJECT OF THE BDVENTAS CLASS
		ObjBD = new BDventas();
	}
	//LISTARAUTOMOVIL() METHOD RETURNS AN ARRAYLIST OF AUTOMOVIL OBJECTS
	public ArrayList<Automovil> ListarAutomovil(){
		return ObjBD.ListarAutomovil();	
	}
	//METHOD TO INSERT A NEW AUTOMOVIL OBJECT IN TH DB INVOKING THE PROCEDURE IN BDVENTAS CLASS
	public void InsertarAutomvil(Automovil ObjA){
		 ObjBD.InsertarAutomvil(ObjA);
		
	}

}
