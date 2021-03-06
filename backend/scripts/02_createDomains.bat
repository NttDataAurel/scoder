@echo off

set GF_DIR=D:\practicaDeVara\glassfish4.1.2

set FRONT_DOMAIN=scoder_front
set /a FRONT_PORTBASE=1000
set /a FRONT_ADMINPORT=%FRONT_PORTBASE% + 48

set BACK_DOMAIN=scoder_back
set /a BACK_PORTBASE=2000
set /a BACK_ADMINPORT=%BACK_PORTBASE% + 48
set MYSQL_USER=scoder
set MYSQL_PASS=scoderPass
set MYSQL_DB=scoderdb

@echo on
xcopy org.eclipse.persistence.moxy-2.6.1.jar %GF_DIR%\glassfish\modules\
if not exist %GF_DIR%\glassfish\modules\org.eclipse.persistence.moxy-2.6.1.jar (
    echo "   Error. Cannot copy eclipse moxy jar. Eclipse moxy has to be copied to %GF_DIR%\glassfish\modules\"
	pause
	exit /b
)

rm %GF_DIR%\glassfish\modules\org.eclipse.persistence.moxy.jar
if exist %GF_DIR%\glassfish\modules\org.eclipse.persistence.moxy.jar (
    echo "   Error. org.eclipse.persistence.moxy.jar needs to be deleted from %GF_DIR%\glassfish\modules\"
	pause
	exit /b
)

echo Creating %FRONT_DOMAIN%
@call %GF_DIR%\bin\asadmin.bat create-domain --portbase %FRONT_PORTBASE% %FRONT_DOMAIN%
echo Creating %BACK_DOMAIN%
@call %GF_DIR%\bin\asadmin.bat create-domain --portbase %BACK_PORTBASE% %BACK_DOMAIN%
xcopy mysql-connector-java-8.0.11.jar  %GF_DIR%\glassfish\domains\%BACK_DOMAIN%\lib\ext\
if not exist %GF_DIR%\glassfish\domains\%BACK_DOMAIN%\lib\ext\mysql-connector-java*.jar (
    echo "   Error. Cannot find mysqlconnector. Mysql connector has to be copied to %BACK_DOMAIN%\lib\ext\"
	pause
	exit /b
)

@call %GF_DIR%\bin\asadmin.bat start-domain %BACK_DOMAIN%
@call %GF_DIR%\bin\asadmin.bat --port %BACK_ADMINPORT% --user admin create-jdbc-connection-pool ^
--datasourceclassname com.mysql.cj.jdbc.MysqlDataSource ^
--restype javax.sql.DataSource ^
--steadypoolsize 18  ^
--maxpoolsize 32  ^
--maxwait 60000 ^
--poolresize 2  ^
--idletimeout 300  ^
--isolationlevel read-committed ^
--isisolationguaranteed  ^
--isconnectvalidatereq=true  ^
--validationmethod auto-commit  ^
--failconnection=true  ^
--description scoderConnectionPool  ^
--property user=%MYSQL_USER%:password=%MYSQL_PASS%:URL=jdbc\:mysql\://localhost\:3306/%MYSQL_DB%:useSSL=false ^
scoderJdbcPool 

@call %GF_DIR%\bin\asadmin.bat --port %BACK_ADMINPORT% --user admin  create-jdbc-resource  ^
--connectionpoolid scoderJdbcPool ^
scoderJdbcResource

@call %GF_DIR%\bin\asadmin.bat --port %BACK_ADMINPORT% --user admin  create-jvm-options -Dcom.sun.jersey.server.impl.cdi.lookupExtensionInBeanManager=true
@call %GF_DIR%\bin\asadmin.bat --port %BACK_ADMINPORT% --user admin  list-jvm-options 

@call %GF_DIR%\bin\asadmin.bat stop-domain %BACK_DOMAIN%
pause