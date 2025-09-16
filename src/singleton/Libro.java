package singleton;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data  // genera getters, setters, toString, equals, hashCode

public class Libro {
    private final String titulo;
    private final String autor;
    private final int anio;

    public Libro(String titulo, String autor, int anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
    }

    public String getTitulo() { return titulo; }
    public String getAutor()  { return autor; }
    public int getAnio()      { return anio; }

    @Override
    public String toString() {
        return String.format("%s (%d) - %s", titulo, anio, autor);
    }
}
