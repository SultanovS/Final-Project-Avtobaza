package com.epam.avtobaza.client;
/**
 * Класс, занимающийся построением и заполнением таблицы водителей в интерфейсе Диспетчера 
 */
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Disp_Table_drivers {
	
	public void LoadDriverTable() {
		
		final Label table_driver = new Label("Список водителей");
		VerticalPanel  table_drivers = new VerticalPanel();
		table_drivers.add(table_driver);
		final FlexTable driver_table = new FlexTable();
		driver_table.addStyleName("simple-little-table");
		driver_table.setText(0, 0, "id");
		driver_table.setText(0, 1, "Ф И О");
		driver_table.setText(0, 2, "Логин");
		driver_table.setText(0, 3, "Пароль");
		
		new Fill_values("voditel", driver_table, 3);
		
		table_drivers.add(driver_table);
		RootPanel.get("5").clear();
		RootPanel.get("5").add(table_drivers);
	}
}
