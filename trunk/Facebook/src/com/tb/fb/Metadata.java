package com.tb.fb;
/**
 * 
 * <p>The Metadata class parses the values returned in the Metadata object from Facebook. The Metadata object contains all of the connections for any one object. For instance, a Page object has connections to "feed", "picture", "tagged", "links", "photos", "groups", "albums", "statuses", "videos", "notes", "posts", "members", "events" and "checkins". Each of these values are URLs to those objects. The metadata object also describes each of the properties of an object.</p>
 * 
 * @author Travis Beauvais - <a href="http://travisbeauvais.com" target="_blank">http://travisbeauvais.com</a>
 * @version 0.1
 * @see FacebookObject
 *
 */
public class Metadata {
	private String accounts, activities, albums, attending, books, checkins, comments, declined, events, feed, friends, groups, home, inbox, interests, invited, likes, links, maybe, members, movies, music, noreply, notes, outbox, photos, picture, posts, statuses, subscriptions, tagged, television, updates, videos;
	public Metadata connections;
	public FacebookObject[] fields;
	
	/**
	 * 
	 * <p>Parses a JSON string and sets all of the object values based on that JSON string.</p>
	 * 
	 * @param metaJSON			The JSON string that will be parsed.
	 * 
	 */
	public Metadata(String metaJSON) {
		if (metaJSON.substring(0,1).equals("\""))
			metaJSON = metaJSON.substring(metaJSON.indexOf(":")+1);
		
		Object[] attr = Facebook.objs(metaJSON);
		String attrName, value;
		int separator;
		
		for(int n=0; n<attr.length; n++) {
			separator = attr[n].toString().indexOf(":");
			attrName = attr[n].toString().substring(1, separator-1);
			value = attr[n].toString().substring(separator+1);

			if (attrName.equals("accounts"))
			    setAccounts(value);
			else if (attrName.equals("activities"))
			    setActivities(value);
			else if (attrName.equals("albums"))
			    setAlbums(value);
			else if (attrName.equals("attending"))
			    setAttending(value);
			else if (attrName.equals("books"))
			    setBooks(value);
			else if (attrName.equals("checkins"))
			    setCheckins(value);
			else if (attrName.equals("comments"))
			    setComments(value);
			else if (attrName.equals("declined"))
			    setDeclined(value);
			else if (attrName.equals("events"))
			    setEvents(value);
			else if (attrName.equals("feed"))
			    setFeed(value);
			else if (attrName.equals("friends"))
			    setFriends(value);
			else if (attrName.equals("groups"))
			    setGroups(value);
			else if (attrName.equals("home"))
			    setHome(value);
			else if (attrName.equals("inbox"))
			    setInbox(value);
			else if (attrName.equals("interests"))
			    setInterests(value);
			else if (attrName.equals("invited"))
			    setInvited(value);
			else if (attrName.equals("likes"))
			    setLikes(value);
			else if (attrName.equals("links"))
			    setLinks(value);
			else if (attrName.equals("maybe"))
			    setMaybe(value);
			else if (attrName.equals("members"))
			    setMembers(value);
			else if (attrName.equals("movies"))
			    setMovies(value);
			else if (attrName.equals("music"))
			    setMusic(value);
			else if (attrName.equals("noreply"))
			    setNoreply(value);
			else if (attrName.equals("notes"))
			    setNotes(value);
			else if (attrName.equals("outbox"))
			    setOutbox(value);
			else if (attrName.equals("photos"))
			    setPhotos(value);
			else if (attrName.equals("picture"))
			    setPicture(value);
			else if (attrName.equals("posts"))
			    setPosts(value);
			else if (attrName.equals("statuses"))
			    setStatuses(value);
			else if (attrName.equals("subscriptions"))
			    setSubscriptions(value);
			else if (attrName.equals("tagged"))
			    setTagged(value);
			else if (attrName.equals("television"))
			    setTelevision(value);
			else if (attrName.equals("updates"))
			    setUpdates(value);
			else if (attrName.equals("videos"))
			    setVideos(value);
			
			else if (attrName.equals("connections"))
				connections = new Metadata(attr[n].toString());
			
			else if (attrName.equals("fields"))
				setFields(attr[n].toString());
		}
	}
	
