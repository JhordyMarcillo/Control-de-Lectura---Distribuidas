INSERT INTO usuarios (id, nombre, email, capital_disponible) VALUES
 (uuid_generate_v4(), 'Juan Perez', 'juan.perez@andesfin.com', 5000.00),
 (uuid_generate_v4(), 'Maria Lopez', 'maria.lopez@andesfin.com', 8000.00),
 (uuid_generate_v4(), 'Carlos Gomez', 'carlos.gomez@andesfin.com', 3000.00),
 (uuid_generate_v4(), 'Ana Torres', 'ana.torres@andesfin.com', 10000.00),
 (uuid_generate_v4(), 'Luis Andrade', 'luis.andrade@andesfin.com', 6500.00);

INSERT INTO productos_financieros
(id, nombre, descripcion, costo, porcentaje_retorno, activo)
VALUES
(uuid_generate_v4(), 'ETF Global',
 'ETF diversificado de mercados globales',
 1500.00, 12.00, true),

(uuid_generate_v4(), 'Fondo Acciones Tech',
 'Fondo enfocado en acciones tecnológicas',
 1000.00, 8.50, true),

(uuid_generate_v4(), 'Fondo de Dividendos',
 'Fondo orientado a generación de dividendos',
 800.00, 6.75, true),

(uuid_generate_v4(), 'Bonos Corporativos AAA',
 'Bonos corporativos de alta calificación',
 500.00, 5.25, true);
