//client
import java.net.*;
import java.io.*;
class EchoClient {
	private Socket s;
	private BufferedReader br;
	private BufferedWriter bw;
	private BufferedReader brmsg;
	private String msg;
	private String returnmsg;
	public EchoClient (String ip, int port) throws UnknownHostException, IOException {
		//3.���� ����
		s = new Socket(ip, port);
		//4.����� ��Ʈ�� ����
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		while(true) {
			//5.�޽��� �۽�
			brmsg = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("�����޽��� : ");
			msg = brmsg.readLine();
			bw.write(msg);
			bw.newLine();
			bw.flush();
			//8.�޽��� ����
			returnmsg = br.readLine();
			if(returnmsg.equals("exit")) {
				System.out.println("���� ���� ����");
				break;
			} else {
				System.out.println("���ƿ� �޽���: " + returnmsg);
			}
		}
		//9.���� ����
		if(s!=null) s.close();
		if(br!=null) br.close();
		if(bw!=null) bw.close();
		if(brmsg!=null) brmsg.close();
	}//������
	public static void main(String[] args) throws UnknownHostException, IOException {
	new EchoClient("192.168.0.61", 3000);
	}//����
}