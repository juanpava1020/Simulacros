package controller;

import entity.Medico;
import model.ModelMedico;

import javax.swing.*;

public class ControllerMedico {
    public static void listarMedicos(){

       ModelMedico objModelMedico = new ModelMedico();

       String listaMedicos = "Lista de medicos \n";

       for (Object objMedico : objModelMedico.listar()){
           listaMedicos += (Medico)objMedico + "\n";
       }
       JOptionPane.showMessageDialog(null,listaMedicos);

    }

    public static String listarMedicosString(){

        ModelMedico objModelMedico = new ModelMedico();

        String listaMedicos = "Lista de medicos \n";

        for (Object objMedico : objModelMedico.listar()){
            listaMedicos += (Medico)objMedico + "\n";
        }
        return listaMedicos;
    }

    public static void create(){
        ModelMedico objModelMedico = new ModelMedico();
        Medico objMedico = new Medico();

    String nombre = JOptionPane.showInputDialog(null,"ingresa el nombre");
    String apellido = JOptionPane.showInputDialog(null,"ingresa el apellido");
    int id_especialidad = Integer.parseInt(JOptionPane.showInputDialog( ControllerEspecialidad.listarEspecialidadesString()   + "ingresa el id de la especialidad")) ;
    objMedico.setNombre(nombre);
    objMedico.setApellido(apellido);
    objMedico.setId_especialidad(id_especialidad);

    Medico medico = (Medico) objModelMedico.create(objMedico);
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
