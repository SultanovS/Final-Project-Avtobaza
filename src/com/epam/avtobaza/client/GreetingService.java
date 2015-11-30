package com.epam.avtobaza.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Клиентская заглушка для удалённого вызова
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	
	String[][] Check_LoginPassw(String log, String passw);
	
	void Add_New_reis(String massa, String obem, String adres);

	void Add_New_driver(String fio, String login, String passw);

	void Add_New_avto(String model, String gruzopodemnost, String obem);

	String[][] Fill_list_table(String base);

	void Naznachit_reis_avto(String base, String id_reisa, String id_voditelya);

	void Driver_avto_reis_update(String base, String id, String sostoyanie);

	void Delete_by_id(String base, String id);

	ArrayList<String> Check_available_avto(String id_reisa);
}
