package builder;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data  // genera getters, setters, toString, equals, hashCode
@NoArgsConstructor  // genera constructor vacío
@AllArgsConstructor // genera constructor con todos los atributos
public class Usuario {
    private String nombre;
    private String email;
    private String direccion;
    private String telefono;
    private LocalDate fechaNacimiento; //atributos del usuario

    // constructor privado para q solo el builder pueda crear
    private Usuario(Builder builder) {
        this.nombre = builder.nombre;
        this.email = builder.email;
        this.direccion = builder.direccion;
        this.telefono = builder.telefono;
        this.fechaNacimiento = builder.fechaNacimiento;
    }


    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Usuario solicitado: " +
                "Nombre= " + nombre +
                ", Email= " + email +
                ", Direccion= " + direccion +
                ", Telefono= " + telefono +
                ", Fecha de nacimiento= " + fechaNacimiento;
    }

    // clase builder
    public static class Builder {
        private final String nombre;
        private final String email;
        private String direccion;
        private String telefono;
        private LocalDate fechaNacimiento;

        public Builder(String nombre, String email) {
            this.nombre = nombre;
            this.email = email;
        }

        public Builder direccion(String direccion) {
            this.direccion = direccion;
            return this;
        }

        public Builder telefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public Builder fechaNacimiento(LocalDate fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
            return this;
        }

        public Usuario build() {
            return new Usuario(this);
        }//crea el usuario
    }
}
