# Backend for recognition web application

## api scheme
| Methods	| Urls	| Actions
| -------- | ------- | ------- |
| GET | api/tutorials | get all Tutorials
| GET | api/tutorials/:id | get Tutorial by id
| POST | api/tutorials | add new Tutorial
| PUT | api/tutorials/:id | update Tutorial by id
| DELETE | api/tutorials/:id | remove Tutorial by id

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