	/**
	 * <p>Set the accounts value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @param a		The value of accounts.
	 */
	public void setAccounts(String a) {this.accounts = Facebook.removeQuotes(a);}
	/**
	 * <p>Set the activities value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @param a		The value of activities.
	 */
	public void setActivities(String a) {this.activities = Facebook.removeQuotes(a);}
	/**
	 * <p>Set the albums value.</p>
	 * <p>Only used in the User, Page, and Application objects.</p>
	 * 
	 * @param a		The value of albums.
	 */
	public void setAlbums(String a) {this.albums = Facebook.removeQuotes(a);}
	/**
	 * <p>Set the attending value.</p>
	 * <p>Only used in the Event object.</p>
	 * 
	 * @param a		The value of attending.
	 */
	public void setAttending(String a) {this.attending = Facebook.removeQuotes(a);}
	/**
	 * <p>Set the books value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @param b		The value of books.
	 */
	public void setBooks(String b) {this.books = Facebook.removeQuotes(b);}
	/**
	 * <p>Set the checkins value.</p>
	 * <p>Only used in the User and Page object.</p>
	 * 
	 * @param c	The value of checkins.
	 */
	public void setCheckins(String c) {this.checkins = Facebook.removeQuotes(c);}
	/**
	 * <p>Set the comments value.</p>
	 * <p>Used in almost all objects.</p>
	 * 
	 * @param c		The value of comments.
	 */
	public void setComments(String c) {this.comments = Facebook.removeQuotes(c);}
	/**
	 * <p>Set the declined value.</p>
	 * <p>Only used in the Event object.</p>
	 * 
	 * @param d		The value of declined.
	 */
	public void setDeclined(String d) {this.declined = Facebook.removeQuotes(d);}
	/**
	 * <p>Set the events value.</p>
	 * <p>Only used in the User and Page objects.</p>
	 * 
	 * @param e		The value of events.
	 */
	public void setEvents(String e) {this.events = Facebook.removeQuotes(e);}
	/**
	 * <p>Set the feed value.</p>
	 * <p>Only used in the User, Page, Event, Group and Application objects.</p>
	 * 
	 * @param f		The value of feed.
	 */
	public void setFeed(String f) {this.feed = Facebook.removeQuotes(f);}
	/**
	 * <p>Set the friends value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @param f		The value of friends.
	 */
	public void setFriends(String f) {this.friends = Facebook.removeQuotes(f);}
	/**
	 * <p>Set the groups value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @param g		The value of groups.
	 */
	public void setGroups(String g) {this.groups = Facebook.removeQuotes(g);}
	/**
	 * <p>Set the home value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @param h		The value of home.
	 */
	public void setHome(String h) {this.home = Facebook.removeQuotes(h);}
	/**
	 * <p>Set the inbox value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @param i		The value of inbox.
	 */
	public void setInbox(String i) {this.inbox = Facebook.removeQuotes(i);}
	/**
	 * <p>Set the interests value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @param i		The value of interests.
	 */
	public void setInterests(String i) {this.interests = Facebook.removeQuotes(i);}
	/**
	 * <p>Set the invited value.</p>
	 * <p>Only used in the Event object.</p>
	 * 
	 * @param i		The value of invited.
	 */
	public void setInvited(String i) {this.invited = Facebook.removeQuotes(i);}
	/**
	 * <p>Set the likes value.</p>
	 * <p>Used on almost all objects.</p>
	 * 
	 * @param l		The value of likes.
	 */
	public void setLikes(String l) {this.likes = Facebook.removeQuotes(l);}
	/**
	 * <p>Set the links value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @param l		The value of links.
	 */
	public void setLinks(String l) {this.links = Facebook.removeQuotes(l);}
	/**
	 * <p>Set the maybe value.</p>
	 * <p>Only used in the Event object.</p>
	 * 
	 * @param m		The value of maybe.
	 */
	public void setMaybe(String m) {this.maybe = Facebook.removeQuotes(m);}
	/**
	 * <p>Set the members value.</p>
	 * <p>Only used in the Group object.</p>
	 * 
	 * @param m		The value of members.
	 */
	public void setMembers(String m) {this.members = Facebook.removeQuotes(m);}
	/**
	 * <p>Set the movies value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @param m		The value of movies.
	 */
	public void setMovies(String m) {this.movies = Facebook.removeQuotes(m);}
	/**
	 * <p>Set the music value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @param m		The value of music.
	 */
	public void setMusic(String m) {this.music = Facebook.removeQuotes(m);}
	/**
	 * <p>Set the noreply value.</p>
	 * <p>Only used in the Event object.</p>
	 * 
	 * @param n		The value of noreply.
	 */
	public void setNoreply(String n) {this.noreply = Facebook.removeQuotes(n);}
	/**
	 * <p>Set the notes value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @param n		The value of notes.
	 */
	public void setNotes(String n) {this.notes = Facebook.removeQuotes(n);}
	/**
	 * <p>Set the outbox value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @param o		The value of outbox.
	 */
	public void setOutbox(String o) {this.outbox = Facebook.removeQuotes(o);}
	/**
	 * <p>Set the photos value.</p>
	 * <p>Only used in the User, Page, Album and Application objects.</p>
	 * 
	 * @param p		The value of photos.
	 */
	public void setPhotos(String p) {this.photos = Facebook.removeQuotes(p);}
	/**
	 * <p>Set the picture value.</p>
	 * <p>Only used in the User, Group, Event, Page and Application objects.</p>
	 * 
	 * @param p		The value of picture.
	 */
	public void setPicture(String p) {this.picture = Facebook.removeQuotes(p);}
	/**
	 * <p>Set the posts value.</p>
	 * <p>Only used in the User, Page, and Application objects.</p>
	 * 
	 * @param p		The value of posts.
	 */
	public void setPosts(String p) {this.posts = Facebook.removeQuotes(p);}
	/**
	 * <p>Set the statuses value.</p>
	 * <p>Only used in the User, Page and Application objects.</p>
	 * 
	 * @param s		The value of statuses.
	 */
	public void setStatuses(String s) {this.statuses = Facebook.removeQuotes(s);}
	/**
	 * <p>Set the subscriptions value.</p>
	 * <p>Only used in the Applications object.</p>
	 * 
	 * @param s		The value of subscriptions.
	 */
	public void setSubscriptions(String s) {this.subscriptions = Facebook.removeQuotes(s);}
	/**
	 * <p>Set the tagged value.</p>
	 * <p>Only used in the User, Page and Application object.</p>
	 * 
	 * @param t		The value of tagged.
	 */
	public void setTagged(String t) {this.tagged = Facebook.removeQuotes(t);}
	/**
	 * <p>Set the television value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @param t		The value of television.
	 */
	public void setTelevision(String t) {this.television = Facebook.removeQuotes(t);}
	/**
	 * <p>Set the updates value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @param u		The value of updates.
	 */
	public void setUpdates(String u) {this.updates = Facebook.removeQuotes(u);}
	/**
	 * <p>Set the videos value.</p>
	 * <p>Only used in the User, Page and Application object.</p>
	 * 
	 * @param v		The value of videos.
	 */
	public void setVideos(String v) {this.videos = Facebook.removeQuotes(v);}
	
