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

CREATE TABLE detalle_usuario(
    id BIGSERIAL PRIMARY KEY,
    id_usuario BIGINT NOT NULL REFERENCES usuario(id),
    nro_documento VARCHAR(18) NOT NULL,
    tipo_documento VARCHAR(50) NOT NULL,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    ciudad VARCHAR(50) NOT NULL,
    foto_perfil BYTEA,
    fecha_nacimiento DATE NOT NULL,
    notificaciones BOOLEAN NOT NULL,
    fecha_creacion TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    fecha_modificacion TIMESTAMP WITHOUT TIME ZONE,
    usuario_modificacion BIGINT
);

CREATE TABLE dispositivo_usuario(
    id BIGSERIAL PRIMARY KEY,
    id_usuario BIGINT NOT NULL REFERENCES usuario(id),
    fecha_asociacion TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    fecha_desasociacion TIMESTAMP WITHOUT TIME ZONE,
    fecha_modificacion TIMESTAMP WITHOUT TIME ZONE,
    usuario_modificacion BIGINT
);

CREATE TABLE sesion_usuario(
    id BIGSERIAL PRIMARY KEY,
    id_usuario BIGINT NOT NULL REFERENCES usuario(id),
    id_dispositivo BIGINT NOT NULL REFERENCES dispositivo_usuario(id),
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
    id_especie BIGINT NOT NULL REFERENCES especie_animal(id),
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
    id_especie BIGINT REFERENCES especie_animal(id),
    id_raza BIGINT REFERENCES raza_animal(id),
    fecha_creacion TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    usuario_creacion BIGINT NOT NULL,
    fecha_modificacion TIMESTAMP WITHOUT TIME ZONE,
    usuario_modificacion BIGINT
);

CREATE TABLE mascota(
    id BIGSERIAL PRIMARY KEY,
    id_usuario BIGINT REFERENCES usuario(id),
    id_especie BIGINT REFERENCES especie_animal(id),
    id_raza BIGINT REFERENCES raza_animal(id),
    nombre VARCHAR(255),
    fecha_nacimiento DATE,
    edad INT,
    tamanho VARCHAR(10),
    ciudad VARCHAR(255),
    direccion VARCHAR(255),
    color_primario VARCHAR(255),
    color_secundario VARCHAR(255),
    estado BOOLEAN,
    fotografia BYTEA,
    descripcion VARCHAR(255),
    fecha_creacion TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    usuario_creacion BIGINT NOT NULL,
    fecha_modificacion TIMESTAMP WITHOUT TIME ZONE,
    usuario_modificacion BIGINT
);