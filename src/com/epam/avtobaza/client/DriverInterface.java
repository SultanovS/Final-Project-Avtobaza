package com.epam.avtobaza.client;
/**
 * Класс, занимающийся построением всего интерфейса Водителей 
 */
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class DriverInterface {
	
	public void onLoad(String name, String id) {
	
		final Label name_of_driver = new Label(name);
		
		// Таблица машин
		Driver_Table_avto driver_Table_avto = new Driver_Table_avto();
		driver_Table_avto.FillAvtoTable(name);
		
		// Таблица Рейсов
		Driver_Table_reisi driver_Table_reisi = new Driver_Table_reisi();
		driver_Table_reisi.FillReisTable(name);
	
		// Меню справа
		Driver_right_menu driver_left_menu = new Driver_right_menu();
		driver_left_menu.makeRightMenu(name, id);

		final Button driver_exit = new Button("Exit", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				for (int i = 1; i <= 9; i++) {
					String s = Integer.toString(i);
					RootPanel.get(s).clear();
				}
				Avtobaza avt = new Avtobaza();
				avt.onModuleLoad();
			}
		});
		VerticalPanel FIO_Exit = new VerticalPanel();
		FIO_Exit.setSpacing(7);
		FIO_Exit.add(name_of_driver);
		FIO_Exit.add(driver_exit);
		RootPanel.get("1").add(FIO_Exit);
	}
	
}
