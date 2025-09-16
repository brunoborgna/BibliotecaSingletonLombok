package Factory;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // genera getters, setters, toString, equals, hashCode
@NoArgsConstructor  // genera constructor vacío


public class LibroFisico implements Libro1 {
    private String titulo;
    private String autor;

    public LibroFisico(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    @Override
    public String getTipo() {
        return "Fisico";
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public String getAutor() {
        return autor;
    }
}
