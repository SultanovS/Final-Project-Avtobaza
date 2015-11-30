package com.epam.avtobaza.client;

/**
 * Класс, занимающийся построением в интерфейсе Диспетчера с левой стороны меню 
 * добавления/удаления  машин, водителей, рейсов
 */

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Disp_left_menu {
	
	public void Make_left_menu() {
		
	VerticalPanel left_menu = new VerticalPanel();
	left_menu.setSpacing(7);
	
	// Лэйбл и кнопка добавления/удаления рейсов
	final Label add_delete_reis = new Label("Добавить/Удалить рейс");
	left_menu.add(add_delete_reis);
	HorizontalPanel hPanel = new HorizontalPanel();
	final Button add_reis = new Button("Добавить");
	final Button del_reis = new Button("Удалить");
	add_reis.setTitle("Рейс");
	del_reis.setTitle("Рейс");
	hPanel.add(add_reis);
	hPanel.add(del_reis);
	left_menu.add(hPanel);
	
	// Лэйбл и кнопка добавления/удаления водителей
	final Label add_delete_driver = new Label("Добавить/Удалить водителя");
	left_menu.add(add_delete_driver);
	HorizontalPanel hPanel1 = new HorizontalPanel();
	final Button add_driver = new Button("Добавить");
	final Button del_driver = new Button("Удалить");
	add_driver.setTitle("Водитель");
	del_driver.setTitle("Водитель");
	hPanel1.add(add_driver);
	hPanel1.add(del_driver);
	left_menu.add(hPanel1);

	// Лэйбл и кнопка добавления/удаления машин
	final Label add_delete_avto = new Label("Добавить/Удалить машину");
	left_menu.add(add_delete_avto);
	HorizontalPanel hPanel2 = new HorizontalPanel();
	final Button add_avto = new Button("Добавить");
	final Button del_avto = new Button("Удалить");
	hPanel2.add(add_avto);
	hPanel2.add(del_avto);
	add_avto.setTitle("Авто");
	del_avto.setTitle("Авто");
	left_menu.add(hPanel2);
	
	// Кнопка выхода
	final Button exitbtn = new Button("Exit");
	exitbtn.setTitle("Выход");
	
	// Обработка нажатия всех кнопок Добавить и Удалить
	class ButtonsHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			RootPanel.get("3").clear();
			MessageBox mBox = new MessageBox();
			
			if (((Button)event.getSource()).getTitle().equals(add_avto.getTitle())) {
				if (((Button)event.getSource()).getText().equals("Добавить")) {
					mBox.showMessage("Добавить", "Авто");
				} else {
					mBox.showMessage("Удалить", "Авто");
				}
			}
			if (((Button)event.getSource()).getTitle().equals(add_driver.getTitle())) {
				if (((Button)event.getSource()).getText().equals("Добавить")) {
					mBox.showMessage("Добавить", "Водитель");
				} else {
					mBox.showMessage("Удалить", "Водитель");
				}
			}
			if (((Button)event.getSource()).getTitle().equals(add_reis.getTitle())) {
				if (((Button)event.getSource()).getText().equals("Добавить")) {
					mBox.showMessage("Добавить", "Рейс");
				} else {
					mBox.showMessage("Удалить", "Рейс");
				}
			}
			if (((Button)event.getSource()).getTitle().equals(exitbtn.getTitle())) {
				for (int i = 1; i <= 9; i++) {
					String s = Integer.toString(i);
					RootPanel.get(s).clear();
				}
				Avtobaza avt = new Avtobaza();
				avt.onModuleLoad();
			}
		}
	}
	//	Добавление слушателя ко всем кнопкам
	ButtonsHandler addhandler = new ButtonsHandler();
	add_avto.addClickHandler(addhandler);
	add_reis.addClickHandler(addhandler);
	add_driver.addClickHandler(addhandler);
	del_avto.addClickHandler(addhandler);
	del_reis.addClickHandler(addhandler);
	del_driver.addClickHandler(addhandler);
	exitbtn.addClickHandler(addhandler);
		
	left_menu.add(exitbtn);
	RootPanel.get("1").add(left_menu);
	
	}
	
}