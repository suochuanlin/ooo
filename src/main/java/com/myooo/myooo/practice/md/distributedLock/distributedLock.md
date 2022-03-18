##  分布式锁

~~~~
1、实现分布式锁的方式
2、为何选用Redisson,Redisson与Jdies对比优劣势
3、分布式锁使用中问题及 原理，Redlock 、lua脚本等
~~~~

#### 1、实现分布式锁的方式

~~~~
1、redis分布式锁要点分析
2、多节点redis实现的分布式锁算法(RedLock):有效防止单点故障
redlock: Redis Distributed Lock
~~~~
**1、分布式锁特点: 互斥性、无死锁、容错/高可用**

**1.1、问题： 防止死锁（设置超时）、锁误删除（Lua）、原子操作问题(设定唯一Value)、过期时间<业务时间(锁续租)**

**1.2 特性**

互斥性: setNx

无死锁: expire 原子性操作: set key value TTL(Time To Live)

容错/高可用:  





2、RedLock

相关资料:
[Redlock（redis分布式锁）原理分析](https://www.cnblogs.com/rgcLOVEyaya/p/RGC_LOVE_YAYA_1003days.html)

![Image text](https://github.com/suochuanlin/ooo/blob/master/src/main/resources/imagefolder/WechatIMG279.jpeg)
