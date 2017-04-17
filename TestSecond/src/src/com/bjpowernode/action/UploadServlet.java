package src.com.bjpowernode.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import net.sf.json.JSONArray;
import src.com.bjpowernode.entity.Qu;


public class UploadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		 //0)�ֲ�����
	     String sql="select * from qu where cid=?";
	     Connection con=null;
	     PreparedStatement ps=null;
	     ResultSet rs=null;
	     List<Qu> quList= new ArrayList();
	    //1. ��á����б�š�
	    String cid = request.getParameter("cid");
	    try{
       	 Class.forName("com.mysql.jdbc.Driver");
		     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
            ps = con.prepareStatement(sql);	            
            ps.setInt(1, Integer.valueOf(cid));
            rs=ps.executeQuery();
       }catch(Exception ex){
       	ex.printStackTrace();
       }
	   try{
		   while(rs.next()){
		    	Qu qu = new Qu();
		    	qu.setQid(rs.getInt("qid"));
		    	qu.setQname(rs.getString("qname"));
		    	qu.setCid(rs.getInt("cid"));
		    	quList.add(qu);
		    }
	   }catch(Exception ex){
		   ex.printStackTrace();
	   }
	   JSONArray jsonData=JSONArray.fromObject(quList);
	   response.setCharacterEncoding("utf-8");
	   PrintWriter out=response.getWriter();
	   out.print(jsonData); 

	}
	 @SuppressWarnings("unchecked")  
	    @Override  
	    protected void service(HttpServletRequest req, HttpServletResponse resp)  
	            throws ServletException, IOException {  
	        req.setCharacterEncoding("utf-8");  
	        resp.setContentType("text/html;charset=utf-8");  
	        //为解析类提供配置信息  
	        DiskFileItemFactory factory = new DiskFileItemFactory();  
	        //创建解析类的实例  
	        ServletFileUpload sfu = new ServletFileUpload(factory);  
	        //开始解析  
	        sfu.setFileSizeMax(1024*400);  
	        //每个表单域中数据会封装到一个对应的FileItem对象上  
	        try {  
	            List<FileItem> items = sfu.parseRequest(req);  
	            //区分表单域  
	            for (int i = 0; i < items.size(); i++) {  
	                FileItem item = items.get(i);  
	                //isFormField为true，表示这不是文件上传表单域  
	                if(!item.isFormField()){ 
	                    ServletContext sctx = getServletContext();  
	                    //获得存放文件的物理路径  
	                    //upload下的某个文件夹   得到当前在线的用户  找到对应的文件夹  
	                    String contextPath = sctx.getContextPath();
	                    System.out.println(contextPath);
	                    String path = sctx.getRealPath("/upload");  
	                    System.out.println(path);  
	                    //获得文件名  
	                    String fileName = item.getName();  
	                    System.out.println(fileName);  
	                    //该方法在某些平台(操作系统),会返回路径+文件名  
	                    fileName = fileName.substring(fileName.lastIndexOf("/")+1);  
	                    File file = new File(path+"\\"+fileName);  
	                    if(!file.exists()){  
	                        item.write(file);  
	                        //将上传图片的名字记录到数据库中  
	                        resp.sendRedirect("ok.html");  
	                    }  
	                }  
	            }  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	          
	    }  
	 
}
