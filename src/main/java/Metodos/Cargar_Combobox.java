package Metodos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;

public class Cargar_Combobox {
    Pool metodospool = new Pool();
    PreparedStatement ps;
    ResultSet rs;
    
    public void consultar_discos(JComboBox cbox_discos){
        //Creamos objeto tipo connection
        java.sql.Connection con = null;
        //Creamos consulta sql
        String sql = "SELECT nombreDisco FROM album ORDER BY nombreDisco ASC";
        
        //Establecemos bloque try-catch-finally
        try{
            //establecemos conexion con la base de datos
            con = metodospool.getConnection();
            //Preparar la consulta SQL
            ps = con.prepareStatement(sql);
            //Ejecutamos la consulta
            rs = ps.executeQuery();
            
            //Llenamos nouestro comboBox
            cbox_discos.addItem("Seleccione una opcion");
            while(rs.next()){
                cbox_discos.addItem(rs.getString("nombreDisco"));
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error");
        }
        
    }
    
}
