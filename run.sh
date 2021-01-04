#!/bin/sh
gradle clean
gradle war
gradle deploy
systemctl restart tomcat
gradle clean