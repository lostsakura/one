FROM openjdk:8-jdk-slim
LABEL maintainer="lostsakura"
LABEL version="v1.0"
LABEL description="简单的访问IP记录应用"

COPY target/module-global-1.0-SNAPSHOT.jar /home/one/global.jar

# 校时
CMD yum install -y ntpdate \
 && ntpdate ntp1.aliyun.com

ENTRYPOINT ["java", "-jar", "-Duser.timezone=GMT+08", "/home/one/global.jar", "--spring.profiles.active=test"]

EXPOSE 8701