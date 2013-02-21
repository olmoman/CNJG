import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// Assigned to Daniel 

public class SentenceGrabber {
	
	private String sourceURLPath = "http://en.wikipedia.org/wiki/Portal:Contents/Quick_index";
	private String sourceDomain = "http://en.wikipedia.org";
	
	
	/**
	 * Method that randomly selects a sentence from a randomly selected article on 
	 * Wikipedia.
	 * 
	 * @return
	 */
	public String getSentence(){
		
		// will be needed to select arbitary pages/sentences
		Random random = new Random();
		
		// get a list of links to pages sorted in alphabetical order
		String html = this.getHTMLFromURL(sourceURLPath);
		Document doc = Jsoup.parse(html);
		Elements links = doc.getElementsByAttribute("href");
		ArrayList<String> pagesByAlphabet = new ArrayList<String>();
		for(Element e : links){
			if(e.attr("href").contains("/wiki/Special:AllPages/"))
				pagesByAlphabet.add(e.attr("href"));
		}
		
		// URL to list of articles with randomly chosen letter
		String randomPage = sourceDomain + pagesByAlphabet.get(random.nextInt(pagesByAlphabet.size()));
		
		// retrieves list of links to pages
		html = getHTMLFromURL(randomPage);
		doc = Jsoup.parse(html);
		links = doc.getElementsByClass("mw-redirect");
		pagesByAlphabet = new ArrayList<String>();
		for(Element e : links){
			pagesByAlphabet.add(e.attr("href"));
		}
		
		// url to randomly chosen article
		randomPage = sourceDomain + pagesByAlphabet.get(random.nextInt(pagesByAlphabet.size()));
		
		// extract paragraphs from article
		html = getHTMLFromURL(randomPage);
		doc = Jsoup.parse(html);
		Elements paragraphs = doc.getElementsByTag("p");
		
		// extract all sentences from paragraphs and store in list
		ArrayList<String> sentences = new ArrayList<String>();
		for(Element e : paragraphs){
			String[] fragments = e.text().split("\\. ");
			for(String s : fragments)
				sentences.add(s);
		}

		
		// if sentences available, select a random one to return
		if(sentences.size()>0)
			return sentences.get(random.nextInt(sentences.size()));
		else return "";
	}
	
	
	/**
	 * private method that returns html from a URL
	 * 
	 * @param urlPath
	 * @return
	 */
	private String getHTMLFromURL(String urlPath){
		HttpURLConnection connection = null;
	     OutputStreamWriter wr = null;
	     BufferedReader rd  = null;
	     StringBuilder sb = null;
	     String line = null;
	     URL serverAddress = null;
	     
	     String html = "";
	     
	     try {
	          serverAddress = new URL(urlPath);
	          //connection = null;
	        
	          //Set up the initial connection
	          connection = (HttpURLConnection)serverAddress.openConnection();
	          connection.setRequestMethod("GET");
	          connection.setDoOutput(true);
	          connection.setReadTimeout(10000);
	                    
	          connection.connect();

	        
	          //read the result from the server
	          rd  = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	          sb = new StringBuilder();
	          
	          while ((line = rd.readLine()) != null)
	          {
	              sb.append(line + '\n');
	          }
	        
	          //System.out.println(sb.toString());
	          html =  sb.toString();
	                    
	      } catch (MalformedURLException e) {
	          e.printStackTrace();
	      } catch (ProtocolException e) {
	          e.printStackTrace();
	      } catch (IOException e) {
	          e.printStackTrace();
	      }
	      finally
	      {
	          //close the connection, set all objects to null
	          connection.disconnect();
	          rd = null;
	          sb = null;
	          wr = null;
	          connection = null;
	          
	         
	      }
	     return html;
	     
	}

}
