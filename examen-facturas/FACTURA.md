# API Factura — SIS414

Implementa Spring Boot y Spring Data JPA con las capas Entity, Repository, Service y Controller.

| Campo | Tipo |
| --- | --- |
| id | Long, generado por la base |
| numero | String |
| cliente | String |
| total | Double |
| fecha | LocalDate |

| Método | Ruta | Resultado |
| --- | --- | --- |
| POST | /api/facturas | Crea, HTTP 201 |
| GET | /api/facturas | Lista, HTTP 200 |
| GET | /api/facturas/{id} | Busca, HTTP 200 o 404 |
| PUT | /api/facturas/{id} | Actualiza, HTTP 200 o 404 |
| DELETE | /api/facturas/{id} | Elimina, HTTP 204 o 404 |

JSON para POST o PUT:

```json
{
  "numero": "F-001",
  "cliente": "Ana Perez",
  "total": 125.5,
  "fecha": "2026-10-08"
}
```

Probar desde /swagger-ui/index.html. Primero crear, copiar el id generado, buscarlo, actualizarlo y eliminarlo. Una búsqueda posterior debe devolver 404.

Configurar PostgreSQL con DB_URL, DB_USERNAME y DB_PASSWORD según README.md. Hibernate crea la tabla facturas al arrancar. El ejemplo Product de clase permanece como referencia separada.

La pregunta teórica 10 corresponde a la opción A: la clase principal con @SpringBootApplication contiene el método main en el patrón típico.
