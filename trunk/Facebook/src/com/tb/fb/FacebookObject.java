package com.tb.fb;
/**
 * 
 * <p>A FacebookObject is the result of a call to the Facebook API. The returned JSON string gets parsed into a FacebookObject. All of the resulting string, int or float values are accessible through <code>get</code> methods. Any objects, whether DataObject, FacebookObject, FacebookObject[] or Metadata, are publicly available.</p>
 * <p>Assuming to a call to "me" with the additional field of "friends" (<code>FacebookObject me = Facebook.api("me", "friends");</code>), the resulting data would be accessed by:
 * <ul>
 * 		<li>User ID 			- <code>me.getId();</code></li>
 * 		<li>User employer 		- <code>me.work[0].getEmployer();</code> (If the user has more than one entry in their work history they would be accessible as well)</li>
 * 		<li>Third friend's name	- <code>me.friends.data[2].getName();</code></li>
 * </ul>
 * 
 * All other objects work in the exact same way. All the objects mirror the JSON results from Facebook.</p>
 * 
 * @author Travis Beauvais - <a href="http://travisbeauvais.com" target="_blank">http://travisbeauvais.com</a>
 * @version 0.1
 * @see DataObject
 * @see Metadata
 *
 */
public class FacebookObject {
	private String active, attribution, bio, birthday, callback_url, can_post, caption, category, city, company_overview, country, created_time, deny, description, email, embed_html, end_date, end_time, fields_string, first_name, founded, gender, icon, id, last_name, link, locale, location_string, message, mission, name, next, object, picture, political, previous, privacy_string, products, quotes, relationship_status, religion, source, start_date, start_time, state, street, subject, type, updated_time, username, value, verified, website, zip;
	private String[] interested_in, meeting_for;
	private int count, fan_count, height, likes_count, position_int, timezone, version, width;
	private float latitude, longitude, x, y;
	public FacebookObject application, connections, employer, from, hometown, location, owner, place, position, privacy, venue;
	public FacebookObject[] actions, education, fields, work;
	public DataObject accounts, activities, albums, attending, books, checkins, comments, declined, events, feed, friends, groups, home, inbox, interests, invited, likes, links, maybe, members, movies, music, noreply, notes, outbox, photos, posts, statuses, subscriptions, tagged, tags, television, to, updates, videos;
	public Metadata metadata;
	
