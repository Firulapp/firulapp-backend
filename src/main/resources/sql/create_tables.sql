CREATE TABLE usuario(
    id BIGSERIAL PRIMARY KEY,
    nombre_usuario VARCHAR(50) UNIQUE NOT NULL,
    correo VARCHAR(100) UNIQUE NOT NULL,
    clave_encriptada VARCHAR(128) NOT NULL,
    tipo_usuario VARCHAR(20) NOT NULL,
    habilitado BOOLEAN NOT NULL,
    logueado BOOLEAN NOT NULL,
    fecha_creacion TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    fecha_modificacion TIMESTAMP WITHOUT TIME ZONE
);

CREATE TABLE ciudad(
   id BIGSERIAL PRIMARY KEY NOT NULL,
   nombre VARCHAR(100) NOT NULL,
   departamento VARCHAR(100) NOT NULL,
   pais VARCHAR(100) NOT NULL,
   estado BOOLEAN,
   fecha_creacion TIMESTAMP WITHOUT TIME ZONE NOT NULL,
   usuario_creacion BIGINT NOT NULL,
   fecha_modificacion TIMESTAMP WITHOUT TIME ZONE,
   usuario_modificacion BIGINT
);

CREATE TABLE detalle_usuario(
    id BIGSERIAL PRIMARY KEY,
    id_usuario BIGINT NOT NULL REFERENCES usuario(id) ON DELETE CASCADE,
    nro_documento VARCHAR(18) NOT NULL,
    tipo_documento VARCHAR(50) NOT NULL,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    ciudad BIGINT REFERENCES ciudad(id) ON DELETE CASCADE,
    foto_perfil BYTEA,
    fecha_nacimiento DATE NOT NULL,
    notificaciones BOOLEAN NOT NULL,
    fecha_creacion TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    fecha_modificacion TIMESTAMP WITHOUT TIME ZONE,
    usuario_modificacion BIGINT
);

CREATE TABLE dispositivo_usuario(
    id BIGSERIAL PRIMARY KEY,
    id_usuario BIGINT NOT NULL REFERENCES usuario(id) ON DELETE CASCADE,
    fecha_asociacion TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    fecha_desasociacion TIMESTAMP WITHOUT TIME ZONE,
    fecha_modificacion TIMESTAMP WITHOUT TIME ZONE,
    usuario_modificacion BIGINT
);

CREATE TABLE sesion_usuario(
    id BIGSERIAL PRIMARY KEY,
    id_usuario BIGINT NOT NULL REFERENCES usuario(id) ON DELETE CASCADE,
    id_dispositivo BIGINT NOT NULL REFERENCES dispositivo_usuario(id) ON DELETE CASCADE,
    fecha_inicio TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    fecha_fin TIMESTAMP WITHOUT TIME ZONE,
    fecha_modificacion TIMESTAMP WITHOUT TIME ZONE,
    usuario_modificacion BIGINT
);

CREATE TABLE regla_conducta(
    id BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descripcion TEXT NOT NULL,
    estado BOOLEAN NOT NULL DEFAULT TRUE,
    fecha_creacion TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    usuario_creacion BIGINT NOT NULL,
    fecha_modificacion TIMESTAMP WITHOUT TIME ZONE,
    usuario_modificacion BIGINT
);

CREATE TABLE especie_animal(
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT NOT NULL,
    estado BOOLEAN NOT NULL DEFAULT TRUE,
    fecha_creacion TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    usuario_creacion BIGINT NOT NULL,
    fecha_modificacion TIMESTAMP WITHOUT TIME ZONE,
    usuario_modificacion BIGINT
);

CREATE TABLE raza_animal(
    id BIGSERIAL PRIMARY KEY,
    id_especie BIGINT NOT NULL REFERENCES especie_animal(id) ON DELETE CASCADE,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT NOT NULL,
    estado BOOLEAN NOT NULL DEFAULT TRUE,
    fecha_creacion TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    usuario_creacion BIGINT NOT NULL,
    fecha_modificacion TIMESTAMP WITHOUT TIME ZONE,
    usuario_modificacion BIGINT
);

CREATE TABLE tipo_servicio(
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT NOT NULL,
    estado BOOLEAN NOT NULL DEFAULT TRUE,
    fecha_creacion TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    usuario_creacion BIGINT NOT NULL,
    fecha_modificacion TIMESTAMP WITHOUT TIME ZONE,
    usuario_modificacion BIGINT
);

CREATE TABLE ayuda(
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT NOT NULL,
    estado BOOLEAN NOT NULL DEFAULT TRUE,
    enlace VARCHAR(255),
    fecha_creacion TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    usuario_creacion BIGINT NOT NULL,
    fecha_modificacion TIMESTAMP WITHOUT TIME ZONE,
    usuario_modificacion BIGINT
);

CREATE TABLE cuidado_mascota(
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT NOT NULL,
    estado BOOLEAN NOT NULL DEFAULT TRUE,
    imagen BYTEA,
    link VARCHAR(255),
    id_especie BIGINT REFERENCES especie_animal(id) ON DELETE CASCADE,
    id_raza BIGINT REFERENCES raza_animal(id) ON DELETE CASCADE,
    fecha_creacion TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    usuario_creacion BIGINT NOT NULL,
    fecha_modificacion TIMESTAMP WITHOUT TIME ZONE,
    usuario_modificacion BIGINT
);

