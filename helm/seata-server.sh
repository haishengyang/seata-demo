#!/bin/bash
#https://seata.apache.org/zh-cn/docs/next/ops/deploy-by-helm

cd ./seata-server

helm install seata-server .


#export NODE_PORT=$(kubectl get --namespace default -o jsonpath="{.spec.ports[0].nodePort}" services seata-server)
#export NODE_IP=$(kubectl get nodes --namespace default -o jsonpath="{.items[0].status.addresses[0].address}")
#echo http://$NODE_IP:$NODE_PORT
#http://192.168.65.3:30091