package abstractfactory;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data  // genera getters, setters, toString, equals, hashCode
@NoArgsConstructor  // genera constructor vacío
@AllArgsConstructor // genera constructor con todos los atributos
public class EnvioNormal implements MetodoEnvio{

    @Override
    public void enviar() {
        System.out.println("Enviando producto con metodo normal. Duracion estimada: 5-7 dias");
    }
}
