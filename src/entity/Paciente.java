package entity;

public class Paciente {
    private int id_paciente;
    private String nombre;
    private String apellidos;

    private String documento_identidad;

    private String fecha_nacimiento;

    public Paciente() {
    }

    public Paciente(int id_paciente, String nombre, String apellidos, String documento_identidad, String fecha_nacimiento) {
        this.id_paciente = id_paciente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.documento_identidad = documento_identidad;
        this.fecha_nacimiento = fecha_nacimiento;
    }


    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDocumento_identidad() {
        return documento_identidad;
    }

    public void setDocumento_identidad(String documento_identidad) {
        this.documento_identidad = documento_identidad;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }


    @Override
    public String toString() {
        return "entity.Paciente{" +
                "id_paciente=" + id_paciente +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", documento_identidad='" + documento_identidad + '\'' +
                ", fecha_nacimiento='" + fecha_nacimiento + '\'' +
                '}';
    }
}
