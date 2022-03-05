# SpringSecurity x doma2サンプルアプリケーション

## buildpacksでのBuildの仕方
```
mvn spring-boot:build-image -DskipTests=true

docker image ls

docker run -p 8080:8080 <image_id>
```

## DockerfileでのBuildの仕方
```
docker image build -t akiraabe/spring-boot-docker:[tag] .
docker login
docker push akiraabe/spring-boot-docker:[tag]
```