	/**
	 * <p>Parses a JSON string and sets all of the object values based on that JSON string.</p>
	 * 
	 * @param postJSON			JSON string to be parsed
	 */
	public FacebookObject(String postJSON) {	
		if (postJSON.substring(0,1).equals("\""))
			postJSON = postJSON.substring(postJSON.indexOf(":")+1);
		
		Object[] attr = Facebook.objs(postJSON);
		String attrName, value;
		int separator;
		System.out.println(postJSON);
		for(int n=0; n<attr.length; n++) {
			separator = attr[n].toString().indexOf(":");
			attrName = attr[n].toString().substring(1, separator-1);
			value = attr[n].toString().substring(separator+1);
			
			if (attrName.equals("active"))
				setActive(value);
			else if (attrName.equals("attribution"))
				setAttribution(value);
			else if (attrName.equals("bio"))
				setBio(value);
			else if (attrName.equals("birthday"))
				setBirthday(value);
			else if (attrName.equals("callback_url"))
				setCallbackURL(value);
			else if (attrName.equals("can_post"))
				setCanPost(value);
			else if (attrName.equals("caption"))
				setCaption(value);
			else if (attrName.equals("category"))
				setCategory(value);
			else if (attrName.equals("city"))
				setCity(value);
			else if (attrName.equals("company_overview"))
				setCompanyOverview(value);
			else if (attrName.equals("country"))
				setCountry(value);
			else if (attrName.equals("created_time"))
				setCreatedTime(value);
			else if (attrName.equals("deny"))
				setDeny(value);
			else if (attrName.equals("description"))
				setDescription(value);
			else if (attrName.equals("email"))
				setEmail(value);
			else if (attrName.equals("embed_html"))
				setEmbedHTML(value);
			else if (attrName.equals("end_date"))
				setEndDate(value);
			else if (attrName.equals("end_time"))
				setEndTime(value);
			else if (attrName.equals("fields") && (value.substring(0,1).equals("\"") && value.substring(value.length()-1).equals("\"")))
				setFields(value);
			else if (attrName.equals("first_name"))
				setFirstName(value);
			else if (attrName.equals("founded"))
				setFounded(value);
			else if (attrName.equals("gender"))
				setGender(value);
			else if (attrName.equals("icon"))
				setIcon(value);
			else if (attrName.equals("id"))
				setId(value);
			else if (attrName.equals("last_name"))
				setLastName(value);
			else if (attrName.equals("link"))
				setLink(value);
			else if (attrName.equals("location") && (value.substring(0,1).equals("\"") && value.substring(value.length()-1).equals("\"")))
				setLocation(value);
			else if (attrName.equals("locale"))
				setLocale(value);
			else if (attrName.equals("message"))
				setMessage(value);
			else if (attrName.equals("mission"))
				setMission(value);
			else if (attrName.equals("name"))
				setName(value);
			else if (attrName.equals("next"))
				setNext(value);
			else if (attrName.equals("object"))
				setObject(value);
			else if (attrName.equals("picture"))
				setPicture(value);
			else if (attrName.equals("political"))
				setPolitical(value);
			else if (attrName.equals("previous"))
				setPrevious(value);
			else if (attrName.equals("privacy") && (value.substring(0,1).equals("\"") && value.substring(value.length()-1).equals("\"")))
				setPrivacy(value);
			else if (attrName.equals("products"))
				setProducts(value);
			else if (attrName.equals("quotes"))
				setQuotes(value);
			else if (attrName.equals("relationship_status"))
				setRelationshipStatus(value);
			else if (attrName.equals("religion"))
				setReligion(value);
			else if (attrName.equals("source"))
				setSource(value);
			else if (attrName.equals("start_date"))
				setStartDate(value);
			else if (attrName.equals("start_time"))
				setStartTime(value);
			else if (attrName.equals("state"))
				setState(value);
			else if (attrName.equals("street"))
				setStreet(value);
			else if (attrName.equals("subject"))
				setSubject(value);
			else if (attrName.equals("type"))
				setType(value);
			else if (attrName.equals("updated_time"))
				setUpdatedTime(value);
			else if (attrName.equals("username"))
				setUsername(value);
			else if (attrName.equals("value"))
				setValue(value);
			else if (attrName.equals("verified"))
				setVerified(value);
			else if (attrName.equals("website"))
				setWebsite(value);
			else if (attrName.equals("zip"))
				setZip(value);
			
			
			else if (attrName.equals("interested_in"))
				setInterestedIn(value);
			else if (attrName.equals("meeting_for"))
				setMeetingFor(value);
			
			
			else if (attrName.equals("count"))
				setCount(Integer.parseInt(value));
			else if (attrName.equals("fan_count"))
				setFanCount(Integer.parseInt(value));
			else if (attrName.equals("height"))
				setHeight(Integer.parseInt(value));
			else if (attrName.equals("likes") && value.length() < 6)
				setLikes(Integer.parseInt(value));
			else if (attrName.equals("position") && (!value.substring(0,1).equals("{") && !value.substring(value.length()-1).equals("}")))
				setPosition(Integer.parseInt(value));
			else if (attrName.equals("timezone"))
				setTimezone(Integer.parseInt(value));
			else if (attrName.equals("version"))
				setVersion(Integer.parseInt(value));
			else if (attrName.equals("width"))
				setWidth(Integer.parseInt(value));
			
			
			else if (attrName.equals("latitude"))
				setLatitude(Float.parseFloat(value));
			else if (attrName.equals("longitude"))
				setLongitude(Float.parseFloat(value));
			else if (attrName.equals("x"))
				setX(Float.parseFloat(value));
			else if (attrName.equals("y"))
				setY(Float.parseFloat(value));
			
			
			else if (attrName.equals("accounts"))
				accounts = new DataObject(attr[n].toString());
			else if (attrName.equals("activities"))
				activities = new DataObject(attr[n].toString());
			else if (attrName.equals("albums"))
				albums = new DataObject(attr[n].toString());
			else if (attrName.equals("application"))
				application = new FacebookObject(attr[n].toString());
			else if (attrName.equals("attending"))
				attending = new DataObject(attr[n].toString());
			else if (attrName.equals("books"))
				books = new DataObject(attr[n].toString());
			else if (attrName.equals("comments"))
				comments = new DataObject(attr[n].toString());
			else if (attrName.equals("declined"))
				declined = new DataObject(attr[n].toString());
			else if (attrName.equals("employer"))
				employer = new FacebookObject(attr[n].toString());
			else if (attrName.equals("feed"))
				feed = new DataObject(attr[n].toString());
			else if (attrName.equals("friends"))
				friends = new DataObject(attr[n].toString());
			else if (attrName.equals("from"))
				from = new FacebookObject(attr[n].toString());
			else if (attrName.equals("groups"))
				groups = new DataObject(attr[n].toString());
			else if (attrName.equals("home"))
				home = new DataObject(attr[n].toString());
			else if (attrName.equals("hometown"))
				hometown = new FacebookObject(attr[n].toString());
			else if (attrName.equals("inbox"))
				inbox = new DataObject(attr[n].toString());
			else if (attrName.equals("interests"))
				interests = new DataObject(attr[n].toString());
			else if (attrName.equals("invited"))
				invited = new DataObject(attr[n].toString());
			else if (attrName.equals("likes"))
				likes = new DataObject(attr[n].toString());
			else if (attrName.equals("links"))
				links = new DataObject(attr[n].toString());
			else if (attrName.equals("location"))
				location = new FacebookObject(attr[n].toString());
			else if (attrName.equals("maybe"))
				maybe = new DataObject(attr[n].toString());
			else if (attrName.equals("members"))
				members = new DataObject(attr[n].toString());
			else if (attrName.equals("movies"))
				movies = new DataObject(attr[n].toString());
			else if (attrName.equals("music"))
				music = new DataObject(attr[n].toString());
			else if (attrName.equals("noreply"))
				noreply = new DataObject(attr[n].toString());
			else if (attrName.equals("notes"))
				notes = new DataObject(attr[n].toString());
			else if (attrName.equals("outbox"))
				outbox = new DataObject(attr[n].toString());
			else if (attrName.equals("owner"))
				owner = new FacebookObject(attr[n].toString());
			else if (attrName.equals("photos"))
				photos = new DataObject(attr[n].toString());
			else if (attrName.equals("place"))
				place = new FacebookObject(attr[n].toString());
			else if (attrName.equals("position"))
				position = new FacebookObject(attr[n].toString());
			else if (attrName.equals("posts"))
				posts = new DataObject(attr[n].toString());
			else if (attrName.equals("statuses"))
				statuses = new DataObject(attr[n].toString());
			else if (attrName.equals("subscriptions"))
				subscriptions = new DataObject(attr[n].toString());
			else if (attrName.equals("tagged"))
				tagged = new DataObject(attr[n].toString());
			else if (attrName.equals("tags"))
				tags = new DataObject(attr[n].toString());
			else if (attrName.equals("television"))
				television = new DataObject(attr[n].toString());
			else if (attrName.equals("to"))
				to = new DataObject(attr[n].toString());
			else if (attrName.equals("updates"))
				updates = new DataObject(attr[n].toString());
			else if (attrName.equals("venue"))
				venue = new FacebookObject(attr[n].toString());
			else if (attrName.equals("videos"))
				videos = new DataObject(attr[n].toString());
			
			else if (attrName.equals("metadata"))
				metadata = new Metadata(attr[n].toString());
			
			else if (attrName.equals("actions")) {
				setArray(attr[n].toString());
			} else if (attrName.equals("education")) {
				setArray(attr[n].toString());
			} else if (attrName.equals("fields")) {
				setArray(attr[n].toString());
			} else if (attrName.equals("work")) {
				setArray(attr[n].toString());
			}
		}
	}

