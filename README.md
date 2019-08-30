Docker를 이용한 간단한 Redis 설치

```bash
$ docker run -p 6379:6379 --name redis-demo -d redis
$ docker exec -it redis-demo redis-cli
```

Redis : 메모리 기반 Key-Value 구조의 저장소

기본 명령어
```bash
# 추가
$ set [key] [value]
$ hset [hash key] [field] [value] [field] [value]

# 전체 조회
$ keys *
$ hgetall [hash key]

# 조회
$ get [key]
$ hget [hash key] [filed]

# 삭제
$ del [key]

# 전체 삭제
$ flushall
```