	/**
	 * <p>Sets the values of fields which is an array of FacebookObjects. Uses a JSON string to set the value.</p>
	 * 
	 * @param ar		The JSON string with the values.
	 * 
	 * @see FacebookObject
	 */
	public void setFields(String ar) {
		int ind = ar.indexOf(":");
		Object[] obj = Facebook.objs(ar.substring(ind+1));
		
		fields = new FacebookObject[obj.length];
			
		for(int z=0; z<obj.length; z++) {
			fields[z] = new FacebookObject(obj[z].toString());
		}
	}
	
	
	/**
	 * <p>Get the accounts value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @return The URL to the User's accounts data.
	 */
	public String getAccounts() {return accounts;}
	/**
	 * <p>Get the activities value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @return The URL to the User's activities.
	 */
	public String getActivities() {return activities;}
	/**
	 * <p>Get the albums value.</p>
	 * <p>Only used in the User, Page, and Application objects.</p>
	 * 
	 * @return The URL to the object's albums.
	 */
	public String getAlbums() {return albums;}
	/**
	 * <p>Get the attending value.</p>
	 * <p>Only used in the Event object.</p>
	 * 
	 * @return The URL to the list of people attending the Event.
	 */
	public String getAttending() {return attending;}
	/**
	 * <p>Get the books value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @return The URL to the User's books.
	 */
	public String getBooks() {return books;}
	/**
	 * <p>Get the checkins value.</p>
	 * <p>Only used in the User and Page object.</p>
	 * 
	 * @return The URL to the object's checkins.
	 */
	public String getCheckins() {return checkins;}
	/**
	 * <p>Get the comments value.</p>
	 * <p>Used in almost all objects.</p>
	 * 
	 * @return The URL to the object's comments.
	 */
	public String getComments() {return comments;}
	/**
	 * <p>Get the declined value.</p>
	 * <p>Only used in the Event object.</p>
	 * 
	 * @return The URL to the list of Users who declined the Event.
	 */
	public String getDeclined() {return declined;}
	/**
	 * <p>Get the events value.</p>
	 * <p>Only used in the User and Page objects.</p>
	 * 
	 * @return The URL the object's events.
	 */
	public String getEvents() {return events;}
	/**
	 * <p>Get the feed value.</p>
	 * <p>Only used in the User, Page, Event, Group and Application objects.</p>
	 * 
	 * @return The URL to the object's feed.
	 */
	public String getFeed() {return feed;}
	/**
	 * <p>Get the friends value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @return The URL to the User's friend list.
	 */
	public String getFriends() {return friends;}
	/**
	 * <p>Get the groups value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @return The URL to the User's groups.
	 */
	public String getGroups() {return groups;}
	/**
	 * <p>Get the home value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @return The URL to the User's home feed.
	 */
	public String getHome() {return home;}
	/**
	 * <p>Get the inbox value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @return The URL to the User's inbox.
	 */
	public String getInbox() {return inbox;}
	/**
	 * <p>Get the interests value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @return The URL to the User's interests.
	 */
	public String getInterests() {return interests;}
	/**
	 * <p>Get the invited value.</p>
	 * <p>Only used in the Event object.</p>
	 * 
	 * @return The URL to the User's invited to the Event.
	 */
	public String getInvited() {return invited;}
	/**
	 * <p>Get the likes value.</p>
	 * <p>Used on almost all objects.</p>
	 * 
	 * @return The URL to the Users who liked the object - or Pages a User likes.
	 */
	public String getLikes() {return likes;}
	/**
	 * <p>Get the links value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @return The URL to the User's links.
	 */
	public String getLinks() {return links;}
	/**
	 * <p>Get the maybe value.</p>
	 * <p>Only used in the Event object.</p>
	 * 
	 * @return The URL to the User's who might attend an Event.
	 */
	public String getMaybe() {return maybe;}
	/**
	 * <p>Get the members value.</p>
	 * <p>Only used in the Group object.</p>
	 * 
	 * @return The URL to the list of Users who are a member of a Group.
	 */
	public String getMembers() {return members;}
	/**
	 * <p>Get the movies value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @return The URL to the User's movies.
	 */
	public String getMovies() {return movies;}
	/**
	 * <p>Get the music value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @return The URL to the User's music.
	 */
	public String getMusic() {return music;}
	/**
	 * <p>Get the noreply value.</p>
	 * <p>Only used in the Event object.</p>
	 * 
	 * @return The URL to the Users who have not replied to an Event invitation.
	 */
	public String getNoreply() {return noreply;}
	/**
	 * <p>Get the notes value.</p>
	 * <p>Only used in the User, Page and Application object.</p>
	 * 
	 * @return The URL to the object's notes
	 */
	public String getNotes() {return notes;}
	/**
	 * <p>Get the outbox value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @return The URL to the User's outbox.
	 */
	public String getOutbox() {return outbox;}
	/**
	 * <p>Get the photos value.</p>
	 * <p>Only used in the User, Page, Album and Application objects.</p>
	 * 
	 * @return The URL to the object's Photos.
	 */
	public String getPhotos() {return photos;}
	/**
	 * <p>Get the picture value.</p>
	 * <p>Only used in the User, Group, Event, Page and Application objects.</p>
	 * 
	 * @return The URL to the object's picture.
	 */
	public String getPicture() {return picture;}
	/**
	 * <p>Get the posts value.</p>
	 * <p>Only used in the User, Page, and Application objects.</p>
	 * 
	 * @return The URL to the object's Posts.
	 */
	public String getPosts() {return posts;}
	/**
	 * <p>Get the statuses value.</p>
	 * <p>Only used in the User, Page and Application objects.</p>
	 * 
	 * @return The URL to the object's Statuses.
	 */
	public String getStatuses() {return statuses;}
	/**
	 * <p>Get the subscriptions value.</p>
	 * <p>Only used in the Applications object.</p>
	 * 
	 * @return The URL to the Application's Subscriptions.
	 */
	public String getSubscriptions() {return subscriptions;}
	/**
	 * <p>Get the tagged value.</p>
	 * <p>Only used in the User, Page and Application object.</p>
	 * 
	 * @return The URL to the Posts an object is Tagged in.
	 */
	public String getTagged() {return tagged;}
	/**
	 * <p>Get the television value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @return The URL to the User's television shows.
	 */
	public String getTelevision() {return television;}
	/**
	 * <p>Get the updates value.</p>
	 * <p>Only used in the User object.</p>
	 * 
	 * @return The URL to the User's updates.
	 */
	public String getUpdates() {return updates;}
	/**
	 * <p>Get the videos value.</p>
	 * <p>Only used in the User, Page and Application object.</p>
	 * 
	 * @return The URL to the object's Videos.
	 */
	public String getVideos() {return videos;}
	
}