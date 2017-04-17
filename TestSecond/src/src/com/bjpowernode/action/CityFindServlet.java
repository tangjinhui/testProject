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
import src.com.bjpowernode.entity.City;

public class CityFindServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = "select * from city where pid=?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<City> cityList = new ArrayList<City>();
		String pid = request.getParameter("pid");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			ps = con.prepareStatement(sql);
			ps.setInt(1, Integer.valueOf(pid));
			rs = ps.executeQuery();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			while (rs.next()) {
				City city = new City();
				city.setCid(rs.getInt("cid"));
				city.setCname(rs.getString("cname"));
				city.setPid(rs.getInt("pid"));
				cityList.add(city);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		JSONArray jsonData = JSONArray.fromObject(cityList);
		response.setCharacterEncoding("utf-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "*");
		response.addHeader("Access-Control-Allow-Headers", "*");
		PrintWriter out = response.getWriter();
		out.print(jsonData);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println(request.getParameter("name"));
	}
}
