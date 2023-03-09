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
