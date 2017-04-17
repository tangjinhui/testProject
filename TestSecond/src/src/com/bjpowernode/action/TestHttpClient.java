package src.com.bjpowernode.action;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import src.com.bjpowernode.entity.City;

public class TestHttpClient {
	public static void main(String[] args) {
//		for(int i=0;i<100;i++){
//			sendGet("http://www.jianshu.com/p/217a50bf87a3");
//		} 
	    List<City> attachmentList = Lists.newArrayList();
        City city1= new City();
        city1.setCid(1);
        attachmentList.add(city1);
        
        City city2= new City();
        city2.setCid(2);
        attachmentList.add(city2);
        
        City city3= new City();
        city3.setCid(3);
        attachmentList.add(city3);
        
        Map<Integer, City> map = Maps.uniqueIndex(attachmentList, new Function<City, Integer>() {
            @Override
            public Integer apply(City input) {
                return input.getCid();
            }
        });
        System.out.println("Map的值"+JSON.toJSON(map));
        
        
        
        
        
		Integer param1=2;
		Integer param =2;
		if(param1 != param){
			System.out.println("wodkidjskfljdsklf");
		}
		
		
	}
	
	public static  void sendGet(String url){  
	       String result = null;  
	       HttpClient httpClient = new DefaultHttpClient();  
	       HttpGet get = new HttpGet(url);  
	       InputStream in = null;  
		   try {
			 HttpResponse response = httpClient.execute(get);
	           HttpEntity entity = response.getEntity();  
	           if (entity != null) {  
	               entity = new BufferedHttpEntity(entity);  
	               in = entity.getContent();  
	               byte[] read = new byte[1024];  
	               byte[] all = new byte[0];  
	               int num;  
	               while ((num = in.read(read)) > 0) {  
	                   byte[] temp = new byte[all.length + num];  
	                   System.arraycopy(all, 0, temp, 0, all.length);  
	                   System.arraycopy(read, 0, temp, all.length, num);  
	                   all = temp;  
	               }  
	               result = new String(all, "UTF-8");  
	           }  
			
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  finally {  
	           if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	           get.abort();  
	       }  
	         
//	       return result;  
	   }  
	
}
