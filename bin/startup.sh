#!/bin/bash
#
set -x

# Explicitly set the JAVA_HOME and JAVA_OPTS
JAVA_HOME=${JAVA_HOME:-/usr/java/java11}
JAVA_OPTS="-Xmx1g"

# Start the JAVA project
RUN_DIR="$(dirname $0)/.."

cd $RUN_DIR
JAR_PATH="$(find ${RUN_DIR} -name 'iotms-[0-9]*.[0-9]*.[0-9]*.jar')"
[ -z "$JAR_PATH" ] && echo "ABORTED: JAR program not found!" && exit 1

$JAVA_HOME/bin/java $JAVA_OPTS -jar $JAR_PATH

