package database;

import java.util.Date;

public class HistorialTable {

	public void insertarServicio(String patente, String fechaReserva, int tipoServicio, DriverConexion driverConexion) {
		InsertarModificarDB insertarHistorial = new InsertarModificarDB();
		try{
			String s = "INSERT INTO historial(id_servicio,fecha,autopatente,servicio_tipo) VALUES(NULL,'"+fechaReserva+"', '"+patente+"', "+tipoServicio+");";
			insertarHistorial.modificarInsertar(s, driverConexion);
		}
		catch(Exception e) {
			System.out.println("Error al insertar");
		}
	}
	
}