package database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import modelos.Auto;
import modelos.Persona;

public class AutoTable {

	public void insertarAuto(Auto auto, DriverConexion driverConexion) {
		InsertarModificarDB insertarAuto = new InsertarModificarDB();
		try{
			String s = "INSERT INTO auto(patente,marca,tipoMotor,persona_dni) VALUES ('"+auto.getPatente()+"', '"+auto.getMarca()+"', '"+auto.getTipoMotor()+"' ,"+auto.getDniDueno()+");";
			insertarAuto.modificarInsertar(s, driverConexion);
		}
		catch(Exception e) {
			System.out.println("Error al insertar");
		}
	}
	
	public void borrarAuto(Auto auto, DriverConexion driverConexion) {
		InsertarModificarDB borrarAuto = new InsertarModificarDB();
		try{
			String s = "DELETE FROM auto WHERE patente = '"+auto.getPatente()+"';";
			borrarAuto.modificarInsertar(s, driverConexion);
		}
		catch(Exception e) {
			System.out.println("Error al borrar");
		}
	}
	
	public void modificarAuto(Auto auto, DriverConexion driverConexion) {
		InsertarModificarDB actualizarAuto = new InsertarModificarDB();
		try{
			String s = "UPDATE auto SET persona_dni = "+auto.getDniDueno()+"  WHERE patente = '"+auto.getPatente()+"';";
			actualizarAuto.modificarInsertar(s, driverConexion);
		}
		catch(Exception e) {
			System.out.println("Error al borrar");
		}
	}
	
	public ArrayList<String> getPatentes(DriverConexion driverConexion) throws SQLException{
		ArrayList<String> autosPatentes = new ArrayList<String>();
		String consulta = "SELECT patente FROM auto";
		ResultSet rs = driverConexion.getConexionBD().createStatement().executeQuery(consulta);
		ResultSetMetaData metaData = rs.getMetaData();
		int numColumna = metaData.getColumnCount();
		while(rs.next()) {
			String s = (String) rs.getObject(1);
			autosPatentes.add(s);
		}
		return autosPatentes;
	}
	
	public String getTipoMotor(String patente, DriverConexion driverConexion) throws SQLException{
		String consulta = "SELECT tipoMotor FROM auto WHERE patente = '"+patente+"'";
		ResultSet rs = driverConexion.getConexionBD().createStatement().executeQuery(consulta);
		ResultSetMetaData metaData = rs.getMetaData();
		String s = (String) rs.getObject(1);
		return s;
	}
}
