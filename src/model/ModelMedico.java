package model;

import database.ConfigDB;
import entity.Especialidad;
import entity.Medico;
import interfaces.CRUD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelMedico implements CRUD{

    @Override
    public ArrayList<Object> listar() {
        ArrayList<Object> listaMedicos = new ArrayList<>();
        Connection objConnetion = ConfigDB.openConnection();

        try {
            //creamos la sentencia
            String sql = "SELECT * FROM medico";
            //preparamos
            PreparedStatement objPrepare = objConnetion.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();

            //ya necesitamos generar el ciclo que va a recorrer lo que contenga la lista
            while (objResult.next()){
                Medico objMedico = new Medico();
                objMedico.setNombre(objResult.getString("nombre"));
                objMedico.setApellido(objResult.getString("apellido"));
                objMedico.setId(objResult.getInt("id"));
                objMedico.setId_especialidad(objResult.getInt("id_especialidad"));

                listaMedicos.add(objMedico);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR"+ e.getMessage());
        }
        ConfigDB.closeConnection();


        return listaMedicos;
    }

    @Override
    public Object create(Object obj) {
        Medico objMedico = (Medico) obj;
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "INSERT INTO medico (nombre, apellido, id_especialidad) VALUES (?, ?, ?)";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1, objMedico.getNombre());
            objPrepare.setString(2, objMedico.getApellido());
            objPrepare.setInt(3, objMedico.getId_especialidad());
            objPrepare.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error"+ e.getMessage());
        }
        return objMedico;
    }


    @Override
    public boolean update(Object obj) {
    Medico objMedico = (Medico) obj;
    Boolean isUpdate = false;
    Connection objConnection = ConfigDB.openConnection();

    try {
        String sql = "UPDATE medico SET nombre = ?, apellido = ? WHERE id_especialidad = ?;";
        PreparedStatement objPrepare = objConnection.prepareStatement(sql);
        objPrepare.setString(1, objMedico.getNombre());
        objPrepare.setString(2, objMedico.getApellido());
        objPrepare.setInt(3, objMedico.getId_especialidad());
        int filasAfectadas = objPrepare.executeUpdate();
        if (filasAfectadas > 0){
            isUpdate=true;
            JOptionPane.showMessageDialog(null,"se actualizo correctamente");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null,"error" + e);
    }

        return isUpdate;
    }

    @Override
    public boolean delete(Object obj) {
        Medico objMedico = (Medico) obj;
        boolean isDelete = false;
        Connection objConnection= ConfigDB.openConnection();
        try {
            String sql ="DELETE FROM medico WHERE id_medico = ?;";
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);
            objPrepared.setInt(1,objMedico.getId());
            int filasAfectadas =  objPrepared.executeUpdate();
            if (filasAfectadas > 0){
                isDelete=true;
                JOptionPane.showMessageDialog(null,"el medico se elimino correctamente");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"error"+ e.getMessage());
        }

        return isDelete;
    }

}
