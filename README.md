# Sistema de Control de Lectura - Simulación de Inversiones Financieras

## 📋 Descripción del Proyecto

**ControlLectura** es una API REST desarrollada en Spring Boot que permite simular inversiones financieras. El sistema gestiona usuarios, productos financieros y realiza simulaciones de inversión utilizando un algoritmo greedy que selecciona los productos con mayor porcentaje de retorno dentro del capital disponible.

### Características Principales:
- **Gestión de Usuarios**: CRUD de usuarios con capital disponible para invertir
- **Catálogo de Productos**: Productos financieros con costos y porcentajes de retorno
- **Simulación de Inversiones**: Algoritmo greedy que optimiza la selección de productos
- **Historial de Simulaciones**: Registro y consulta de simulaciones realizadas por usuario
- **Cálculo de Retornos**: Estimación de ganancias basadas en el porcentaje de retorno de cada producto

---

## 🛠️ Tecnologías Utilizadas

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| **Java** | 25 | Lenguaje de programación principal |
| **Spring Boot** | 4.0.2 | Framework de aplicación |
| **Spring Data JPA** | 4.0.2 | Persistencia de datos |
| **PostgreSQL** | Latest | Base de datos relacional |
| **Maven** | Latest | Gestión de dependencias |
| **Lombok** | Latest | Reducción de código boilerplate |
| **Docker** | Latest | Contenedor de base de datos |

### Dependencias Principales:
- `spring-boot-starter-data-jpa`: ORM y acceso a datos
- `spring-boot-starter-webmvc`: Framework web REST
- `spring-boot-starter-validation`: Validación de datos
- `postgresql`: Driver de conexión a PostgreSQL
- `lombok`: Anotaciones para reducir código

---

## 📦 Instalación y Ejecución

### Prerrequisitos
- JDK 25 o superior
- Maven 3.8+
- PostgreSQL 15+ (o usar Docker)

### Opción 1: Ejecución Local con PostgreSQL

1. **Crear la base de datos PostgreSQL:**
   ```sql
   CREATE DATABASE db_control;
   ```

2. **Configurar credenciales en `application.yaml`:**
   ```yaml
   spring:
     datasource:
       url: jdbc:postgresql://localhost:5432/db_control
       username: postgres
       password: postgres
   ```

3. **Ejecutar la aplicación:**
   ```bash
   ./mvnw spring-boot:run
   ```

### Opción 2: Usando Docker Compose

1. **Ejecutar PostgreSQL en contenedor:**
   ```bash
   docker-compose up -d
   ```

2. **Ejecutar la aplicación:**
   ```bash
   ./mvnw spring-boot:run
   ```

### Verificar que está funcionando:
La API estará disponible en: `http://localhost:8080`

---

## 🔗 Endpoints de la API

### 1. Listar Todos los Usuarios

**Endpoint:** `GET /usuarios`

**Descripción:** Retorna la lista de todos los usuarios registrados en el sistema.

**Respuesta (200 OK):**
```json
[
  {
    "id": "550e8400-e29b-41d4-a716-446655440000",
    "nombre": "Juan Perez",
    "email": "juan.perez@andesfin.com",
    "capitalDisponible": 5000.00
  },
  {
    "id": "550e8400-e29b-41d4-a716-446655440001",
    "nombre": "Maria Lopez",
    "email": "maria.lopez@andesfin.com",
    "capitalDisponible": 8000.00
  }
]
```

---

### 2. Listar Productos Financieros

**Endpoint:** `GET /productos`

**Descripción:** Retorna todos los productos financieros activos disponibles para inversión.

**Respuesta (200 OK):**
```json
[
  {
    "nombre": "ETF Global",
    "costo": 1500.00,
    "porcentajeRetorno": 12.00,
    "gananciaEstimada": null
  },
  {
    "nombre": "Fondo Acciones Tech",
    "costo": 1000.00,
    "porcentajeRetorno": 8.50,
    "gananciaEstimada": null
  },
  {
    "nombre": "Fondo de Dividendos",
    "costo": 800.00,
    "porcentajeRetorno": 6.75,
    "gananciaEstimada": null
  },
  {
    "nombre": "Bonos Corporativos AAA",
    "costo": 500.00,
    "porcentajeRetorno": 5.25,
    "gananciaEstimada": null
  }
]
```

---

### 3. Crear Simulación de Inversión

**Endpoint:** `POST /simulaciones`

**Descripción:** Ejecuta una simulación de inversión seleccionando productos con mayor retorno dentro del capital disponible.

