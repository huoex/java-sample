package hex.com.test12.IO3;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class deserial {

	public void call() {
		person p = new person();
		p.setName("zs");
		byte[] b = serialized(p);
		person p1 = (person) deserialized(b);
		System.out.println(p1);
	}

	private byte[] serialized(Object o) {
		ByteArrayOutputStream baos = null;
		ObjectOutputStream oos = null;
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(new BufferedOutputStream(baos));
//			oos = new ObjectOutputStream(baos);
			
			oos.writeObject(o);
			oos.flush();
			oos.reset();
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (null != baos) {
				try {
					baos.close();
				} catch (IOException e) {
				}
			}
			if (null != oos) {
				try {
					oos.close();
				} catch (IOException e) {
				}
			}
		}

	}

	private Object deserialized(byte[] sharedData) {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new ByteArrayInputStream(sharedData));
			return ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (null != ois) {
				try {
					ois.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
