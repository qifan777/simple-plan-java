### 安装redis

```
docker run --name myredis --net=mynet --network-alias redis -v redis-data:/data  -d redis:6.2.5 redis-server --appendonly yes
```

### 安装mysql8.0

```
docker run --name mymysql  --net=mynet --network-alias mysql -v mysql-data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=123456 -d  mysql:8.0.26
```

### 导入sql文件

cloud_base.sql是系统模块的sql文件 cloud_plan_manager.sql是计划管理模块的sql文件

### 修改hosts

打开C:\Windows\System32\drivers\etc\hosts添加下面的内容

```
#k8s-cloud
127.0.0.1 cloud-gateway
127.0.0.1 cloud-system
127.0.0.1 cloud-plan
```

### 以下不用安装

### 安装rabbitmq(自带延迟消息插件)

```
docker run -d  --name myrabbit --net=mynet --network-alias rabbitmq -v rabbitmq-data:/var/lib/rabbitmq -e RABBITMQ_DEFAULT_USER=root -e RABBITMQ_DEFAULT_PASS=admin   circleci/rabbitmq-delayed:3.8.9-management-38
docker run  --name myrabbit -e RABBITMQ_DEFAULT_USER=root -e RABBITMQ_DEFAULT_PASS=admin  -p 5672:5672 -p 15672:15672 -d     circleci/rabbitmq-delayed:3.8.9-management-38
docker pull 
```

### 安装nacos(不使用配置中心)

```
docker run --name mynacos  --net=mynet --network-alias nacos -e MODE=standalone -d nacos/nacos-server:2.0.2
```