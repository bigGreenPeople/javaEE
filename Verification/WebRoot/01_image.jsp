<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="image/jpeg"  import="java.awt.*,java.awt.image.*,java.util.*,javax.imageio.*" %>
<%!
	public Color getColor(){
		Random random = new Random();
		int r = random.nextInt(256);//0-255
		int g = random.nextInt(256);
		int b = random.nextInt(256);
		return new Color(r,g,b);
	}
	public String getNum(){
		String str = "";
		Random random = new Random();
		for(int i=0;i<4;i++){
			str += random.nextInt(10);//0-9
		}
		return str;
	}
%>
<%
	response.setHeader("pragma", "mo-cache");
	response.setHeader("cache-control", "no-cache");
	response.setDateHeader("expires", 0);
	
	BufferedImage image = new BufferedImage(80,30,BufferedImage.TYPE_INT_RGB);
	
	Graphics g = image.getGraphics();
	g.setColor(new Color(200,200,200));
	g.fillRect(0,0,80,30);
	
	
	for (int i = 0; i < 30; i++) {
		Random random = new Random();
		int x = random.nextInt(80);
		int y = random.nextInt(30);
		int xl = random.nextInt(x+10);
		int yl = random.nextInt(y+10);
		g.setColor(getColor());
		g.drawLine(x, y, x + xl, y + yl);
	}
	
	
	g.setFont(new Font("serif", Font.BOLD,16));
	g.setColor(Color.BLACK);
	String checkNum = getNum();//"2525"
	
	StringBuffer sb = new StringBuffer();
	for(int i=0;i<checkNum.length();i++){
		sb.append(checkNum.charAt(i)+" ");//"2 5 2 5"
	}
	g.drawString(sb.toString(),15,20);
	
	session.setAttribute("CHECKNUM",checkNum);//2525
	
	ImageIO.write(image,"jpeg",response.getOutputStream());
	out.clear();
	out = pageContext.pushBody();
%>


