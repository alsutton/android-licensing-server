package com.andlicensing.actions;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletDispatcherResult;

import com.opensymphony.xwork2.ActionSupport;

@Result(name="success", value="/index-html.jsp", type=ServletDispatcherResult.class)
public class Controller 
extends ActionSupport {
	
	/**
	 * Generated serial id.
	 */
	private static final long serialVersionUID = -310173662502408686L;

	/**
	 * Show the index of all recent posts.
	 * @return
	 */
	public String index() {
		return SUCCESS;		
	}
}
