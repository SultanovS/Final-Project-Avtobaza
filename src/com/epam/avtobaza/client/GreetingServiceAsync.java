package com.epam.avtobaza.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {

	void Check_LoginPassw(String log, String passw, AsyncCallback<String[][]> asyncCallback);

	void Add_New_reis(String massa, String obem, String adres, AsyncCallback<Void> callback);

	void Add_New_driver(String fio, String login, String passw, AsyncCallback<Void> asyncCallback);

	void Add_New_avto(String model, String gruzopodemnost, String obem, AsyncCallback<Void> asyncCallback);

	void Fill_list_table(String base, AsyncCallback<String[][]> asyncCallback);

	void Naznachit_reis_avto(String base, String id_reisa, String id_voditelya, AsyncCallback<Void> asyncCallback);

	void Driver_avto_reis_update(String base, String id, String sostoyanie, AsyncCallback<Void> asyncCallback);

	void Delete_by_id(String base, String id, AsyncCallback<Void> asyncCallback);

	void Check_available_avto(String id_reisa, AsyncCallback<ArrayList<String>> asyncCallback);

}
