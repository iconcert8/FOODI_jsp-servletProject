package me.foodi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ActionJson {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
