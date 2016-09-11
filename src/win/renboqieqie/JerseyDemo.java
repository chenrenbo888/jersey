package win.renboqieqie;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * 发送图片到另外一台tomcat服务器得到
 * @author Administrator
 *
 */
public class JerseyDemo {


	public static void main(String[] args) throws IOException {
		//实例化一个jersey
		Client client = new Client();
		//另一台服务器的路径
		String url = "http://localhost:8088/image-web/upload/qqqqq.jpg";
		//设置请求的路径
		WebResource resource = client.resource(url);
		//读取本地图片为流或二进制
		String path = "F:\\mypicture\\intro-bg.jpg";
		byte[] readFileToByteArray = FileUtils.readFileToByteArray(new File(path));
		 //发送请求
		resource.put(String.class,readFileToByteArray);
	}
}
