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
	 * ��ȡ��֤����Ϣ
	 */
	public void checkCode() {
		try {
			BufferedImage buffimg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = buffimg.createGraphics();

			// ����һ��������������ࡣ
			Random random = new Random();
			g.setColor(Color.white);
			g.fillRect(0, 0, width, height);

			// �������壬����Ĵ�СӦ�ø���ͼƬ�ĸ߶�������
			Font font = new Font("times new roman", Font.PLAIN, 22);
			// �������塣
			g.setFont(font);

			// ���߿�
			g.setColor(Color.gray);
			g.drawRect(0, 0, width - 1, height - 1);

			// �������160�������ߣ�ʹͼ���е���֤�벻�ױ���������̽�⵽��
			g.setColor(Color.gray);
			for (int i = 0; i < 18; i++) {
				int x = random.nextInt(width);
				int y = random.nextInt(height);
				int xl = random.nextInt(12);
				int yl = random.nextInt(12);
				g.drawLine(x, y, x + xl, y + yl);
			}

			// randomcode���ڱ��������������֤�룬�Ա��û���¼�������֤��
			StringBuffer randomcode = new StringBuffer();
			int red = 0, green = 0, blue = 0;

			// �������4λ���ֵ���֤�롣
			for (int i = 0; i < 4; i++) {
				// �õ������������֤�����֡�
				String strrand = String.valueOf(random.nextInt(10));

				// �����������ɫ������������ɫֵ�����������ÿλ���ֵ���ɫֵ������ͬ��
				red = random.nextInt(200);
				green = random.nextInt(200);
				blue = random.nextInt(200);

				// ��������߶� 13��height֮��
				float imght = 0;
				while (imght <= 12) {
					imght = Float.parseFloat(String.valueOf(random.nextInt(height)));
				}
				// �������������ɫ����֤����Ƶ�ͼ���С�
				g.setColor(new Color(red, green, blue));
				g.drawString(strrand, 11 * i + 6, imght);

				// ���������ĸ�����������һ��
				randomcode.append(strrand);
			}
			// ����λ���ֵ���֤�뱣�浽session�С�
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("checkCode", randomcode.toString());
			// ��ֹͼ�񻺴档
			response=ServletActionContext.getResponse();
			response.setHeader("pragma", "no-cache");
			response.setHeader("cache-control", "no-cache");
			response.setDateHeader("expires", 0);
			response.setContentType("image/jpeg");

			// ��ͼ�������servlet������С�
			ServletOutputStream sos = response.getOutputStream();
			ImageIO.write(buffimg, "jpeg", sos);
			sos.close();
		} catch (Exception e) {
			this.addFieldError("ϵͳ����", "��ȡ��֤����Ϣ�쳣��");
			e.printStackTrace(System.out);
		}
	}

	/**
	 * ��¼ҳ��
	 */
	@Override
	public String index() {
		return Constants.INDEX;
	}
	
	/**
	 * ϵͳ��¼
	 * @return
	 */
	public String login() {
		return redirect("/main/index.jhtml?rnd="+Math.random());
	}
	
	public void validateLogin() {
		if (StringUtils.isEmpty(username)) {
			this.addFieldError("username", "�û�����Ϊ�գ�");
		}
		
		if (StringUtils.isEmpty(password)) {
			this.addFieldError("password", "���벻��Ϊ�գ�");
		}
		
		if(StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password)){
			MD5 md5=new MD5();
			String pwd=md5.getMD5ofStr(password);
			
			SysUserSO user=new SysUserSO();
			user.setUsername(username);
			user.setPassword(pwd);
			SysUser po=sysUserDAO.checkUser(user);
			
			if(po==null){
				this.addFieldError("username", "�û��������벻��ȷ��");
			}else{
				HttpSession session=ServletActionContext.getRequest().getSession();
				session.setAttribute(Constants.DEFAULT_USER_LOGIN, po);
			}
			
		}else{
			this.addFieldError("username", "�û�������Ϊ�գ�");
			this.addFieldError("password", "���벻��Ϊ�գ�");
		}
		this.setInputResult(Constants.INDEX);
	}
	
	/**
	 * �˳�ϵͳ
	 * @return
	 */
	public String logout() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute(Constants.DEFAULT_USER_LOGIN);
		return redirectSuccess("/login/index.jhtml?rnd="+Math.random(), "�˳��ɹ�");
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
	private int width = 66;// ��֤��ͼƬ�Ŀ�ȡ�
	private int height = 32;// ��֤��ͼƬ�ĸ߶ȡ�
	@Resource
	private SysUserDAO sysUserDAO;
	private static final long serialVersionUID = 3350921852489479314L;

}
