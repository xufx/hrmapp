jsp页面发出请求，被控制器接收到，控制器调用业务逻辑组件（service）处理，控制器是jsp页面和业务逻辑组件的中间层

控制器的处理顺序：
解析请求参数
调用业务逻辑方法
将处理结果返回给jsp页面

springmvc控制器：核心控制器DispatcherServlet+业务控制器Controller