CREATE TABLE mascota(
    id BIGSERIAL PRIMARY KEY,
    id_usuario BIGINT REFERENCES usuario(id) ON DELETE CASCADE,
    id_especie BIGINT REFERENCES especie_animal(id) ON DELETE CASCADE,
    id_raza BIGINT REFERENCES raza_animal(id) ON DELETE CASCADE,
    nombre VARCHAR(255),
    fecha_nacimiento DATE,
    edad INT,
    tamanho VARCHAR(10),
    ciudad BIGINT REFERENCES ciudad(id) ON DELETE CASCADE,
    direccion VARCHAR(255),
    color_primario VARCHAR(255),
    color_secundario VARCHAR(255),
    estado VARCHAR(30),
    fotografia BYTEA,
    descripcion VARCHAR(255),
    fecha_creacion TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    usuario_creacion BIGINT NOT NULL,
    fecha_modificacion TIMESTAMP WITHOUT TIME ZONE,
    usuario_modificacion BIGINT
);

CREATE TABLE ficha_medica_mascota(
    id BIGSERIAL PRIMARY KEY,
    id_mascota BIGINT REFERENCES mascota(id) ON DELETE CASCADE,
    veterinaria VARCHAR(255) NOT NULL,
    tratamiento TEXT,
    observacion TEXT,
    diagnostico TEXT,
    recordatorio_tratamiento BOOLEAN,
    peso_mascota BIGINT,
    medida BIGINT,
    fecha_consulta DATE NOT NULL,
    fecha_creacion TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    usuario_creacion BIGINT NOT NULL,
    fecha_modificacion TIMESTAMP WITHOUT TIME ZONE,
    usuario_modificacion BIGINT
);

CREATE TABLE vacunacion_mascota(
    id BIGSERIAL PRIMARY KEY,
    id_mascota BIGINT REFERENCES mascota(id) ON DELETE CASCADE,
    veterinaria VARCHAR(255) NOT NULL,
    recordatorio BOOLEAN NOT NULL,
    vacuna VARCHAR(255) NOT NULL,
    fecha_vacunacion DATE NOT NULL,
    observacion TEXT,
    fecha_creacion TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    usuario_creacion BIGINT NOT NULL,
    fecha_modificacion TIMESTAMP WITHOUT TIME ZONE,
    usuario_modificacion BIGINT
);

CREATE TABLE actividad_mascota(
    id BIGSERIAL PRIMARY KEY,
    id_mascota BIGINT REFERENCES mascota(id) ON DELETE CASCADE ,
    fecha_actividad DATE,
    hora_actividad TIME NOT NULL,
    titulo VARCHAR(255) NOT NULL,
    detalle TEXT NOT NULL,
    recordatorio BOOLEAN NOT NULL,
    fecha_creacion TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    usuario_creacion BIGINT NOT NULL,
    fecha_modificacion TIMESTAMP WITHOUT TIME ZONE,
    usuario_modificacion BIGINT
);

CREATE TABLE recordatorio_evento(
    id BIGSERIAL PRIMARY KEY,
    id_ficha_medica BIGINT REFERENCES ficha_medica_mascota(id) MATCH SIMPLE ON DELETE CASCADE,
    id_vacunacion_mascota BIGINT REFERENCES vacunacion_mascota(id) MATCH SIMPLE ON DELETE CASCADE,
    id_actividad_mascota BIGINT REFERENCES actividad_mascota(id) MATCH SIMPLE ON DELETE CASCADE,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE,
    hora_inicio TIME NOT NULL,
    frecuencia_horas BIGINT,
    frecuencia_meses BIGINT,
    mensaje VARCHAR(255) NOT NULL
);

CREATE TABLE padrinos_mascota(
    id BIGSERIAL PRIMARY KEY,
    id_mascota BIGINT REFERENCES mascota(id) ON DELETE CASCADE,
    id_usuario BIGINT REFERENCES usuario(id) ON DELETE CASCADE,
    monto INT,
    fecha_creacion TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    usuario_creacion BIGINT NOT NULL,
    fecha_modificacion TIMESTAMP WITHOUT TIME ZONE,
    usuario_modificacion BIGINT
);

CREATE TABLE reporte_mascota(
    id BIGSERIAL PRIMARY KEY,
    id_mascota BIGINT REFERENCES mascota(id) ON DELETE CASCADE,
    id_usuario BIGINT REFERENCES usuario(id) ON DELETE CASCADE,
    descripcion VARCHAR(255) NOT NULL,
    estado VARCHAR(30),
    calle_1 VARCHAR(100),
    calle_2 VARCHAR(100),
    ciudad BIGINT REFERENCES ciudad(id) ON DELETE CASCADE,
    longitud_ubicacion REAL,
    latitud_ubicacion REAL,
    referencia VARCHAR(255),
    observacion VARCHAR(255),
    fecha_creacion TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    usuario_creacion BIGINT NOT NULL,
    fecha_modificacion TIMESTAMP WITHOUT TIME ZONE,
    usuario_modificacion BIGINT
);

CREATE TABLE tel_usuario(
    id BIGSERIAL PRIMARY KEY,
    id_usuario BIGINT REFERENCES usuario(id) ON DELETE CASCADE,
    cod_pais varchar(10),
    nro_celular INT NOT NULL,
    fecha_creacion TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    usuario_creacion BIGINT NOT NULL,
    fecha_modificacion TIMESTAMP WITHOUT TIME ZONE,
    usuario_modificacion BIGINT
);
