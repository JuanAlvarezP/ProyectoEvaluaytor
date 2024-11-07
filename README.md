# ProyectoEvaluaytor

**ProyectoEvaluaytor** es un sistema backend desarrollado en **Java** con **Spring Boot**, diseñado para proporcionar una solución eficiente y escalable para la gestión de evaluaciones. La aplicación expone una API RESTful que permite a los clientes interactuar con el sistema de manera sencilla y segura.

## Características

- **API RESTful completa:** Endpoints para la gestión de evaluaciones, usuarios y resultados.
- **Seguridad:** Autenticación y autorización implementadas con Spring Security.
- **Gestión de datos:** Operaciones CRUD para los recursos principales.
- **Arquitectura escalable y modular.**

## Tecnologías Utilizadas

- **Lenguaje:** Java 17  
- **Framework:** Spring Boot  
- **Gestión de dependencias:** Maven  
- **Base de datos:** MySQL o cualquier base de datos compatible con JPA  
- **IDE:** Visual Studio Code  

## Requisitos Previos

- **Java 17** o superior  
- **Maven** (para la gestión de dependencias)  
- **Visual Studio Code** con las extensiones de Java  
- **Base de datos MySQL**  

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/JuanAlvarezP/ProyectoEvaluaytor.git

2. Importa el proyecto en Visual Studio Code como un proyecto Maven.
3. Configura las credenciales de la base de datos en el archivo application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/tu_base_de_datos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update

4. Ejecuta la aplicación
   mvn spring-boot:run


