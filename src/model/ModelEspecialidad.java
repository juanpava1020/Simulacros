package model;
import database.ConfigDB;
import entity.Especialidad;
import interfaces.CRUD;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

//aca utilizo el implements crud y traigo la plantilla, es decir: listar,crear,editar y eliminar
public class ModelEspecialidad implements CRUD {
    @Override
    public ArrayList<Object> listar() {
        // para listar necesito una lista, entonces creamos(instanciamos) una
        ArrayList<Object> listaDeEspecialides = new ArrayList<>();
        // despues de esto abrimos la conexion
        Connection objConnection = ConfigDB.openConnection();

        //despues de abrir la conexion t0do puede fallar
        //utilizamos un try-catch
        
        try {
            //sentencia sql
            String sql = "SELECT * FROM especialidad";
            //aca hacemos la preparacion
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            //ejecutamos
            ResultSet objResult =  objPrepare.executeQuery();

            // el while es un ciclo que se va a repetir siempre que tenga algo en objResult
            while (objResult.next()){
                //aca instanciamos una especialidad que se va a llamar objEspecialidad
                Especialidad objEspecialidad = new Especialidad();
                //a objEspecialidad le vamos a agregamos valores que tengo en el objResult que es lo que obtengo de la base de datos para poder listar
                objEspecialidad.setNombre(objResult.getString("nombre"));
                objEspecialidad.setDescripcion(objResult.getString("descripcion"));
                objEspecialidad.setId(objResult.getInt("id_especialidad"));
                //a la lista que creamos inicialmente le vamos a agregar el objEspecialidad que es el que almacena los valores
                listaDeEspecialides.add(objEspecialidad);
            }
            //esto es si ocurre un error con la base de datos
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        //cierro conexion
        ConfigDB.closeConnection();
        //como queremos listar entonces retornamos una lista
        return listaDeEspecialides;
    }
    @Override
    public Object create(Object obj) {
        Connection objConexion = ConfigDB.openConnection();
        Especialidad objEspecialidad = (Especialidad) obj;


        try {
            String sql = "INSERT INTO especialidad (nombre, descripcion) VALUES(?, ?);";
            PreparedStatement objPrepare = objConexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objEspecialidad.getNombre());
            objPrepare.setString(2, objEspecialidad.getDescripcion());

            objPrepare.execute();

            /*ResultSet result = objPrepare.getGeneratedKeys();
            if (result.next()){
                objEspecialidad.setId(result.getInt("id"));
            }*/

            JOptionPane.showMessageDialog(null, "Se ha creado la especialidad correctamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear la especialidad: " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return objEspecialidad;
    }
    @Override
    public boolean update(Object obj) {
        Especialidad objEspecialidad = (Especialidad) obj;
        Connection objConexion = ConfigDB.openConnection();
        boolean isUpdate = false;

        try {
/*          UPDATE nombre_tabla
            SET columna1 = valor1, columna2 = valor2, ...
            WHERE condición;*/
            String sql = "UPDATE especialidad SET nombre = ?, descripcion = ? WHERE id_especialidad = ?;";
            PreparedStatement objPrepare =  objConexion.prepareStatement(sql);

            objPrepare.setString(1, objEspecialidad.getNombre());
            objPrepare.setString(2, objEspecialidad.getDescripcion());
            objPrepare.setInt(3,objEspecialidad.getId());

            int filasAfectadas =  objPrepare.executeUpdate();

            if (filasAfectadas > 0){
                isUpdate = true;
                JOptionPane.showMessageDialog(null,"Actualizado con exito" );
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return isUpdate;
    }
    @Override
    public boolean delete(Object obj) {

        boolean isDeleted = false;

        Especialidad objEspecialidad = (Especialidad) obj;
        Connection objConnection = ConfigDB.openConnection();
        try {
/*            DELETE FROM empleados
            WHERE departamento = 'Ventas';*/
           String sql = "DELETE FROM especialidad WHERE id_especialidad = ?;";
           PreparedStatement objPrepare = objConnection.prepareStatement(sql);

           objPrepare.setInt(1, objEspecialidad.getId());

           int filasAfectadas = objPrepare.executeUpdate();

           if (filasAfectadas > 0){
               JOptionPane.showMessageDialog(null, "Especialidad eliminada satisfactorimente");
               isDeleted = true;
           }




        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }


        return isDeleted;
    }
}
