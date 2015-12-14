package io.mattslater.model;

public enum Category {
	OPED,
	ARTS,
	SPORTS,
	FEATURE;
	
	  public String womp() {
	        return name().charAt(0) + name().substring(1).toLowerCase();
	    }
}
