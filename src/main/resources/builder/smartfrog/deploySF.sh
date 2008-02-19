#!/bin/bash
ssh -x $1 "export JAVA_HOME=$JAVA_HOME; export PATH=$JAVA_HOME/bin:$JAVA_HOME/jre/bin$PATH; export SFHOME=$2; export SFUSERHOME=$3; export SFUSERHOME1=$4; cd $7; $2/bin/sfStart $1 $6 $5"