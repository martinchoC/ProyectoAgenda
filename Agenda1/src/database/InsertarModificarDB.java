package database;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InsertarModificarDB {

	public void modificarInsertar(String modificacionInsersion, DriverConexion dc)	{
		try{
	        Statement stmt =dc.getConexionBD().createStatement();
	        stmt.executeUpdate(modificacionInsersion);
	        JOptionPane.showMessageDialog(null, "Modificacion/Insercion realizada correctamente.","Informacion"
	        		, JOptionPane.INFORMATION_MESSAGE);
	        stmt.close();
	     }
	     catch (SQLException ex) { 
	        JOptionPane.showMessageDialog(new JFrame(),
	                                      ex.getMessage() + "\n", 
	                                      "Error al ejecutar la consulta.",
	                                      JOptionPane.ERROR_MESSAGE);
	     }
  }
}
