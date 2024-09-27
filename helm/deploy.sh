#!/bin/bash

# 添加 Helm 仓库
helm repo add bitnami https://charts.bitnami.com/bitnami
helm repo add rocketmq https://apache.github.io/rocketmq-operator/charts
helm repo add nacos https://nacos.io/helm-chart
helm repo update

# 部署 MySQL
helm install my-mysql bitnami/mysql --set auth.rootPassword=yourpassword

# 部署 Zookeeper
helm install my-zookeeper bitnami/zookeeper

# 部署 RocketMQ
helm install my-rocketmq rocketmq/rocketmq-operator

# 部署 Nacos
helm install my-nacos ./nacos
