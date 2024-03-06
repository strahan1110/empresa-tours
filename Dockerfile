FROM tomcat:latest

COPY ./webapps /usr/local/tomcat/webapps

EXPOSE 8080

CMD ["catalina.sh", "run"]