	/**
	 * <p>Set the active value.</p>
	 * <p>Only used in the Subscription object.</p>
	 * 
	 * @param a		The value of active.
	 */
	public void setActive(String a) {this.active = Facebook.removeQuotes(a);}
	/**
	 * <p>Set the attribution value.</p>
	 * <p>Only used in the Post object.</p>
	 * 
	 * @param a		The value of attribution.
	 */
	public void setAttribution(String a) {this.attribution = Facebook.removeQuotes(a);}
	/**
	 * <p>Set the bio.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @param b		The value of bio.
	 */
	public void setBio(String b) {this.bio = Facebook.removeQuotes(b);}
	/**
	 * <p>Set the birthday value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @param bd		The value of birthday.
	 */
	public void setBirthday(String bd) {this.birthday = Facebook.removeQuotes(bd);}
	/**
	 * <p>Set the callback_url value.</p>
	 * <p>Only used in the Subscription object.</p>
	 * 
	 * @param cu		The value of callback_url.
	 */
	public void setCallbackURL(String cu) {this.callback_url = Facebook.removeQuotes(cu);}
	/**
	 * <p>Set the can_post value.</p>
	 * <p>Only used in the Page object.</p>
	 * 
	 * @param cp		The value of can_post.
	 */
	public void setCanPost(String cp) {this.can_post = Facebook.removeQuotes(cp);}
	/**
	 * <p>Set the caption value.</p>
	 * <p>Only used in the Link and Post objects.</p>
	 * 
	 * @param c		The value of caption.
	 */
	public void setCaption(String c) {this.caption = Facebook.removeQuotes(c);}
	/**
	 * <p>Set the category value.</p>
	 * <p>Only used in the Page and Application objects.</p>
	 * 
	 * @param c		The value of category.
	 */
	public void setCategory(String c) {this.category = Facebook.removeQuotes(c);}
	/**
	 * <p>Set the city value.</p>
	 * <p>Only used in the Event.venue, Checkin.place.location and Group.venue objects.</p>
	 * 
	 * @param c		The value of city.
	 */
	public void setCity(String c) {this.city = Facebook.removeQuotes(c);}
	/**
	 * <p>Set the company_overview value.</p>
	 * <p>Only used in the Page object.</p>
	 * 
	 * @param co		The value of company_overview.
	 */
	public void setCompanyOverview(String co) {this.company_overview = Facebook.removeQuotes(co);}
	/**
	 * <p>Set the country value.</p>
	 * <p>Only used in the Event.venue, Checkin.place.location and Group.venue objects.</p>
	 * 
	 * @param ctry		The country of active.
	 */
	public void setCountry(String ctry) {this.country = Facebook.removeQuotes(ctry);}
	/**
	 * <p>Set the created_time value.</p>
	 * <p>Used on almost all objects.</p>
	 * 
	 * @param ct		The value of created_time.
	 */
	public void setCreatedTime(String ct) {this.created_time = Facebook.removeQuotes(ct);}
	/**
	 * <p>Set the deny value.</p>
	 * 
	 * @param d		The value of deny.
	 */
	public void setDeny(String d) {this.deny = Facebook.removeQuotes(d);}
	/**
	 * <p>Set the description value.</p>
	 * <p>Used on almost all objects.</p>
	 * 
	 * @param d		The value of description.
	 */
	public void setDescription(String d) {this.description = Facebook.removeQuotes(d);}
	/**
	 * <p>Set the email value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @param e		The email of active.
	 */
	public void setEmail(String e) {this.email = Facebook.removeQuotes(e);}
	/**
	 * <p>Set the embed_html value.</p>
	 * <p>Only used in the Video object.</p>
	 * 
	 * @param eh		The value of embed_html.
	 */
	public void setEmbedHTML(String eh) {this.embed_html = Facebook.removeQuotes(eh);}
	/**
	 * <p>Set the end_date value.</p>
	 * 
	 * @param ed		The value of end_date.
	 */
	public void setEndDate(String ed) {this.end_date = Facebook.removeQuotes(ed);}
	/**
	 * <p>Set the end_time value.</p>
	 * <p>Only used in the Event object.</p>
	 * 
	 * @param et		The value of end_time.
	 */
	public void setEndTime(String et) {this.end_time = Facebook.removeQuotes(et);}
	/**
	 * <p>Set the fields_string value.</p>
	 * <p>fields_string is an alias for "fields" when the value is only a string.</p>
	 * <p>Only used in the Subscription object.</p>
	 * 
	 * @param f		The value of fields_string.
	 */
	public void setFields(String f) {this.fields_string = Facebook.removeQuotes(f);}
	/**
	 * <p>Set the first_name value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @param n		The value of first_name.
	 */
	public void setFirstName(String n) {this.first_name = Facebook.removeQuotes(n);}
	/**
	 * <p>Set the founded value.</p>
	 * <p>Only used in the Page object.</p>
	 * 
	 * @param f		The value of founded.
	 */
	public void setFounded(String f) {this.founded = Facebook.removeQuotes(f);}
	/**
	 * <p>Set the gender value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @param g		The value of gender.
	 */
	public void setGender(String g) {this.gender = Facebook.removeQuotes(g);}
	/**
	 * <p>Set the icon value.</p>
	 * <p>Used in almost all objects.</p>
	 * 
	 * @param i		The value of icon.
	 */
	public void setIcon(String i) {this.icon = Facebook.removeQuotes(i);}
	/**
	 * <p>Set the id value.</p>
	 * <p>Used in ALL objects.</p>
	 * 
	 * @param i		The value of id.
	 */
	public void setId(String i) {this.id = Facebook.removeQuotes(i);}
	/**
	 * <p>Set the last_name value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @param n		The value of last_name.
	 */
	public void setLastName(String n) {this.last_name = Facebook.removeQuotes(n);}
	/**
	 * <p>Set the link value.</p>
	 * <p>Used in almost all objects.</p>
	 * 
	 * @param l		The value of link.
	 */
	public void setLink(String l) {this.link = Facebook.removeQuotes(l);}
	/**
	 * <p>Set the locale value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @param l		The value of locale.
	 */
	public void setLocale(String l) {this.locale = Facebook.removeQuotes(l);}
	/**
	 * <p>Set the location_string value.</p>
	 * <p>Only used in the Event and Album objects.</p>
	 * 
	 * @param l		The value of location_string.
	 */
	public void setLocation(String l) {this.location_string = Facebook.removeQuotes(l);}
	/**
	 * <p>Set the message value.</p>
	 * <p>Only used in the Checkin, Link, Note, Status Message, Video and Post objects.</p>
	 * 
	 * @param m		The value of message.
	 */
	public void setMessage(String m) {this.message = Facebook.removeQuotes(m);}
	/**
	 * <p>Set the mission value.</p>
	 * <p>Only used in the Page object.</p>
	 * 
	 * @param m		The value of mission.
	 */
	public void setMission(String m) {this.mission = Facebook.removeQuotes(m);}
	/**
	 * <p>Set the name value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @param name		The value of name.
	 */
	public void setName(String name) {this.name = Facebook.removeQuotes(name);}
	/**
	 * <p>Set the next value.</p>
	 * <p>Used in any object that returns large sets.</p>
	 * 
	 * @param n		The value of next.
	 */
	public void setNext(String n) {
		this.next = Facebook.unescape(Facebook.removeQuotes(n));
	}
	/**
	 * <p>Set the object value.</p>
	 * <p>Only used in the Subscription object.</p>
	 * 
	 * @param o		The value of object.
	 */
	public void setObject(String o) {this.object = Facebook.removeQuotes(o);}
	/**
	 * <p>Set the picture value.</p>
	 * <p>Usewd in MANY objects.</p>
	 * 
	 * @param p		The value of picture.
	 */
	public void setPicture(String p) {this.picture = Facebook.removeQuotes(p);}
	/**
	 * <p>Set the political value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @param p		The value of political.
	 */
	public void setPolitical(String p) {this.political = Facebook.removeQuotes(p);}
	/**
	 * <p>Set the previous value.</p>
	 * <p>Used in any object that returns large sets.</p>
	 * 
	 * @param p		The value of previous.
	 */
	public void setPrevious(String p) {
		this.previous = Facebook.unescape(Facebook.removeQuotes(p));
	}
	/**
	 * <p>Set the privacy_string value.</p>
	 * <p>privacy_string is an alias of "privacy" when the value is only a string.</p>
	 * <p>Only used in the Event and Group objects.</p>
	 * 
	 * @param p		The value of privacy_string.
	 */
	public void setPrivacy(String p) {this.privacy_string = Facebook.removeQuotes(p);}
	/**
	 * <p>Set the products value.</p>
	 * <p>Only used in the Page object.</p>
	 * 
	 * @param p		The value of products.
	 */
	public void setProducts(String p) {this.products = Facebook.removeQuotes(p);}
	/**
	 * <p>Set the quotes value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @param q		The value of quotes.
	 */
	public void setQuotes(String q) {this.quotes = Facebook.removeQuotes(q);}
	/**
	 * <p>Set the relationship_status value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @param rs		The value of relationship_status.
	 */
	public void setRelationshipStatus(String rs) {this.relationship_status = Facebook.removeQuotes(rs);}
	/**
	 * <p>Set the religion value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @param r		The value of religion.
	 */
	public void setReligion(String r) {this.religion = Facebook.removeQuotes(r);}
	/**
	 * <p>Set the source value.</p>
	 * <p>Only used in the Photo and Post objects.</p>
	 * 
	 * @param s		The value of source.
	 */
	public void setSource(String s) {this.source = Facebook.removeQuotes(s);}
	/**
	 * <p>Set the start_date value.</p>
	 * 
	 * @param sd		The value of start_date.
	 */
	public void setStartDate(String sd) {this.start_date = Facebook.removeQuotes(sd);}
	/**
	 * <p>Set the start_time value.</p>
	 * <p>Only used in the Event object.</p>
	 * 
	 * @param st		The value of start_time.
	 */
	public void setStartTime(String st) {this.start_time = Facebook.removeQuotes(st);}
	/**
	 * <p>Set the state value.</p>
	 * <p>Only used in the Event.venue, Checkin.place.location and Group.venue objects.</p>
	 * 
	 * @param st		The value of state.
	 */
	public void setState(String st) {this.state = Facebook.removeQuotes(st);}
	/**
	 * <p>Set the street value.</p>
	 * <p>Only used in the Event.venue, Checkin.place.location and Group.venue objects.</p>
	 * 
	 * @param str		The value of street.
	 */
	public void setStreet(String str) {this.street = Facebook.removeQuotes(str);}
	/**
	 * <p>Set the subject value.</p>
	 * <p>Only used in the Note object.</p>
	 * 
	 * @param s		The value of subject.
	 */
	public void setSubject(String s) {this.subject = Facebook.removeQuotes(s);}
	/**
	 * <p>Set the type value.</p>
	 * <p>Used in many objects.</p>
	 * 
	 * @param t		The value of type.
	 */
	public void setType(String t) {this.type = Facebook.removeQuotes(t);}
	/**
	 * <p>Set the updated_time value.</p>
	 * <p>Used in almost all objects.</p>
	 * 
	 * @param ut		The value of updated_time.
	 */
	public void setUpdatedTime(String ut) {this.updated_time = Facebook.removeQuotes(ut);}
	/**
	 * <p>Set the username value.</p>
	 * <p>Only used in the Page and User objects.</p>
	 * 
	 * @param u		The value of username.
	 */
	public void setUsername(String u) {this.username = Facebook.removeQuotes(u);}
	/**
	 * <p>Set the value value.</p>
	 * 
	 * @param v		The value of value.
	 */
	public void setValue(String v) {this.value = Facebook.removeQuotes(v);}
	/**
	 * <p>Set the verified value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @param v		The value of verified.
	 */
	public void setVerified(String v) {this.verified = Facebook.removeQuotes(v);}
	/**
	 * <p>Set the website value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @param w		The value of website.
	 */
	public void setWebsite(String w) {this.website = Facebook.removeQuotes(w);}
	/**
	 * <p>Set the zip value.</p>
	 * <p>Only used in the Event.venue, Checkin.place.location and Group.venue objects.</p>
	 * 
	 * @param z		The value of zip.
	 */
	public void setZip(String z) {this.zip = Facebook.removeQuotes(z);}
	

