package cn.com.kington.webapp.actions;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import cn.com.kington.bean.system.SysUser;
import cn.com.kington.bean.system.SysUserSO;
import cn.com.kington.common.Constants;
import cn.com.kington.common.MD5;
import cn.com.kington.dao.system.SysUserDAO;

public class LoginAction extends BaseActionSupport {
	/**
	 * 获取验证码信息
	 */
	public void checkCode() {
		try {
			BufferedImage buffimg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = buffimg.createGraphics();

			// 创建一个随机数生成器类。
			Random random = new Random();
			g.setColor(Color.white);
			g.fillRect(0, 0, width, height);

			// 创建字体，字体的大小应该根据图片的高度来定。
			Font font = new Font("times new roman", Font.PLAIN, 22);
			// 设置字体。
			g.setFont(font);

			// 画边框。
			g.setColor(Color.gray);
			g.drawRect(0, 0, width - 1, height - 1);

			// 随机产生160条干扰线，使图象中的认证码不易被其它程序探测到。
			g.setColor(Color.gray);
			for (int i = 0; i < 18; i++) {
				int x = random.nextInt(width);
				int y = random.nextInt(height);
				int xl = random.nextInt(12);
				int yl = random.nextInt(12);
				g.drawLine(x, y, x + xl, y + yl);
			}

			// randomcode用于保存随机产生的验证码，以便用户登录后进行验证。
			StringBuffer randomcode = new StringBuffer();
			int red = 0, green = 0, blue = 0;

			// 随机产生4位数字的验证码。
			for (int i = 0; i < 4; i++) {
				// 得到随机产生的验证码数字。
				String strrand = String.valueOf(random.nextInt(10));

				// 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
				red = random.nextInt(200);
				green = random.nextInt(200);
				blue = random.nextInt(200);

				// 产生随机高度 13至height之间
				float imght = 0;
				while (imght <= 12) {
					imght = Float.parseFloat(String.valueOf(random.nextInt(height)));
				}
				// 用随机产生的颜色将验证码绘制到图像中。
				g.setColor(new Color(red, green, blue));
				g.drawString(strrand, 11 * i + 6, imght);

				// 将产生的四个随机数组合在一起。
				randomcode.append(strrand);
			}
			// 将四位数字的验证码保存到session中。
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("checkCode", randomcode.toString());
			// 禁止图像缓存。
			response=ServletActionContext.getResponse();
			response.setHeader("pragma", "no-cache");
			response.setHeader("cache-control", "no-cache");
			response.setDateHeader("expires", 0);
			response.setContentType("image/jpeg");

			// 将图像输出到servlet输出流中。
			ServletOutputStream sos = response.getOutputStream();
			ImageIO.write(buffimg, "jpeg", sos);
			sos.close();
		} catch (Exception e) {
			this.addFieldError("系统错误", "获取验证码信息异常！");
			e.printStackTrace(System.out);
		}
	}

	/**
	 * 登录页面
	 */
	@Override
	public String index() {
		return Constants.INDEX;
	}
	
	/**
	 * 系统登录
	 * @return
	 */
	public String login() {
		return redirect("/main/index.jhtml?rnd="+Math.random());
	}
	
	public void validateLogin() {
		if (StringUtils.isEmpty(username)) {
			this.addFieldError("username", "用户不能为空！");
		}
		
		if (StringUtils.isEmpty(password)) {
			this.addFieldError("password", "密码不能为空！");
		}
		
		if(StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password)){
			MD5 md5=new MD5();
			String pwd=md5.getMD5ofStr(password);
			
			SysUserSO user=new SysUserSO();
			user.setUsername(username);
			user.setPassword(pwd);
			SysUser po=sysUserDAO.checkUser(user);
			
			if(po==null){
				this.addFieldError("username", "用户名或密码不正确！");
			}else{
				HttpSession session=ServletActionContext.getRequest().getSession();
				session.setAttribute(Constants.DEFAULT_USER_LOGIN, po);
			}
			
		}else{
			this.addFieldError("username", "用户名不能为空！");
			this.addFieldError("password", "密码不能为空！");
		}
		this.setInputResult(Constants.INDEX);
	}
	
	/**
	 * 退出系统
	 * @return
	 */
	public String logout() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute(Constants.DEFAULT_USER_LOGIN);
		return redirectSuccess("/login/index.jhtml?rnd="+Math.random(), "退出成功");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	private String username;
	private String password;
	private String checkCode;
	private HttpServletResponse response;
	private HttpServletRequest request;
	private int width = 66;// 验证码图片的宽度。
	private int height = 32;// 验证码图片的高度。
	@Resource
	private SysUserDAO sysUserDAO;
	private static final long serialVersionUID = 3350921852489479314L;

}
