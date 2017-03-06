package edu.fjnu.fujiantravel.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

import edu.fjnu.fujiantravel.order.Order;
import edu.fjnu.fujiantravel.order.OrderHandler;
import edu.fjnu.fujiantravel.push.PushHandler;
import edu.fjnu.fujiantravel.push.PushMessage;
import edu.fjnu.fujiantravel.user.User;
import edu.fjnu.fujiantravel.user.UserHandler;

public class ServerThread implements Runnable {

	private Socket socket = null;
	private DataOutputStream out = null;
	private DataInputStream in = null;
	private MyMessage msg = new MyMessage();

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			while (socket != null) {
				String info = null;
				info = in.readUTF();
				msg = (MyMessage) Json.JsontoObject(info, msg.getClass());
				int type = msg.gethead();
				typeoperation(type);
			}
		} catch (IOException e) {
			e.printStackTrace();
			error();
		} catch (SQLException e) {
			e.printStackTrace();
			error();
		}
	}

	private void typeoperation(int type) throws SQLException, IOException {
		switch (type) {
		case Client.CLINT_FINISH:
			System.out.println(socket.getInetAddress().getHostAddress() + ":请求结束");
			in.close();
			out.close();
			socket.close();
			socket = null;
			break;
		case User.USERLOG:
			UserHandler.userlog(out, msg);
			break;
		case User.USERREGISTER:
			UserHandler.userregister(out, msg);
			break;
		case Order.CREATEORDER:
			OrderHandler.createorder(out, msg);
			break;
		case PushMessage.PUSHBIND:
			PushHandler.binduser(out, msg);
			break;
		default:
			this.messageerror();
			break;
		}
	}

	private void error() {
		try {
			msg.sethead(Client.SERVER_ERROR);
			msg.setdetail(null);
			String JsonStr = Json.ObjecttoJson(msg);
			out.writeUTF(JsonStr);
			out.flush();

			out.close();
			in.close();
			socket.close();
			socket = null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void messageerror() {
		try {
			msg.sethead(Client.MESSAGEHEAD_ERROR);
			msg.setdetail(null);
			String JsonStr = Json.ObjecttoJson(msg);
			out.writeUTF(JsonStr);
			out.flush();

			out.close();
			in.close();
			socket.close();
			socket = null;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}