	/**
	 * <p>Set the count value.</p>
	 * <p>Only used in the Album object.</p>
	 * 
	 * @param c		The value of count.
	 */
	public void setCount(int c) {this.count = c;}
	/**
	 * <p>Set the fan_count value.</p>
	 * <p>Only used in the Page object.</p>
	 * 
	 * @param fc		The value of fan_count.
	 */
	public void setFanCount(int fc) {this.fan_count = fc;}
	/**
	 * <p>Set the height value.</p>
	 * <p>Only used in the Photo object.</p>
	 * 
	 * @param h		The value of height.
	 */
	public void setHeight(int h) {this.height = h;}
	/**
	 * <p>Set the likes_count value.</p>
	 * 
	 * @param lc		The value of likes_count.
	 */
	public void setLikes(int lc) {this.likes_count = lc;}
	/**
	 * <p>Set the position_int value.</p>
	 * <p>position_int is an alias of "position" when the value is only a number and not an object.
	 * 
	 * @param p		The value of position_int.
	 */
	public void setPosition(int p) {this.position_int = p;}
	/**
	 * <p>Set the timezone value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @param tz		The value of timezone.
	 */
	public void setTimezone(int tz) {this.timezone = tz;}
	/**
	 * <p>Set the version value.</p>
	 * <p>Only used in the Group object.</p>
	 * 
	 * @param v		The value of version.
	 */
	public void setVersion(int v) {this.version = v;}
	/**
	 * <p>Set the width value.</p>
	 * <p>Only used in the Photo object.</p>
	 * 
	 * @param w		The value of width.
	 */
	public void setWidth(int w) {this.width = w;}
	

