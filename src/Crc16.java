public class Crc16 {
	public static void main(String... a) {
		byte[] bytes = new byte[] {
				(byte) 0X0000,(byte) 0XC0C1,(byte) 0XC181,(byte) 0X0140,(byte) 0XC301,(byte) 0X03C0,(byte) 0X0280,(byte) 0XC241,
				(byte) 0XC601,(byte) 0X06C0,(byte) 0X0780,(byte) 0XC741,(byte) 0X0500,(byte) 0XC5C1,(byte) 0XC481,(byte) 0X0440,
				(byte) 0XCC01,(byte) 0X0CC0,(byte) 0X0D80,(byte) 0XCD41,(byte) 0X0F00,(byte) 0XCFC1,(byte) 0XCE81,(byte) 0X0E40,
				(byte) 0X0A00,(byte) 0XCAC1,(byte) 0XCB81,(byte) 0X0B40,(byte) 0XC901,(byte) 0X09C0,(byte) 0X0880,(byte) 0XC841,
				(byte) 0XD801,(byte) 0X18C0,(byte) 0X1980,(byte) 0XD941,(byte) 0X1B00,(byte) 0XDBC1,(byte) 0XDA81,(byte) 0X1A40,
				(byte) 0X1E00,(byte) 0XDEC1,(byte) 0XDF81,(byte) 0X1F40,(byte) 0XDD01,(byte) 0X1DC0,(byte) 0X1C80,(byte) 0XDC41,
				(byte) 0X1400,(byte) 0XD4C1,(byte) 0XD581,(byte) 0X1540,(byte) 0XD701,(byte) 0X17C0,(byte) 0X1680,(byte) 0XD641,
				(byte) 0XD201,(byte) 0X12C0,(byte) 0X1380,(byte) 0XD341,(byte) 0X1100,(byte) 0XD1C1,(byte) 0XD081,(byte) 0X1040,
				(byte) 0XF001,(byte) 0X30C0,(byte) 0X3180,(byte) 0XF141,(byte) 0X3300,(byte) 0XF3C1,(byte) 0XF281,(byte) 0X3240,
				(byte) 0X3600,(byte) 0XF6C1,(byte) 0XF781,(byte) 0X3740,(byte) 0XF501,(byte) 0X35C0,(byte) 0X3480,(byte) 0XF441,
				(byte) 0X3C00,(byte) 0XFCC1,(byte) 0XFD81,(byte) 0X3D40,(byte) 0XFF01,(byte) 0X3FC0,(byte) 0X3E80,(byte) 0XFE41,
				(byte) 0XFA01,(byte) 0X3AC0,(byte) 0X3B80,(byte) 0XFB41,(byte) 0X3900,(byte) 0XF9C1,(byte) 0XF881,(byte) 0X3840,
				(byte) 0X2800,(byte) 0XE8C1,(byte) 0XE981,(byte) 0X2940,(byte) 0XEB01,(byte) 0X2BC0,(byte) 0X2A80,(byte) 0XEA41,
				(byte) 0XEE01,(byte) 0X2EC0,(byte) 0X2F80,(byte) 0XEF41,(byte) 0X2D00,(byte) 0XEDC1,(byte) 0XEC81,(byte) 0X2C40,
				(byte) 0XE401,(byte) 0X24C0,(byte) 0X2580,(byte) 0XE541,(byte) 0X2700,(byte) 0XE7C1,(byte) 0XE681,(byte) 0X2640,
				(byte) 0X2200,(byte) 0XE2C1,(byte) 0XE381,(byte) 0X2340,(byte) 0XE101,(byte) 0X21C0,(byte) 0X2080,(byte) 0XE041,
				(byte) 0XA001,(byte) 0X60C0,(byte) 0X6180,(byte) 0XA141,(byte) 0X6300,(byte) 0XA3C1,(byte) 0XA281,(byte) 0X6240,
				(byte) 0X6600,(byte) 0XA6C1,(byte) 0XA781,(byte) 0X6740,(byte) 0XA501,(byte) 0X65C0,(byte) 0X6480,(byte) 0XA441,
				(byte) 0X6C00,(byte) 0XACC1,(byte) 0XAD81,(byte) 0X6D40,(byte) 0XAF01,(byte) 0X6FC0,(byte) 0X6E80,(byte) 0XAE41,
				(byte) 0XAA01,(byte) 0X6AC0,(byte) 0X6B80,(byte) 0XAB41,(byte) 0X6900,(byte) 0XA9C1,(byte) 0XA881,(byte) 0X6840,
				(byte) 0X7800,(byte) 0XB8C1,(byte) 0XB981,(byte) 0X7940,(byte) 0XBB01,(byte) 0X7BC0,(byte) 0X7A80,(byte) 0XBA41,
				(byte) 0XBE01,(byte) 0X7EC0,(byte) 0X7F80,(byte) 0XBF41,(byte) 0X7D00,(byte) 0XBDC1,(byte) 0XBC81,(byte) 0X7C40,
				(byte) 0XB401,(byte) 0X74C0,(byte) 0X7580,(byte) 0XB541,(byte) 0X7700,(byte) 0XB7C1,(byte) 0XB681,(byte) 0X7640,
				(byte) 0X7200,(byte) 0XB2C1,(byte) 0XB381,(byte) 0X7340,(byte) 0XB101,(byte) 0X71C0,(byte) 0X7080,(byte) 0XB041,
				(byte) 0X5000,(byte) 0X90C1,(byte) 0X9181,(byte) 0X5140,(byte) 0X9301,(byte) 0X53C0,(byte) 0X5280,(byte) 0X9241,
				(byte) 0X9601,(byte) 0X56C0,(byte) 0X5780,(byte) 0X9741,(byte) 0X5500,(byte) 0X95C1,(byte) 0X9481,(byte) 0X5440,
				(byte) 0X9C01,(byte) 0X5CC0,(byte) 0X5D80,(byte) 0X9D41,(byte) 0X5F00,(byte) 0X9FC1,(byte) 0X9E81,(byte) 0X5E40,
				(byte) 0X5A00,(byte) 0X9AC1,(byte) 0X9B81,(byte) 0X5B40,(byte) 0X9901,(byte) 0X59C0,(byte) 0X5880,(byte) 0X9841,
				(byte) 0X8801,(byte) 0X48C0,(byte) 0X4980,(byte) 0X8941,(byte) 0X4B00,(byte) 0X8BC1,(byte) 0X8A81,(byte) 0X4A40,
				(byte) 0X4E00,(byte) 0X8EC1,(byte) 0X8F81,(byte) 0X4F40,(byte) 0X8D01,(byte) 0X4DC0,(byte) 0X4C80,(byte) 0X8C41,
				(byte) 0X4400,(byte) 0X84C1,(byte) 0X8581,(byte) 0X4540,(byte) 0X8701,(byte) 0X47C0,(byte) 0X4680,(byte) 0X8641,
				(byte) 0X8201,(byte) 0X42C0,(byte) 0X4380,(byte) 0X8341,(byte) 0X4100,(byte) 0X81C1,(byte) 0X8081,(byte) 0X4040
		};
		//    byte[] byteStr = new byte[4];
		Integer crcRes = new Crc16().calculate_crc(bytes);
//		System.out.println("!!!!!!!"+crcRes);

		//    byteStr[0] = (byte) ((crcRes & 0x000000ff));
		//    byteStr[1] = (byte) ((crcRes & 0x0000ff00) >>> 8);
	} 

	int calculate_crc(byte[] bytes) {
		int i;
		int crc_value = 0xffff;
		for (int len = 0; len < bytes.length; len++) {

			//        for (i = 0x80; i != 0; i >>= 1) {
			crc_value ^= bytes[len];
			for(i=0; i<8; i++) {
				if((crc_value & 0x0001) != 0) {
					crc_value >>=1;
					crc_value ^= 0xA001;
				}
				else
					crc_value >>=1;
			}

		}
		return crc_value;
	}

}