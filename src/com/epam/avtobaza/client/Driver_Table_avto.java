package com.epam.avtobaza.client;
/**
 * Класс, занимающийся в интерфейса Водителя построением и заполнением таблицы автомобилей,
 * которые закреплены за конкретным водителем  
 */
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Driver_Table_avto {
	
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	
	public void FillAvtoTable(final String name) {
	
	VerticalPanel  table_avto = new VerticalPanel();
	final Label spisok_avto = new Label("Список автомобилей:");
	table_avto.add(spisok_avto);
	final FlexTable avto_table = new FlexTable();
	avto_table.addStyleName("simple-little-table");
	avto_table.setText(0, 0, "id");
	avto_table.setText(0, 1, "Марка");
	avto_table.setText(0, 2, "Грузоподъемность");
	avto_table.setText(0, 3, "Объём");
	avto_table.setText(0, 4, "Состояние");

	greetingService.Fill_list_table("avtomobil", new AsyncCallback<String[][]>() {

		@Override
		public void onFailure(Throwable caught) {
		}
		@Override
		public void onSuccess(String[][] result) {
			for (int i = 0; i <= result.length; i++) {
				if (name.equals(result[i][5])) {
					for (int j = 0; j <= 4; j++) {
					avto_table.setText(i+1, j, result[i][j]);
					}
				}
			}
		}
		
	});
	
	table_avto.add(avto_table);
	RootPanel.get("2").add(table_avto);

}

}