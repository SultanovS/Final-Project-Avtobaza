package com.epam.avtobaza.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Класс который занимается удалением записей из таблицы.
 */
public class Delete_values {
	Logger logger = Logger.getLogger("avtobazalogger");
	
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	
	public Delete_values(String base, String id) {
		
		greetingService.Delete_by_id(base, id, new AsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
				
			}
			@Override
			public void onFailure(Throwable caught) {
				logger.log(Level.INFO, "Произошла ошибка " + caught.toString());
				}
		});
	}
}
