package database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServiciosTable {
	
	public void actualizarServicio(int id, int precio, DriverConexion driverConexion) {
		InsertarModificarDB actualizarPrecio = new InsertarModificarDB();
		try{
			String s = "UPDATE servicio SET precio = "+precio+"  WHERE tipo = '"+id+"';";
			actualizarPrecio.modificarInsertar(s, driverConexion);
		}
		catch(Exception e) {
			System.out.println("Error al borrar");
		}
	}
	
	public ArrayList<String> getServicios(DriverConexion driverConexion) throws SQLException{
		ArrayList<String> servicios = new ArrayList<String>();
		String consulta = "SELECT descripcion_servicio FROM servicio";
		ResultSet rs = driverConexion.getConexionBD().createStatement().executeQuery(consulta);
		ResultSetMetaData metaData = rs.getMetaData();
		int numColumna = metaData.getColumnCount();
		while(rs.next()) {
			String s = (String) rs.getObject(1);
			servicios.add(s);
		}
		return servicios;
	}
}
