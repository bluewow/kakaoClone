package com.clone.chat.util;

import java.util.LinkedHashMap;

public class Response extends LinkedHashMap<String, Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7142831488393615132L;
	
	public Response(String key, Object obj) {
		put(key, obj);
	}
	
//	TODO ErrorCodes
//	public Response(ErrorCodes code) {
//		put("ERROR", "");)
//	}
}
