#!/bin/sh

FILE=rita-1.0.61.jar
GID=org.rednoise.rita
AID=rita
VER=1.0.61
PACK=jar

mvn install:install-file -Dfile=$FILE -DgroupId=$GID -DartifactId=$AID -Dversion=$VER -Dpackaging=$PACK -DgeneratePom=true
