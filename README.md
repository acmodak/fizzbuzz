#Fizzbuzz Web Application

Following are some assumptions:
1) As the requirement mentioned web application assumed it needs to be an api
2) I expected input will be a query param in format that was in example

#Components:
1) fizzbuzz-app: this is the main application comprises services, controller and a kafka producer
2) fizzbuzz-client: this a retrofit client for the api
3) fizzbuzz-consumer: kafka consumer to consume fizz buzz messages

#To run the application:
1) Please make sure you have docker installed.
2) run docker-compose up -d
3) ./gradlew clean build to buid the application
4) run docker build -f fizzbuzz-app/Dockerfile -t fizzbuzz-app:1 .
5) docker run -p 8080:8080 fizzbuzz-app:1 &

#How to call the endpoint
http://localhost:8080/fizzbuzz/v1?input=["1"]

#Todo
Add consumer for consuming messages sent by producer
