Docker를 이용한 간단한 Redis 설치

```bash
$ docker run -p 6379:6379 --name redis-demo -d redis
$ docker exec -it redis-demo redis-cli
```
