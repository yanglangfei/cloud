#!/usr/bin/env bash
# 打包module 下的docker镜像

set -eo pipefail

modules=(app gateway task product-service user-service discover config-server admin)

for module in "${modules[@]}"; do
    docker build -t "microservice/${module}:latest" ${module}
done