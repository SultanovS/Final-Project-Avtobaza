package com.epam.avtobaza.client;
/**
 * Класс, занимающийся посылкой запросов на сервер по заполнению из БД таблиц, Листбоксов и т.д.
 */
import java.util.ArrayList;

import com.epam.avtobaza.client.Disp_Table_Reisov;
import com.epam.avtobaza.client.Driver_Table_avto;
import com.epam.avtobaza.client.Driver_Table_reisi;
import com.epam.avtobaza.client.GreetingService;
import com.epam.avtobaza.client.GreetingServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;

public class Fill_values {
	
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	
	// Вычисление водителей, машины которых соответствуют требованиям к рейсу
	public Fill_values(final ListBox id_vod, String id_reisa) {
		greetingService.Check_available_avto(id_reisa, new AsyncCallback<ArrayList<String>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onSuccess(ArrayList<String> result) {
				id_vod.clear();
				for (int i = 0; i < result.size(); i++) {
					id_vod.addItem(result.get(i));
				}
			}
			
		});
	}
	
	// Заполнение ListBox-ов id-шниками
	public Fill_values(String base, final ListBox list) {
			
			greetingService.Fill_list_table(base, new AsyncCallback<String[][]>() {
				@Override
				public void onSuccess(String[][] result) {
					list.clear();
					for (int i = 0; i < result.length; i++) {
						list.addItem(result[i][0]);
					}
				}
				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
				}
			});
		}
	
	//Заполнение таблиц.  kzs- количество заполняемых столбцов
	public Fill_values(String base, final FlexTable table, final int kzs) {
		
		greetingService.Fill_list_table(base, new AsyncCallback<String[][]>() {

			@Override
			public void onSuccess(String[][] result) {
				for (int i = 0; i < result.length; i++) {
					for (int j = 0; j <= kzs; j++) {
						table.setText(i+1, j, result[i][j]);
					}
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
			}
			
		});
	}
	
	// Назначение рейсов или машин на водителя  
	public Fill_values(final String base, String id_reisa_avto, String id_voditelya) {
		
		greetingService.Naznachit_reis_avto(base, id_reisa_avto, id_voditelya, new AsyncCallback<Void>() {
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
			}
			@Override
			public void onSuccess(Void result) {
				if (base.equals("reis")) {
				Disp_Table_Reisov disp_Table_Reisov = new Disp_Table_Reisov();
				disp_Table_Reisov.LoadReisTable();
				}
				if (base.equals("avtomobil")) {
					Disp_Table_avto disp_Table_avto = new Disp_Table_avto();
					disp_Table_avto.LoadAvtoTable();
				}
			}
			
		});
	}
	
	// Заполнение таблиц в интерфейсе водителей
	public Fill_values(String base, String id, final String sostoyanie, final String name) {
		greetingService.Driver_avto_reis_update(base, id, sostoyanie, new AsyncCallback<Void>() {
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
			}
			@Override
			public void onSuccess(Void result) {
				RootPanel.get("2").clear();
				RootPanel.get("5").clear();
				Driver_Table_avto driver_Table_avto = new Driver_Table_avto();
				driver_Table_avto.FillAvtoTable(name);
				Driver_Table_reisi driver_Table_reisi = new Driver_Table_reisi();
				driver_Table_reisi.FillReisTable(name);
			}
			
		});
		
	}
}
