package src.com.bjpowernode.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import src.com.bjpowernode.entity.Qu;


public class QuFindServlet extends HttpServlet {

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

}
