
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

public class Serial {
	String a = "hello world";
	byte buffer[] = a.getBytes();
	Crc16 crc16 = new Crc16();
	public Serial() {
		super();

	}

	void connect(String portName) throws Exception{

		CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
		if(portIdentifier.isCurrentlyOwned()) {
			System.out.println("Error : 포트가 현재 사용중입니다");
		} else {
			CommPort commPort = portIdentifier.open(this.getClass().getName(),2000);

			if (commPort instanceof SerialPort) {
				SerialPort serialPort = (SerialPort) commPort;
				serialPort.setSerialPortParams(57600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
				serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
				InputStream in = serialPort.getInputStream();
				OutputStream out = serialPort.getOutputStream();
				System.out.println("시리얼 포트가 열렸습니다. 포트는 : "+serialPort.getName());
				//				try {
				//					int c =0;
				//					while((c = System.in.read()) > -1) {
				//						((OutputStream) this.out).write(9);
				//					}
				//				} catch (IOException e) {
				//					// TODO: handle exception
				//					e.printStackTrace();
				//				}
				//				int msg = 9;
				//				out.write(msg);
				
				try {
					System.out.println("메세지를 입력하세요. 단, 값은 한번밖에 못보냅니다");
					System.out.println(" 126 : "+Integer.toHexString(-35));
					System.out.println(" -88 : "+Integer.toHexString(-57));
					System.out.println("0x8005 : "+0x8000);
					System.out.println("0xffff : "+0xffff);
					System.out.println("0xff : "+0xff);
					System.out.println("buffer의 크기는 : "+buffer.length);
					//System.in.read(buffer);
					//buffer[0] = 97;
					byte[] send = new byte[buffer.length+2];
					for(int i = 0; i<buffer.length;i++) {
						send[i] = buffer[i];
					}
					System.out.println(Arrays.toString(buffer));
					send[send.length -1 ] = (byte)(crc16.calculate_crc(buffer) & 0xff);
					send[send.length -2 ] = (byte)(crc16.calculate_crc(buffer) >> 8);
					out.write(send);
					//					try {
					//						Thread.sleep(3000);
					//					} catch (InterruptedException e) {
					//						// TODO Auto-generated catch block
					//						e.printStackTrace();
					//					}
					//					System.out.println("쓰기전 "+in.read(buffer));
					//System.out.println("버퍼 길이 : "+ send.length);
					System.out.println("어레이 : "+Arrays.toString(send));
					//System.out.println("뉴 스트링 : "+new String(send));
					Thread.sleep(300);
					(new Thread(new SerialRead(in))).start();
					//					System.out.println("쓰기 후 "+in.read(buffer));
					//					System.out.println("시리얼  array"+Arrays.toString(buffer));
					//					System.out.println("시리얼  new string"+new String(buffer));
					//					out.flush();
					//					out.close();

				}catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				//				serialPort.close();
				//				(new Thread(new SerialRead(in))).stop();
				//				(new Thread(new SerialWriter(out))).start();


				//System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

			} else {
				System.out.println("Error : 시리얼 포트는 오직 이 예제에만 작동합니다");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			(new Serial()).connect("COM2");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}




