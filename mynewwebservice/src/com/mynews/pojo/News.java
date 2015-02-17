/**
 * 
 */
package com.mynews.pojo;


/**
 * @author kuatre
 *
 */
public class News {
	private String username, userPic;
	private String newsgist;
	private int newsimg;
	private int newsaudio;
	private int newsvideo;
	private String timeofnews;
		
	public News(){
		
	}

	/**
	 * @param username
	 * @param userPic
	 * @param newsgist
	 * @param newsimg
	 * @param newsaudio
	 * @param newsvideo
	 * @param timeofnews
	 */
	public News(String username, String userPic, String newsgist,
			int newsimg, int newsaudio, int newsvideo, String timeofnews) {
		this.username	=	username;
		this.userPic	=	userPic;
		this.newsgist	=	newsgist;
		this.newsimg 	=	newsimg;
		this.newsaudio 	=	newsaudio;
		this.newsvideo 	=	newsvideo;
		this.timeofnews =	timeofnews;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the userPic
	 */
	public String getUserPic() {
		return userPic;
	}

	/**
	 * @param userPic the userPic to set
	 */
	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}

	/**
	 * @return the newsgist
	 */
	public String getNewsgist() {
		return newsgist;
	}

	/**
	 * @param newsgist the newsgist to set
	 */
	public void setNewsgist(String newsgist) {
		this.newsgist = newsgist;
	}

	/**
	 * @return the newsimg
	 */
	public int getNewsimg() {
		return newsimg;
	}

	/**
	 * @param newsimg the newsimg to set
	 */
	public void setNewsimg(int newsimg) {
		this.newsimg = newsimg;
	}

	/**
	 * @return the newsaudio
	 */
	public int getNewsaudio() {
		return newsaudio;
	}

	/**
	 * @param newsaudio the newsaudio to set
	 */
	public void setNewsaudio(int newsaudio) {
		this.newsaudio = newsaudio;
	}

	/**
	 * @return the newsvideo
	 */
	public int getNewsvideo() {
		return newsvideo;
	}

	/**
	 * @param newsvideo the newsvideo to set
	 */
	public void setNewsvideo(int newsvideo) {
		this.newsvideo = newsvideo;
	}

	/**
	 * @return the timeofnews
	 */
	public String getTimeofnews() {
		return timeofnews;
	}

	/**
	 * @param timeofnews the timeofnews to set
	 */
	public void setTimeofnews(String timeofnews) {
		this.timeofnews = timeofnews;
	}


	
}
