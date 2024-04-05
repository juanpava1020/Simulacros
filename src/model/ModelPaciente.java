package model;

import database.ConfigDB;
import entity.Medico;
import entity.Paciente;
import interfaces.CRUD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelPaciente implements CRUD {

    @Override
    public ArrayList<Object> listar() {
        ArrayList<Object> listaPacientes = new ArrayList<>();
        Connection objConnetion = ConfigDB.openConnection();

        try {
            //creamos la sentencia
            String sql = "SELECT * FROM paciente";
            //preparamos
            PreparedStatement objPrepare = objConnetion.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();

            //ya necesitamos generar el ciclo que va a recorrer lo que contenga la lista
            while (objResult.next()){
                Paciente objPaciente = new Paciente();
                objPaciente.setId_paciente(objResult.getInt("id_paciente"));
                objPaciente.setNombre(objResult.getString("nombre"));
                objPaciente.setApellidos(objResult.getString("apellido"));
                objPaciente.setDocumento_identidad(objResult.getString("documento_identidad"));
                objPaciente.setFecha_nacimiento(objResult.getString("fecha_nacimiento"));

                listaPacientes.add(objPaciente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR"+ e.getMessage());
        }
        ConfigDB.closeConnection();
        return listaPacientes;
    }


    @Override
    public Object create(Object obj) {
        Paciente objPaciente = (Paciente) obj;
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "INSERT INTO paciente (nombre, apellido, documento_identidad, fecha_nacimiento) VALUES (?, ?, ?, ?)";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1, objPaciente.getNombre());
            objPrepare.setString(2, objPaciente.getApellidos());
            objPrepare.setString(3, objPaciente.getDocumento_identidad());
            objPrepare.setString(3, objPaciente.getFecha_nacimiento());
            objPrepare.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error"+ e.getMessage());
        }
        return objPaciente;
    }

    @Override
    public boolean update(Object obj) {
        Paciente objPaciente = (Paciente) obj;
        boolean isUpdate = false;
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "UPDATE paciente SET nombre = ?, apellido = ?, documento_identidad = ?, fecha_nacimiento = ? WHERE id_paciente = ?;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);



            objPrepare.setString(1, objPaciente.getNombre());
            objPrepare.setString(2, objPaciente.getApellidos());
            objPrepare.setString(3, objPaciente.getDocumento_identidad());
            objPrepare.setString(4, objPaciente.getFecha_nacimiento());
            objPrepare.setInt(5, objPaciente.getId_paciente());
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
        Paciente objPaciente = (Paciente) obj;
        boolean isDelete = false;
        Connection objConnection= ConfigDB.openConnection();
        try {
            String sql ="DELETE FROM paciente WHERE id_paciente = ?;";
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);
            objPrepared.setInt(1,objPaciente.getId_paciente());
            int filasAfectadas =  objPrepared.executeUpdate();
            if (filasAfectadas > 0){
                isDelete=true;
                JOptionPane.showMessageDialog(null,"el paciente se elimino correctamente");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"error"+ e.getMessage());
        }

        return isDelete;
    }
}
