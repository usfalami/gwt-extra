package usf.gwt.ui.servcie;

import java.util.List;

import usf.gwt.ui.test.Value;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

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
