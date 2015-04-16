create table catalogo_usuarios
(
id_usuario number,
nombre varchar2(45),
ap_pat varchar2(45),
ap_mat varchar2(45),
nombre_usuario varchar2(200),
password_usuario varchar2(200),
tipo number(1),
status number(1) default 1 not null,
constraint pk_usuario primary key (id_usuario),
constraint uq_usuario unique(nombre_usuario),
constraint ck_status_usuario check(status in(0,1))
);

CREATE TABLE USER_ROLE(
ID_USER_ROLE NUMBER,
USER_ID NUMBER,
AUTHORITY VARCHAR2(45), 
constraint pk_user_role primary key (ID_USER_ROLE),
constraint fk_user foreign key (USER_ID) references catalogo_usuarios(id_usuario)
);

create table catalogo_carreras
(
id_carrera number,
nombre_carrera varchar2(50),
id_usuario number not null,
status number(1) default 1 not null,
constraint pk_carrera primary key (id_carrera),
constraint fk_usuario foreign key (id_usuario) references catalogo_usuarios(id_usuario),
constraint uq_carrera unique(nombre_carrera),
constraint ck_status_carrera check(status in(0,1))
);

create table catalogo_especialidades
(
id_especialidad number,
nombre_especialidad varchar2(150),
id_carrera number not null,
status number(1) default 1 not null,
constraint pk_especialidad primary key (id_especialidad),
constraint fk_carrera foreign key (id_carrera) references catalogo_carreras(id_carrera),
constraint ck_status_especialidad check(status in(0,1))
);

create table catalogo_aulas
(
id_aula number,
edificio varchar2(30),
aula varchar2(30),
tipo_aula number(1),/* 0 = teorico, 1 = practico*/
capacidad_aula number(3),
id_carrera number not null,
status number(1) default 1 not null,
constraint pk_aula primary key (id_aula),
constraint fk_carrera_aula foreign key (id_carrera) references catalogo_carreras(id_carrera),
constraint ck_status_aula check(status in(0,1))
);

create table catalogo_planes
(
id_plan number,
nombre_plan varchar(20),
status number(1) default 1 not null,
constraint pk_plan primary key (id_plan),
constraint uq_plan unique(nombre_plan),
constraint ck_status_plan check(status in(0,1))
);

create table catalogo_profesores
(
id_profesor number,
nombre_profesor varchar2(50),
ap_pat_profesor varchar2(50),
ap_mat_profesor varchar2(50),
status number(1) default 1 not null,
constraint pk_profesor primary key (id_profesor),
constraint ck_status_profesor check(status in(0,1))
);

create table catalogo_ciclo_escolar(
id_ciclo_escolar number,
nombre_ciclo_escolar varchar2(10),
fecha_inicio varchar2(10),
fecha_fin varchar2(10),
status number(1),
constraint pk_ciclo_escolar primary key(id_ciclo_escolar),
constraint ck_status_ciclo_escolar check(status in(0,1))
);

create table catalogo_materias
(
id_materia number,
nombre_materia varchar2(100),
horas_practicas number(1),
horas_teoricas number(1),
bloque number(2),
id_especialidad number not null,
status number(1) default 1 not null,
constraint pk_materia primary key (id_materia),
constraint fk_especialidad foreign key (id_especialidad) references catalogo_especialidades(id_especialidad),
constraint ck_status_materia check(status in(0,1))
);

create table catalogo_grupos
(
id_grupo number,
clave_grupo number,
horas_practicas_restantes number(1),
horas_teoricas_restantes number(1),
forzar_grupo varchar(5),
capacidad_grupo number(3),
id_materia number not null,
id_profesor number not null,
id_plan number not null,
id_ciclo_escolar number not null,
status number(1) default 1 not null,
constraint pk_grupo primary key (id_grupo),
constraint fk_materia foreign key (id_materia) references catalogo_materias(id_materia),
constraint fk_profesor foreign key (id_profesor) references catalogo_profesores(id_profesor),
constraint fk_plan foreign key (id_plan) references catalogo_planes(id_plan),
constraint fk_ciclo_escolar foreign key (id_ciclo_escolar) references catalogo_ciclo_escolar(id_ciclo_escolar),
constraint uq_grupo unique(clave_grupo),
constraint ck_status_grupo check(status in(0,1))
);

create table horario_aula
(
id_horario number,
id_aula number,
id_grupo number,
dia varchar2(10),
horario varchar2(13),
tipo_horario varchar2(1),
status number(1) default 1 not null,
constraint pk_horario primary key (id_horario),
constraint fk_aula foreign key (id_aula) references catalogo_aulas(id_aula),
constraint fk_grupo foreign key (id_grupo) references catalogo_grupos(id_grupo),
constraint ck_st_horarios check (status in(0,1))
);

create sequence seq_grupos increment by 1 start with 0 minvalue 0;
create sequence seq_aulas increment by 1 start with 0 minvalue 0;
create sequence seq_materias increment by 1 start with 0 minvalue 0;
create sequence seq_planes increment by 1 start with 0 minvalue 0;
create sequence seq_profesores increment by 1 start with 0 minvalue 0;
create sequence seq_carreras increment by 1 start with 0 minvalue 0;
create sequence seq_especialidades increment by 1 start with 0 minvalue 0;
create sequence seq_usuarios increment by 1 start with 0 minvalue 0;
create sequence seq_ciclo_escolar increment by 1 start with 0 minvalue 0;
create sequence seq_horario_aula increment by 1 start with 0 minvalue 0;

