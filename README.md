EchoServer
==========

Simple reproduction of problem with netty and threads

Simple thread problem demonstration
  
To reproduce, run:
  
  mvn assembly:single
  java -Dthreaded -jar target/echoServer-1.0-SNAPSHOT-jar-with-dependencies.jar
  
And then telnet to the echo server on port 8007.
  
You'll see that the listeners in the future don't get called until new data is received and echoed.

Closing the connection causes the listener of the last future to be called.

If you omit -Dthreaded, the code will execute everything on the same thread,
resulting in normal behavior on the future completion listeners.
