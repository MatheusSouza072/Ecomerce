# Ecomerce
to run mysql container: docker run --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql:8.0.23


Connection to a database is required, if you prefer, run the command:

docker run --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql:8.0.23

The main class path: com.product.ProductApplication

The application port is 7050

I recommend using java version 11.

For more information use the swagger documentation: http://localhost:7050/swagger-ui.html
