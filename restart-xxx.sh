i1=`ps -ef|grep -E "xxx-boot-0.0.1.jar"|grep -v grep|awk '{print $2}'`
message='�����ɹ�'
if [ ! -z $i1 ] ; then
  message='�����ɹ�'
  kill -9 $i1
fi
nohup java -jar /home/xxx/xxx-boot-0.0.1.jar > nohup.log 2>&1 &
i1=`ps -ef|grep -E "xxx-boot-0.0.1.jar"|grep -v grep|awk '{print $2}'`
if [ ! -z $i1 ] ; then
  echo $message'����id:'$i1
else
 echo '����ʧ�ܽ���'
fi
