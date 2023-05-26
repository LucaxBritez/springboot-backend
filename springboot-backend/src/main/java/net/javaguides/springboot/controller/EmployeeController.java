package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
  En Spring Boot, "@RestController" es una anotación que se utiliza para marcar una clase como un controlador REST.
Un controlador REST es un componente de una aplicación web que maneja las solicitudes HTTP entrantes y devuelve las
respuestas HTTP correspondientes.
  Cuando se utiliza la anotación "@RestController", todos los métodos de la clase se consideran
de forma predeterminada como métodos que devuelven datos en formato JSON o XML. La anotación "@ResponseBody" se
aplica automáticamente a cada método de la clase, por lo que no es necesario anotar cada método individualmente.
  La anotación "@RestController" también proporciona la capacidad de manejar automáticamente los
errores y excepciones, y es compatible con la anotación "@RequestMapping"
para permitir la asignación de rutas URL a los métodos del controlador.
  En resumen, la anotación "@RestController" en Spring Boot se utiliza para marcar una clase
como un controlador REST. La anotación combina la funcionalidad de las anotaciones "@Controller" y
"@ResponseBody" y permite que los métodos de la clase devuelvan datos en formato JSON o XML.
También proporciona la capacidad de manejar automáticamente los errores y excepciones y
es compatible con la anotación "@RequestMapping".
*/
@RestController



/*En Spring Boot, "@RequestMapping" es una anotación que se utiliza para
asignar una URL a un método de controlador específico. Es una anotación
muy útil para definir la ruta de acceso para las solicitudes HTTP
y mapear los métodos del controlador que procesan las solicitudes.*/
@RequestMapping("/api/v1/employees")

public class EmployeeController {

  /*La anotación @Autowired se utiliza en Spring Framework para inyectar automáticamente las dependencias de una
    clase, permitiendo que se manejen las instancias necesarias sin tener que crearlas manualmente.*/
  @Autowired
  private EmployeeRepository employeeRepository;

  /*La anotación "@GetMapping" en Spring Boot se utiliza para asignar una URL a un método
de controlador específico que maneja las solicitudes HTTP GET. La anotación es una variante
más específica de la anotación "@RequestMapping" que se utiliza cuando se desea definir una
ruta de acceso para una solicitud GET específica. La anotación puede ser utilizada a nivel de
clase y de método, y permite definir una ruta de acceso específica para una solicitud GET.*/
  @GetMapping
  //Recuperar todos los empleados REST API
  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }

  /*En resumen, la anotación "@PostMapping" en Spring Boot se utiliza para asignar una URL a
 un método de controlador específico que maneja las solicitudes HTTP POST. La anotación es una
 variante más específica de la anotación "@RequestMapping" que se utiliza cuando se desea definir
 una ruta de acceso para una solicitud POST específica. La anotación puede ser utilizada a nivel de
 clase y de método, y permite definir una ruta de acceso específica para una solicitud POST.*/
  //Crear empleados REST API
  @PostMapping
    /*La anotación @RequestBody es una anotación proporcionada por Spring en Java que se utiliza en
     el contexto de un controlador (controller) para indicar que un parámetro de un método de controlador
      debe estar enlazado al cuerpo de la solicitud HTTP.
      Cuando se aplica @RequestBody a un parámetro de un método de controlador, Spring se encarga de
      analizar automáticamente el cuerpo de la solicitud y convertirlo en el tipo de objeto
      especificado en el parámetro. Esto es especialmente útil cuando se trabaja con solicitudes POST
      o PUT donde los datos se envían en el cuerpo de la solicitud en lugar de en la URL.*/
  public Employee createEmployee(@RequestBody Employee employee) {
    return employeeRepository.save(employee);
  }

  //Recuperar empleado en base al ID REST API

  @GetMapping("{id}")


    /*La anotación @PathVariable es una anotación proporcionada por Spring en Java que se utiliza en el contexto de un
     controlador (controller) para obtener valores de variables de la URL y asignarlos como parámetros de un método de
     controlador.

    Cuando se aplica @PathVariable a un parámetro de un método de controlador, Spring busca el valor correspondiente
    en la URL y lo asigna al parámetro. Esto es especialmente útil cuando se necesita acceder a partes variables de una
    URL, como identificadores únicos o valores dinámicos.*/
  public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
    Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
    return ResponseEntity.ok(employee);
  }

  //Modificar un empleado existente REST API
  /*La anotación @PutMapping es una anotación proporcionada por Spring en Java que se utiliza en el contexto de un
   controlador (controller) para mapear una solicitud HTTP PUT a un método de controlador específico.

    Cuando se aplica @PutMapping a un método de controlador, se especifica que ese método debe ser invocado cuando se
    reciba una solicitud HTTP PUT en la URL mapeada.*/
  @PutMapping("{id}")
  public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails) {
    Employee updateEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

    updateEmployee.setFirstName(employeeDetails.getFirstName());
    updateEmployee.setLastName(employeeDetails.getLastName());
    updateEmployee.setEmailId(employeeDetails.getEmailId());

    employeeRepository.save(updateEmployee);

    return ResponseEntity.ok(updateEmployee);
  }


  //Borar empleado REST API
  /*La anotación @DeleteMapping es una anotación proporcionada por Spring en Java que se utiliza en el
  contexto de un controlador (controller) para mapear una solicitud HTTP DELETE a un método de controlador específico.

  Cuando se aplica @DeleteMapping a un método de controlador, se especifica que ese método debe
  ser invocado cuando se reciba una solicitud HTTP DELETE en la URL mapeada.*/
  @DeleteMapping("{id}")
  public  ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){

    Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
    employeeRepository.delete(employee);
    return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
