package database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Persona;

public class PersonaTable {
	

	public void insertarPersona(Persona persona, DriverConexion driverConexion) {
		InsertarModificarDB insertar = new InsertarModificarDB();
		try{
			String s = "INSERT INTO persona(dni,nombre,apellido,cantServicios) VALUES("+persona.getDni()+", '"+persona.getNombre()+"', '"+persona.getApellido()+"' ,"+persona.getCantidadServicios()+");";
			insertar.modificarInsertar(s, driverConexion);
		}
		catch(Exception e) {
			System.out.println("Error al insertar");
		}
	}
	
	public void borrarPersona(int dni, DriverConexion driverConexion) {
		InsertarModificarDB borrar = new InsertarModificarDB();
		try{
			String s = "DELETE FROM persona WHERE DNI = '"+dni+"';";
			borrar.modificarInsertar(s, driverConexion);
		}
		catch(Exception e) {
			System.out.println("Error al borrar");
		}
	}
	
	public void actualizarPersona(Persona persona, DriverConexion driverConexion) {
		InsertarModificarDB actualizar = new InsertarModificarDB();
		try{
			String s = "UPDATE persona SET cantServicios = "+persona.getCantidadServicios()+"  WHERE DNI = '"+persona.getDni()+"';";
			actualizar.modificarInsertar(s, driverConexion);
		}
		catch(Exception e) {
			System.out.println("Error al actualizar");
		}
	}
	
	public ArrayList<String> getDNIs(DriverConexion driverConexion) throws SQLException{
		ArrayList<String> personasDNI = new ArrayList<String>();
		String consulta = "SELECT dni FROM persona";
		
		ResultSet rs = driverConexion.getConexionBD().createStatement().executeQuery(consulta);
		ResultSetMetaData metaData = rs.getMetaData();
		int numColumna = metaData.getColumnCount();
		while(rs.next()) {
			String s = String.valueOf((Integer) rs.getObject(1));
			personasDNI.add(s);
		}
		return personasDNI;
	}
	
}
