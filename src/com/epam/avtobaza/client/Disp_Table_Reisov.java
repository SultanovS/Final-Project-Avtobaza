package com.epam.avtobaza.client;
/**
 * Класс, занимающийся построением и заполнением таблицы рейсов в интерфейсе Диспетчера 
 */
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Disp_Table_Reisov {

	public void LoadReisTable() {
		
		VerticalPanel  table_reisov = new VerticalPanel();
		final Label spisok_reisov = new Label("Список рейсов:");
		final FlexTable reisov_table = new FlexTable();
		table_reisov.add(spisok_reisov);
		reisov_table.addStyleName("simple-little-table");
		reisov_table.setText(0, 0, "id");
		reisov_table.setText(0, 1, "Масса груза");
		reisov_table.setText(0, 2, "Объём груза");
		reisov_table.setText(0, 3, "Адрес доставки");
		reisov_table.setText(0, 4, "Готов/Не готов");
		reisov_table.setText(0, 5, "Имя исполнителя");
		
		new Fill_values("reis", reisov_table, 5);
		table_reisov.add(reisov_table);
		RootPanel.get("2").clear();
		RootPanel.get("2").add(table_reisov);
	}

}
