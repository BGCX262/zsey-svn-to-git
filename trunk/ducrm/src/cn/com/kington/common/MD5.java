package cn.com.kington.common;

public class MD5 {
	private static final byte[] PADDING = { -128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0 };
	private long[] state = new long[4];
	private long[] count = new long[2];
	private byte[] buffer = new byte[64];
	public String digestHexStr;
	private byte[] digest = new byte[16];

	public String getMD5ofStr16(String inbuf) {
		String result = getMD5ofStr(inbuf);
		if ((result != null) && (result.length() > 16)) {
			result = result.substring(8, 24);
		} else {
			result = null;
		}
		return result;
	}

	public String getMD5ofStr(String inbuf) {
		if ((inbuf == null) || (inbuf.trim().length() < 1))
			return null;

		md5Init();

		md5Update(inbuf.getBytes(), inbuf.length());

		md5Final();

		this.digestHexStr = "";

		for (int i = 0; i < 16; ++i) {
			this.digestHexStr += byteHEX(this.digest[i]);
		}

		return this.digestHexStr;
	}

	public MD5() {
		md5Init();
	}

	private void md5Init() {
		this.count[0] = 0L;

		this.count[1] = 0L;

		this.state[0] = 1732584193L;

		this.state[1] = -271733879L;

		this.state[2] = -1732584194L;

		this.state[3] = 271733878L;
	}

	private long F(long x, long y, long z) {
		return (x & y | (x ^ 0xFFFFFFFF) & z);
	}

	private long G(long x, long y, long z) {
		return (x & z | y & (z ^ 0xFFFFFFFF));
	}

	private long H(long x, long y, long z) {
		return (x ^ y ^ z);
	}

	private long I(long x, long y, long z) {
		return (y ^ (x | z ^ 0xFFFFFFFF));
	}

	private long FF(long a, long b, long c, long d, long x, long s, long ac) {
		a += F(b, c, d) + x + ac;

		a = (int) a << (int) s | (int) a >>> (int) (32L - s);

		a += b;

		return a;
	}

	private long GG(long a, long b, long c, long d, long x, long s, long ac) {
		a += G(b, c, d) + x + ac;

		a = (int) a << (int) s | (int) a >>> (int) (32L - s);

		a += b;

		return a;
	}

	private long HH(long a, long b, long c, long d, long x, long s, long ac) {
		a += H(b, c, d) + x + ac;

		a = (int) a << (int) s | (int) a >>> (int) (32L - s);

		a += b;

		return a;
	}

	private long II(long a, long b, long c, long d, long x, long s, long ac) {
		a += I(b, c, d) + x + ac;

		a = (int) a << (int) s | (int) a >>> (int) (32L - s);

		a += b;

		return a;
	}

	private void md5Update(byte[] inbuf, int inputLen) {
		int i;
		byte[] block = new byte[64];

		int index = (int) (this.count[0] >>> 3) & 0x3F;

		if ((this.count[0] += (inputLen << 3)) < (inputLen << 3)) {
			this.count[1] += 1L;
		}
		this.count[1] += (inputLen >>> 29);

		int partLen = 64 - index;

		if (inputLen >= partLen) {
			md5Memcpy(this.buffer, inbuf, index, 0, partLen);

			md5Transform(this.buffer);

			for (i = partLen; i + 63 < inputLen; i += 64) {
				md5Memcpy(block, inbuf, 0, i, 64);

				md5Transform(block);
			}

			index = 0;
		} else {
			i = 0;
		}

		md5Memcpy(this.buffer, inbuf, index, i, inputLen - i);
	}

	private void md5Final() {
		byte[] bits = new byte[8];

		Encode(bits, this.count, 8);

		int index = (int) (this.count[0] >>> 3) & 0x3F;

		int padLen = (index < 56) ? 56 - index : 120 - index;

		md5Update(PADDING, padLen);

		md5Update(bits, 8);

		Encode(this.digest, this.state, 16);
	}

	private void md5Memcpy(byte[] output, byte[] input, int outpos, int inpos,
			int len) {
		for (int i = 0; i < len; ++i) {
			output[(outpos + i)] = input[(inpos + i)];
		}
	}

