#!/bin/bash
dir=/opt/backup/loginErrorLog
/home/sudytech/mysql/bin/mysqldump -uroot -pbyau#20180129113 IDSPLUS T_LOGINERRORLOG > "$dir/LOGINERRORLOG_`date +%Y%m%d`.sql"
#USE IDSPLUS;	
/home/sudytech/mysql/bin/mysql -uroot -pbyau#20180129113 -e "use IDSPLUS;delete from T_LOGINERRORLOG;"
