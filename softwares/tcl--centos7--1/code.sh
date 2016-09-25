result=$(which tclsh)
if [ "$?" -ne 0 ]; then
   result=$(yum install -y tclsh)
   if [ $? -ne 0 ]; then
      exit 1
   fi
fi
exit 0