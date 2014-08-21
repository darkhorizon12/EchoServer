EchoServer
==========

Simple reproduction of problem with netty and threads

Simple thread problem demonstration
  
To reproduce, run:
  
    mvn compile
    mvn assembly:single
    java -Dthreaded -jar target/echoServer-1.0-SNAPSHOT-jar-with-dependencies.jar
  
And then telnet to the echo server on port 8007.
  
You'll see that the listeners in the future don't get called until new data is received and echoed.

Closing the connection causes the listener of the last future to be called.

If you omit -Dthreaded, the code will execute everything on the same thread,
resulting in normal behavior on the future completion listeners.

Sample run:

    Aug 20, 2014 4:43:56 PM io.netty.handler.logging.LoggingHandler channelRegistered
    INFO: [id: 0x7b016846] REGISTERED
    Aug 20, 2014 4:43:56 PM io.netty.handler.logging.LoggingHandler bind
    INFO: [id: 0x7b016846] BIND(0.0.0.0/0.0.0.0:8007)
    Aug 20, 2014 4:43:56 PM io.netty.handler.logging.LoggingHandler channelActive
    INFO: [id: 0x7b016846, /0:0:0:0:0:0:0:0:8007] ACTIVE
    Aug 20, 2014 4:43:59 PM io.netty.handler.logging.LoggingHandler logMessage
    INFO: [id: 0x7b016846, /0:0:0:0:0:0:0:0:8007] RECEIVED: [id: 0x7005b0ec, /0:0:0:0:0:0:0:1:51002 => /0:0:0:0:0:0:0:1:8007]
    About to write to io.netty.channel.DefaultChannelHandlerContext@133b3134
    Got future DefaultChannelPromise@2fb6ca34(incomplete)
    About to write to io.netty.channel.DefaultChannelHandlerContext@133b3134
    Got future DefaultChannelPromise@292346b8(incomplete)
    Got completion DefaultChannelPromise@2fb6ca34(success)
    Got completion DefaultChannelPromise@292346b8(success)
