docker build . -t my-api  

docker network create my-network

docker run --name my-db -p 3306:3306 --network my-network -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=mydb -e MYSQL_USER=user -e MYSQL_PASSWORD=user -d mysql

docker run -p 8080:8080 --network my-network --name my-api -d my-api