**Cuerpo de la Petición (JSON):**
```json
{
  "usuario_id": "550e8400-e29b-41d4-a716-446655440000",
  "capital_disponible": 5000.00,
  "productos_ids": [
    "660e8400-e29b-41d4-a716-446655440001",
    "660e8400-e29b-41d4-a716-446655440002",
    "660e8400-e29b-41d4-a716-446655440003",
    "660e8400-e29b-41d4-a716-446655440004"
  ]
}
```

**Respuesta (200 OK):**
```json
{
  "id": "770e8400-e29b-41d4-a716-446655440000",
  "usuario_id": "550e8400-e29b-41d4-a716-446655440000",
  "simulacion_id": "770e8400-e29b-41d4-a716-446655440000",
  "fecha_simulacion": "2024-01-15T10:30:00",
  "capital_disponible": 5000.00,
  "ganancia_total": 275.00,
  "productos": [
    {
      "nombre": "ETF Global",
      "costo": 1500.00,
      "porcentajeRetorno": 12.00,
      "gananciaEstimada": 180.00
    },
    {
      "nombre": "Fondo Acciones Tech",
      "costo": 1000.00,
      "porcentajeRetorno": 8.50,
      "gananciaEstimada": 85.00
    },
    {
      "nombre": "Fondo de Dividendos",
      "costo": 800.00,
      "porcentajeRetorno": 6.75,
      "gananciaEstimada": 54.00
    },
    {
      "nombre": "Bonos Corporativos AAA",
      "costo": 500.00,
      "porcentajeRetorno": 5.25,
      "gananciaEstimada": 26.25
    }
  ]
}
```

---

### 4. Listar Simulaciones por Usuario

**Endpoint:** `GET /simulaciones/{usuarioId}`

**Descripción:** Retorna el historial de simulaciones realizadas por un usuario específico.

**Respuesta (200 OK):**
```json
[
  {
    "id": "770e8400-e29b-41d4-a716-446655440000",
    "usuario_id": "550e8400-e29b-41d4-a716-446655440000",
    "fecha_simulacion": "2024-01-15T10:30:00",
    "capital_disponible": 5000.00,
    "ganancia_total": 275.00,
    "cantidad_productos": 4,
    "retorno_porcentaje": 5.50
  }
]
```

---

## 📊 Ejemplos de Uso y Tablas de Cálculo

### Ejemplo 1: Simulación con Capital de $5,000

**Productos Disponibles:**
| Producto | Costo | % Retorno | Ganancia Estimada |
|----------|-------|-----------|-------------------|
| ETF Global | $1,500 | 12.00% | $180.00 |
| Fondo Acciones Tech | $1,000 | 8.50% | $85.00 |
| Fondo de Dividendos | $800 | 6.75% | $54.00 |
| Bonos Corporativos AAA | $500 | 5.25% | $26.25 |

**Algoritmo de Selección:**
1. Ordenar productos por mayor % de retorno (descendente)
2. Seleccionar productos mientras el costo acumulado no supere el capital disponible

**Resultado:**
```
Capital Disponible: $5,000.00

Productos Seleccionados:
├── ETF Global: $1,500.00 → Ganancia: $180.00
├── Fondo Acciones Tech: $1,000.00 → Ganancia: $85.00
├── Fondo de Dividendos: $800.00 → Ganancia: $54.00
└── Bonos Corporativos AAA: $500.00 → Ganancia: $26.25
    ───────────────────────────────────────────────────
    Total Invertido: $3,800.00
    Ganancia Total: $345.25
    Retorno General: 6.905%
```

---

### Ejemplo 2: Simulación con Capital de $8,000

**Solicitud:**
```json
{
  "usuario_id": "550e8400-e29b-41d4-a716-446655440001",
  "capital_disponible": 8000.00,
  "productos_ids": ["todos"]
}
```

**Resultado:**
| Producto | Costo | % Retorno | Ganancia | Selection |
|----------|-------|-----------|----------|-----------|
| ETF Global | $1,500 | 12.00% | $180.00 | ✓ |
| Fondo Acciones Tech | $1,000 | 8.50% | $85.00 | ✓ |
| Fondo de Dividendos | $800 | 6.75% | $54.00 | ✓ |
| Bonos Corporativos AAA | $500 | 5.25% | $26.25 | ✓ |

```
Capital Disponible: $8,000.00
Capital Invertido: $3,800.00
Ganancia Total: $345.25
Retorno sobre Capital: 4.32%
Capital Sobrante: $4,200.00
```

---

### Ejemplo 3: Cálculo de Retorno Porcentual

**Fórmula:**
```
Retorno Porcentual = (Ganancia Total / Capital Disponible) × 100
```

