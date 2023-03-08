package com.kh.teamproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	//예외처리 메서드
//	@ExceptionHandler(Exception.class)
//	public String catcher(Exception ex) {
//		return "errorPage";
//	}
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		
		
		
		
		
		URL url=null;
		BufferedReader br = null;
		String result = "";
		StringBuilder urlBuilder = new StringBuilder("http://openapi.foodsafetykorea.go.kr/api/"); 
		// 2. 오픈 API의요청 규격에 맞는 파라미터 생성, 발급받은 인증키.
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
		try {
			//url에 요청인자 삽입
			urlBuilder.append(URLEncoder.encode("16108f3fd1f0410ba326", "UTF-8"));//인증키
			urlBuilder.append("/" + URLEncoder.encode("COOKRCP01", "UTF-8") + "/"+ URLEncoder.encode("XML", "UTF-8")); /* XML 또는 JSON */
			urlBuilder.append("/" + URLEncoder.encode("1", "UTF-8") + "/" + URLEncoder.encode("5", "UTF-8")); /* 페이지 */
			urlBuilder.append("/" + URLEncoder.encode("RCP_PARTS_DTLS", "UTF-8") + "="+ URLEncoder.encode("감자", "UTF-8"));
			/*RCP_PARTS_DTLS: 재료명, RCP_NM: 메뉴명 */
			url = new URL(urlBuilder.toString());
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
			String line;
			while ((line = br.readLine()) != null) {
				result = result + line.trim();// result = URL로 XML을 읽은 값
			}
			
			InputSource is = new InputSource(new StringReader(result));
            builder = factory.newDocumentBuilder();
            doc = builder.parse(is);
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
			
            // XPathExpression expr = xpath.compile("/response/body/items/item");
            XPathExpression expr = xpath.compile("//COOKRCP01/row");//<COOKRCP01> 아래의 <row>의 값들을 읽음
            NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                NodeList child = nodeList.item(i).getChildNodes();
                for (int j = 0; j < child.getLength(); j++) {
                    Node node = child.item(j);
                    if(node.getTextContent()!="") {
                    	System.out.println("현재 노드 이름 : " + node.getNodeName());
                    	System.out.println("현재 노드 값 : " + node.getTextContent());
                    	System.out.println("");
                    	//현재 노드 이름 : RCP_PARTS_DTLS: 레시피의 첫 줄 
//                    	1	RCP_SEQ	일련번호
//                    	2	RCP_NM	메뉴명
//                    	3	RCP_WAY2	조리방법
//                    	4	RCP_PAT2	요리종류
//                    	5	INFO_WGT	중량(1인분)
//                    	6	INFO_ENG	열량
//                    	7	INFO_CAR	탄수화물
//                    	8	INFO_PRO	단백질
//                    	9	INFO_FAT	지방
//                    	10	INFO_NA	나트륨
//                    	11	HASH_TAG	해쉬태그
//                    	12	ATT_FILE_NO_MAIN	이미지경로(소)
//                    	13	ATT_FILE_NO_MK	이미지경로(대)
//                    	14	RCP_PARTS_DTLS	재료정보
//                    	15	MANUAL01	만드는법_01
//                    	16	MANUAL_IMG01	만드는법_이미지_01
//                    	17	MANUAL02	만드는법_02
//                    	18	MANUAL_IMG02	만드는법_이미지_02
//                   	...
                    }
                }
            }
				
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//임시로 써본거라 지우셔도 됩니다!
/*		
		//cloudinary API 테스트
		// Configure
		Map config = new HashMap();
		config.put("cloud_name", "dd4rzi6aj");
		config.put("api_key", "328149227124265");
		config.put("api_secret", "RDJ2-M9CAkGwJxX1WjEt5EVoUgU");
		Cloudinary cloudinary = new Cloudinary(config);


		// Upload
		try {
		  cloudinary.uploader().upload("C:\\Users\\Luminite\\Pictures\\Screenshots\\marketsample.png", ObjectUtils.asMap("sample_beta", "market_sample"));
		} catch (IOException exception) {
		  System.out.println(exception.getMessage());
		}
*/		
		
		return "home";
	}
	
}
