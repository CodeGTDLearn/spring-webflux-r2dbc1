echo on
REM SETTING JDK8 AS DEFAULT
set JAVA_HOME=C:\Program Files\java\AdoptOpenJDK-8.0.252.09\

REM CLEAN EVERYTHING BEFORE GO-UP EVERYTHING
docker-compose -f ../dev-compose.yml down --remove-orphans
docker-compose -f ../test-compose.yml down --remove-orphans

docker container prune --force
docker container rm $(docker container ls -q)

docker system prune --volumes --force
docker volume rm $(docker volume ls -q)

docker image prune --force
docker image rm pauloportfolio/web-api

docker system df
docker image ls

REM MAVEN-CLEAN-PACKAGE WITHOUT TESTS
cd ..
call mvn clean package -DskipTests
cd docker-script-start-files

docker-compose -f ../dev-compose.yml down --remove-orphans
docker-compose -f ../test-compose.yml down --remove-orphans

docker container prune --force
docker container rm $(docker container ls -q)

docker system prune --volumes --force
docker volume rm $(docker volume ls -q)

docker image prune --force
docker image rm pauloportfolio/web-api

docker system df
docker image ls

rem START THE COMPOSE CONTAINERS
docker-compose -f ../dev-compose.yml up --build --force-recreate

pause

