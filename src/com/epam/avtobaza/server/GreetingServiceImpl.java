package com.epam.avtobaza.server;

import java.util.ArrayList;
import com.epam.avtobaza.client.GreetingService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * Реализация удалённых запросов на серверной стороне
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {

	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	}
	
	// Проверка логина/пароля на форме авторизации
	@Override
	public String[][] Check_LoginPassw(String log, String passw) {
		log = escapeHtml(log);
		passw = escapeHtml(passw);
		JDBCconnection jdbc = new JDBCconnection();
		String[][] result = jdbc.GetConnect("select * from voditel");
		return result;
	}
	// Заполнение таблиц и Листбоксов
	@Override
	public String[][] Fill_list_table(String base) {
		
		JDBCconnection jdbc = new JDBCconnection();
		String[][] result = jdbc.GetConnect("select * from "+base+" order by id asc");
		if (!base.equals("voditel")) {
		String[][] result1 = jdbc.GetConnect("select id, FIO from voditel order by id asc");
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result1.length; j++) {
				if (result[i][5].equals(result1[j][0])) {
					result[i][5]=result1[j][1];
				}
			}
		}
		}
		return result;
	}
	//	Удаление записи в таблицах
	@Override
	public void Delete_by_id(String base, String id) {
		String zapros = "delete from "+base+" where id="+id;
		JDBCconnection jdbc = new JDBCconnection();
		jdbc.GetConnectUpdate(zapros);
	}
	// Добавление нового рейса
	@Override
	public void Add_New_reis(String massa, String obem, String adres) {
		String zapros = "insert into reis (massa_gruza, obem_gruza, Adres) values ("+massa+", "+obem+", '"+adres+"')";
		JDBCconnection jdbc = new JDBCconnection();
		jdbc.GetConnectUpdate(zapros);
	}
	// Добавление нового водителя
	@Override
	public void Add_New_driver(String fio, String login, String passw) {
		String zapros = "insert into voditel (FIO, Login, Passw) values ('"+fio+"', '"+login+"', '"+passw+"')";
		JDBCconnection jdbc = new JDBCconnection();
		jdbc.GetConnectUpdate(zapros);
	}
	// Добавление нового автомобиля
	@Override
	public void Add_New_avto(String model, String gruzopodemnost, String obem) {
		String zapros = "insert into avtomobil (Model, gruzopodemnost, obem) values ('"+model+"', '"+gruzopodemnost+"', '"+obem+"')";
		JDBCconnection jdbc = new JDBCconnection();
		jdbc.GetConnectUpdate(zapros);
	}
	// Назначение рейса на водителя
	@Override
	public void Naznachit_reis_avto(String base, String id_reisa_avto, String id_voditelya) {
		 String zapros = "update "+base+" set id_vodit="+id_voditelya+" where id="+id_reisa_avto;
			JDBCconnection jdbc = new JDBCconnection();
			jdbc.GetConnectUpdate(zapros);
	}
	// Обновление данных во всех таблицах 
	@Override
	public void Driver_avto_reis_update(String base, String id, String sostoyanie) {
		String zapros = "update "+base+" set sostoyanie='"+sostoyanie+"' where id="+id;
		JDBCconnection jdbc = new JDBCconnection();
		jdbc.GetConnectUpdate(zapros);		
	}
	// Проверка соответствия параметров автомобиля требованиям к рейсу 
	@Override
	public ArrayList<String> Check_available_avto(String id_reisa) {
		ArrayList<String> list = new ArrayList<String>();
		JDBCconnection jdbc = new JDBCconnection();
		String[][] result = new String[1][3];
		result = jdbc.GetConnect("select massa_gruza, obem_gruza from reis where id="+id_reisa);
		String[][] ispr_avto = jdbc.GetConnect("select gruzopodemnost, obem, id_vodit from avtomobil where sostoyanie='Исправен'");
				for (int i = 0; i < ispr_avto.length; i++) {
					if ((Float.parseFloat(ispr_avto[i][0]) >= Float.parseFloat(result[0][0])) && (Float.parseFloat(ispr_avto[i][1]) >= Float.parseFloat(result[0][1]))) {
						list.add(ispr_avto[i][2]);
					}
				}
		return list;
	}
}


