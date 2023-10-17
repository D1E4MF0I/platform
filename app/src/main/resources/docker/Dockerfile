FROM openjdk:17
ADD app-0.0.1-exec.jar app.jar
# 暴露端口
EXPOSE 9108

# 时区修改为上海
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone

## 运行命令组装一下啦
ENTRYPOINT ["java","-Dfile.encoding=utf-8","-jar","/app.jar"]
