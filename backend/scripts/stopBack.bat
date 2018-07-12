set GF_DIR=D:\practicaDeVara\glassfish4.1.2
set FRONT_DOMAIN=scoder_front
set BACK_DOMAIN=scoder_back

@call %GF_DIR%\bin\asadmin.bat stop-domain %BACK_DOMAIN%

pause
