import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class SerialRead implements Runnable {
	InputStream in;
	Crc16 crc16 = new Crc16();
	//	String a = "hellow world";
	//전체 받을 포맷
	byte[] recieve_crc = new byte[13];
	//crc를 제외한 부분
	byte[] recieve = new byte[11];
	//    Serial serial = new Serial();
	public SerialRead(InputStream in) {
		this.in = in;
	}

	public void run() {
		int len = -1;
		try {
			while ((len = this.in.read(recieve_crc)) > -1) {
				for(int i = 0; i<recieve.length;i++) {
					recieve[i] = recieve_crc[i];
				}
				byte[] crc_check = new byte[2];
				crc_check[1] = recieve_crc[recieve_crc.length-2];
				crc_check[0] = recieve_crc[recieve_crc.length-1];
				if( ((byte)(crc16.calculate_crc(recieve) & 0xff) == crc_check[1]) & ((byte)(crc16.calculate_crc(recieve) >> 8) == crc_check[0]) ) {
					System.out.println(Arrays.toString(recieve_crc));
					System.out.print(new String(recieve_crc,0,len));
				}
			} 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