	/**
	 * <p>Set the latitude value.</p>
	 * <p>Only used in the Event.venue and Checkin.place.location objecst.</p>
	 * 
	 * @param lat		The value of latitude.
	 */
	public void setLatitude(float lat) {this.latitude = lat;}
	/**
	 * <p>Set the longitude value.</p>
	 * <p>Only used in the Event.venue and Checkin.place.location object.</p>
	 * 
	 * @param longi		The value of longitude.
	 */
	public void setLongitude(float longi) {this.longitude = longi;}
	/**
	 * <p>Set the x value.</p>
	 * <p>Only used in the Photo.tags object.</p>
	 * 
	 * @param x		The value of x.
	 */
	public void setX(float x) {this.x = x;}
	/**
	 * <p>Set the y value.</p>
	 * <p>Only used in the Photo.tags object.</p>
	 * 
	 * @param y		The value of y.
	 */
	public void setY(float y) {this.y = y;}
	
	/**
	 * <p>Sets the values of interested_in which is an array of strings. Uses a JSON string to set the value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @param ii		The JSON string with the values for interested_in.
	 */
	public void setInterestedIn(String ii) {
		Object[] interestedIn = Facebook.objs(ii);
		interested_in = new String[interestedIn.length];
		for(int n=0; n<interestedIn.length; n++) {
			interested_in[n] = interestedIn[n].toString();
		}
	}
	/**
	 * <p>Sets the values of meeting_for which is an array of strings. Uses a JSON string to set the value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @param mf		The JSON string with the values for meeting_for.
	 */
	public void setMeetingFor(String mf) {
		Object[] meetingFor = Facebook.objs(mf);
		meeting_for = new String[meetingFor.length];
		for(int n=0; n<meetingFor.length; n++) {
			meeting_for[n] = meetingFor[n].toString();
		}
	}
	
