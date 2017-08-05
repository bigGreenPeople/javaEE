package com.dom4j;

import java.io.FileOutputStream;
import java.util.*;

import org.dom4j.*;
import org.dom4j.io.*;

public class Dom4j_1 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
//		得到解析器
		SAXReader sr=new SAXReader();
//		指定解析哪个XML文件
		Document doc=sr.read("src/MyXml.xml");
		
		//list(doc.getRootElement());
		add(doc.getRootElement());
		//del(doc.getRootElement());
		//upd(doc);
	}
	
	//修改元素
	public static void upd(Document doc) throws Exception
	{
		List<Element> stus=(List)doc.getRootElement().elements("学生");
		
		for(Element stu:stus)
		{
			Element stu_age=stu.element("年龄");
			int age=Integer.parseInt((stu_age.getTextTrim()))+3;
			stu_age.setText(age+"");
		}
		format(doc.getRootElement());
	}
	
	//删除一个元素
	public static void del(Element doc) throws Exception
	{
		//得到第一个学生
		Element stu=doc.element("学生");
		//从根节点去删除他或者属性
		stu.remove(stu.attribute("sex"));
		format(doc);
	}
	
	//添加元素
	public static void add(Element doc) throws Exception
	{
		Element stu=DocumentHelper.createElement("学生");
		//添加一个属性
		stu.addAttribute("sex", "男");
		Element stu_name=DocumentHelper.createElement("姓名");
		stu_name.setText("傅杰");
		Element stu_age=DocumentHelper.createElement("年龄");
		stu_age.setText("18");
		Element stu_intro=DocumentHelper.createElement("介绍");
		stu_intro.setText("学生");
		//将所有的子节点添加到学生节点中
		stu.add(stu_name);
		stu.add(stu_age);
		stu.add(stu_intro);
		//将学生节点添加到根节点中
		//doc.add(stu);
//		将节点添加到指定的位置
		List li = doc.elements();
		li.add(2,stu);
		
		format(doc);
		
	}
	
	public static void format(Element doc) throws Exception
	{
		//得到一个有着好看格式的指定编码对象
		OutputFormat output=OutputFormat.createPrettyPrint();
		output.setEncoding("utf-8");
		//将内存树写入到XML文件中(注意要将编码模式设置成UTF-8)
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/MyXml.xml"),output);
		//将dom树写入到文件中
		writer.write(doc);
		//释放文件
		writer.close();
	}

	//遍历我们的文档
	public static void list(Element doc)
	{
		System.out.println(doc.getName()+"\t"+doc.getTextTrim()+"\t属性:"+doc.attributeValue("sex"));
//		得到文档的迭代器
		Iterator<Element> it=doc.elementIterator();
		
		while(it.hasNext())
		{
			Element e=(Element)it.next();
			list(e);
			
		}
	}
}
