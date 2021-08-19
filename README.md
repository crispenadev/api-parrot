# api-Parrot
## Version 1.0.1

[![N|Solid](https://cldup.com/dTxpPi9lDf.thumb.png)](https://nodesource.com/products/nsolid)

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

api-Parrot es un microservicio encargado de 3 operaciones basicas para ordernar prdocutos ligados a un usuarios con seguridad a nivel de token.

## Features

- Creacion de usuarios con email como llave primaria
- Creacion de token para opereaciones ligadas al usuario
- Creacion de ordenes con sus respectiva lista de productos
- Crearcion de reporte de productos vendidos con base en rango de fechas

> El API será consumida por una base de 1000 usuarios con uso constante para la creación de ordenes.
> Tiene que contener los siguientes servicios web, almacenando los datos necesarios para su correcto funcionamiento:.
>Creacion de usuarios, ordenes y productos y reportes.

## Tech
- [Java] - lenguaje backend
- [Spring Core] -Framework backend para la injeccion de dependencias y flujo general del proyecto.
- [Spring Security] -Framework backend para el uso de JWT.
- [Spring DATA] -Framework backend para el manejo de persistencia.
- [Spring Boot] - Framework backend de principal.
- [Spring Rest] - Framework backend para el manejo de rest.
- [Swagger] - Herramienta para documentacion rest.
- [Maven] - Framework backend para el manejo de rest.
- [MongoAtlas] - Base de datos cloud no relacional
- [Git] - Framework backend para el manejo de rest.

## Variables de entorno
Vault-Storage necesita variables de entorno para funcionar en diferentes ambiente s de mandeara parametrizable y transaparente.

| Propiedad | Valor |
| ------ | ------ |
| spring.data.mongodb.uri |mongodb+srv://dev_parrot:BmLKo95Ji3yDeRod@cluster0.2amei.mongodb.net/parrot_operational?retryWrites=true&w=majority|
|spring.data.mongodb.database|parrot_operational|
##  Intalacion
![alt text](https://github.com/crispenadev/api-parrot/blob/main/mvn.png?raw=true)