	/**
	 * <p>Sets the values of a variable that is an array of FacebookObjects. Uses a JSON string to set the value.</p>
	 * <p>Used to set actions (Post, Status Message), education (User), fields (Metadata) and work (User).</p>
	 * @param ar		The JSON string with the values.
	 * 
	 * @see FacebookObject
	 */
	public void setArray(String ar) {
		int ind = ar.indexOf(":");
		String attrName = ar.substring(1,ind-1);
		String value = ar.substring(ind+1);
		Object[] obj = Facebook.objs(value);
		
		if (attrName.equals("actions")) {
			actions = new FacebookObject[obj.length];
			
			for(int z=0; z<obj.length; z++) {
				actions[z] = new FacebookObject(obj[z].toString());
			}
		} else if (attrName.equals("education")) {
			education = new FacebookObject[obj.length];
			
			for(int z=0; z<obj.length; z++) {
				education[z] = new FacebookObject(obj[z].toString());
			}
		} else if (attrName.equals("fields")) {
			fields = new FacebookObject[obj.length];
			
			for(int z=0; z<obj.length; z++) {
				fields[z] = new FacebookObject(obj[z].toString());
			}
		} else if (attrName.equals("work")) {
			work = new FacebookObject[obj.length];
					
			for(int z=0; z<obj.length; z++) {
				work[z] = new FacebookObject(obj[z].toString());
			}
		}
	}
	
