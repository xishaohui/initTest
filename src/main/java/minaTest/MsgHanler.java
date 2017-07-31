package minaTest;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MsgHanler extends IoHandlerAdapter{
	private static final Logger log = LoggerFactory.getLogger(MsgHanler.class);
	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		log.error("-----exception--------");
		super.exceptionCaught(session, cause);
	}
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		//从服务器中接收到信息后的处理
		log.info("-----msg  receive-----");
		log.info("message:{}"+message.toString());
		super.messageReceived(session, message);
	}
	
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		log.info("-----msg--sent--------");
		super.messageSent(session, message);
	}
	@Override
	public void sessionCreated(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		log.info("---session create-----");
		super.sessionCreated(session);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
