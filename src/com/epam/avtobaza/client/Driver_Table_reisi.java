package com.epam.avtobaza.client;
/**
 * Класс, занимающийся в интерфейса Водителя построением и заполнением таблицы рейсов,
 * которые закреплены за конкретным водителем  
 */
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Driver_Table_reisi {

	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	VerticalPanel  table_avto = new VerticalPanel();
	
	public void FillReisTable(final String name) {
	
	final Label spisok_reisov = new Label("Список рейсов:");
	VerticalPanel  table_reisov = new VerticalPanel();
	table_reisov.add(spisok_reisov);
	final FlexTable reisov_table = new FlexTable();
	reisov_table.addStyleName("simple-little-table");
	reisov_table.addStyleName("cw-FlexTable");
	reisov_table.setText(0, 0, "id");
	reisov_table.setText(0, 1, "Масса груза");
	reisov_table.setText(0, 2, "Объём груза");
	reisov_table.setText(0, 3, "Адрес доставки");
	reisov_table.setText(0, 4, "Готов/Не готов");

	greetingService.Fill_list_table("reis", new AsyncCallback<String[][]>() {
		@Override
		public void onFailure(Throwable caught) {
		}
		@Override
		public void onSuccess(String[][] result) {
			for (int i = 0; i <= result.length; i++) {
				if (name.equals(result[i][5])) {
					for (int j = 0; j <= 4; j++) {
						reisov_table.setText(i+1, j, result[i][j]);
					
					}
				}
			}
		}
		
	});
	
	table_reisov.add(reisov_table);
	RootPanel.get("5").add(table_reisov);
	
}
}