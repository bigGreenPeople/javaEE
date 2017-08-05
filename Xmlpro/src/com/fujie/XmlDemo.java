package com.fujie;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;


//本程序完成对xml文件的crud操作
public class XmlDemo {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//DocumentBuilderFactory.newInstance()方法获得DOM解析工厂
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		//通过dom工厂的newDocumentBuilder()方法得到Dom解析器
		DocumentBuilder dbu=dbf.newDocumentBuilder();
//		指定解析那个xml文件
		Document document=dbu.parse("src/MyXml.xml");
		
		//list(document);
		//read(document);
		//add(document);
		//del(document);
		upd(document);
	}
	
	//修改节点
	public static void upd(Document doc) throws Exception
	{
		//得到第一个学生
		Element stu = (Element)doc.getElementsByTagName("学生").item(0);
		//得到学生的第一个姓名(程序不知道学生有几个姓名)
		Node stu_name=stu.getElementsByTagName("姓名").item(0);
		//设置姓名中的内容
		stu_name.setTextContent("傅杰");
		
		trans(doc);
	}
	
	//删除结点
	public static void del(Document doc) throws Exception
	{
//		//找到第一个学生 
//		Node node=doc.getElementsByTagName("学生").item(0);
//		//父节点去删除子节点
//		node.getParentNode().removeChild(node);
		
//		删除属性
		Element node = (Element)doc.getElementsByTagName("学生").item(0);
		node.removeAttribute("sex");
		trans(doc);
	}
	//添加节点
	public static void add(Document doc) throws Exception
	{
		//创建一个新的学生节点
		Element stu=doc.createElement("学生");
		Element stu_name=doc.createElement("姓名");
		stu_name.setTextContent("付杰");
		Element stu_age=doc.createElement("年龄");
		stu_age.setTextContent("20");
		Element stu_intro=doc.createElement("介绍");
		stu_intro.setTextContent("非常优秀");
		
//		添加到学生
		stu.appendChild(stu_name);
		stu.appendChild(stu_age);
		stu.appendChild(stu_intro);
		//在新建的学生节点中加入内容
		
		//将节点添加到doc中
		doc.getDocumentElement().appendChild(stu);
		
		trans(doc);
	}
	
	//更新xml文件函数
	public static void trans(Document doc) throws Exception
	{
		//得到TransformerFactory
		TransformerFactory tff=TransformerFactory.newInstance();
		//通过tff得到一个转换器
		Transformer tf=tff.newTransformer();
		//更新文件
		tf.transform(new DOMSource(doc),new StreamResult("src/MyXml.xml"));
	}
	//遍历document
	public static void list(Node node)
	{
		//在控制台打印出节点的名字
		if(node.getNodeType()==Node.ELEMENT_NODE)
		{
			System.out.println(node.getNodeName());
		}
		//取出子节点
		NodeList nl = node.getChildNodes();
		//递归下去遍历到所有的节点 
		for(int i=0;i<nl.getLength();i++)
		{
			Node n=nl.item(i);
			list(n);
		}
		
	}
	//具体查询某个学生的信息 
	public static void read(Document doc)
	{
//		得到学生的集合
		NodeList nl = doc.getElementsByTagName("学生");
		//得到第一个学生
		Element stu=(Element)nl.item(0);
		System.out.println(stu.getAttribute("sex"));
//		得到名字
		Element name=(Element)stu.getElementsByTagName("姓名").item(0);
		System.out.println(name.getTextContent());
	}
}
