package net.gondor.support;

import javax.servlet.http.HttpServletRequest;

public class Param {
	public String getStringParam(HttpServletRequest request,String key) {
		String error = request.getParameter(key);
		if(error==null||error.length()==0){
			error="";
		}
		return error;
	}
	public int getIntParam(HttpServletRequest request,String key) {
		int error=0;
		String errorParan = request.getParameter(key);
		if(errorParan==null||errorParan.length()==0){
			errorParan="";
			return error;
		}else{
			return Integer.parseInt(errorParan);			
		}
	}
}
