package com.epam.avtobaza.client;
/**
 * Класс используется для построения и вызова диалогового окна-формы добавления/удаления машин, водителей и рейсов
 */

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MessageBox {

	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	boolean res = true;
	
	void showMessage(String buttonName,final String title) {
		
		final DialogBox dialogbox = new DialogBox();
		final VerticalPanel vPanel = new VerticalPanel();
		// Если вызывается удаление
		if (buttonName.equals("Удалить")) {
			final ListBox id_list = new ListBox();
			final Label id_ = new Label();
			
			if (title.equals("Рейс")) {
				new Fill_values("reis", id_list);
				id_.setText("id Рейса");
				vPanel.add(id_);
				vPanel.add(id_list);
			}
			if (title.equals("Авто")) {
				new Fill_values("avtomobil", id_list);
				id_.setText("id Авто");
				vPanel.add(id_);
				vPanel.add(id_list);
			}
			if (title.equals("Водитель")) {
				new Fill_values("voditel", id_list);
				id_.setText("id Водителя");
				vPanel.add(id_);
				vPanel.add(id_list);
			}
			final Button del = new Button("Удалить", new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					if (title.equals("Рейс")) {
					RootPanel.get("4").clear();
					new Delete_values("reis", id_list.getSelectedItemText());
					Disp_Table_Reisov disp_Table_Reisov = new Disp_Table_Reisov();
					disp_Table_Reisov.LoadReisTable();
					Disp_left_reis_menu disp_left_reis_menu = new Disp_left_reis_menu();
					disp_left_reis_menu.Make_left_menu_reisov();
					id_list.clear();
					new Fill_values("reis", id_list);
					}
					if (title.equals("Водитель")) {
					RootPanel.get("5").clear();
					new Delete_values("voditel", id_list.getSelectedItemText());
					Disp_Table_drivers disp_Table_drivers = new Disp_Table_drivers();
					disp_Table_drivers.LoadDriverTable();
					Disp_right_avto_menu disp_right_avto_menu = new Disp_right_avto_menu();
					disp_right_avto_menu.Make_right_menu();
					Disp_left_reis_menu disp_left_reis_menu = new Disp_left_reis_menu();
					disp_left_reis_menu.Make_left_menu_reisov();
					id_list.clear();
					new Fill_values("voditel", id_list);
					}	
					if (title.equals("Авто")) {
					RootPanel.get("8").clear();
					new Delete_values("avtomobil", id_list.getSelectedItemText());
					Disp_Table_avto disp_Table_avto = new Disp_Table_avto();
					disp_Table_avto.LoadAvtoTable();
					Disp_right_avto_menu disp_right_avto_menu = new Disp_right_avto_menu();
					disp_right_avto_menu.Make_right_menu();
					id_list.clear();
					new Fill_values("avtomobil", id_list);
					}
				}
			});
			vPanel.add(del);
		}
		else {
		// Форма для добавления
		final String[] labelNames = {"Добавить/Удалить рейс", "Добавить/Удалить водителя", "Добавить/Удалить машину",
								"Модель Машины", "Грузоподъёмность", "Вместительность",
								"Ф И О", "Логин", "Пароль",
								"Масса груза", "Объём груза", "Адрес доставки",};
		final TextBox value1 = new TextBox();
		final TextBox value2 = new TextBox();
		final TextBox value3 = new TextBox();
		final Button add = new Button("Добавить", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (title.equals("Рейс")) {
					
					greetingService.Add_New_reis(
							value1.getText(), 
							value2.getText(), 
							value3.getText(), new AsyncCallback<Void>() {
								@Override
								public void onSuccess(Void result) {
									Disp_Table_Reisov disp_Table_Reisov = new Disp_Table_Reisov();
									RootPanel.get("2").clear();
									disp_Table_Reisov.LoadReisTable();
									RootPanel.get("4").clear();
									Disp_left_reis_menu disp_left_reis_menu = new Disp_left_reis_menu();
									disp_left_reis_menu.Make_left_menu_reisov();
								}
								@Override
								public void onFailure(Throwable caught) {
								}
							});
				}
				
				if (title.equals("Водитель")) {
					greetingService.Add_New_driver(
							value1.getText(), 
							value2.getText(), 
							value3.getText(), new AsyncCallback<Void>() {
								@Override
								public void onSuccess(Void result) {
									Disp_Table_drivers disp_Table_drivers = new Disp_Table_drivers();
									disp_Table_drivers.LoadDriverTable();
									Disp_right_avto_menu disp_right_avto_menu = new Disp_right_avto_menu();
									disp_right_avto_menu.Make_right_menu();
									Disp_left_reis_menu disp_left_reis_menu = new Disp_left_reis_menu();
									disp_left_reis_menu.Make_left_menu_reisov();
								}
								@Override
								public void onFailure(Throwable caught) {
								}
							});
				}
				if (title.equals("Авто")) {
					greetingService.Add_New_avto(
							value1.getText(), 
							value2.getText(), 
							value3.getText(), new AsyncCallback<Void>() {
								@Override
								public void onSuccess(Void result) {
									Disp_Table_avto disp_Table_avto = new Disp_Table_avto();
									disp_Table_avto.LoadAvtoTable();
									Disp_right_avto_menu disp_right_avto_menu = new Disp_right_avto_menu();
									disp_right_avto_menu.Make_right_menu();
								}
								@Override
								public void onFailure(Throwable caught) {
								}
							});
				}
			}
		});
		
				if (title.equals("Авто")) {
					vPanel.add(new Label(labelNames[3]));
					vPanel.add(value1);
					vPanel.add(new Label(labelNames[4]));
					vPanel.add(value2);
					vPanel.add(new Label(labelNames[5]));
					vPanel.add(value3);
				}
				if (title.equals("Водитель")) {
					vPanel.add(new Label(labelNames[6]));
					vPanel.add(value1);
					vPanel.add(new Label(labelNames[7]));
					vPanel.add(value2);
					vPanel.add(new Label(labelNames[8]));
					vPanel.add(value3);
				}
				if (title.equals("Рейс")) {
					vPanel.add(new Label(labelNames[9]));
					vPanel.add(value1);
					vPanel.add(new Label(labelNames[10]));
					vPanel.add(value2);
					vPanel.add(new Label(labelNames[11]));
					vPanel.add(value3);
				}
		vPanel.add(add);
		}
		
		Button closeBtn = new Button("Закрыть", new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogbox.hide();
			}
		});
		vPanel.add(closeBtn);
		vPanel.setSpacing(7);
		dialogbox.add(vPanel);
		dialogbox.center();
		
	}
	
}
