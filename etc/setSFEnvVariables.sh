# This empty shell script is sourced by the SmartFrog entry points, so as to provide
# an override point for anyone wishing to set up environment variables.
# You are free to add whatever you wish here; it is read by the shell script setSFProperties
# It is marked in the RPM files as a configuration file -when upgrading, all customisations are preserved.

if [ "`uname -a|grep SunOS`" != "" ]; then
  # Intel Solaris 10 (dev13)
  if [ "`uname -a|grep i386|grep 5.10`" != "" ]; then
    export JAVA_HOME=/qa/tools/opt/solaris10_x86/jdk1.6.0_15
  fi;

  # Intel Solaris 9 (dev66)
  if [ "`uname -a|grep i386|grep 5.9`" != "" ]; then
    export JAVA_HOME=/qa/tools/opt/solaris9_x86/jdk1.6.0_15
  fi;

  # SPARC Solaris 10 (dev92)
  if [ "`uname -a|grep sparc|grep 5.10`" != "" ]; then
    export JAVA_HOME=/qa/tools/opt/solaris10_sparc/jdk1.6.0_15
  fi;

  # SPARC Solaris 9 (dev12)
  if [ "`uname -a|grep sparc|grep 5.9`" != "" ]; then
    export JAVA_HOME=/qa/tools/opt/solaris9_sparc/jdk1.6.0_15
  fi;

  export PATH=$JAVA_HOME/bin:$PATH
fi;

