#!/bin/bash
ssh -x $1 "export JAVA_HOME=\${NATIVE_TOOLS}\${SEP}\${JAVA16}; export PATH=\${NATIVE_TOOLS}\${SEP}\${JAVA16}/bin:\${NATIVE_TOOLS}\${SEP}\${JAVA16}/jre/bin:\$PATH; export SFHOME=$2; export SFUSERHOME=$3; $2/bin/sfStopDaemon $1"
