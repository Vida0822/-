/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.89
 * Generated at: 2023-06-17 15:19:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/WEB-INF/tags/notLogin.tag", Long.valueOf(1685061372149L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1684308834400L));
    _jspx_dependants.put("/WEB-INF/tags/isLogin.tag", Long.valueOf(1685064432945L));
    _jspx_dependants.put("jar:file:/D:/Class/WorkSpace/JSPClass/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/tumblbug/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems_005fend;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems_005fend = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems_005fend.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");

String contextPath = request.getContextPath();

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<script\r\n");
      out.write("	src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js\"></script>\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\"\r\n");
      out.write("	rel=\"stylesheet\">\r\n");
      out.write("<link href=\"style.css\" rel=\"stylesheet\">\r\n");
      out.write("<script\r\n");
      out.write("	src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(contextPath);
      out.write("/static/css/style.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(contextPath);
      out.write("/static/css/list.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<div class=\"style__ProjectEditorButton-zxsodr-5 cfcgIZ\">프로젝트 올리기</div>\r\n");
      out.write("	<script>\r\n");
      out.write("		$(\".style__ProjectEditorButton-zxsodr-5\")\r\n");
      out.write("				.on(\r\n");
      out.write("						\"click\",\r\n");
      out.write("						function() {\r\n");
      out.write("							location.href = \"http://localhost/tumblbug/publicWeb/projectStart.jsp\";\r\n");
      out.write("						});\r\n");
      out.write("	</script>\r\n");
      out.write("\r\n");
      out.write("	");
      if (_jspx_meth_u_005fnotLogin_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      out.write('	');
      if (_jspx_meth_u_005fisLogin_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("	<script>\r\n");
      out.write("		document.getElementById('loginButton').addEventListener('click',\r\n");
      out.write("				function() {\r\n");
      out.write("					window.location.href = '/tumblbug/login.do';\r\n");
      out.write("				});\r\n");
      out.write("	</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<div class=\"style__CategoryWrapper-zxsodr-18 ehJwom effect_hover\">홈</div>\r\n");
      out.write("	<!-- searchCondition = 0(default) -->\r\n");
      out.write("	<div class=\"style__CategoryWrapper-zxsodr-18 ehJwom effect_hover\">인기</div>\r\n");
      out.write("	<!-- searchCondition = 5 -->\r\n");
      out.write("	<div class=\"style__CategoryWrapper-zxsodr-18 ehJwom effect_hover\">신규</div>\r\n");
      out.write("	<!-- searchCondition = 6 -->\r\n");
      out.write("	<div class=\"style__CategoryWrapper-zxsodr-18 ehJwom effect_hover\">마감임박</div>\r\n");
      out.write("	<!-- searchCondition = 6 -->\r\n");
      out.write("	<div class=\"style__CategoryWrapper-zxsodr-18 ehJwom effect_hover\">공개예정</div>\r\n");
      out.write("	<!-- searchCondition = 3 -->\r\n");
      out.write("	<div class=\"style__CategoryWrapper-zxsodr-18 ehJwom steadio_hover\">스테디오</div>\r\n");
      out.write("	<!-- 링크 -->\r\n");
      out.write("\r\n");
      out.write("	<script>\r\n");
      out.write("		$(\".ehJwom\")\r\n");
      out.write("				.on(\r\n");
      out.write("						\"click\",\r\n");
      out.write("						function(event) {\r\n");
      out.write("							var searchCondition;\r\n");
      out.write("							var searchWord;\r\n");
      out.write("\r\n");
      out.write("							// 클릭한 요소에 따라 searchCondition과 searchWord 설정\r\n");
      out.write("							if ($(this).text() === \"홈\") {\r\n");
      out.write("								searchCondition = 0;\r\n");
      out.write("							} else if ($(this).text() === \"인기\") {\r\n");
      out.write("								searchCondition = 3;\r\n");
      out.write("							} else if ($(this).text() === \"신규\") {\r\n");
      out.write("								searchCondition = 4;\r\n");
      out.write("								searchWord = \"new\";\r\n");
      out.write("							} else if ($(this).text() === \"마감임박\") {\r\n");
      out.write("								searchCondition = 4;\r\n");
      out.write("								searchWord = \"end\";\r\n");
      out.write("							} else if ($(this).text() === \"공개예정\") {\r\n");
      out.write("								searchCondition = 5;\r\n");
      out.write("								searchWord = \"공개예정\";\r\n");
      out.write("							}\r\n");
      out.write("\r\n");
      out.write("							// 스테디오인 경우 외부 링크로 이동\r\n");
      out.write("							if ($(this).hasClass(\"steadio_hover\")) {\r\n");
      out.write("								location.href = \"https://steadio.co/?utm_source=tumblbug&utm_medium=gnb&utm_campaign=ver1\";\r\n");
      out.write("							} else {\r\n");
      out.write("								// 다른 요소들은 내부 페이지로 이동\r\n");
      out.write("								/*	location.href = \"/tumblbug/listProject.do?searchCondition=\"\r\n");
      out.write("											+ searchCondition\r\n");
      out.write("											+ \"&searchWord=\"\r\n");
      out.write("											+ searchWord;*/\r\n");
      out.write("								pageGoPost({\r\n");
      out.write("									url : \"/tumblbug/listProject.do\", //이동할 페이지\r\n");
      out.write("									target : \"_self\",\r\n");
      out.write("									vals : [ //전달할 인수들\r\n");
      out.write("									[ \"searchCondition\", searchCondition ],\r\n");
      out.write("											[ \"searchWord\", searchWord ] ]\r\n");
      out.write("								}); // pageGoPost\r\n");
      out.write("							} // else \r\n");
      out.write("						}); // click\r\n");
      out.write("\r\n");
      out.write("		function pageGoPost(d) {\r\n");
      out.write("			var insdoc = \"\";\r\n");
      out.write("\r\n");
      out.write("			for (var i = 0; i < d.vals.length; i++) {\r\n");
      out.write("				insdoc += \"<input type='hidden' name='\"+ d.vals[i][0] +\"' value='\"+ d.vals[i][1] +\"'>\";\r\n");
      out.write("			}\r\n");
      out.write("\r\n");
      out.write("			var goform = $(\"<form>\", {\r\n");
      out.write("				method : \"post\",\r\n");
      out.write("				action : d.url,\r\n");
      out.write("				target : d.target,\r\n");
      out.write("				html : insdoc\r\n");
      out.write("			}).appendTo(\"body\");\r\n");
      out.write("\r\n");
      out.write("			goform.submit();\r\n");
      out.write("		} // pageGoPost\r\n");
      out.write("	</script>\r\n");
      out.write("\r\n");
      out.write("	<!--  검색  -->\r\n");
      out.write("	<input placeholder=\"검색어를 입력해주세요.\"\r\n");
      out.write("		class=\"style__SearchInput-zxsodr-16 jPMsmJ\">\r\n");
      out.write("	<script>\r\n");
      out.write("		$(\"input.jPMsmJ\").on(\r\n");
      out.write("				\"keydown\",\r\n");
      out.write("				function() {\r\n");
      out.write("					if (event.which == 13) {\r\n");
      out.write("						pageGoPost({\r\n");
      out.write("							url : \"/tumblbug/listProject.do\", //이동할 페이지\r\n");
      out.write("							target : \"_self\",\r\n");
      out.write("							vals : [ //전달할 인수들\r\n");
      out.write("							[ \"searchCondition\", 6 ],\r\n");
      out.write("									[ \"searchWord\", $(this).text() ] ]\r\n");
      out.write("						}); // pageGoPost\r\n");
      out.write("					} //if\r\n");
      out.write("				}); // keydown\r\n");
      out.write("	</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<div>\r\n");
      out.write("		<div class=\"style__Depth1CategoryText-zxsodr-27 dQhnSR\">푸드</div>\r\n");
      out.write("		<div class=\"style__Depth1CategoryText-zxsodr-27 dQhnSR\">향수 · 뷰티</div>\r\n");
      out.write("		<div class=\"style__Depth1CategoryText-zxsodr-27 dQhnSR\">의류</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	<div>\r\n");
      out.write("		<div class=\"style__Depth1CategoryText-zxsodr-27 dQhnSR\">반려동물</div>\r\n");
      out.write("		<div class=\"style__Depth1CategoryText-zxsodr-27 dQhnSR\">푸드</div>\r\n");
      out.write("		<div class=\"style__Depth1CategoryText-zxsodr-27 dQhnSR\">디지털게임</div>\r\n");
      out.write("		<div class=\"style__Depth1CategoryText-zxsodr-27 dQhnSR\">출판</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	<div>\r\n");
      out.write("		<div class=\"style__Depth1CategoryText-zxsodr-27 dQhnSR\">디자인</div>\r\n");
      out.write("		<div class=\"style__Depth1CategoryText-zxsodr-27 dQhnSR\">예술</div>\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("	<script>\r\n");
      out.write("					$(\"div.style__Depth1CategoryText-zxsodr-27.dQhnSR\").on(\r\n");
      out.write("							\"click\",\r\n");
      out.write("							function(event) {\r\n");
      out.write("								//      location.href = \"/tumblbug/listProject.do?searchCondition=1&searchWord=\"+ $(this).text();\r\n");
      out.write("								pageGoPost({\r\n");
      out.write("									url : \"/tumblbug/listProject.do\", //이동할 페이지\r\n");
      out.write("									target : \"_self\",\r\n");
      out.write("									vals : [ //전달할 인수들\r\n");
      out.write("									[ \"searchCondition\", 1 ],\r\n");
      out.write("											[ \"searchWord\", $(this).text() ] ]\r\n");
      out.write("								}); // pageGoPost\r\n");
      out.write("							}); // click   \r\n");
      out.write("	</script>\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	<!--  배너  -->\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	<div\r\n");
      out.write("		class=\"FrontProjectsSection__Wrapper-sc-1na1z58-1 kLmlvM tbb FrontPage__SpotlightContainer-sc-1ev69zc-10 goYsGO\">\r\n");
      out.write("		<div class=\"FrontProjectsSection__ListTitle-sc-1na1z58-4 gRQZNs\">신규 프로젝트 (수정전:주목할 만한 프로젝트)</div>\r\n");
      out.write("		<div\r\n");
      out.write("			class=\"ProjectListWithCard__ListWrapper-sc-80ruv-3 izZdZi FrontProjectsSection__StyledProjectListWithCard-sc-1na1z58-5 cbDFbB\">\r\n");
      out.write("			<div\r\n");
      out.write("				class=\"FrontProjectsSection__WrapperComponent-sc-1na1z58-0 gArLlO ProjectListWithCard__StyledWrapperComponent-sc-80ruv-0 hpdqas\">\r\n");
      out.write("				<!-- 신규 프로젝트 (ajax처리해줘야함) -->\r\n");
      out.write("				");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("				");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	\r\n");
      out.write("	<script>\r\n");
      out.write("		$(\"div.info-wrapper dl dd span a\").on(\"click\", function(event) {\r\n");
      out.write("			//      location.href = \"/tumblbug/listProject.do?searchCondition=1&searchWord=\"+ $(this).text();\r\n");
      out.write("			pageGoPost({\r\n");
      out.write("				url : \"/tumblbug/listProject.do\", //이동할 페이지\r\n");
      out.write("				target : \"_self\",\r\n");
      out.write("				vals : [ //전달할 인수들\r\n");
      out.write("				[ \"searchCondition\", 2 ], [ \"searchWord\", $(this).text() ] ]\r\n");
      out.write("			}); // pageGoPost\r\n");
      out.write("		}); // click\r\n");
      out.write("	</script>\r\n");
      out.write("\r\n");
      out.write("	<!-- 인기 프로젝트  -->\r\n");
      out.write("	<div class=\"FrontPage__StyledPopularProjectsSection-sc-1ev69zc-1 ccGCBK\">\r\n");
      out.write("	\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("	<!--  마감임박 : ajax 처리 같이 -->\r\n");
      out.write("	<div class=\"Container__ContainerComponent-sc-1ey2h1l-0 kUAclQ FrontPageContentSection__StyledContainer-nkpafk-3 kfWoez has-bg\">\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_u_005fnotLogin_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  u:notLogin
    org.apache.jsp.tag.web.notLogin_tag _jspx_th_u_005fnotLogin_005f0 = new org.apache.jsp.tag.web.notLogin_tag();
    _jsp_getInstanceManager().newInstance(_jspx_th_u_005fnotLogin_005f0);
    try {
      _jspx_th_u_005fnotLogin_005f0.setJspContext(_jspx_page_context);
      _jspx_th_u_005fnotLogin_005f0.setJspBody(new Helper( 0, _jspx_page_context, _jspx_th_u_005fnotLogin_005f0, null));
      _jspx_th_u_005fnotLogin_005f0.doTag();
    } finally {
      _jsp_getInstanceManager().destroyInstance(_jspx_th_u_005fnotLogin_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_u_005fisLogin_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  u:isLogin
    org.apache.jsp.tag.web.isLogin_tag _jspx_th_u_005fisLogin_005f0 = new org.apache.jsp.tag.web.isLogin_tag();
    _jsp_getInstanceManager().newInstance(_jspx_th_u_005fisLogin_005f0);
    try {
      _jspx_th_u_005fisLogin_005f0.setJspContext(_jspx_page_context);
      _jspx_th_u_005fisLogin_005f0.setJspBody(new Helper( 1, _jspx_page_context, _jspx_th_u_005fisLogin_005f0, null));
      _jspx_th_u_005fisLogin_005f0.doTag();
    } finally {
      _jsp_getInstanceManager().destroyInstance(_jspx_th_u_005fisLogin_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /WEB-INF/view/list.jsp(191,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!errors.nonewCardList}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("					");
          if (_jspx_meth_c_005fforEach_005f0(_jspx_th_c_005fif_005f0, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("				");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems_005fend.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f0);
      // /WEB-INF/view/list.jsp(192,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("projectCard");
      // /WEB-INF/view/list.jsp(192,5) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/view/list.jsp(192,5) '${newCardList}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${newCardList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      // /WEB-INF/view/list.jsp(192,5) name = end type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setEnd(7);
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("						<div class=\"card-wrapper\">\r\n");
            out.write("							<div\r\n");
            out.write("								class=\"ProjectCardOnlyPercentage__Wrapper-sc-1qqprx-8 jctwLa\">\r\n");
            out.write("								<div\r\n");
            out.write("									class=\"ProjectCardOnlyPercentage__Card-sc-1qqprx-7 hVNfHN link-wrapper\">\r\n");
            out.write("									<div class=\"image-wrapper\">\r\n");
            out.write("										<!--  이미지  -->\r\n");
            out.write("									<!-- 	<a style=\"background-image:  -->\r\n");
            out.write("										<a \r\n");
            out.write("											href=\"/tumblbug/view.do?pro_cd=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${projectCard.project.pro_cd}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write('"');
            out.write('>');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${projectCard.file.af_cd}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</a>\r\n");
            out.write("										\r\n");
            out.write("\r\n");
            out.write("										<!--  좋아요  -->\r\n");
            out.write("										<div\r\n");
            out.write("											class=\"LikeButton__Wrapper-whittq-0 kiaOkh ProjectCardOnlyPercentage__StyledLikeButton-sc-1qqprx-9 iUMvsh\">\r\n");
            out.write("											<button type=\"button\">\r\n");
            out.write("												<span>좋아요</span>\r\n");
            out.write("											</button>\r\n");
            out.write("											\r\n");
            out.write("										</div>\r\n");
            out.write("									</div>\r\n");
            out.write("									<div class=\"info-wrapper\">\r\n");
            out.write("										<dl>\r\n");
            out.write("											<dd class=\"project-sub-info\">\r\n");
            out.write("												<!--  세부 카테고리 링크 -->\r\n");
            out.write("												<span> <a>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${projectCard.detailCategory.dtl_ctg_name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</a></span>\r\n");
            out.write("												<!-- 창작자 이름  -->\r\n");
            out.write("												<span> <a href=\"/창작자조회.do?");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${projectCard.member.m_cd}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write('"');
            out.write('>');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${projectCard.member.m_name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</a></span>\r\n");
            out.write("											</dd>\r\n");
            out.write("											<dt>\r\n");
            out.write("												<!--  프로젝트 제목 -->\r\n");
            out.write("												<a\r\n");
            out.write("													href=\"/tumblbug/view.do?pro_cd=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${projectCard.project.pro_cd}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\">\r\n");
            out.write("													<strong>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${projectCard.project.pro_long}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</strong>\r\n");
            out.write("												</a>\r\n");
            out.write("											</dt>\r\n");
            out.write("										</dl>\r\n");
            out.write("										<!--  달성률  -->\r\n");
            out.write("										<div class=\"funding-status\">\r\n");
            out.write("											<span class=\"percentage\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${projectCard.ach_rate}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("% 달성</span>\r\n");
            out.write("										</div>\r\n");
            out.write("										<!-- 남은기간 -->\r\n");
            out.write("										<div class=\"funding-status\">\r\n");
            out.write("											<span class=\"percentage\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${projectCard.paySum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("총결제예정금액</span>\r\n");
            out.write("											<span class=\"percentage\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${projectCard.left_days}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("남은기간</span>\r\n");
            out.write("										</div>\r\n");
            out.write("									</div>\r\n");
            out.write("								</div>\r\n");
            out.write("							</div>\r\n");
            out.write("						</div>\r\n");
            out.write("					");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems_005fend.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f1_reused = false;
    try {
      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f1.setParent(null);
      // /WEB-INF/view/list.jsp(245,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${errors.nonewCardList}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("					<h3>해당 조건으로 존재하는 프로젝트가 없습니다</h3>\r\n");
          out.write("				");
          int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      _jspx_th_c_005fif_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f1_reused);
    }
    return false;
  }

  private class Helper
      extends org.apache.jasper.runtime.JspFragmentHelper
  {
    private javax.servlet.jsp.tagext.JspTag _jspx_parent;
    private int[] _jspx_push_body_count;

    public Helper( int discriminator, javax.servlet.jsp.JspContext jspContext, javax.servlet.jsp.tagext.JspTag _jspx_parent, int[] _jspx_push_body_count ) {
      super( discriminator, jspContext, _jspx_parent );
      this._jspx_parent = _jspx_parent;
      this._jspx_push_body_count = _jspx_push_body_count;
    }
    public boolean invoke0( javax.servlet.jsp.JspWriter out ) 
      throws java.lang.Throwable
    {
      out.write("\r\n");
      out.write("		<div class=\"style__UserText-zxsodr-11 fXtfpK\" id=\"loginButton\">로그인/회원가입</div>\r\n");
      out.write("	");
      return false;
    }
    public boolean invoke1( javax.servlet.jsp.JspWriter out ) 
      throws java.lang.Throwable
    {
      out.write("\r\n");
      out.write("		<a href=\"/tumblbug/logout.do\">[로그아웃하기]</a>\r\n");
      out.write("	");
      return false;
    }
    public void invoke( java.io.Writer writer )
      throws javax.servlet.jsp.JspException
    {
      javax.servlet.jsp.JspWriter out = null;
      if( writer != null ) {
        out = this.jspContext.pushBody(writer);
      } else {
        out = this.jspContext.getOut();
      }
      try {
        Object _jspx_saved_JspContext = this.jspContext.getELContext().getContext(javax.servlet.jsp.JspContext.class);
        this.jspContext.getELContext().putContext(javax.servlet.jsp.JspContext.class,this.jspContext);
        switch( this.discriminator ) {
          case 0:
            invoke0( out );
            break;
          case 1:
            invoke1( out );
            break;
        }
        jspContext.getELContext().putContext(javax.servlet.jsp.JspContext.class,_jspx_saved_JspContext);
      }
      catch( java.lang.Throwable e ) {
        if (e instanceof javax.servlet.jsp.SkipPageException)
            throw (javax.servlet.jsp.SkipPageException) e;
        throw new javax.servlet.jsp.JspException( e );
      }
      finally {
        if( writer != null ) {
          this.jspContext.popBody();
        }
      }
    }
  }
}