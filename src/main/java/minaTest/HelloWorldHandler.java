package minaTest;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class HelloWorldHandler extends IoHandlerAdapter{
	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(session, cause);
	}
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		String string = message.toString();
		if(string.trim().equalsIgnoreCase("quit")){
			session.close(true);
			return ;
		}
		System.out.println("recevied message:"+string);
		String reply= "Hi,i am server";
		session.write(reply);
		System.out.println("message have been writeen");
	}
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("message have been sent");
	}
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		System.out.println("closed session");
	}
	@Override
	public void sessionCreated(IoSession session) throws Exception {
		System.out.println("session created");
	}
	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		System.out.println("IDLE:"+session.getIdleCount(status));
	}
	@Override
	public void sessionOpened(IoSession session) throws Exception {
		System.out.println("session opened");
	}
	
}
