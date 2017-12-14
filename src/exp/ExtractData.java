package exp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringEscapeUtils;

public class ExtractData {
	
	public static void main(String[] args) {
		//escape("{\"html\": \"{@html@}<h2>Test Test!</h2><div id=\"wcmTest\"><p>This is a test text.</p></div>{@html@}\",\"mobileFriendly\": \"true\",\"priority\" : 1,\"categories\": \"254133427475504699376875279529023,Consumer,245471861221094008030992638563541\"}");
		final char ch = 'A';
		
		switch(65){
		 
		 case ch:
		  System.out.println("65");
		 case 66:
		  System.out.println("66");
		 
		 }
	}
	
	public static String getAffectedCi(String arg){
		if(arg.contains("Not up to date")){
			
		}
		return null;
	}
	public static String escape(String args) {		
		String sstr = args;
		String html= null;
		String escapeHtml = null;
		Pattern p = Pattern.compile("\\{@html@\\}.+\\{@html@\\}");
		Matcher match = p.matcher(sstr);
		if(match.find()){
			html = match.group();
		}
		
		escapeHtml = (html!=null)?html.replace("{@html@}", ""):null;
		
		
		String newS =  sstr.replace(html, StringEscapeUtils.escapeHtml(escapeHtml));
		System.out.println(newS);
		return newS;
		
		
	}
	
	
}
