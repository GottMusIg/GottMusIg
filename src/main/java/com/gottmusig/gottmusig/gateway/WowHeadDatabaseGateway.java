package com.gottmusig.gottmusig.gateway;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gottmusig.gottmusig.model.wowhead.Classes;
import com.gottmusig.gottmusig.model.wowhead.Filters;
import com.gottmusig.gottmusig.model.wowhead.Quality;
import com.gottmusig.gottmusig.model.wowhead.Slot;
import com.gottmusig.gottmusig.model.wowhead.WowHead;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WowHeadDatabaseGateway {
	

	public static final String BASE_URL = "http://www.wowhead.com/";
	private static final String ITEM_PARAM = "items/";
	private static final String WOW_LIST_VIEW_ITEMS_REGEX = "(?<=listviewitems\\s=\\s)\\[.*\\]?(?=;)";
	private final ObjectMapper objectMapper;
	
	public WowHeadDatabaseGateway(){
		objectMapper = new ObjectMapper();
		objectMapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
	}

	public WowHead getItemsFor(Classes wowClass, int minLvl, int maxLvl, Slot slot, Quality quality) throws IOException{

		String requestUrl = buildUrl(wowClass,minLvl, maxLvl, slot, quality);
		
		Document wowheadResultPage =  Jsoup.connect(requestUrl).get();
		String itemsAsJsonString = getJsonItemListString(wowheadResultPage);
		WowHead wowhead = convertJsonStringToObject(itemsAsJsonString);
		log.debug("Found: "+wowhead.getItems().size()+ " wowheaditems :)");
		return wowhead;
	}

	//TODO
	private String buildUrl(Classes wowClass,int minLvl,int maxLvl, Slot slot, Quality quality ){
		
		String finalUrl = BASE_URL+ITEM_PARAM+Filters.getMinRequiredLevelUrlPart(maxLvl) + Filters.getMaxRequiredLevelUrlPart(minLvl)+wowClass.getURLPart();
		
		if(quality != null){
			finalUrl += quality.getURLPart();
		}
		
		if(slot != null){
			finalUrl+=slot.getURLPart();
		}
		
		log.debug("URL: "+finalUrl);
		return applyStandtartfilters(finalUrl, wowClass);
	}
	
	private String applyStandtartfilters(String url, Classes wowClass){			
		Filters filter2 = Filters.CAN_BE_EQUIPPED_YES;	
		return url + filter2.getUrlPart();
	}
	
	private String getJsonItemListString(Document doc){
		
		Elements scripts = doc.select("script"); // Get the script part
		String values="";
		for(Element script : scripts){
			
			Pattern p =   Pattern.compile(WOW_LIST_VIEW_ITEMS_REGEX); // Regex for the value of the key
			Matcher m = p.matcher(script.html()); 
			
			while( m.find() )
			{
				values = m.group();
			}
		}
		return addJsonWrapper(values);

	}

	private String addJsonWrapper(String values){
		String jsonString =  "{\"items\": "+values+" }";
		log.debug(jsonString);
		return jsonString;
	}
	
	private WowHead convertJsonStringToObject(String jsonString) throws IOException{
		return objectMapper.readValue(jsonString, WowHead.class);
	}
	
}
