package com.buyanne.blog_backend.util;

public class PictureUtil {

	public static String randomBlogFirstPicture() {
		int m = 0;
		int n = 14;
		int temp=m+(int)(Math.random()*(n+1-m));
		return "https://cdn.jsdelivr.net/gh/buyanne/JsDelivr@3.8/ContentThumb/"+temp+".jpg";
	}
}
