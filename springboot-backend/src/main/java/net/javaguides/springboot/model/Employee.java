package net.javaguides.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/*La anotación @Getter es una anotación proporcionada por el proyecto Lombok que se utiliza en Java
para generar automáticamente los métodos de acceso "getters" para los campos de una clase. Al
 aplicar la anotación @Getter a un campo, Lombok generará un método getter correspondiente para
 ese campo, lo que simplifica la escritura del código y reduce la cantidad de código repetitivo.*/
@Getter

/*La anotación @Setter es otra anotación proporcionada por Lombok en Java
que se utiliza para generar automáticamente los métodos de acceso "setters"
para los campos de una clase. Al aplicar la anotación @Setter a un campo, Lombok
generará automáticamente un método setter correspondiente para ese campo.*/
@Setter

/* La anotación @NoArgsConstructor es otra anotación proporcionada por Lombok en
*  Java que se utiliza para generar automáticamente un constructor sin argumentos
*  en una clase. Al aplicar la anotación @NoArgsConstructor a una clase, Lombok generará
*  automáticamente un constructor sin argumentos.*/
@NoArgsConstructor


/*La anotación @AllArgsConstructor es una anotación proporcionada por Lombok en Java
que se utiliza para generar automáticamente un constructor con todos los argumentos en una clase.
Al aplicar la anotación @AllArgsConstructor a una clase, Lombok generará automáticamente un
constructor que acepte todos los campos de la clase como argumentos.*/
@AllArgsConstructor

//La anotación @Entity especifica que la clase es una entidad y está asignada a una tabla de base de datos.
@Entity

//La anotación @Table especifica el nombre de la tabla de la base de datos que se usará para la asignación.
@Table(name = "employees")
public class Employee {

    //La etiqueta "@Id" es utilizada en JPA para marcar un campo como clave primaria de una entidad, lo que permite
    // mapear objetos Java a filas de una tabla en una base de datos relacional.


    //La etiqueta "@GeneratedValue" se utiliza en JPA para especificar cómo se generará el valor de
    // una clave primaria de manera automática. Esta anotación se utiliza junto con la anotación "@Id" para indicar que
    // un campo representa la clave primaria de una entidad.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id")
    private String emailId;

}
