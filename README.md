A Simple Spring Boot Rabbit MQ Web Application

Steps
Download ERLANG from https://www.erlang.org/downloads
Install 

Download RabbitMQ from https://www.rabbitmq.com/install-windows.html
Install and Run As Service
Open command prompt
cd ...\RabbitMQ Server\rabbitmq_server-3.12.5\sbin
RUN : rabbitmq-plugins enable rabbitmq_management

Access Rabbit MQ : http://localhost:15672/ with username/password as guest/guest

Start the application

API : http://localhost:8080/api/order/mcdonalds

POST

{
"name":"Burger",
"price":100,
"qty": 2
}

Check the log and rabbitmq metrics

![image](https://github.com/srss-pocs/springboot-rabbitmq/assets/145287517/d2753cfa-4e6b-4431-bd19-59c1a3290986)
