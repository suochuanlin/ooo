设置一个来自客户端URL：http://localhost:8080/webgateway/index

1、服务器8080端口接收到客户发来的请求，被一个在那里监听的叫HTTP1.1的Connector获取了这个链接请求；

2、Connector把请求交给同在Service下的Engine去处理，并等待Engine的响应；

3、Engine把url解析，并把请求传给相对应的Host处理，如果没有相对应的Host，则用默认名叫localhost的Host来处理；

4、Host再把url解析为/webgateway/index.html，匹配context-path为/webgateway的Context去处理（如果匹配不到就把该请求交给路径名为””的Context去处理）；

5、context-path为/webgateway的Context会匹配Servlet Mapping为/index的Servlet处理；

6、构造HttpServletRequest对象和HttpServletResponse对象，作为参数调用Servlet的doGet或doPost方法；

7、Context把处理完的HttpServletResponse对象返回给Host；

8、Host把HttpServletResponse对象返回给Engine；

9、Engine把HttpServletResponse对象返回给Connector；

10、Connector把HttpServletResponse对象返回给客户browser。
