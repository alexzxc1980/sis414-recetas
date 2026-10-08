# API REST - Sistema de Recetas (SIS-414)
**Estudiante:** Juan Alex Chambi Montes

## Examen: API REST de Factura

- [Codigo completo del examen](./examen-facturas)
- [Swagger publico: probar la API](https://sis414-examen.onrender.com/swagger-ui/index.html)
- [Listado de facturas](https://sis414-examen.onrender.com/api/facturas)
- [Guia de endpoints y JSON](./examen-facturas/FACTURA.md)

Implementado con Spring Boot, Spring Data JPA y PostgreSQL. Incluye crear, listar, buscar por ID, actualizar y eliminar facturas. La carpeta examen-facturas es un proyecto Gradle independiente; el proyecto de recetas permanece en la raiz.

El despliegue actual de Render esta conectado al repositorio sis414-examen. Esta carpeta contiene la copia para entrega. Para desplegarla desde este repositorio, usar examen-facturas como Root Directory y configurar DB_URL, DB_USERNAME y DB_PASSWORD en Render.
