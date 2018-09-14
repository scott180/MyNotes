#!/bin/bash
#mkdir -p /home/share/timerSearch
file=/home/share/timerSearch/record.txt
echo "========================================" >> $file
echo "定时查询脚本启动了。。。" >> $file
date "+%Y-%m-%d %H:%M:%S"  >> $file

/opt/sudytech/mysql/bin/mysql -uroot -p12344 -e "use IDSPLUS;select id,loginName,name,password,idcard,field29 from T_USER where loginName='admin'\G;" >> $file

echo "" >> $file
echo "" >> $file

