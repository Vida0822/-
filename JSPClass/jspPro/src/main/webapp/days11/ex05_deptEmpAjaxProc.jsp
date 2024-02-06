<%@page import="com.util.JdbcUtil"%>
<%@page import="com.util.ConnectionProvider"%>
<%@page import="net.sf.json.JSONSerializer"%>
<%@page import="java.sql.Date"%>
<%@page import="net.sf.json.JSONArray"%>
<%@page import="net.sf.json.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    // https://json-lib.sourceforge.net/index.html
    
    // java.lang.ClassNotFoundException: org.apache.commons.lang.exception.NestableRuntimeException
    
    
   int pdeptno = 10;
   try{
       pdeptno =  Integer.parseInt( request.getParameter("deptno") );
   }catch(NumberFormatException e){  }
   
   //
   Connection con = null;
   PreparedStatement pstmt = null;
   ResultSet rs = null;
   
   String sql = "select empno, ename, sal, job, hiredate, mgr, comm, deptno " 
               + " from emp "
               + " where deptno = ? "
              + " order by sal desc";
    
   // JSON이라는 데이터로 결과를 생성해 응답하려한다 (응답데이터 : ArrayList -> Json 객체)
   // {속성명: "속성값"} 
   JSONObject jsonData = new JSONObject(); // 이 페이지 응답데이터를 이걸로 할거임 ! 
	
   try{      
      con = ConnectionProvider.getConnection();
      pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, pdeptno); //10,20
      rs = pstmt.executeQuery(); 
       
       // 하나의 사원정보 => [  {} {} {}  ]
    	JSONArray jsonEmpArray = new JSONArray();  // []  : json객체(사원)을 담는 배열 
    	JSONObject jsonEmp = new JSONObject(); // json 객체 (사원객체)
    	
      	while( rs.next() ){ 
	         int empno = rs.getInt("empno");
	         String ename = rs.getString("ename");         
	         String job = rs.getString("job");
	         Date hiredate = rs.getDate("hiredate");
	         int mgr = rs.getInt("mgr");
	         double sal = rs.getDouble("sal");  
	         double comm = rs.getDouble("comm");
	         int deptno = rs.getInt("deptno");
	          
		      jsonEmp.put("empno", empno);
		      jsonEmp.put("ename", ename);
		      jsonEmp.put("job", job);
		      
		      // 엥 이거 추가하니까 오류 - net.sf.json.JSONException: java.lang.reflect.InvocationTargetException
		      // json 자료형은 String,name,true|false, null, function, array, object 밖에 없음 <-> Date 자료형은 없음
		      // ; java -> json 변환시 java.util.Date 는 변환이 안된다
		      jsonEmp.put("hiredate", hiredate.toLocaleString());
		      jsonEmp.put("mgr", mgr);
		      jsonEmp.put("sal", sal);
		      jsonEmp.put("comm", comm);
		      jsonEmp.put("deptno", deptno);
		      
		      jsonEmpArray.add(jsonEmp);
	      } // while 
	      jsonData.put("emp", jsonEmpArray);
	   }catch(Exception e){
	      e.printStackTrace();
	   }finally{
	      JdbcUtil.close(rs);
	      JdbcUtil.close(pstmt);
	      JdbcUtil.close(con);
	   } // try  
%>
<%=  jsonData %>