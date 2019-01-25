#!/usr/bin/env sh

mvn clean install

sudo rm /opt/tomcat/webapps/SADF.war
sudo rm -rf /opt/tomcat/webapps/SADF

ls -la /opt/tomcat/webapps

cp target/SADF.war /opt/tomcat/webapps/

service tomcat stop
service tomcat start
