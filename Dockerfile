FROM ghcr.io/graalvm/graalvm-ce:ol7-java17-22.3.0 as build

RUN gu install native-image

RUN yum install -y zip unzip libstdc++-static freetype-devel

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn

COPY pom.xml .

RUN chmod +x ./mvnw

COPY src src

RUN ./mvnw clean package -DskipTests -Pnative

ENTRYPOINT ["sh", "-c" ,"./target/test-app-one"]
