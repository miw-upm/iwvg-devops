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
echo ============ mvn sonar:sonar ... =======================================================
echo .
call mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install --settings settings.xml
call mvn sonar:sonar -Dsonar.organization=miw-upm-github -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=2c0fb8373ef9b9e73ffad70e23f1a77158fb0e37 --settings settings.xml
pause

