@echo off
rem Steps:
rem 1. (Re)build jar-file of the project
rem 2. If successfully, copy it to docker-compose folder of the project
rem 3. Run app in docker-compose
rem 4. Open web view in browser

del mvn.report>nul 2>nul
echo Rebuilding Jar...

call mvn clean
call mvn package -Dmaven.test.skip=true
rem call mvn package -DskipTests   - also works
if errorlevel 1 (echo Error occured while building jar. Exiting
    goto exit)
echo Done

echo Copying app jar-file into the container...
copy target\book-store-example-1.0-SNAPSHOT.jar docker-compose\>nul 2>nul
if errorlevel 1 (echo Copying jar failed. Exiting
    goto exit)
echo Done

echo Starting services...
cd docker-compose
docker-compose up -d
if errorlevel 1 (echo Error occured while running docker-compose. Exiting
    goto exit)
cd ..
echo Ready

echo Opening view in browser
for /F %%a in ('docker-machine ip') do (set docker_machine_ip=%%a)
explorer http://%docker_machine_ip%:8080

:exit
@echo on