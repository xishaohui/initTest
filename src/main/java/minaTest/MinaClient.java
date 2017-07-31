package minaTest;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.future.CloseFuture;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.SocketConnector;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class MinaClient {
	private SocketConnector connector;
	private ConnectFuture future;
	private IoSession session;
	
	public boolean connect(){
		/**
		 * 1.创建一个socket连接，连接到服务器；
		 */
		connector = new NioSocketConnector();
		/**
		 * 获取过滤器链，用于添加过滤器
		 */
		DefaultIoFilterChainBuilder chain = connector.getFilterChain();
		//a. 添加日志过滤器
		chain.addLast("logger", new LoggingFilter());
		//b. 添加字符的编码过滤器
		chain.addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("utf-8"))));
		//2 设置信息处理器，用于处理接受到的信息；
		connector.setHandler(new MsgHanler());
		// 3 根据ip和端口号连接服务器
		future = connector.connect(new InetSocketAddress("127.0.0.1", 8888));
		//等待连接创建完成
		future.awaitUninterruptibly();
		//4 获取session对象，通过session对象可以向服务器发送信息；
		session = future.getSession();
		session.getConfig().setUseReadOperation(true);
		return future.isConnected();
	}
	/**
	 *向服务器发送信息
	 */
	public void sendMsg2Server(String message){
		session.write(message);
	}
	/**
	 * 关闭与服务器的连接
	 * 
	 */
	public boolean close(){
		CloseFuture future = session.getCloseFuture();
		future.awaitUninterruptibly(1000);
		connector.dispose();
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
