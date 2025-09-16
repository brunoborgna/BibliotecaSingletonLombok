package abstractfactory;

public interface AbstractFactory {
    InterfazUI crearInterfazUI();  // crea la interfaz de usuario
    MetodoEnvio crearMetodoEnvio(); // crea el metodo de envio
// las familias van a ser interfazUsuario+metodoenvio
// y se crean a travaes de esos metodos
// las fabricas implementan esos metodos y crean objetos especificos
}
