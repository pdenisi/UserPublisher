mvn clean
wait
mvn install
wait
docker stop $1 
docker rm $1
docker rmi -f $2
wait
docker build -t userpublisher:spring-docker --no-cache . 
wait
docker run -it --rm -p 8080:8080 userpublisher:spring-docker --network kafka_docker_example_net
wait
