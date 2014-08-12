package hex.com.test12.IO1;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
/**
 * flush()
 * 一般用完IO流之后（如果你有一个好的习惯）我们都会去调用close()方法
 * @author bfs
 *
 */
public class Test {
	public static void main(String[] args) throws Exception {
		File file = new File("text.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(file);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		byte[] b = new byte[1024*2];
		bos.write(b);
		//注掉bos.flush()
		//b必须不能小于8KB，否则不写入文件
//		bos.flush();
		bos.close();
	}
}
