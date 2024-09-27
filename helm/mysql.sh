#!/bin/bash
# 官网地址 https://artifacthub.io/packages/helm/bitnami/mysql
# 添加 Helm 仓库
helm repo add bitnami https://charts.bitnami.com/bitnami

helm repo update
# 部署 MySQL
helm install my-mysql bitnami/mysql --set auth.rootPassword=Sinosoft@1302,primary.service.type=LoadBalancer,primary.service.ports.mysql=3307

#删除mysql
#helm uninstall my-mysql