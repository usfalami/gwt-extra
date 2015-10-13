package com.gwt.extra.client.service;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwt.extra.shared.Value;

public interface DataServiceAsync {

	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static DataServiceAsync instance;
		public static DataServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(DataService.class);
			}
			return instance;
		}
	}

	void getValues(String value, AsyncCallback<List<Value>> callback);
}
