Tomcat 架构设计
参考资料: [超链接] https://objcoding.com/2019/05/30/tomcat-architecture/


Tomcat 本质： 一个WEB服务器+一个Servlet容器，所以它必然需要处理网络的链接 与 Servlet的管理。

![Image text](https://github.com/suochuanlin/ooo/blob/master/src/main/resources/imagefolder/Tomcat结构.jpeg)

一个 Tomcat 代表一个 Server 服务器，一个 Server 服务器可以包含多个 Service 服务，Tomcat 默认的 Service 服务是 Catalina，而一个 Service 服务可以包含多个连接器，因为 Tomcat 支持多种网络协议，包括 HTTP/1.1、HTTP/2、AJP 等等，一个 Service 服务还会包括一个容器，容器外部会有一层 Engine 引擎所包裹，负责与处理连接器的请求与响应，连接器与容器之间通过 ServletRequest 和 ServletResponse 对象进行交流。
~~~~
server.xml配置结构
<Server port="8005" shutdown="SHUTDOWN">

  <Service name="Catalina">

    <Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" URIEncoding="UTF-8"/>

    <Connector port="8009" protocol="AJP/1.3" redirectPort="8443"/>

    <Engine defaultHost="localhost" name="Catalina">

      <Host appBase="webapps" autoDeploy="true" name="localhost" unpackWARs="true">

        <Context docBase="handler-api" path="/handler" reloadable="true" source="org.eclipse.jst.jee.server:handler-api"/>
      </Host>
    </Engine>
  </Service>
</Server>
~~~~

### 连接器（Connector）
连接器负责将各种网络协议封装起来，对外部屏蔽了网络连接与 IO 处理的细节，将处理得到的 Request 对象传递给容器处理，Tomcat 将处理请求的细节封装到 ProtocolHandler，ProtocolHandler 是一个接口类型，通过实现 ProtocolHandler 来实现各种协议的处理，如 Http11AprProtocol：
![Image text](https://github.com/suochuanlin/ooo/blob/master/src/main/resources/imagefolder/connector结构.jpg)

`Endpoint 组件用来处理底层的 Socket 网络连接`

`process 方法会创建一个 processor 对象，调用它的 process 方法将 Socket 字节流封装成 Request 对象`

`Adapter 的主要作用是将 Request 对象适配成容器能够识别的 Request 对象。`

### 容器（Container）
Tomcat中一共设计了4中容器，Engine、Host、Context、Wrapper，关系如下：

![Image text](https://github.com/suochuanlin/ooo/blob/master/src/main/resources/imagefolder/容器结构.png)




`Engine：表示一个虚拟主机的引擎，一个 Tomcat Server 只有一个 引擎，连接器所有的请求都交给引擎处理，而引擎则会交给相应的虚拟主机去处理请求；`

`Host：表示虚拟主机，一个容器可以有多个虚拟主机，每个主机都有对应的域名，在 Tomcat 中，一个 webapps 就代表一个虚拟主机，当然 webapps 可以配置多个；`

`Context：表示一个应用容器，一个虚拟主机可以拥有多个应用，webapps 中每个目录都代表一个 Context，每个应用可以配置多个 Servlet。`


**从容器的组合关系来看，他们调用顺序必定是：**

`Engine -> Host -> Context -> Wrapper -> Servlet`

### Tomcat如何定位servlet


那么 Tomcat 是如何来定位 Servlet 的呢？答案是利用 Mapper 组件来完成定位的工作。

Mapper 最主要的核心功能是保存容器组件之间访问路径的映射关系
![Image text](https://github.com/suochuanlin/ooo/blob/master/src/main/resources/imagefolder/Tomcat定位servlet.png)
