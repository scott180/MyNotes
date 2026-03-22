#!/bin/bash
#file=/home/share/timerSearch/record.txt
#crontab -uroot -e
#*/1 * * * * /bin/bash /home/share/timerSearch/timerSearchDB.sh >> /home/share/timerSearch/record.txt 2>&1
echo "===============begin=========================" 
echo "定时查询脚本启动了。。。" 
date "+%Y-%m-%d %H:%M:%S" 

docker_name=mobile_ucc_db_1
sql="use UCCPLUS;select id,loginName,name,password,idcard,field29 from T_USER where loginName='admin'\G;"
#docker exec -it ${docker_name} mysql -uroot -pSudy.web123 -e $sql  >> $file
docker exec -i mobile_ucc_db_1 mysql -uroot -pSudy.web123 -e "select now();use UCCPLUS;select id,loginName,name,password,idcard,field29 from T_USER where loginName='admin'\G;"  >> /home/share/timerSearch/recordDB.txt

echo "" 
echo "" 
