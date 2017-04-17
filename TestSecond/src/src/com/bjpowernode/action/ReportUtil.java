package src.com.bjpowernode.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 类ReportUtil.java的实现描述：TODO 类实现描述
 * 
 * @author tangjinhui 2017年2月8日 下午4:34:14
 */
public class ReportUtil {
	/**
	 * @author tangjinhui
	 * @param url
	 *            网址
	 * @param ecoding
	 *            编码集
	 * @return String 网页源代码 </br>
	 *         <a href="www.baidu.com" style="font-size:30px;color:red;">百度一下就知道
	 *         </a>
	 */
	public static String getHtmlResourceByUrl(String url, String ecoding) {
		//存储源代码的容器
		StringBuffer buffer = new StringBuffer();
		URL urlobj = null;
		URLConnection uc =null;
		try {
			// 建立网络连接
			 urlobj = new URL(url);
			// dakai网络连接
			 uc = urlobj.openConnection();
			//建立文件写入流
			InputStreamReader irs = new InputStreamReader(uc.getInputStream(),ecoding);
			//把文件流放到内存中，建立文件缓冲流，提交程序的执行效率
			BufferedReader br = new BufferedReader(irs);
			//建立临时文件
			String temp = null;
			while((temp = br.readLine()) !=null){
				buffer.append(temp+"\n");
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("网络不给力");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("您的网路连接打开失败，请稍后重试");
		}
		return buffer.toString();
	}
	public static void main(String[] args){
		String url = " ";
		String Encoding="utf-8";
		String htmlResourceByUrl = getHtmlResourceByUrl(url,Encoding);
		//解析html
		System.out.println(htmlResourceByUrl);
		Document document = Jsoup.parse(htmlResourceByUrl);
		Element element = document.getElementsByClass("n_main").get(0);
//		 String text = element.getElementById("price").getElementsByTag("span").text();
		 System.out.println(element);
//		for (Element ele : elementsByTag) {
//			ele
//		}
		
	}
}
