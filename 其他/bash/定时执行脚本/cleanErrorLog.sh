#!/bin/bash
dir=/opt/backup/loginErrorLog
/home/tech/mysql/bin/mysqldump -uroot -pbyau#20180129113 IDSPLUS T_LOGINERRORLOG > "$dir/LOGINERRORLOG_`date +%Y%m%d`.sql"
#USE IDSPLUS;	
/home/tech/mysql/bin/mysql -uroot -pbyau#20180129113 -e "use IDSPLUS;delete from T_LOGINERRORLOG;"
