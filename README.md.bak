# HttpConnectDemo
Android网络连接token失效，重新登录问题研究

#问题出现场景
服务器token到时间就自动失效；\<br/>
其他原因导致token失效，比如机器重启；\<br/>

#实现重新登录要求
即使用户token失效，也不退出到登录页面；\<br/> 
做到自动登录功能，保持用户操作连贯性，重新登录后继续用户之前的操作；\<br/>
\<br/>  
\<br/>  
 A(param1,param2){ 调用接口1，返回token失效，调用登录接口}  \<br/>
 B(param1,param2){ 调用接口2，返回token失效，调用登录接口} \<br/>
......................\<br/>
 login(username,pwd){登录，登录后的操作，如何返回A或B或其他等继续之前操作}
