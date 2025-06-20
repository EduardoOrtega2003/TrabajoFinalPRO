# 📘 Notas API - Spring Boot RESTful API

Este proyecto es una API REST desarrollada con Spring Boot que permite gestionar usuarios y sus notas. Está diseñada como parte de un proyecto educativo para demostrar el uso de JPA, servicios REST y manejo de errores.

## 📝 Características

- Gestión de usuarios (crear, leer, actualizar, eliminar)
- Gestión de notas asociadas a usuarios
- Validación de datos
- Manejo de errores
- API versionada (v1 y v2)
- Base de datos MySQL

## 🗃️ Requisitos Previos

- Java 17 o superior
- Maven
- MySQL
- IDE (recomendado: IntelliJ IDEA o Eclipse)

## 🛠️ Configuración

1. Clona el repositorio
2. Configura la base de datos MySQL:
   - Crea una base de datos llamada `notasdb`
   - O modifica la configuración en `application.properties` según tus necesidades

3. Configura las credenciales de la base de datos en `application.properties`:
```properties
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

## 🏗️ Estructura del Proyecto

```
notasapi/
├── src/main/java/com/tuapp/notasapi/
│   ├── controller/     # Controladores REST
│   ├── model/         # Entidades JPA
│   ├── repository/    # Repositorios JPA
│   ├── service/       # Servicios de negocio
│   ├── dto/           # Objetos de transferencia de datos
│   └── exception/     # Manejo de excepciones
```

## 🚩 Endpoints de la API

### API v1 - Usuarios

- `GET /api/v1/usuarios` - Obtener todos los usuarios
- `GET /api/v1/usuarios/{id}` - Obtener un usuario específico
- `POST /api/v1/usuarios` - Crear un nuevo usuario
- `PUT /api/v1/usuarios/{id}` - Actualizar un usuario
- `DELETE /api/v1/usuarios/{id}` - Eliminar un usuario

### API v2 - Usuarios

- `POST /api/v2/sign-in` - Registro de usuario

### API v1 - Notas

- `GET /api/v1/notas` - Obtener todas las notas
- `GET /api/v1/notas?usuarioId={id}&order={asc|desc}` - Obtener notas de un usuario
- `GET /api/v1/notas/{id}` - Obtener una nota específica
- `POST /api/v1/notas?usuarioId={id}` - Crear una nueva nota
- `PUT /api/v1/notas/{id}` - Actualizar una nota
- `DELETE /api/v1/notas/{id}` - Eliminar una nota

## ⌨️ Ejemplos de Uso

### Crear un Usuario
```
POST http://localhost:8080/api/v1/usuarios 
application/json" 
{
    "nombre": "Eduardo ortega",
    "email": "edu@ejemplo.com",
    "password": "123456"
}
```

### Crear una Nota
```
http://localhost:8080/api/v1/notas?usuarioId=1 
application/json" 
{
    "titulo": "Mi primera nota",
    "contenido": "Este es el contenido de mi primera nota"
}
```

## 💭 Ejemplos de prueba

### Creación de Usuario V1

![image](https://github.com/user-attachments/assets/215a719f-fcda-4005-a8c6-2ac41043c3d7)

### Creación de Nota

![image](https://github.com/user-attachments/assets/297816fc-dcfb-4cc4-9997-39e18b085310)

### Mostramos el resultado

![image](https://github.com/user-attachments/assets/f89f5e2e-2e82-4fa7-86a8-8360ec300be7)

### Edición de Usuario y Nota

![image](https://github.com/user-attachments/assets/7fd59b2d-f897-40a0-900b-194065d78b18)

### Eliminación de Nota y Usuario

![image](https://github.com/user-attachments/assets/2002f5fa-0942-4bed-b593-195ed2b98e95)

![image](https://github.com/user-attachments/assets/49dfa889-4cf0-4f92-98a7-d9627f26f6de)

### Creación de Usuario V2

![image](https://github.com/user-attachments/assets/2cfde4b1-998b-48a3-8f86-10618e56b7d7)

## ✅ Validaciones

- Nombre: No puede estar vacío, entre 2 y 100 caracteres
- Email: Formato válido y único
- Contraseña: Mínimo 6 caracteres
- Título de nota: No puede estar vacío, entre 2 y 100 caracteres
- Contenido de nota: No puede estar vacío

## 👁️‍🗨️ Manejo de Errores

La API devuelve códigos de estado HTTP apropiados:
- 200: OK
- 201: Created
- 400: Bad Request
- 404: Not Found
- 500: Internal Server Error

## 🧑🏼‍💻 Tecnologías Utilizadas

- Spring Boot 3.5.0
- Spring Data JPA
- MySQL
- Lombok
- Maven

## ✍🏼 Autor

Eduardo Ortega y Yanira Gutierrez

## 🚶🏼‍♂️‍➡️ Enlace del repositorio de GitHub

https://github.com/EduardoOrtega2003/TrabajoFinalPRO.git
