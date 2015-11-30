package com.epam.avtobaza.client;

/**
 * Класс, занимающийся построением и заполнением таблицы машин в интерфейсе Диспетчера 
 */
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Disp_Table_avto {
	
	public void LoadAvtoTable() {
	
	RootPanel.get("8").clear();
	final Label spisok_avto = new Label("Список автомобилей:");
	VerticalPanel  table_avto = new VerticalPanel();
	table_avto.add(spisok_avto);
	final FlexTable avto_table = new FlexTable();
	avto_table.addStyleName("simple-little-table");
	avto_table.setText(0, 0, "id");
	avto_table.setText(0, 1, "Марка");
	avto_table.setText(0, 2, "Грузоп-сть");
	avto_table.setText(0, 3, "Объём");
	avto_table.setText(0, 4, "Состояние");
	avto_table.setText(0, 5, "Имя Водителя");
	new Fill_values("avtomobil", avto_table, 5);
	table_avto.add(avto_table);
	RootPanel.get("8").add(table_avto);
}
}
