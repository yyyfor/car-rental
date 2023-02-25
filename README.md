# car-rental
Simple implementation of car rental service

## User Case
1. User register: user register to the system
2. Car register: admin register car to the system
3. Car unregister: admin unregister car from the system
4. User search car: user search for available cars
5. User book car: user book for an available car

Read Sequence Diagram [here](./sequence.puml)

## Start
1. Install JDK 17 and gradle
2. Install Docker
3. Run mysql with docker composer
4. create db table with db/schemal.sql
5. start server

## Api Spec
1. POST /v1/user 
- request url: http://localhost:8080/v1/user
- function: user register

```
Request example:
{
  "name": "abc"
}
Response example:
{
  "code": 0,
  "msg": "SUCCESS",
  "data": null
}
```

2. POST /v1/car
- request url: http://localhost:8080/v1/car
- function: admin register car

```
Request example:
{
  "brand": "123",
  "model": "456"
}
Response example:
{
  "code": 0,
  "msg": "SUCCESS",
  "data": null
}
```

3. DELETE /v1/car?id=
- request url: http://localhost:8080/v1/car?id={id}
- function: admin unregister a car

```
Response example:
{
  "code": 0,
  "msg": "SUCCESS",
  "data": null
}
```

4. POST /v1/user/search
- request url: http://localhost:8080/v1/user/search

```
Request example:
{
  "page": 1,
  "size": 10,
  "startTime": "2023-02-28T16:30:28.310Z",
  "endTime": "2023-03-25T16:30:28.310Z"
}
Response example:
{
  "code": 0,
  "msg": "SUCCESS",
  "data": {
    "records": [
      {
        "id": 2,
        "brand": "BMW",
        "model": "3",
        "status": null,
        "createTime": null,
        "updateTime": null
      },
      {
        "id": 3,
        "brand": "BMW",
        "model": "5",
        "status": null,
        "createTime": null,
        "updateTime": null
      },
      {
        "id": 4,
        "brand": "toyota",
        "model": "1",
        "status": null,
        "createTime": null,
        "updateTime": null
      },
      {
        "id": 1068,
        "brand": "123",
        "model": "456",
        "status": null,
        "createTime": null,
        "updateTime": null
      }
    ],
    "total": 4,
    "size": 10,
    "current": 1,
    "orders": [],
    "optimizeCountSql": true,
    "searchCount": true,
    "countId": null,
    "maxLimit": null,
    "pages": 1
  }
}
```

5. POST /v1/booking
- request url: http://localhost:8080/v1/user
- function: user register

```
Request example:
{
  "carId": 2,
  "userId": 1,
  "startTime": "2023-02-26T16:31:48.634Z",
  "endTime": "2023-03-30T16:31:48.634Z"
}
Response example:
{
  "code": 0,
  "msg": "SUCCESS",
  "data": null
}
```

## github
https://github.com/yyyfor/car-rental

## Improvement
To be discussed