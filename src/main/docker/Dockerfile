FROM frolvlad/alpine-oraclejdk8:slim
    MAINTAINER josejavier.blecua@gmail.com

ADD morsedecipherer-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]