package abstractfactory;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data  // genera getters, setters, toString, equals, hashCode
@NoArgsConstructor  // genera constructor vacío
@AllArgsConstructor // genera constructor con todos los atributos
public class AdminUI implements InterfazUI{

    @Override
    public void mostrar() {
        System.out.println("Cargando interfaz de administrador...");
    }
}
