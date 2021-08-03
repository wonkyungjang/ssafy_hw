package com.ssafy.news;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class NewsDAOSAXImpl implements INewsDAO {
	private List<News> list = new ArrayList<>();
	private static NewsDAOSAXImpl instance = new NewsDAOSAXImpl();
	
	public static NewsDAOSAXImpl getInstance() {
		return instance;
	}
	@Override
	public List<News> getNewsList(String url) {
		list.removeAll(list);
		connectXML(url);
		return list;

	}
	
	@Override
	public News search(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<News> connectXML(String url) {
		SAXParserFactory f = SAXParserFactory.newInstance();
		try {
			SAXParser parser = f.newSAXParser();
			SAXHandler handler = new SAXHandler();
			parser.parse(new URL(url).openConnection().getInputStream(),
					handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public class SAXHandler extends DefaultHandler {
		private StringBuilder sb;
		boolean flag;
		News n;
		
		@Override
		//태그를 처음 만나면 발생하는 이벤트
		public void startElement(String uri, String localName, String name,
				Attributes attributes) throws SAXException {
			super.startElement(uri, localName, name, attributes);
			if (name.equalsIgnoreCase("item")) {
				n = new News();
			}
		}

		@Override
		//태그와 태그 사이의 text를 처리하기 위한 이벤트
		public void characters(char[] ch, int start, int length) throws SAXException {
			sb = new StringBuilder(new String(ch, start, length));
			//텍스트를 어떻게 줄지. 문자열로 처음부터 끝까지 받아서 줌
		}

		@Override
		//닫힌 태그를 만나면 발생하는 이벤트
		public void endElement(String uri, String localName, String name)
				throws SAXException {
			if (n != null) {
				if (name.equalsIgnoreCase("title")) {
					n.setTitle(sb.toString().trim());
				} else if (name.equalsIgnoreCase("link")) {
					n.setLink(sb.toString().trim());
				} else if (name.equalsIgnoreCase("description")) {
					n.setDesc(sb.toString().trim());
				} else if (name.equalsIgnoreCase("item")) {
					list.add(n);
				}
			}
			sb.setLength(0);
		}

		
	}

}
	
	

