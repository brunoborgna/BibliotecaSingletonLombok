package prototype;

import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // genera getters, setters, toString, equals, hashCode
@NoArgsConstructor  // genera constructor vacío


public class Prestamo implements Cloneable{
    private String libro;
    private String usuario;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Prestamo(String libro, String usuario, LocalDate fechaInicio, LocalDate fechaFin) {
    this.libro=libro;
    this.usuario=usuario;
    this.fechaInicio=fechaInicio;
    this.fechaFin=fechaFin;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public Prestamo clone() {
        try {
            return (Prestamo) super.clone(); // copia superficial
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Informacion prestamo: " +
                "Libro= " + libro +
                ", Usuario= " + usuario +
                ", Fecha de inicio= " + fechaInicio +
                ", Fecha de pago= " + fechaFin;
    }

}