	public String getActive() {return active;}
	public String getAttribution() {return attribution;}
	public String getBio() {return bio;}
	public String getBirthday() {return birthday;}
	public String getCallbackURL() {return callback_url;}
	public String getCanPost() {return can_post;}
	public String getCaption() {return caption;}
	public String getCategory() {return category;}
	public String getCity() {return city;}
	public String getCompanyOverview() {return company_overview;}
	public String getCountry() {return country;}
	public String getCreatedTime() {return created_time;}
	public String getDeny() {return deny;}
	public String getDescription() {return description;}
	public String getEmail() {return email;}
	public String getEmbedHTML() {return embed_html;}
	public String getEndDate() {return end_date;}
	public String getEndTime() {return end_time;}
	public String getFields() {return fields_string;}
	public String getFirstName() {return first_name;}
	public String getFounded() {return founded;}
	public String getGender() {return gender;}
	public String getIcon() {return icon;}
	public String getId() {return id;}
	public String getLastName() {return last_name;}
	public String getLink() {return link;}
	public String getLocale() {return locale;}
	public String getLocation() {return location_string;}
	public String getMessage() {return message;}
	public String getMission() {return mission;}
	public String getName() {return name;}
	public String getNext() {return next;}
	public String getObject() {return object;}
	public String getPicture() {return picture;}
	public String getPolitical() {return political;}
	public String getPrevious() {return previous;}
	public String getPrivacy() {return privacy_string;}
	public String getProducts() {return products;}
	public String getQuotes() {return quotes;}
	public String getRelationshipStatus() {return relationship_status;}
	public String getReligion() {return religion;}
	public String getSource() {return source;}
	public String getStartDate() {return start_date;}
	public String getStartTime() {return start_time;}
	public String getState() {return state;}
	public String getStreet() {return street;}
	public String getSubject() {return subject;}
	public String getType() {return type;}
	public String getUpdatedTime() {return updated_time;}
	public String getUsername() {return username;}
	public String getValue() {return value;}
	public String getVerified() {return verified;}
	public String getWebsite() {return website;}
	public String getZip() {return zip;}
	
	public int getCount() {return count;}
	public int getFanCount() {return fan_count;}
	public int getHeight() {return height;}
	public int getInt() {return timezone;}
	public int getLikes() {return likes_count;}
	public int getPosition() {return position_int;}
	public int getVersion() {return version;}
	public int getWidth() {return width;}
	
	public float getLatitude() {return latitude;}
	public float getLongitude() {return longitude;}
	public float getX() {return x;}
	public float getY() {return y;}
	
	public String[] getInterestedIn() {return interested_in;}
	public String[] getMeetingFor() {return meeting_for;}	
}
