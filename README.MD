# todo-list app

## Navigation

- [Requirements](#Requirements)
- [Entry points](#Entry-points)
    - [Hosts and ports](#Hosts-and-ports)
    - [Accounts](#Accounts)
- [How to launch](#How-to-launch)
    - [Launch app](#Launch-app)
    - [Frontend requests](#Frontend-requests)
    - [DB connection](#DB-connection)

## Requirements

[Java Developer task.pdf](https://github.com/Goganesh/todo-list/blob/master/docs/Java%20Developer%20task.pdf)

## Entry points

### Hosts and ports

Default parameters

| App           | Host                  |                  
|:--------------|:----------------------|
| todo-list app | http://localhost:8080 | 
| todo-list db  | http://localhost:5432 | 

### Accounts

Authentication using the login-password method

| Login            | Password | Role  |                  
|:-----------------|:---------|:------|
| admin            | 123      | ADMIN |

## How to launch

### Launch app

How launch you need:

- Docker

How to **launch**:

1. Build executable **jar** file -> Start **install** cycle for project. Result is **jar** file in **target** directory.
2. Build images from docker-compose.yaml file -> execute command **docker compose build** in root folder
3. Launch containers from builded images ->  execute command **docker compose start** in root folder

How to **stop**: execute command **docker compose stop** in root folder

How to **remove**: execute command **docker compose down** in root folder

How to **restart**: execute command **docker compose restart** in root folder

### Frontend requests

swagger ui - /swagger-ui/index.html

openapi spec - /v3/api-docs

### DB connection

env parameters for DB:

- SPRING_DATASOURCE_URL
- SPRING_DATASOURCE_USERNAME
- SPRING_DATASOURCE_PASSWORD
- SPRING_DATASOURCE_DRIVER

Default values for connection parameters:

- url: jdbc:postgresql://localhost:5432/postgres
- driverClassName: org.postgresql.Driver
- username: postgres
- password: postgres1
