# Proyecto: Foro Hub

![Badge-Spring](https://github.com/user-attachments/assets/40bd6882-d61b-4059-a547-14021158eec4)

## Índice
1. [Descripción del proyecto](#descripción-del-proyecto)
2. [Estado del proyecto](#estado-del-proyecto)
3. [Tecnologías usadas](#tecnologías-usadas)
4. [Instalación y configuración](#instalación-y-configuración)
5. [Autor](#autor-del-proyecto)
6. [Evidencias](#evidencias-de-funcionamiento)


## Descripción del proyecto
Este proyecto consiste en un foro de consultas, se pueden generar consultas a partir de un curso existente a traves de un usuario.

# Opciones del proyecto:
- Registrar usuarios con todos sus atributos.
- Iniciar sesión con usuario creado para generar un token.
- CRUD usuario:
  - Listar usuarios.
  - Actualizar usuario.
  - Buscar usuario.
  - Eliminar usuario.
- CRUD curso:
   - Registrar curso.
   - Listar cursos.
   - Actualizar curso,
   - Buscar curso.
   - Eliminar curso.
- CRUD consulta:
  - Registrar consultas.
  - Listar consultas.
  - Actualizar consulta.
  - Buscar consulta.
  - Eliminar consulta.

## Estado del proyecto
Actualmente, el proyecto se encuentra concluido, pero podría haber algún tipo de modificación en el futuro.

## Tecnologías usadas
- **Lenguaje:** Java 17 en adelante.
-  Spring Boot version 3 en adelante.
- **Gestor de dependencias:** Maven version 4 en adelante.
- **Base de datos:** MySQL version 8 en adelante.
- **Entorno de desarrollo:** IDE Intellij IDEA.
- **Dependencias:**
  - Lombok
  - Spring Web
  - Jackson
  - Spring Boot Dev Tools
  - String Data JPA
  - Flyway Migration
  - MySQL Driver
  - Validation
  - Spring Security

## Instalación y configuración
### Prerrequisitos

- JDK 17 instalado.
- IntellijIDEA instalado (Recomendado)
- MySQL instalado
- Insomnia instalado (opcional)

# Configurar la base de datos MySQL:

   - Crear una base de datos.
   - Actualizar las credenciales en el archivo `application.properties` o `application.yml`:
     properties
     spring.datasource.url=jdbc:/localhost:####/nombre_base_datos
     spring.datasource.username=tu_usuario
     spring.datasource.password=tu_contraseña
  - Conectar base de datos con IntellijIDEA

     
## Autor del Proyecto
**Paula Vargas**

## Evidencias de funcionamiento
**`Registrar usuario`**

![image](https://github.com/user-attachments/assets/d0fea598-ecd6-4f40-a50a-47ca788718c8)

**`Login usuario`**

![image](https://github.com/user-attachments/assets/31d42c23-8ba1-4f00-a914-2addaf06945b)

**`Listar usuarios`**

![image](https://github.com/user-attachments/assets/72679004-f9c2-476a-80c5-36b71a1eab78)

**`Actualizar usuario`**

![image](https://github.com/user-attachments/assets/de635fcb-a3b4-4a03-8dcb-c3e4964daadb)

![image](https://github.com/user-attachments/assets/9ae1a2fc-847a-4464-9161-e33930b25ce9)

**`Buscar usuario`**

![image](https://github.com/user-attachments/assets/c15cef29-4a4e-4f2e-829e-2db0d2500e0d)

**`Eliminar usuario`**

![image](https://github.com/user-attachments/assets/cde7f38a-61d8-42d3-8203-3babc2ba3d83)

![image](https://github.com/user-attachments/assets/8c99a917-9123-4671-89cd-17b21303d10c)

![image](https://github.com/user-attachments/assets/e5603595-6409-4dbb-875a-74ee2b5c2d00)

**`Registrar curso`**

![image](https://github.com/user-attachments/assets/cdf469f7-bb78-46e7-8ae7-f64a15578dff)

**`Listar cursos`**

![image](https://github.com/user-attachments/assets/90985929-abd0-4710-b495-1a5638279843)

**`Actualizar curso`**

![image](https://github.com/user-attachments/assets/f54e51b5-fa03-4e22-93ba-49009cf588cd)

![image](https://github.com/user-attachments/assets/c1c55810-9a42-48f1-8ea9-9297a5016bed)

**`Buscar curso`**

![image](https://github.com/user-attachments/assets/732632e2-cf92-471e-a494-b37dc6e49ddc)

**`Eliminar curso`**

![image](https://github.com/user-attachments/assets/9288a7a6-e8e3-4f2b-8482-6efe1b3146a7)

![image](https://github.com/user-attachments/assets/15456d24-8181-4d88-8d21-7804d7455adc)

![image](https://github.com/user-attachments/assets/91176c62-bffd-4dfd-a459-94d213a45b23)

**`Registrar consulta`**

![image](https://github.com/user-attachments/assets/08e20ead-abcf-4687-807c-c0f2df0be0a8)

**`Listar consultas`**

![image](https://github.com/user-attachments/assets/f6e8210e-697d-4516-bb52-221c7e08c206)

**`Actualizar consulta`**

![image](https://github.com/user-attachments/assets/272f6246-cef0-4d18-9aad-c34db321cdce)

![image](https://github.com/user-attachments/assets/4ed3be54-721f-4997-b507-672f9119fb41)

**`Buscar consulta`**

![image](https://github.com/user-attachments/assets/ea2bce91-5a06-4386-bee0-62d11d9fdec3)

**`Eliminar consulta`**

![image](https://github.com/user-attachments/assets/89c53f4b-318c-4e21-9451-60d8dfb96c7d)

![image](https://github.com/user-attachments/assets/d79dc40c-d1f7-4983-95f1-c64facf85613)

![image](https://github.com/user-attachments/assets/059892ff-5e49-47fe-99c4-bf3b606d7df6)

**`Actualizar usuario y curso implementados en una consulta`**

![image](https://github.com/user-attachments/assets/3052fc96-417f-478b-89a7-9bff11e5a519)

![image](https://github.com/user-attachments/assets/fa47461b-3fbd-48de-bb41-7a2db95ad89e)

![image](https://github.com/user-attachments/assets/daa4815c-4269-4803-9880-0e27d597506d)

![image](https://github.com/user-attachments/assets/7c54a1e9-da78-43be-8964-3c95df6ef5be)

## Validaciones y excepciones aplicadas
**`Registrar usuario`**

![image](https://github.com/user-attachments/assets/4a760155-fda8-4e75-be45-1507e4f64f10)

[Variables registradas no pueden ser nulas]


![image](https://github.com/user-attachments/assets/14ffc86c-efce-4230-b4e5-2033826d0f87)

[Deben brindarse los campos de forma válida]


![image](https://github.com/user-attachments/assets/a1d755bd-3c92-4755-b062-af5f53c987d2)

[No pueden registrarse 2 veces el mismo nombre ni correo para distintos usuarios]


![image](https://github.com/user-attachments/assets/72acaa63-3ff1-40ae-a2e6-254f8d64fd1e)

[No puede registrarse 2 veces el mismo nombre para distintos usuarios]


![image](https://github.com/user-attachments/assets/5d3c9e15-b859-4346-98bf-bb94ef5844c8)

[No puede registrarse 2 veces el mismo para distintos usuarios]


**`Actualizar usuario`**

![image](https://github.com/user-attachments/assets/bae35686-a4ae-4d8c-8393-f364ca414af4)

[El id es inexistente]


![image](https://github.com/user-attachments/assets/2b785806-7179-4d04-a3e4-2fd1041b839c)

[Las variables registradas no pueden estar vacías]


![image](https://github.com/user-attachments/assets/48908511-4ec4-4005-b47c-37ff27ec3d75)

[La variable para actualizar no puede estar vacía]


![image](https://github.com/user-attachments/assets/1c32a274-f04d-4454-bd4c-6ffedc937dde)

[La variable para actualizar no puede estar vacía]


![image](https://github.com/user-attachments/assets/a46a119f-c8ba-4009-9522-d6499958b7ab)

[No se puede actualizar si el nombre del usuario ingresado, fue registrado con anterioridad]


![image](https://github.com/user-attachments/assets/f5b3bc1c-15d0-4d7a-a452-f615f7059c5f)

[No se puede actualizar si el nombre y el email del usuario ingresado, fueron registrados con anterioridad]


![image](https://github.com/user-attachments/assets/7e2fa0ab-d5df-47b4-845b-efc8c4a1816a)

[No se puede actualizar si el email del usuario ingresado, fue registrado con anterioridad]


**`Eliminar usuario`**

![image](https://github.com/user-attachments/assets/efc6acf9-958c-4e81-bafd-66cd56f4f2db)

[Id inexistente]


**`Registrar curso`**

![image](https://github.com/user-attachments/assets/d36aa82f-495d-4008-b5b6-b0f3979a2bbd)

[Variable nombre no puede estar vacía]


![image](https://github.com/user-attachments/assets/a9502ade-ba51-4208-8c13-607759c42540)

[Deben ingresarse los espacios de fórma válida]


![image](https://github.com/user-attachments/assets/3e56378f-d915-417d-ab83-e668cb56f3c5)

[Variable categoría no puede estar vacía]


![image](https://github.com/user-attachments/assets/8f67da47-e54d-4e0b-ad21-39e20ad2e01c)

[Ingresar la variable categoria en el formato Enum]

**`Actualizar curso`**

![image](https://github.com/user-attachments/assets/38370be4-854e-4873-b357-8efa97f8c5ce)

[Id inexistente]


![image](https://github.com/user-attachments/assets/6154ec50-8eda-443e-b481-723f93368a4f)

[Variable nombre no puede estar vacía]


**`Eliminar curso`**

![image](https://github.com/user-attachments/assets/47319ad6-9586-4080-9770-b60d61bee7fa)

[Id inexistente]


**`Registrar consulta`**

![image](https://github.com/user-attachments/assets/7a66ce39-6dfe-4809-931d-34cefd5e703b)

[No puede registrarse el mismo nombre y mensaje para distintas consultas]

![image](https://github.com/user-attachments/assets/a5aab3f4-6a84-404a-8db4-a3699b4d5ce0)

[Puede registrarse una consulta aunque los titulos sean iguales, mientras el mensaje sea distinto]


![image](https://github.com/user-attachments/assets/4508dd86-5c8e-4994-b440-9c612e45b49b)

[No puede registrarse el mismo mensaje para distintas consultas]


![image](https://github.com/user-attachments/assets/22cfeb86-23fb-4b1b-adbe-691aa4b30722)

[Las variables registradas no deben estar vacías]


![image](https://github.com/user-attachments/assets/a96d7366-d83f-4fc1-a710-13937d7730ca)

[No puede realizarse una consulta con un usuario desabilitado]


![image](https://github.com/user-attachments/assets/ac2fa1a0-529a-48bf-b2b1-9cba4f831ddd)

[No puede realizarse una consulta con un curso desabilitado]


![image](https://github.com/user-attachments/assets/92b917c4-cd19-422f-8162-69344f0d8d3f)

[Id usuario inexistente]


![image](https://github.com/user-attachments/assets/a5922344-fd9b-4537-8f99-791ca699a3be)

[Id curso inexistente]


**`Actualizar consulta`**

![image](https://github.com/user-attachments/assets/665ff4a6-d7d7-49bb-854a-53ea2301f5bd)

[Las variables titulo y mensaje no pueden estar vacías]


![image](https://github.com/user-attachments/assets/36d108a6-c41d-48fb-a2c8-b1f805b61fd9)

[La variable titulo no puede estar vacía]


![image](https://github.com/user-attachments/assets/456b3352-6b58-46c6-9c33-d9471e31a207)

[La variable mensaje no puede estar vacía]


![image](https://github.com/user-attachments/assets/e567740b-7d37-4ecb-9131-95b0306a41f0)

[No se puede actualizar el mismo titulo ni el mismo mensaje para distintas consultas]


![image](https://github.com/user-attachments/assets/e4604707-d658-47fa-893f-14da526c1037)

[No se puede actualizar el mismo mensaje para distintas consultas]



![image](https://github.com/user-attachments/assets/873d1756-66f6-4199-9545-4147ce1b0407)

[Id usuario inexistente]


![image](https://github.com/user-attachments/assets/7a75be10-69d2-402f-8e64-ed4b2cf81192)

[No se puede actualizar una consulta con un curso desabilitado]


![image](https://github.com/user-attachments/assets/7eced2a0-cba1-49b0-b13e-98bef58b68ce)

[Se puede actualizar una consulta con el mismo titulo mientras el mensaje sea distinto a otra consulta existente ]


**`Eliminar consulta`**

![image](https://github.com/user-attachments/assets/895982d5-dab5-4c3c-a705-bfcf3688b551)

[Id curso inexistente]


## Mejoras 

## Aclaraciones

---
