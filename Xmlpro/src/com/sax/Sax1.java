package com.sax;

import javax.xml.parsers.*;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Sax1 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
//		创建SAXParserFactory工厂
		SAXParserFactory spf=SAXParserFactory.newInstance();
//		使用SAXParserFactory得到解析器
		SAXParser sp=spf.newSAXParser();
//		把xml文件和事件对象关联
		sp.parse("src/MyXml.xml", new My());
	}

}

class My extends DefaultHandler
{

	@Override
	//文档开始执行此函数
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("文档开始扫描啦！");
	}
//	文档结束执行此函数
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("文档结束");
	}
//	节点开始执行此函数
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		//qName是元素的名称
		//Attributes是属性对象
//		System.out.println("元素名称是:"+qName+"    该元素的属性是:"+attributes.getQName(0)+"   该属性值是"+attributes.getValue(0));
	}
//	节点结束执行此函数
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
//		System.out.println("元素名称是:"+qName);
	}
//	进入内容文本执行此函数
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
//		super.characters(ch, start, length);
//		ch里面是xml文件的所有的字符串
		String con=new String(ch,start,length);
		if(!con.trim().equals(""))
		{
			System.out.println(con);
		}
	}
	
}