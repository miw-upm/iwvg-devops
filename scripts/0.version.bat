@echo off
::set se definen variables
set workspace=C:\DatosJBB\WorkSpaces\Oxygen\IWVG.Forge
::Las variables de entorno se pueden configurar directamente en Windows cuando se tienen los permisos necesarios
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_65
set M2_HOME=C:\Archivos_de_programa\apache-maven-3.3.3
:: %var% se accede a una variable
set PATH=%PATH%;%JAVA_HOME%\bin;%M2_HOME%\bin
::echo saca por pantalla un mensaje
echo -----------------------------------------
echo . (C) MIW
echo -----------------------------------------
echo .
echo Workspace --- %workspace%
echo JAVA_HOME --- %JAVA_HOME%
echo M2_HOME   --- %M2_HOME%
echo .
cd %workspace%
echo ============ mvn --version =======================================================
echo .
:: Se ejecuta un comando maven
call mvn --version
echo .
::Se queda la consola abierta para realizar comandos en línea
cmd /k
