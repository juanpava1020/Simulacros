import controller.ControllerCita;
import controller.ControllerEspecialidad;
import controller.ControllerMedico;
import database.ConfigDB;
import model.ModelEspecialidad;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int opcion = 0;
        int opCita = 0;
        int opEspecialidad = 0;
        int opMedico = 0;
        int opPaciente = 0;

        do {
            opcion=Integer.parseInt(JOptionPane.showInputDialog("""
                    ***** MENU *****
                    1. cita.
                    2. especialidad.
                    3. medico.
                    4. paciente.
                    
                    ingrese una opcion:
                    """));
            switch (opcion){
                case 1:
                    do {
                        opCita = Integer.parseInt(JOptionPane.showInputDialog("""
                            ***** CRUD CITA *****
                            1. listar citas.
                            2. crear cita.
                            3. editar cita.
                            4. eliminar cita.
                            5. salir.
                            
                            ingrese una opcion
                            """));
                        switch (opCita){
                            case 1:
                                ControllerCita.listar();
                                break;
                            case 2:
                                ControllerCita.crear();
                                break;
                            case 3:
                                ControllerCita.editar();
                                break;
                            case 4:
                                ControllerCita.eliminar();
                                break;
                        }
                    }while (opCita != 5);
                    break;

                case 2:
                    do {
                        opEspecialidad =Integer.parseInt(JOptionPane.showInputDialog("""
                                ***** CRUD ESPECIALIALIDAD *****
                                1. listar especialidades.
                                2. crear especialidad.
                                3. editar especialidad.
                                4. eliminar especialidad.
                                5. salir.
                                ingresa un opcion.                              
                                """));
                        switch (opEspecialidad){
                            case 1:
                                ControllerEspecialidad.listarEspecialidades();
                                break;
                            case 2:
                                ControllerEspecialidad.crear();
                                break;
                            case 3:
                                ControllerEspecialidad.actualizar();
                                break;
                            case 4:
                                ControllerEspecialidad.eliminar();
                                break;
                        }

                    }while (opEspecialidad != 5);
                    break;

                case 3:
                    do {
                        opMedico = Integer.parseInt(JOptionPane.showInputDialog("""
                                ***** CRUD MEDICO *****
                                1. listar medicos.
                                2. crear medico.
                                3. editar medico.
                                4. eliminar medico.
                                5. salir.
                              
                                elige una opcion.                              
                                """));
                        switch (opMedico){
                            case 1:
                                ControllerMedico.listarMedicos();
                                break;
                            case 2:
                                ControllerMedico.create();
                            case 3:
                                ControllerMedico.actualizar();
                                break;
                            case 4:
                                ControllerMedico.eliminar();
                                break;
                        }
                    }while (opMedico != 5);
                    break;

                case 4:
                    do {
                        opPaciente = Integer.parseInt(JOptionPane.showInputDialog("""
                                ***** CRUD PACIENTE *****
                                1. listar pacientes.
                                2. crear paciente.
                                3. editar paciente.
                                4. eliminar paciente.
                                5. salir.
                                
                                elige una opcion.
                                """));
                        switch (opPaciente){
                            case 1:

                                break;
                            case 2:

                                break;
                            case 3:

                                break;
                            case 4:

                                break;
                        }
                    }while (opPaciente != 5);
                    break;
            }
        }while (opcion != 5);
    }
}