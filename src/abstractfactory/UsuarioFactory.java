package abstractfactory;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data  // genera getters, setters, toString, equals, hashCode
@NoArgsConstructor  // genera constructor vacío
@AllArgsConstructor // genera constructor con todos los atributos
public class UsuarioFactory implements AbstractFactory{
    @Override
    public InterfazUI crearInterfazUI() {
        return new UsuarioUI();//crea interfaz usuario
    }

    @Override
    public MetodoEnvio crearMetodoEnvio() {
        return new EnvioNormal();//crea envio normal
    }
}