**Ejemplo de Cálculo:**
```
Ganancia Total: $345.25
Capital Disponible: $5,000.00

Retorno = ($345.25 / $5,000.00) × 100
Retorno = 0.06905 × 100
Retorno = 6.905%
```

---

### Ejemplo 4: Selección de Productos con Algoritmo Greedy

**Lógica del Algoritmo:**
```java
// 1. Ordenar por mayor porcentaje de retorno
productos.sort((a, b) -> b.getPorcentajeRetorno().compareTo(a.getPorcentajeRetorno()));

// 2. Seleccionar productos mientras haya capital disponible
for (ProductoFinanciero producto : productos) {
    if (costoAcumulado.add(producto.getCosto()).compareTo(capitalDisponible) <= 0) {
        // Seleccionar producto
        BigDecimal ganancia = producto.getCosto()
            .multiply(producto.getPorcentajeRetorno())
            .divide(BigDecimal.valueOf(100));
    }
}
```

**Demostración con $3,000 de Capital:**

| Paso | Producto | Costo | % Retorno | Capital Actual | Acción |
|------|----------|-------|-----------|----------------|--------|
| 1 | ETF Global | $1,500 | 12.00% | $3,000 | ✓ Seleccionado |
| 2 | Fondo Tech | $1,000 | 8.50% | $1,500 | ✓ Seleccionado |
| 3 | Dividendos | $800 | 6.75% | $500 | ✗ No cabe |
| 4 | Bonos AAA | $500 | 5.25% | $500 | ✓ Seleccionado |

**Resultado Final:**
```
Inversión Total: $3,000.00
Ganancia: $180.00 + $85.00 + $26.25 = $291.25
Retorno: 9.71%
```

---

## 📁 Estructura del Proyecto

```
Control-de-Lectura---Distribuidas/
├── pom.xml                                    # Configuración Maven
├── src/main/
│   ├── java/com/espe/edu/ec/ControlLectura/
│   │   ├── ControlLecturaApplication.java    # Clase principal
│   │   ├── config/                           # Configuraciones
│   │   ├── controllers/                      # Controladores REST
│   │   │   ├── ProductoController.java
│   │   │   ├── SimulacionController.java
│   │   │   └── UsuarioController.java
│   │   ├── dtos/                             # Data Transfer Objects
│   │   │   ├── ProductoDTO.java
│   │   │   ├── SimulacionRequestDTO.java
│   │   │   ├── SimulacionResponseDTO.java
│   │   │   └── SimulacionResumenDTO.java
│   │   ├── entities/                         # Entidades JPA
│   │   │   ├── ProductoFinanciero.java
│   │   │   ├── Simulacion.java
│   │   │   ├── SimulacionProducto.java
│   │   │   └── Usuario.java
│   │   ├── repository/                       # Repositorios
│   │   ├── service/                          # Servicios
│   │   └── docker-compose.yml                # Docker PostgreSQL
│   └── resources/
│       └── application.yaml                  # Configuración app
└── src/test/                                 # Tests unitarios
```

---

## 🔧 Configuración de Base de Datos

### Datos Iniciales Cargados

**Usuarios:**
| ID | Nombre | Email | Capital |
|----|--------|-------|---------|
| uuid-1 | Juan Perez | juan.perez@andesfin.com | $5,000 |
| uuid-2 | Maria Lopez | maria.lopez@andesfin.com | $8,000 |
| uuid-3 | Carlos Gomez | carlos.gomez@andesfin.com | $3,000 |
| uuid-4 | Ana Torres | ana.torres@andesfin.com | $10,000 |
| uuid-5 | Luis Andrade | luis.andrade@andesfin.com | $6,500 |

**Productos Financieros:**
| Nombre | Descripción | Costo | % Retorno |
|--------|-------------|-------|-----------|
| ETF Global | ETF diversificado de mercados globales | $1,500 | 12.00% |
| Fondo Acciones Tech | Fondo enfocado en acciones tecnológicas | $1,000 | 8.50% |
| Fondo de Dividendos | Fondo orientado a generación de dividendos | $800 | 6.75% |
| Bonos Corporativos AAA | Bonos corporativos de alta calificación | $500 | 5.25% |

---

## 🚀 Próximos Pasos

- [ ] Agregar autenticación JWT
- [ ] Implementar más algoritmos de inversión
- [ ] Agregar gráficos de rendimiento
- [ ] Implementar tests de integración
- [ ] Documentación con Swagger/OpenAPI

---

## 📝 Licencia

Este proyecto fue desarrollado para fines educativos en la Universidad de las Fuerzas Armadas ESPE.

---

**Desarrollado con ❤️ para la materia de Sistemas Distribuidos**

