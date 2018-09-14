#!/bin/bash
#mkdir -p /home/share/timerSearch
file=/home/share/timerSearch/record.txt
echo "========================================" >> $file
echo "定时查询脚本启动了。。。" >> $file
date "+%Y-%m-%d %H:%M:%S"  >> $file
docker exec -it sudy_casdb_ids_db.1.bdpuc69ybmlu4x6d6zxmyemps /bin/bash /home/share/timerSearch/select

echo "" >> $file
echo "" >> $file

