package model;

import database.ConfigDB;
import entity.Cita;
import entity.Medico;
import interfaces.CRUD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelCita implements CRUD {

    @Override
    public ArrayList<Object> listar() {
        ArrayList<Object> listarCitas = new ArrayList<>();
        Connection objConnetion = ConfigDB.openConnection();

        try {
            //creamos la sentencia
            String sql = "SELECT * FROM medico";
            //preparamos
            PreparedStatement objPrepare = objConnetion.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();

            //ya necesitamos generar el ciclo que va a recorrer lo que contenga la lista
            while (objResult.next()){
               Cita objCita = new Cita();
                objCita.setId_cita(objResult.getInt("id"));
                objCita.setId_paciente(objResult.getInt("id_paciente"));
                objCita.setId_medico(objResult.getInt("id_medico"));
                objCita.setFecha_cita(objResult.getString("fecha_cita"));
                objCita.setHora_cita(objResult.getString("hora_cita"));
                objCita.setMotivo(objResult.getString("motivo"));


                listarCitas.add(objCita);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR"+ e.getMessage());
        }
        ConfigDB.closeConnection();


        return listarCitas;
    }
    @Override
    public Object create(Object obj) {
        Cita objCita = (Cita)obj;
        Connection objConnection= ConfigDB.openConnection();
        try {
            String sql ="INSERT INTO cita (id_paciente, id_medico, fecha_cita, hora_cita, motivo) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement objprepared = objConnection.prepareStatement(sql);
            objprepared.setInt(1,objCita.getId_paciente());
            objprepared.setInt(2,objCita.getId_medico());
            objprepared.setString(3,objCita.getFecha_cita());
            objprepared.setString(4,objCita.getHora_cita());
            objprepared.setString(5,objCita.getMotivo());
            objprepared.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"arror"+ e.getMessage());
        }
        ConfigDB.closeConnection();

        return objCita;
    }

    //private int id;
    //    private int id_paciente;
    //    private int id_medico;
    //    private String fecha_cita;
    //    private String hora_cita;
    //    private String motivo;
    @Override
    public boolean update(Object obj) {
        Cita objCita =(Cita) obj;
        Connection objConnection = ConfigDB.openConnection();
        boolean isUpdate = false;
        try {
            String sql = "UPDATE cita SET id_paciente = ?, id_medico = ?,fecha_cita = ? , hora_cita = ?, motivo = ? WHERE id_cita = ?;";
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);
            objPrepared.setInt(1,objCita.getId_paciente());
            objPrepared.setInt(2,objCita.getId_medico());
            objPrepared.setString(3,objCita.getFecha_cita());
            objPrepared.setString(4,objCita.getHora_cita());
            objPrepared.setString(5,objCita.getMotivo());
            int filasAfectadas = objPrepared.executeUpdate();

            if (filasAfectadas > 0){
                JOptionPane.showMessageDialog(null,"se actualizo la cita");
                isUpdate = true;
            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"error"+ e.getMessage());
        }
        return isUpdate;
    }

    @Override
    public boolean delete(Object obj) {
        Cita objCita = (Cita) obj;
        Connection objConnection = ConfigDB.openConnection();
        boolean isDelete =false;
        try {
            String sql = "DELETE FROM cita WHERE id_cita = ?;";
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);
            objPrepared.setInt(1,objCita.getId_cita());
            int filasAfectadas = objPrepared.executeUpdate();

            if (filasAfectadas > 0){
                JOptionPane.showMessageDialog(null,"se elimino la cita correctamente");
                isDelete=true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"error" + e.getMessage());

        }
        ConfigDB.closeConnection();

        return isDelete;
    }
};
