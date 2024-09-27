#!/bin/bash
#https://artifacthub.io/packages/helm/ygqygq2/nacos
helm repo add ygqygq2 https://ygqygq2.github.io/charts/
helm repo update

helm install my-nacos ygqygq2/nacos --version 2.1.7 set service.type=LoadBalancer


#卸载nacos
#helm uninstall my-nacos