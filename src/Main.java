import Factory.Libro1;
import Factory.LogisticaLibro;
import abstractfactory.AdminFactory;
import abstractfactory.AdminUI;
import abstractfactory.UsuarioFactory;
import builder.Usuario;
import prototype.Prestamo;
import singleton.Database;
import singleton.Libro;
import java.time.LocalDate;


import java.util.List;

public class Main {
    public static <AbstractFactory> void main(String[] args) {


        //EJERCICIO 1


        System.out.println("\n EJERCICIO 1\n");

        // Pido la "DB" varias veces
        Database db1 = Database.getInstance();
        Database db2 = Database.getInstance();
        Database db3 = Database.getInstance();

        // 1) Demostramos que es la misma instancia
        System.out.println("¿db1 y db2 son la misma instancia? " + (db1 == db2));
        System.out.println("¿db1 y db3 son la misma instancia? " + (db1 == db3));

        System.out.println("id db1: " + System.identityHashCode(db1));
        System.out.println("id db2: " + System.identityHashCode(db2));
        System.out.println("id db3: " + System.identityHashCode(db3));


        // 2) Agregamos libros usando referencias distintas (db1, db2 y db3)
        db1.agregarLibro(new Libro("El Principito", "Antoine de Saint-Exupéry", 1943));
        db2.agregarLibro(new Libro("Cien años de soledad", "Gabriel García Márquez", 1967));
        db3.agregarLibro(new Libro("Hola!", "Bruno Borgna", 2025));
        db2.agregarLibro(new Libro("Chau!", "Gaston Schilardi", 2025));
        db1.agregarLibro(new Libro("Hello!", "Jeremias Carobene Gustavo", 2028));
        //db1.agregarLibro(null); //para probar la excepcion


        // listamos da igual poner db1, db2 o db3
        List<Libro> todos = db2.listarLibros();
        System.out.println("\nLibros en la Database:");
        for (Libro l : todos) {
            System.out.println(" - " + l);
        }


        //EJERCICIO 2


        System.out.println("\n EJERCICIO 2 \n");

        LogisticaLibro logistica = new LogisticaLibro();

        // Crear un libro físico
        Libro1 libroFisico = logistica.crearLibro("Físico", "El Quijote", "Miguel de Cervantes");
        if (libroFisico != null) {
            System.out.println("Libro creado: " + libroFisico.getTipo() + " - " + libroFisico.getTitulo() + " de " + libroFisico.getAutor());
        }

        // Crear un libro digital
        Libro1 libroDigital = logistica.crearLibro("Digital", "Cien años de soledad", "Gabriel García Márquez");
        if (libroDigital != null) {
            System.out.println("Libro creado: " + libroDigital.getTipo() + " - " + libroDigital.getTitulo() + " de " + libroDigital.getAutor());
        }

        // intentar crear un libro con tipo no válido
        Libro1 libroInvalido = logistica.crearLibro("Audio", "El Principito", "Antoine de Saint-Exupéry");
        if (libroInvalido == null) {
            System.out.println("No se pudo crear el libro. Ingrese 'Fisico' ó 'Digital'.");
        }


        //EJERCICIO 3


        System.out.println("\n EJERCICIO 3 \n");

        // fabricas para administradores y usuarios
        abstractfactory.AbstractFactory adminFactory = new abstractfactory.AdminFactory();
        abstractfactory.AbstractFactory usuarioFactory = new abstractfactory.UsuarioFactory();

        // objetos para administradores
        abstractfactory.InterfazUI adminBruno = adminFactory.crearInterfazUI();
        abstractfactory.MetodoEnvio adminEnvio = adminFactory.crearMetodoEnvio();

        //información de los objetos para administradores
        System.out.println("\n--- Configuración para Administrador ---");
        adminBruno.mostrar();
        adminEnvio.enviar();

        // objetos para usuarios normales
        abstractfactory.InterfazUI clienteJuan = usuarioFactory.crearInterfazUI();
        abstractfactory.MetodoEnvio usuarioEnvio = usuarioFactory.crearMetodoEnvio();

        // información de los objetos para usuarios normales
        System.out.println("\n--- Configuración para Usuario Normal ---");
        clienteJuan.mostrar();
        usuarioEnvio.enviar();


        //EJERCICIO 4


        System.out.println("\n EJERCICIO 4 \n");

        Usuario brunoborgna = new Usuario.Builder("Bruno Borgna", "bborgna@gmail.com")
                .direccion("Pedro Molina 500, Ciudad de Mendoza")
                //falta telefono pero no pasa nada
                .fechaNacimiento(LocalDate.of(1990, 5, 15))
                .build(); // lo construye
        System.out.println(brunoborgna); //para mostrarlo

        Usuario jeremiascarobene = new Usuario.Builder("Jeremias Carobene", "jeremias@gmail.com")
                //falta direccion pero no pasa nada
                .telefono("+54 9 261 987 6543")
                .fechaNacimiento(LocalDate.of(1969, 3, 2))
                .build();
        System.out.println(jeremiascarobene);

        Usuario gastonschilardi = new Usuario.Builder("Gaston", "gschilardi@gmail.com")
                //falta direccion y telefono pero no pasa nada
                .fechaNacimiento(LocalDate.of(1969, 3, 2))
                .build();
        System.out.println(gastonschilardi);


        //EJERCICIO 5


        System.out.println("\n EJERCICIO 5 \n");

        // Crear un préstamo prototipo
        Prestamo prestamoPrototipo = new Prestamo(
                "El Principito",
                "Juan Pérez",
                LocalDate.of(2025, 8, 1),  // Fecha de inicio: 1 de agosto de 2025
                LocalDate.of(2025, 8, 15)   // Fecha de fin: 15 de agosto de 2025
        );

        // mostrar el prestamo
        System.out.println("--- Prestamo 1 ---");
        System.out.println(prestamoPrototipo);

        // clonar modificando
        Prestamo prestamo1 = prestamoPrototipo.clone();
        prestamo1.setLibro("Cien años de soledad");
        prestamo1.setUsuario("María López");
        prestamo1.setFechaInicio(LocalDate.of(2025, 8, 5));
        prestamo1.setFechaFin(LocalDate.of(2025, 8, 19));

        Prestamo prestamo2 = prestamoPrototipo.clone();
        prestamo2.setLibro("Don Quijote de la Mancha");
        prestamo2.setUsuario("Carlos García");
        prestamo2.setFechaInicio(LocalDate.of(2025, 8, 10));
        prestamo2.setFechaFin(LocalDate.of(2025, 8, 24));


        // mostramos los clonados
        System.out.println("\n--- Prestamo 2 ---");
        System.out.println(prestamo1);

        System.out.println("\n--- Prestamo 3 ---");
        System.out.println(prestamo2);

        // mostramos q son clones
        System.out.println("\n--- Verificando clonacion ---");
        System.out.println("¿El prestamo 1 y el prestamo 2 son el mismo objeto? " + (prestamoPrototipo == prestamo1));
        System.out.println("¿El prestamo 1 y el prestamo 3 son el mismo objeto? " + (prestamoPrototipo == prestamo2));
        System.out.println("¿El prestamo 2 y el prestamo 3 son el mismo objeto? " + (prestamo1 == prestamo2));


    }
}





