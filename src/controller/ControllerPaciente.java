package controller;

import entity.Medico;
import entity.Paciente;
import model.ModelMedico;
import model.ModelPaciente;

import javax.swing.*;

public class ControllerPaciente {
    public static void listarpaciente(){

        ModelPaciente objModelPaciente = new ModelPaciente();

        String listaPaciente = "Lista de pacientes\n";

        for (Object objpaciente : objModelPaciente.listar()){
            listaPaciente += (Medico)objpaciente + "\n";
        }
        JOptionPane.showMessageDialog(null,listaPaciente);

    }

    public static String listarPacientesString(){

        ModelPaciente objModelPaciente = new ModelPaciente();

        String listaPacientes = "Lista de pacientes \n";

        for (Object objPaciente : objModelPaciente.listar()){
            listaPacientes += (Paciente)objPaciente + "\n";
        }
        return listaPacientes;
    }

    public static void create(){
        ModelPaciente objModelPaciente = new ModelPaciente();
        Paciente objPaciente = new Paciente();

        String nombre = JOptionPane.showInputDialog(null,"ingresa el nombre");
        String apellido = JOptionPane.showInputDialog(null,"ingresa el apellido");
        int id_especialidad = Integer.parseInt(JOptionPane.showInputDialog( ControllerEspecialidad.listarEspecialidadesString()   + "ingresa el id de la especialidad")) ;
        objPaciente.setNombre(nombre);
        objPaciente.setApellido(apellido);
        objPaciente.setId_especialidad(id_especialidad);

        Medico medico = (Medico) objModelPaciente.create(objPaciente);
        JOptionPane.showMessageDialog(null,"el medico se agrego correctamente"+ medico);
    }

    public static void actualizar(){
        ModelMedico objModelMedico = new ModelMedico();
        Medico objMedico = new Medico();
        String nombre = JOptionPane.showInputDialog("ingresa el nombre que deseas actualizar");
        String apellido = JOptionPane.showInputDialog("ingresa el apellido que deseas actualizar");
        int id = Integer.parseInt(JOptionPane.showInputDialog(listarMedicosString() +"ingresa el id del usuario que deseas eliminar" ));
        objMedico.setNombre(nombre);
        objMedico.setApellido(apellido);
        objMedico.setId(id);
        objModelMedico.update(objMedico);
        JOptionPane.showMessageDialog(null, "se actualizo correctamente");
    }

    public static  void eliminar(){
        ModelMedico objModelMedico = new ModelMedico();
        Medico objMedico = new Medico();
        int id = Integer.parseInt(JOptionPane.showInputDialog(null,listarMedicosString()+"ingresa el id del medico que deseas eliminar"));
        objMedico.setId(id);
        objModelMedico.delete(objMedico);
    }

}
