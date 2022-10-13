docker build . -t my-api  

docker network create my-network

docker run --name my-db -p 3306:3306 --network my-network -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=mydb -e MYSQL_USER=user -e MYSQL_PASSWORD=user -d mysql

docker run -p 8080:8080 --network my-network -e MYSQL_DB=mydb -e MYSQL_USER=user -e MYSQL_PASSWORD=user --name my-api -d my-api

로컬에서 실행시 VM option에 -DMYSQL_DB=mydb -DMYSQL_USER=root -DMYSQL_PASSWORD=1234로 넣어도 환경변수에 넣은것처럼 인식할 수 있다.