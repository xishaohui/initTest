package minaTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class MinaServer {
	private static final int port = 8888;
	public static void main(String[] args) {
		IoAcceptor ioAcceptor = new NioSocketAcceptor();
		System.out.println("begin server ...");//¿ªÆô·þÎñÆ÷
		ioAcceptor.getFilterChain().addLast("logger", new LoggingFilter());
		ioAcceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter
				(new TextLineCodecFactory(Charset.forName("utf-8"))));
		
		ioAcceptor.setHandler(new HelloWorldHandler());
		ioAcceptor.getSessionConfig().setReadBufferSize(2048);
		ioAcceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
		try {
			ioAcceptor.bind(new InetSocketAddress(port));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
		
		
	}
	
	
	
	
	
	
}