	private void md5Transform(byte[] block) {
		long a = this.state[0];
		long b = this.state[1];
		long c = this.state[2];
		long d = this.state[3];

		long[] x = new long[16];

		Decode(x, block, 64);

		a = FF(a, b, c, d, x[0], 7L, -680876936L);

		d = FF(d, a, b, c, x[1], 12L, -389564586L);

		c = FF(c, d, a, b, x[2], 17L, 606105819L);

		b = FF(b, c, d, a, x[3], 22L, -1044525330L);

		a = FF(a, b, c, d, x[4], 7L, -176418897L);

		d = FF(d, a, b, c, x[5], 12L, 1200080426L);

		c = FF(c, d, a, b, x[6], 17L, -1473231341L);

		b = FF(b, c, d, a, x[7], 22L, -45705983L);

		a = FF(a, b, c, d, x[8], 7L, 1770035416L);

		d = FF(d, a, b, c, x[9], 12L, -1958414417L);

		c = FF(c, d, a, b, x[10], 17L, -42063L);

		b = FF(b, c, d, a, x[11], 22L, -1990404162L);

		a = FF(a, b, c, d, x[12], 7L, 1804603682L);

		d = FF(d, a, b, c, x[13], 12L, -40341101L);

		c = FF(c, d, a, b, x[14], 17L, -1502002290L);

		b = FF(b, c, d, a, x[15], 22L, 1236535329L);

		a = GG(a, b, c, d, x[1], 5L, -165796510L);

		d = GG(d, a, b, c, x[6], 9L, -1069501632L);

		c = GG(c, d, a, b, x[11], 14L, 643717713L);

		b = GG(b, c, d, a, x[0], 20L, -373897302L);

		a = GG(a, b, c, d, x[5], 5L, -701558691L);

		d = GG(d, a, b, c, x[10], 9L, 38016083L);

		c = GG(c, d, a, b, x[15], 14L, -660478335L);

		b = GG(b, c, d, a, x[4], 20L, -405537848L);

		a = GG(a, b, c, d, x[9], 5L, 568446438L);

		d = GG(d, a, b, c, x[14], 9L, -1019803690L);

		c = GG(c, d, a, b, x[3], 14L, -187363961L);

		b = GG(b, c, d, a, x[8], 20L, 1163531501L);

		a = GG(a, b, c, d, x[13], 5L, -1444681467L);

		d = GG(d, a, b, c, x[2], 9L, -51403784L);

		c = GG(c, d, a, b, x[7], 14L, 1735328473L);

		b = GG(b, c, d, a, x[12], 20L, -1926607734L);

		a = HH(a, b, c, d, x[5], 4L, -378558L);

		d = HH(d, a, b, c, x[8], 11L, -2022574463L);

		c = HH(c, d, a, b, x[11], 16L, 1839030562L);

		b = HH(b, c, d, a, x[14], 23L, -35309556L);

		a = HH(a, b, c, d, x[1], 4L, -1530992060L);

		d = HH(d, a, b, c, x[4], 11L, 1272893353L);

		c = HH(c, d, a, b, x[7], 16L, -155497632L);

		b = HH(b, c, d, a, x[10], 23L, -1094730640L);

		a = HH(a, b, c, d, x[13], 4L, 681279174L);

		d = HH(d, a, b, c, x[0], 11L, -358537222L);

		c = HH(c, d, a, b, x[3], 16L, -722521979L);

		b = HH(b, c, d, a, x[6], 23L, 76029189L);

		a = HH(a, b, c, d, x[9], 4L, -640364487L);

		d = HH(d, a, b, c, x[12], 11L, -421815835L);

		c = HH(c, d, a, b, x[15], 16L, 530742520L);

		b = HH(b, c, d, a, x[2], 23L, -995338651L);

		a = II(a, b, c, d, x[0], 6L, -198630844L);

		d = II(d, a, b, c, x[7], 10L, 1126891415L);

		c = II(c, d, a, b, x[14], 15L, -1416354905L);

		b = II(b, c, d, a, x[5], 21L, -57434055L);

		a = II(a, b, c, d, x[12], 6L, 1700485571L);

		d = II(d, a, b, c, x[3], 10L, -1894986606L);

		c = II(c, d, a, b, x[10], 15L, -1051523L);

		b = II(b, c, d, a, x[1], 21L, -2054922799L);

		a = II(a, b, c, d, x[8], 6L, 1873313359L);

		d = II(d, a, b, c, x[15], 10L, -30611744L);

		c = II(c, d, a, b, x[6], 15L, -1560198380L);

		b = II(b, c, d, a, x[13], 21L, 1309151649L);

		a = II(a, b, c, d, x[4], 6L, -145523070L);

		d = II(d, a, b, c, x[11], 10L, -1120210379L);

		c = II(c, d, a, b, x[2], 15L, 718787259L);

		b = II(b, c, d, a, x[9], 21L, -343485551L);

		this.state[0] += a;

		this.state[1] += b;

		this.state[2] += c;

		this.state[3] += d;
	}

	private void Encode(byte[] output, long[] input, int len) {
		int i = 0;
		for (int j = 0; j < len;) {
			output[j] = (byte) (int) (input[i] & 0xFF);

			output[(j + 1)] = (byte) (int) (input[i] >>> 8 & 0xFF);

			output[(j + 2)] = (byte) (int) (input[i] >>> 16 & 0xFF);

			output[(j + 3)] = (byte) (int) (input[i] >>> 24 & 0xFF);

			++i;
			j += 4;
		}
	}

	private void Decode(long[] output, byte[] input, int len) {
		int i = 0;
		for (int j = 0; j < len;) {
			output[i] = (b2iu(input[j]) | b2iu(input[(j + 1)]) << 8 | b2iu(input[(j + 2)]) << 16 | b2iu(input[(j + 3)]) << 24);
			++i;
			j += 4;
		}
	}

	public static long b2iu(byte b) {
		return b;
	}

	public static String byteHEX(byte ib) {
		char[] DigitNormal = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

		char[] ob = new char[2];

		ob[0] = DigitNormal[(ib >>> 4 & 0xF)];

		ob[1] = DigitNormal[(ib & 0xF)];

		String s = new String(ob);

		return s;
	}
}