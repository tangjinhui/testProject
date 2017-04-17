<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
     <script type="text/javascript">
     
     </script>
      <body>
      	<input type="text" id="input" name="test" value/>
				    <center>
				       省<select id="province" >
				       <option value="0">请选择</option>
				       <option value="1">河北省</option> 
				        <option value="2">辽宁省</option> 
				     </select><br/>
				    城市<select id="city" >
				        <option value="0">请选择</option>
				     </select> <br/>
				  行政区<select id="qu">
				        <option value="0">请选择</option>
				     </select> <br/>   
				     
				    
				    </center>
				   
    <input type="checkbox" name="id" value="1" />
    <input type="checkbox" name="id" value="2"/>
    <input type="checkbox" name="id" value="3"/>
    <input type="checkbox" name="id" value="4"/>
    <input type="button" name="fuzhi" value="复制" onclick="copy()"/>
    
    </body>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js">
    
   </script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/erjiliandong.js"> </script>
    	
</html>