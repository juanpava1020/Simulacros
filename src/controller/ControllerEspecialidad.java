package controller;
import entity.Especialidad;
import entity.Medico;
import model.ModelEspecialidad;
import model.ModelMedico;

import javax.swing.*;
public class ControllerEspecialidad {
    public static void crear(){

        ModelEspecialidad objModelEspecialidad = new ModelEspecialidad();



        String nombre = JOptionPane.showInputDialog("Ingresa el nombre de la especialidad");
        String descripcion = JOptionPane.showInputDialog("Ingresa la descripción");
        Especialidad objEspecialidad = new Especialidad();
        objEspecialidad.setNombre(nombre);
        objEspecialidad.setDescripcion(descripcion);

        objModelEspecialidad.create(objEspecialidad);

    }
    public static void listarEspecialidades(){
        //Traemos el objModel, para acceder a sus métodos
        ModelEspecialidad objModelEspecialidad = new ModelEspecialidad();
        //creamos una variable
        String listaEspecialidades = "LISTA ESPECIALIDADES \n";
            //Esto es un arraylist de Object
        //objEspecialidad es el nombre que va a tener el iterador y este va a ser de tipo objeto
        //y va a iterar la lista del model
        for (Object objEspecialidad: objModelEspecialidad.listar()){
            //y lista de especialidad es igual a lo que tenga o este parado el iterador
            //como el objEspecialidad es de tipo objeto y necesitamos especificar que sea de tipo especialidad
            //entonces lo casteamos(Especialidad)
            //y el += es para que se sume cada iteracion a la variable "listaEspecialidad"
            listaEspecialidades += (Especialidad) objEspecialidad + "\n";
        }
        // mostramos la variable que contiene la lista
        JOptionPane.showMessageDialog(null, listaEspecialidades);

    }
    public static String listarEspecialidadesString(){
        //Traemos el objModel, para acceder a sus métodos
        ModelEspecialidad objModelEspecialidad = new ModelEspecialidad();
        String listaEspecialidades = "LISTA ESPECIALIDADES \n";
        //Esto es un arraylist de Object
        for (Object objEspecialidad: objModelEspecialidad.listar()){
            listaEspecialidades += (Especialidad) objEspecialidad + "\n";
        }

        return listaEspecialidades;
    };
    public static void actualizar (){
        ModelEspecialidad objModel = new ModelEspecialidad();
        Especialidad objEspecialidad = new Especialidad();

        int id = Integer.parseInt(JOptionPane.showInputDialog( listarEspecialidadesString() + "\nIngresa el id del usuario que deseas eliminar"));
        String nombre =JOptionPane.showInputDialog("ingresa el nombre que deseas actualizar");
        String descripcion = JOptionPane.showInputDialog("ingresa la nueva descripcion");

        objEspecialidad.setId(id);
        objEspecialidad.setNombre(nombre);
        objEspecialidad.setDescripcion(descripcion);


        objModel.update(objEspecialidad);



        JOptionPane.showMessageDialog(null,"se actualizo correctamente");
    }
    public static void eliminar(){
        ModelEspecialidad objModelEspecialidad = new ModelEspecialidad();
        Especialidad objEspecialidad = new Especialidad();

        int id = Integer.parseInt(JOptionPane.showInputDialog(listarEspecialidadesString() + "\n Ingrese el id del usuario que desea eliminar"));

        objEspecialidad.setId(id);

        objModelEspecialidad.delete(objEspecialidad);

    }
}
