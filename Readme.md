# Microservicio para Consumir y Almacenar Datos de JSONPlaceholder

Este microservicio, desarrollado en Java 11, consume el servicio [jsonplaceholder.typicode.com/posts](https://jsonplaceholder.typicode.com/posts), almacena los resultados en una base de datos en memoria (H2) y expone un endpoint para buscar información por ID o título. Además, se incluye la configuración de JWT para asegurar el endpoint.

## Estructura del Proyecto

La estructura del proyecto se organiza de la siguiente manera:

1. **`src/main/java/com/evaluacion/app/`**: Contiene el código fuente del microservicio.
   - `AppApplication.java`: Clase principal para iniciar la aplicación.
   - `controllers/PublicacionController.java`: Controlador que expone el endpoint y maneja las solicitudes.
   - `models/Publicacion.java`: Clase que representa la entidad de los posts obtenidos del servicio.
   - `models/Usuario.java`: Clase que representa la entidad de los usuarios que acceden al sistema(No genera tablas en la base de datos ya que solo se uso como ejemplo para el inicio de secion con JWT atraves de un login que genera un token el cual es usado para acceder a los demas end-points).
   - `security/*`: Clases empleadas para la configuracion del JWT.
   - `services/PublicacionService.java`: Servicio para manejar la lógica de negocio.

2. **`src/main/resources/`**: Contiene el archivo `application.properties` con la configuración de la base de datos H2.

3. **`EJERCICIO_3.postman_collection.json`**: Archivo de colección de Postman para la validación del microservicio.

4. **`README.md`**: Instrucciones para desplegar el microservicio.

## Pasos para Desplegar el Microservicio

### Requisitos Previos

- Java 11 o superior instalado.
- Maven instalado.
- Postman instalado.

### Pasos

1. Clona o descarga este repositorio en tu máquina local.

    ```bash
    git clone https://github.com/VazquezAriel/EvaluacionArielVazquez3
    ```

2. Navega al directorio del proyecto:

    ```bash
    cd ruta/del/proyecto
    ```

3. Compila el proyecto con Maven:

    ```bash
    mvn clean install
    ```

4. Ejecuta el microservicio:

    ```bash
    java -jar target/nombre-del-jar.jar
    ```

5. El microservicio estará disponible en [http://localhost:8080](http://localhost:8080).

6. Utiliza Postman para probar el microservicio (`EJERCICIO_3.postman_collection.json`).

### Base de datos

- La base de datos H2 está configurada en el archivo `application.properties`. Puedes acceder a la consola de H2 en [http://localhost:8080/h2-bd](http://localhost:8080/h2-bd) (usuario: admin, contraseña: admin12345).





