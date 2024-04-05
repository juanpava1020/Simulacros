package controller;

import entity.Cita;
import entity.Medico;
import model.ModelCita;
import model.ModelPaciente;

import javax.swing.*;

public class ControllerCita {
    public static String listar(){
        ModelCita objModelCita = new ModelCita();
        String listarCita="lista de citas \n";

        for (Object objCita: objModelCita.listar()){
            listarCita += (Medico) objCita;
        }
        return listarCita;

    }
    public static void crear (){
        ModelCita objModelCita = new ModelCita();
        Cita objCita = new Cita();
        ModelPaciente objModelPaciente = new ModelPaciente();

        int id_paciente =Integer.parseInt(JOptionPane.showInputDialog(null,ControllerPaciente+"ingrese el id del paciente"));
        int id_medico =Integer.parseInt(JOptionPane.showInputDialog(null,ControllerMedico.listarMedicosString()+"ingrese el id del medico"));
        String fecha_cita =(JOptionPane.showInputDialog(null,"ingrese la fecha de la cita"));
        String hora_cita =(JOptionPane.showInputDialog(null,"ingrese la hora de la cita"));
        String motivo =(JOptionPane.showInputDialog(null,"ingrese el motivo"));

        objCita.setId_paciente(id_paciente);
        objCita.setId_medico(id_medico);
        objCita.setFecha_cita(fecha_cita);
        objCita.setHora_cita(hora_cita);
        objCita.setMotivo(motivo);
        Cita cita = (Cita) objModelCita.create(objCita);
        JOptionPane.showMessageDialog(null,"se creo correctamenta la cita: \n" + cita);

    }

    public static void editar(){
        ModelCita objModelCita = new ModelCita();
        Cita objCita = new Cita();

        int id_cita =Integer.parseInt(JOptionPane.showInputDialog(null,objModelCita.listar()+"ingresa el id de la cita que quieres editar"));

        int id_paciente =Integer.parseInt(JOptionPane.showInputDialog(null,"ingrese el id del paciente"));
        int id_medico =Integer.parseInt(JOptionPane.showInputDialog(null,"ingrese el id del medico"));
        String fecha_cita =(JOptionPane.showInputDialog(null,"ingrese la fecha de la cita"));
        String hora_cita =(JOptionPane.showInputDialog(null,"ingrese la hora de la cita"));
        String motivo =(JOptionPane.showInputDialog(null,"ingrese el motivo"));

        objCita.setId_paciente(id_paciente);
        objCita.setId_medico(id_medico);
        objCita.setFecha_cita(fecha_cita);
        objCita.setHora_cita(hora_cita);
        objCita.setMotivo(motivo);

        objCita.setId_cita(id_cita);

        objModelCita.update(objCita);

        JOptionPane.showMessageDialog(null,"se actualizo correctamente");
    }

    public static void eliminar (){
    ModelCita objModelCita = new ModelCita();
    Cita objCita = new Cita();
    int idEliminar = Integer.parseInt(JOptionPane.showInputDialog(null,objModelCita.listar()+"ingresa el id que quieres eliminar"));
    objCita.setId_cita(idEliminar);
    objModelCita.delete(objCita);
    }
}
