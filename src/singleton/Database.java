package singleton;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data  // genera getters, setters, toString, equals, hashCode



public class Database {

    // base con una lista
    private final List<Libro> libros = new ArrayList<>();

    // instancia única creada al cargar la clase
    private static final Database INSTANCIA = new Database();

    // constructor privado
    private Database() {}

    // acceso global a la única instancia
    public static Database getInstance() {
        return INSTANCIA;
    }

    // métodos
    public void agregarLibro(Libro libro) {
        if (libro == null) {
            throw new IllegalArgumentException("El libro no puede ser null");
        }
        libros.add(libro);
    }

    // devuelve una copia de la lista interna
    public List<Libro> listarLibros() {
        return new ArrayList<>(libros);
    }
}