Insert into ADMINISTRADOR_AULAS.CATALOGO_USUARIOS (ID_USUARIO,NOMBRE,AP_PAT,AP_MAT,NOMBRE_USUARIO,PASSWORD_USUARIO,TIPO,STATUS) values (1,'ADMINISTRADOR','ADMINISTRADOR','ADMINISTRADOR','ADMIN','administrador',1,1);
Insert into ADMINISTRADOR_AULAS.CATALOGO_USUARIOS (ID_USUARIO,NOMBRE,AP_PAT,AP_MAT,NOMBRE_USUARIO,PASSWORD_USUARIO,TIPO,STATUS) values (2,'BENJAMIN','LOPEZ','GONZALEZ','SISTEMAS','sistemas',2,1);
Insert into ADMINISTRADOR_AULAS.CATALOGO_USUARIOS (ID_USUARIO,NOMBRE,AP_PAT,AP_MAT,NOMBRE_USUARIO,PASSWORD_USUARIO,TIPO,STATUS) values (5,'MARGARITO','CARBAJAL','SUAREZ','ELECTROMECANICA','electromecanica',2,1);
Insert into ADMINISTRADOR_AULAS.CATALOGO_USUARIOS (ID_USUARIO,NOMBRE,AP_PAT,AP_MAT,NOMBRE_USUARIO,PASSWORD_USUARIO,TIPO,STATUS) values (7,'ALEJANDRO GERARDO','NEYRA','ROMERO','ELECTRONICA','electronica',2,1);
Insert into ADMINISTRADOR_AULAS.CATALOGO_USUARIOS (ID_USUARIO,NOMBRE,AP_PAT,AP_MAT,NOMBRE_USUARIO,PASSWORD_USUARIO,TIPO,STATUS) values (6,'JOSE DE JESUS','MILLAN','FUENTES','MECATRONICA','mecatronica',2,1);
Insert into ADMINISTRADOR_AULAS.CATALOGO_USUARIOS (ID_USUARIO,NOMBRE,AP_PAT,AP_MAT,NOMBRE_USUARIO,PASSWORD_USUARIO,TIPO,STATUS) values (8,'NADIA','VAZQUEZ','ARRIAGA','INDUSTRIAL','industrial',2,1);
Insert into ADMINISTRADOR_AULAS.CATALOGO_USUARIOS (ID_USUARIO,NOMBRE,AP_PAT,AP_MAT,NOMBRE_USUARIO,PASSWORD_USUARIO,TIPO,STATUS) values (9,'MARTHA PATRICIA','PEREZ','DOMINGUEZ','LOGISTICA','logistica',2,1);
Insert into ADMINISTRADOR_AULAS.CATALOGO_USUARIOS (ID_USUARIO,NOMBRE,AP_PAT,AP_MAT,NOMBRE_USUARIO,PASSWORD_USUARIO,TIPO,STATUS) values (10,'NANCY KENIA','RUIZ','NATERAS','GESTION','gestion',2,1);
Insert into ADMINISTRADOR_AULAS.CATALOGO_USUARIOS (ID_USUARIO,NOMBRE,AP_PAT,AP_MAT,NOMBRE_USUARIO,PASSWORD_USUARIO,TIPO,STATUS) values (11,'MARIA GUADALUPE','OSORNO','HERNANDEZ','QUIMICA','quimica',2,1);

Insert into ADMINISTRADOR_AULAS.USER_ROLE (ID_USER_ROLE,USER_ID,AUTHORITY) values (1,2,'ROLE_COORDINADOR');
Insert into ADMINISTRADOR_AULAS.USER_ROLE (ID_USER_ROLE,USER_ID,AUTHORITY) values (2,1,'ROLE_ADMINISTRADOR');
Insert into ADMINISTRADOR_AULAS.USER_ROLE (ID_USER_ROLE,USER_ID,AUTHORITY) values (5,5,'ROLE_COORDINADOR');
Insert into ADMINISTRADOR_AULAS.USER_ROLE (ID_USER_ROLE,USER_ID,AUTHORITY) values (7,7,'ROLE_COORDINADOR');
Insert into ADMINISTRADOR_AULAS.USER_ROLE (ID_USER_ROLE,USER_ID,AUTHORITY) values (6,6,'ROLE_COORDINADOR');
Insert into ADMINISTRADOR_AULAS.USER_ROLE (ID_USER_ROLE,USER_ID,AUTHORITY) values (8,8,'ROLE_COORDINADOR');
Insert into ADMINISTRADOR_AULAS.USER_ROLE (ID_USER_ROLE,USER_ID,AUTHORITY) values (9,9,'ROLE_COORDINADOR');
Insert into ADMINISTRADOR_AULAS.USER_ROLE (ID_USER_ROLE,USER_ID,AUTHORITY) values (10,10,'ROLE_COORDINADOR');
Insert into ADMINISTRADOR_AULAS.USER_ROLE (ID_USER_ROLE,USER_ID,AUTHORITY) values (11,11,'ROLE_COORDINADOR');
	
commit;