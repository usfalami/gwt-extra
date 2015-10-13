package com.gwt.extra.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.gwt.extra.shared.Value;

@RemoteServiceRelativePath("DataService")
public interface DataService extends RemoteService {


	List<Value> getValues(String value);
	
	
}
