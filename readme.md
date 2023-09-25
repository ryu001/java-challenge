# Backend for recognition web application

## api schema
| Methods	| Urls	| Actions
| -------- | ------- | ------- |
| POST | api/login | login
| GET | api/users | get users to recognize
| GET | api/users/:id/point | get user's recognized point
| POST | api/recognitions | create a recognition
| GET | api/activities/ | get user's recognition activities

## Database schema

```
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `loginId` varchar(36) NOT NULL,
  `password` varchar(45) NOT NULL DEFAULT '123456',
  `userName` varchar(45) NOT NULL,
  `userRole` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0: staff\\\\n1: manager',
  `userMail` varchar(45) NOT NULL,
  `managerId` int DEFAULT NULL,
  `avatarUrl` varchar(100) DEFAULT NULL,
  `token` varchar(700) DEFAULT NULL,
  `createdTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `employeeId_UNIQUE` (`loginId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `recognition` (
  `id` int NOT NULL AUTO_INCREMENT,
  `recognitionUserId` int NOT NULL,
  `createUserId` int NOT NULL,
  `point` int NOT NULL DEFAULT '0',
  `detail` varchar(512) NOT NULL,
  `createdTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `union index` (`createUserId`,`createdTime` DESC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```

## 组织结构

``` lua
recognition-server
├── src-controller -- controller
├── src-db -- database config
├── src-models -- data models
├── src-repositories -- repository
├── src-routes -- api routes
└── src-utils -- common methods
```
## Tech stack

| 技术                 | 说明                         |
| -------------------- | --------------------------- |
| express              | Web application framework   |
| MySQL                | Database                    |
| mysql2               | Database driver             |
| JWT                  | Authentication              |

## Implemented features

・Login with loginId and password(Password is stored in plain text)

・Authentication using JWT

・Create and retrieve recognitions

## Todo
・Store hashed password(with salt)

・Authenticate user by

## Project setup
```
npm install
```

## Run
```
npm run start
```
