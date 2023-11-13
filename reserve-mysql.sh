docker run -d \
  --name reserve-mysql \
  -e MYSQL_ROOT_PASSWORD=reserve \
  -e MYSQL_DATABASE=reserve \
  -e MYSQL_USER=reserve \
  -e MYSQL_PASSWORD=reserve \
  -p 3306:3306 \
  mysql:latest