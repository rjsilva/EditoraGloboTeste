package br.com.newsletter.oglobo.utils;

public enum Browsers {
	
	Chrome("chrome"), FireFox("firefox");
	
	  private String action;
	  
	    public String getAction(){
	        return this.action;
	    }
	    private Browsers(String action){
	        this.action = action;
	    }

}
