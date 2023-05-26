package net.javaguides.springboot.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*La anotación @ResponseStatus es una anotación proporcionada por Spring Framework
en Java que se utiliza para asignar un código de estado HTTP específico a una respuesta
de una clase controladora (controller) en una aplicación web.

Al aplicar la anotación @ResponseStatus a una clase controladora o a un método de una
 clase controladora, se puede especificar el código de estado HTTP que se enviará en la
  respuesta cuando se invoque ese controlador.*/
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message){
        super(message);

    }
}
