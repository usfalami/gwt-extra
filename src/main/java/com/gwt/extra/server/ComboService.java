package com.gwt.extra.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONWriter;

public class ComboService extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9058059791935404716L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doGet(req, resp);
		try {
			
			JSONWriter json = new JSONWriter(resp.getWriter());
			json.array();
			for(int i=1; i<23; i++) {
				json.object()
					.key("value").value("value$" + i)
					.key("text").value("text_" + i)
				.endObject();
			}
			json.endArray();
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
