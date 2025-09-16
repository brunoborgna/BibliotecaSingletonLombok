
package abstractfactory;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data  // genera getters, setters, toString, equals, hashCode
@NoArgsConstructor  // genera constructor vacío
@AllArgsConstructor // genera constructor con todos los atributos

public class AdminFactory implements AbstractFactory{

    @Override
    public InterfazUI crearInterfazUI() {
        return new AdminUI();//crea la interfaz admin
    }

    @Override
    public MetodoEnvio crearMetodoEnvio() {
        return new EnvioExpress();//crea un envio express
    }
}
