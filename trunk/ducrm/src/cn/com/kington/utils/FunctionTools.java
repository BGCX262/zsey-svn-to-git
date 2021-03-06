package cn.com.kington.utils;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class FunctionTools {
	public static void showMsgAndOutFrame(HttpServletResponse response, String message, String url) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			//��Ҫ����������ٻ��� 
			response.setHeader("Cache-Control","no-cache"); 
			response.setHeader("Cache-Control","no-store"); 
			//������������ 
			response.setDateHeader("Expires",0); 
			//��Ҫ������仺����� 
			response.setHeader("Pragma","no-cache"); 
			out.println("<script type=\"text/javascript\" language=\"javascript\">alert(\"" + message + "\");window.location.href=\"" + url + "\";</script>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
				out.flush();
			}
		}
	}
	
	/**
	 * ִ��JS�ű����
	 * @param response
	 * @param js
	 */
	public static void executeJavascript(HttpServletResponse response, String js) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			//��Ҫ����������ٻ��� 
			response.setHeader("Cache-Control","no-cache"); 
			response.setHeader("Cache-Control","no-store"); 
			//������������ 
			response.setDateHeader("Expires",0); 
			//��Ҫ������仺����� 
			response.setHeader("Pragma","no-cache"); 
			out.println("<script type=\"text/javascript\" language=\"javascript\">"+js+"</script>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
				out.flush();
			}
		}
	}
	
	/**
	 * ִ��JS�ű����
	 * @param response
	 * @param js
	 */
	public static void writeText(HttpServletResponse response, String js) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			//��Ҫ����������ٻ��� 
			response.setHeader("Cache-Control","no-cache"); 
			response.setHeader("Cache-Control","no-store"); 
			//������������ 
			response.setDateHeader("Expires",0); 
			//��Ҫ������仺����� 
			response.setHeader("Pragma","no-cache"); 
			out.println(js);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
				out.flush();
			}
		}
	}
}
