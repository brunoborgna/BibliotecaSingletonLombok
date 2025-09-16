package abstractfactory;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data  // genera getters, setters, toString, equals, hashCode
@NoArgsConstructor  // genera constructor vacío
@AllArgsConstructor // genera constructor con todos los atributos
public class EnvioExpress implements MetodoEnvio{

    @Override
    public void enviar() {
        System.out.printf("Enviando producto con metodo express. Duracion estimada: 1-3 dias");
    }
}
