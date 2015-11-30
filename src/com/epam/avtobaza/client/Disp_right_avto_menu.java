package com.epam.avtobaza.client;
/**
 * Класс, занимающийся построением в интерфейсе Диспетчера меню назначения машин за водителями 
 */
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Disp_right_avto_menu {
	
	//	Создание и заполнение меню распределения рейсов
	public void Make_right_menu() {
		
		final Label naznachit_avto = new Label("Назначить машину:");
		final ListBox id_avto = new ListBox();
		new Fill_values("avtomobil", id_avto);
		final Label id_voditelya = new Label("На водителя:");
		final ListBox id_voditela = new ListBox();
		new Fill_values("voditel", id_voditela);
		final Button naznachit = new Button("Назначить", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
			new	Fill_values("avtomobil", id_avto.getSelectedItemText(), id_voditela.getSelectedItemText());
			}
		});
		
		final VerticalPanel nazna4it = new VerticalPanel();
		nazna4it.setSpacing(7);
		nazna4it.add(naznachit_avto);
		nazna4it.add(id_avto);
		nazna4it.add(id_voditelya);
		nazna4it.add(id_voditela);
		nazna4it.add(naznachit);
		RootPanel.get("6").clear();
		RootPanel.get("6").add(nazna4it);
	}

}
