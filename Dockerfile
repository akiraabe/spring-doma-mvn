###############################################
# Create Runtime Base Image
###############################################
FROM amazoncorretto:11-alpine as base

RUN apk update \
 && apk add tzdata \
 && rm -rf /var/cache/apk/*

ENV LANG ja_JP.UTF-8
ENV LANGUAGE ja_JP
ENV LC_ALL ja_JP.UTF-8

ENV TZ='Asia/Tokyo'
ENV APP_HOME /home/java

# 一般ユーザーの作成
RUN addgroup -g 2000 -S java && adduser -u 2000 -S java -G java
USER java
WORKDIR ${APP_HOME}

# 資源の配置
RUN mkdir app
ADD . app
WORKDIR ${APP_HOME}/app

###############################################
# Create Runtime Base Image
###############################################
FROM amazoncorretto:11-alpine as BUILD

RUN apk update \
  && apk add maven \
  && rm -rf /var/cache/apk/*

WORKDIR /build
COPY pom.xml .
COPY src/ /build/src/

## Maven のローカルレポジトリをキャッシュ
RUN --mount=type=cache,target=/root/.m2 \
 mvn clean package -Dmaven.test.skip=true

###############################################
# Create Final Image
###############################################
FROM base as final

COPY --from=BUILD /build/target/demo2-0.0.1-SNAPSHOT.jar /home/java/app/app.jar

ENTRYPOINT ["java", "-jar", "/home/java/app/app.jar"]
EXPOSE 8080