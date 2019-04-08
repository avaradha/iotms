#!/bin/bash
#
set -x

# Set the defaullt JAVA_HOME for the OS family
OS_FAMILY="$(uname -s)"
case "${OS_FAMILY}" in
    Linux*)     
        DEFAULT_JAVA_HOME="$(dirname $(dirname $(readlink -f $(which java))))"
        ;;
    Darwin*)    
        DEFAULT_JAVA_HOME=$(/usr/libexec/java_home)
        ;;
    CYGWIN*)    
        DEFAULT_JAVA_HOME=""
        ;;
    *)          
        DEFAULT_JAVA_HOME=""
        ;;
esac

# Use the default JAVA_HOME if it is not set
JAVA_HOME=${JAVA_HOME:-${DEFAULT_JAVA_HOME}}
JAVA_OPTS="-Xmx1g"

# Start the JAVA project
RUN_DIR="$(dirname $0)/.."

cd $RUN_DIR
JAR_PATH="$(find ${RUN_DIR} -name 'iotms-[0-9]*.[0-9]*.[0-9]*.jar')"
[ -z "$JAR_PATH" ] && echo "ABORTED: JAR program not found!" && exit 1

$JAVA_HOME/bin/java $JAVA_OPTS -jar $JAR_PATH

