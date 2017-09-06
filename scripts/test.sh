#echo off
export workspace=/home/gonzalo/Escritorio/master/workspace/gonzalo.gutierrez.ecp1.miw.upm.es
#set PATH=%PATH%C:\Program Files (x86)\Java\jre1.8.0_51\bin;C:\Users\bm0827\Desktop\apache-maven-3.3.3\bin
#set JAVA_HOME=C:\Program Files (x86)\Java\jre1.8.0_51
echo -----------------------------------------
echo ".(C) MIW"
echo -----------------------------------------
echo .
echo Workspace --- $workspace
echo .
cd $workspace
echo "============ mvn clean test (profile: develop) ======================================================="
echo .
mvn clean test
exit

