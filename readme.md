# Backend for recognition web application

## api scheme
| Methods	| Urls	| Actions
| -------- | ------- | ------- |
| POST | api/login | login
| GET | api/users | get users to recognize
| GET | api/users/:id/point | get user's recognized point
| POST | api/recognitions | create a recognition
| GET | api/activities/ | get user's recognition activities

## Database schema

## 组织结构

``` lua
recognition-server
├── src-controller -- controller
├── src-db -- database config
├── src-models -- data models
├── src-repositories -- 后台商城管理系统接口
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
