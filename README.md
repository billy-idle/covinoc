# Covinoc

## Descripción

* Este artefacto pretende ser un primer acercamiento al back-end de la aplicación web.
* Aplicando patrones de arquitectura y un desarrollo conducido por pruebas.

## Historias de usuario y casos de uso

### User

#### Casos de uso

* Crear, modificar, consultar y eliminar usuario.

#### Entidades

* User
* UserJpaEntity
* UserCreateRequestModel
* UserUpdateRequestModel
* UserDeleteRequestModel
* UserResponseRequestModel

### Puertos

#### Entrada
* CreateUserUseCase
* UpdateUserUseCase
* FindUserQuery
* DeleteUserUseCase

#### Salida
* DeleteUser
* SaveUser
* FindUser

### Adaptadores

#### Entrada (web)
* UserController

#### Salida (persistence)
* UserPersistenceAdapter

## Arquitectura

La arquitectura de la aplicación corresponde a la arquitectura-hexagonal o tambien llamada *ports and adapters* propuesta por Alistair Cockburn y descrita por Tom Hombergs en su libro *Clean Architecture*.

![alt-text][1]

En esta arquitectura-hexagonal tenemos:

  * entidades
  * casos de uso
  * puertos entrantes y salientes
  * adaptadores entrantes y salientes

todos estos como elementos principales de arquitectura.

A continuación se muestra la estructura de paquetes que expresa esta arquitectura:

```console
C:\Users\corn-pop\IdeaProjects\covinoc\src\main\java\com\github\billy\covinoc\user(architecturally-expresive -> origin)
λ tree /f
Folder PATH listing
Volume serial number is C0000100 6E94:3CDB
C:.
├───adapter
│   ├───in
│   │   └───web
│   │           UserController.java
│   │
│   └───out
│       └───persistence
│               UserJpaEntity.java
│               UserPersistenceAdapter.java
│               UserRepository.java
│
├───application
│   ├───mapper
│   │       UserMapper.java
│   │
│   ├───port
│   │   ├───in
│   │   │       CreateUserUseCase.java
│   │   │       DeleteUserUseCase.java
│   │   │       FindUserQuery.java
│   │   │       UpdateUserUseCase.java
│   │   │       UserCreateRequestModel.java
│   │   │       UserDeleteRequestModel.java
│   │   │       UserFindRequestModel.java
│   │   │       UserResponseModel.java
│   │   │       UserUpdateRequestModel.java
│   │   │
│   │   └───out
│   │           DeleteUser.java
│   │           FindUser.java
│   │           SaveUser.java
│   │
│   └───service
│           CreateUserService.java
│           DeleteUserService.java
│           FindUserService.java
│           UpdateUserService.java
│
└───domain
        User.java
```

### Swagger

```console
http://localhost:8080/swagger-ui/index.htm
```

Se listan los endpoints desarrollados hasta el momento, los cuáles corresponden con los casos de uso implementados. 

[1]: https://github.com/billy-idle/covinoc/blob/architecturally-expresive/src/main/resources/images/hexagonal-architecture.png
