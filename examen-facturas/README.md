# sis414-examen

API REST de Factura para SIS414, adaptada del ejemplo de clase:
https://github.com/jdka-suburbio/sis414v4

Java 21, Gradle Wrapper, PostgreSQL, Spring Data JPA y Swagger.
Implementa el CRUD de Factura con id, numero, cliente, total y fecha. Se conserva Product como referencia de clase.

## Examen de Factura

- Swagger desplegado: https://sis414-examen.onrender.com/swagger-ui/index.html
- API: https://sis414-examen.onrender.com/api/facturas
- [Endpoints y ejemplo JSON](FACTURA.md)
- Operaciones: crear, listar, buscar por ID, actualizar y eliminar.
- Para desplegar desde este repositorio en Render: Root Directory = examen-facturas.

## Ejecutar en Windows

Configurar DB_URL, DB_USERNAME y DB_PASSWORD en el entorno del IDE o de PowerShell.
DB_URL debe tener formato JDBC: jdbc:postgresql://HOST:5432/DATABASE
Para una conexión externa que requiera TLS, agregar ?sslmode=require.
El archivo .env.example documenta las variables: Spring no carga archivos .env automáticamente.

```powershell
.\gradlew.bat bootRun
```

Swagger: http://localhost:8080/swagger-ui/index.html
Comprobación de arranque: http://localhost:8080/health

## Render

1. Crear PostgreSQL en Render y guardar sus datos de conexión.
2. Subir este proyecto a GitHub.
3. Crear un Web Service conectado al repositorio, con runtime Docker y el plan elegido.
4. Configurar DB_URL (JDBC), DB_USERNAME y DB_PASSWORD. Si el servicio y la base están en la misma región, usar el hostname interno de PostgreSQL.
5. Desplegar y abrir /health y /swagger-ui/index.html en la URL del servicio.

También se incluye render.yaml para crear el servicio con un Blueprint. La base se crea aparte; las tres variables se ingresan en Render. No subir contraseñas al repositorio.

## Ejemplo de la clase

- POST /api/products: crear con {"name":"Cuaderno","price":12.5}.
- GET /api/products: listar.
- GET /api/products/{id}: buscar; 404 si no existe.
- DELETE /api/products/{id}: eliminar; 204 o 404.

El ejemplo original no incluye PUT. /health confirma que la aplicación arrancó; no ejecuta una consulta SQL.
