@echo off
set workspace=C:\DatosJBB\WorkSpaces\Oxygen\IWVG.Forge
::Las variables de entorno se pueden configurar directamente en Windows cuando se tienen los permisos necesarios
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_65
set M2_HOME=C:\Archivos_de_programa\apache-maven-3.3.3
set PATH=%PATH%;%JAVA_HOME%\bin;%M2_HOME%\bin
echo -----------------------------------------
echo . (C) MIW
echo -----------------------------------------
echo .
echo Workspace --- %workspace%
echo JAVA_HOME --- %JAVA_HOME%
echo M2_HOME   --- %M2_HOME%
echo .
cd %workspace%

:: -ff, --fail-fast. Stop at first failure in reactorized builds. Línea de comentario
echo ============ mvn -ff clean test --settings settings.xml (profile: develop) ==================================
echo .
call mvn -ff clean test --settings settings.xml
if errorLevel 1 goto errorDevelop

echo .
:: -Dmaven.test.skip=true. To skip running the tests for a particular project
echo ============ call mvn -Dmaven.test.skip=true veriry -Denvironment.type=preproduction --settings settings.xml (profile: preproduction) ======
echo .
call mvn -Dmaven.test.skip=true verify -Denvironment.type=preproduction --settings settings.xml
pause
exit

:errorDevelop
echo .
echo .
echo .
echo ########  ERRORES...
pause
