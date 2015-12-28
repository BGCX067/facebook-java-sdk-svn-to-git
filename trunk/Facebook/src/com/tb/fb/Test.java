package com.tb.fb;
import java.io.IOException;

public class Test {
	public static void main(String[] args) throws IOException {
		Facebook f = new Facebook("access_token");
		
		FacebookObject me = f.api("me");
		System.out.println(me.getId()); // Outputs the current logged in user's ID.
		
		me = f.api("me", "photos");
		System.out.println(me.photos.data[1].getWidth()); // Outputs the width of the current logged in user's second photo.
		
		FacebookObject album = f.api("99394368305");
		System.out.println(album.getCount()); // Outputs the number of photos in this album.
		
		FacebookObject photo = f.api("98423808305", 1);
		System.out.println(photo.comments.data[3].getMessage()); // Outputs the message of the 4th comment on this picture.
		System.out.println(photo.metadata.getComments()); // Outputs the URl to this photo's comments.
		
		
			
	}
}
