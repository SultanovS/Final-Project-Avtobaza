package com.epam.avtobaza.client;

/**
 * Класс, занимающийся построением в интерфейсе Диспетчера меню назначения рейсов 
 */
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

	// Создание и заполнение меню распределения рейсов
public class Disp_left_reis_menu {
	
	public void Make_left_menu_reisov() {
		
	final Label naznachit_reis = new Label("Назначить рейс:");
	final Label id_voditelya = new Label("На водителя:");
	final ListBox id_reisa = new ListBox();
	final ListBox id_voditela = new ListBox();
	new Fill_values("reis", id_reisa);
	class ListHandler implements ChangeHandler {
		@Override
		public void onChange(ChangeEvent event) {
			new Fill_values(id_voditela, id_reisa.getSelectedItemText());
		}
	}
	ListHandler handler = new ListHandler();
	id_reisa.addChangeHandler(handler);
	
	final Button naznachit = new Button("Назначить", new ClickHandler() {
		@Override
		public void onClick(ClickEvent event) {
			if (id_voditela.getSelectedItemText().isEmpty()) {
				DialogAlert dialogalert = new DialogAlert();
				dialogalert.showAlert("id водителя пустое");
			}
			else {
			new Fill_values(id_voditela, "voditel");
			new Fill_values("reis", id_reisa.getSelectedItemText(), id_voditela.getSelectedItemText());
			}
		}
	});
	
	RootPanel.get("4").clear();
	final VerticalPanel nazna4it = new VerticalPanel();
	nazna4it.setSpacing(7);
	nazna4it.add(naznachit_reis);
	nazna4it.add(id_reisa);
	nazna4it.add(id_voditelya);
	nazna4it.add(id_voditela);
	nazna4it.add(naznachit);
	RootPanel.get("4").add(nazna4it);

 }
}