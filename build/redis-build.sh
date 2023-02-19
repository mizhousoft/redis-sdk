#!/bin/sh

set -e
set -u

REDIS_VERSION=6.2.10
REDIS_INSTALL_DIR=/opt/mizhousoft/redis

wget http://download.redis.io/releases/redis-${REDIS_VERSION}.tar.gz

tar xzf redis-${REDIS_VERSION}.tar.gz

cd redis-${REDIS_VERSION}

make PREFIX=${REDIS_INSTALL_DIR} install

mkdir -p ${REDIS_INSTALL_DIR}/conf
cp redis.conf ${REDIS_INSTALL_DIR}/conf/redis_6379.conf

cd ..
cp redis_init_script ${REDIS_INSTALL_DIR}/redis.sh
sed -i 's/^daemonize.*/daemonize yes/g' ${REDIS_INSTALL_DIR}/conf/redis_6379.conf
sed -i 's:^logfile.*:logfile "/opt/mizhousoft/logs/redis/redis.log":g' ${REDIS_INSTALL_DIR}/conf/redis_6379.conf
sed -i 's/^databases.*/databases 16/g' ${REDIS_INSTALL_DIR}/conf/redis_6379.conf
sed -i 's:^dir .*:dir /opt/mizhousoft/redis/data:g' ${REDIS_INSTALL_DIR}/conf/redis_6379.conf
sed -i 's/^save 60 10000.*/save 60 100/g' ${REDIS_INSTALL_DIR}/conf/redis_6379.conf
sed -i 's/^# requirepass.*/requirepass redis123/g' ${REDIS_INSTALL_DIR}/conf/redis_6379.conf
sed -i 's/^bind 127.0.0.1.*/bind 127.0.0.1/g' ${REDIS_INSTALL_DIR}/conf/redis_6379.conf
sed -i 's:^pidfile /var/run/redis_6379.pid:pidfile /opt/mizhousoft/logs/redis/redis_6379.pid:g' ${REDIS_INSTALL_DIR}/conf/redis_6379.conf

chmod +x ${REDIS_INSTALL_DIR}/redis.sh
