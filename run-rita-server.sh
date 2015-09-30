#!/bin/sh

#/usr/local/maven/bin/mvn -f /var/www/html/rita/server/pom.xml exec:java

JAVA=/usr/lib/jvm/java-1.7.0-openjdk-1.7.0.55.x86_64/bin/java
CP=/usr/local/maven/boot/plexus-classworlds-2.4.jar
M2_CONF=/usr/local/maven/bin/m2.conf
MVN_HOME=/usr/local/maven
MAIN=org.codehaus.plexus.classworlds.launcher.Launcher
POM=/var/www/html/rita/server/pom.xml

${JAVA} -classpath ${CP} -Dclassworlds.conf=${M2_CONF} -Dmaven.home=${MVN_HOME} ${MAIN} -f ${POM} exec:java

#/usr/lib/jvm/java-1.7.0-openjdk-1.7.0.55.x86_64/bin/java -classpath /usr/local/maven/boot/plexus-classworlds-2.4.jar -Dclassworlds.conf=/usr/local/maven/bin/m2.conf -Dmaven.home=/usr/local/maven org.codehaus.plexus.classworlds.launcher.Launcher -f /var/www/html/rita/server/pom.xml exec:java
