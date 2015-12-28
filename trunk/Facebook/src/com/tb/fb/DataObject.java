package com.tb.fb;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * <p>A DataObject is a collection of FacebookObjects used when the returning value from Facebook contains multiple values. Comments, photos, likes, and posts are just a couple of the values returned from Facebook that use this object.</p>
 * 
 * @author Travis Beauvais - <a href="http://travisbeauvais.com" target="_blank">http://travisbeauvais.com</a>
 * @version 0.1
 * @see FacebookObject
 *
 */
public class DataObject {
	public FacebookObject[] data;
	public FacebookObject paging;
	private int count;
	
	/**
	 * 
	 * <p>Parses a JSON string and sets all of the object values based on that JSON string.</p>
	 * <p>Checks for paging or a count value and sets them if present. A paging value would become a FacebookObject object and count is an <code>int</code> available through the <code>getCode</code> method.</p>
	 * 
	 * @param json			The JSON string that will be parsed.
	 * @see FacebookObject
	 * 
	 */
	public DataObject(String json) {
		int index = json.indexOf(":");
		Pattern pagingPattern = Pattern.compile("\\],\"paging\":\\{");
		Pattern countPattern = Pattern.compile("\\],\"count\":[0-9]");
		Matcher pages = pagingPattern.matcher(json);
		Matcher count = countPattern.matcher(json);
		Object[] objs;
		
		if (pages.find() || count.find()) {
			json = json.substring(index + 9);
			
			Object[] pagingObj = Facebook.objs(json, 1);
			objs = Facebook.objs(pagingObj[0].toString().substring(1,pagingObj[0].toString().length()-1));
			
			if (pagingObj.length > 1) {
				Object[] otherObjs;
				int separator;
				String attrName;
				for(int x=0; x<pagingObj.length; x++) {
					otherObjs = Facebook.objs("{" + pagingObj[x].toString() + "}");
					
					for(int y=0; y<otherObjs.length; y++) {
						separator = otherObjs[y].toString().indexOf(":");
						attrName = otherObjs[y].toString().substring(1, separator-1);
						
						if (attrName.equals("count"))
							setCount(Integer.parseInt(otherObjs[y].toString().substring(separator+1)));
						else if (attrName.equals("paging"))
							paging = new FacebookObject(otherObjs[y].toString().substring(separator+1));
					}
				}
			}
		} else {
			json = json.substring(index + 10, json.length()-2);
			objs = Facebook.objs(json, 1);
		}
		
		data = new FacebookObject[objs.length];
		
		for(int n=0; n<objs.length; n++) {
			data[n] = new FacebookObject(objs[n].toString());
		}
	}
	
	/**
	 * 
	 * @param c Sets the value of count.
	 */
	public void setCount(int c) {this.count = c;}
	/**
	 * 
	 * @return The value of count.
	 */
	public int getCount() {return count;}
}