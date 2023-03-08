package com.kh.teamproject.temp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

@Controller
public class TempForTable {

	
	@GetMapping("/temp")
	public String insertTable() {
		
		
		String key="eb16ab3bbff3de6855ec9a9df256d865a5214e03f4d8f3dff5af008c178445ab" ;
		
		
		URL url=null;
		BufferedReader br = null;
		String result = "";
		StringBuilder urlBuilder = new StringBuilder("http://211.237.50.150:7080/openapi/"); 
		
		// 2. 오픈 API의요청 규격에 맞는 파라미터 생성, 발급받은 인증키.
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder;
		Document doc = null;
		HttpURLConnection urlconnection =null;
		String line;
		InputSource is=null;
		XPathFactory xpathFactory =null;
		 XPath xpath=null;
		 XPathExpression expr=null;
		 NodeList nodeList =null;
		//http://211.237.50.150:7080/openapi/eb16ab3bbff3de6855ec9a9df256d865a5214e03f4d8f3dff5af008c178445ab/xml/Grid_20150827000000000226_1/1/10
		try {
			//url에 요청인자 삽입
			urlBuilder.append(URLEncoder.encode("eb16ab3bbff3de6855ec9a9df256d865a5214e03f4d8f3dff5af008c178445ab", "UTF-8"));//인증키
			urlBuilder.append("/" + URLEncoder.encode("xml", "UTF-8"));
//			urlBuilder.append("/" + URLEncoder.encode("Grid_20150827000000000226_1", "UTF-8")); /*레시피 기본정보*/
//			urlBuilder.append("/" + URLEncoder.encode("Grid_20150827000000000227_1", "UTF-8")); /*레시피 재료정보*/
			urlBuilder.append("/" + URLEncoder.encode("Grid_20150827000000000228_1", "UTF-8")); /*레시피 과정정보*/
			urlBuilder.append("/" + URLEncoder.encode("1", "UTF-8") + "/" + URLEncoder.encode("100", "UTF-8")); /*레시피 기본정보*/
			url = new URL(urlBuilder.toString());
			urlconnection = (HttpURLConnection) url.openConnection();
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
			
			while ((line = br.readLine()) != null) {
				result = result + line.trim();// result = URL로 XML을 읽은 값
			}
		
			is = new InputSource(new StringReader(result));
            builder = factory.newDocumentBuilder();
            doc = builder.parse(is);
            xpathFactory = XPathFactory.newInstance();
            xpath = xpathFactory.newXPath();
			
//            XPathExpression expr = xpath.compile("//Grid_20150827000000000226_1/row");//<Grid_20150827000000000226_1> 아래의 <row>의 값들을 읽음
//            XPathExpression expr = xpath.compile("//Grid_20150827000000000227_1/row");//<Grid_20150827000000000226_1> 아래의 <row>의 값들을 읽음
            expr = xpath.compile("//Grid_20150827000000000228_1/row");//<Grid_20150827000000000226_1> 아래의 <row>의 값들을 읽음
            nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                NodeList child = nodeList.item(i).getChildNodes();
                for (int j = 0; j < child.getLength(); j++) {
                    Node node = child.item(j);
                    if(node.getTextContent()!="") {
                    	
                    	System.out.println(node.getNodeName()+": "+node.getTextContent() );

                    }
                }
            }
		
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		
		
		
		//기본정보
//		RECIPE_ID	레시피 코드 (SEQ_RECIPE)
//		RECIPE_NM_KO	레시피 이름(한글)
//		SUMRY	간략(요약) 소개   x
//		NATION_CODE	유형코드  x
//		NATION_NM	유형분류  x
//		TY_CODE	음식분류코드   x
//		TY_NM	음식분류   x
//		COOKING_TIME	조리시간  x
//		CALORIE	칼로리  x
//		QNT	분량  x
//		LEVEL_NM	난이도  x
//		IRDNT_CODE	재료별 분류명 x
//		PC_NM	가격별 분류  x
		
		
		
		//재료 정보   
//		RECIPE_ID	레시피 코드
//		IRDNT_SN	재료순번  x
//		IRDNT_NM	재료명
//		IRDNT_CPCTY	재료용량
//		IRDNT_TY_CODE	재료타입 코드 x
//		IRDNT_TY_NM	재료타입명 x
		
		
		
		//레시피 과정정보
//		RECIPE_ID	레시피 코드
//		COOKING_NO	요리설명순서 x
//		COOKING_DC	요리설명
//		STEP_TIP	과정팁	x 	
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		return "temp";
				
		
		
	}
	
}
