package com.epam.avtobaza.client;
/**
 * Класс, занимающийся построением в интерфесе Водителей меню смены статуса машины
 */
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Driver_right_menu {
	
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	
	public void makeRightMenu(final String name, final String id) {
		
		VerticalPanel change_avto_state = new VerticalPanel();
		VerticalPanel change_reis_state = new VerticalPanel();
		change_avto_state.setSpacing(7);
		change_reis_state.setSpacing(7);
		final Label id_avto = new Label("id_машины");
		final Label work_notwork = new Label("Исправна/неисправна");
		final Label id_reisa = new Label("id_рейса");
		final ListBox avto = new ListBox();
		avto.addItem("Исправен");
		avto.addItem("Не исправен");
		
		final ListBox avto_id = new ListBox();
		greetingService.Fill_list_table("avtomobil", new AsyncCallback<String[][]>() {
			@Override
			public void onSuccess(String[][] result) {
				avto_id.clear();
				for (int i = 0; i < result.length; i++) {
					if (result[i][5].equals(name)) {
						avto_id.addItem(result[i][0]);
					}
				}
			}
			@Override
			public void onFailure(Throwable caught) {
			}
		});
		
		final ListBox choose_reis = new ListBox();
		greetingService.Fill_list_table("reis", new AsyncCallback<String[][]>() {
			@Override
			public void onSuccess(String[][] result) {
				choose_reis.clear();
				for (int i = 0; i < result.length; i++) {
					if (result[i][5].equals(name)) {
						choose_reis.addItem(result[i][0]);
					}
				}
			}
			@Override
			public void onFailure(Throwable caught) {
			}
		});
		
		final Button change_avto_State = new Button("ОК", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
			new	Fill_values("avtomobil", avto_id.getSelectedItemText(), avto.getSelectedItemText(), name);
			}
		});
		
		final Button reis_ready = new Button("Готово", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
			new	Fill_values("reis", choose_reis.getSelectedItemText(), "Готов", name);
			}
		});
		
		change_avto_state.add(id_avto);
		change_avto_state.add(avto_id);
		change_avto_state.add(work_notwork);
		change_avto_state.add(avto);
		change_avto_state.add(change_avto_State);
		RootPanel.get("3").add(change_avto_state);
		
		change_reis_state.add(id_reisa);
		change_reis_state.add(choose_reis);
		change_reis_state.add(reis_ready);
				
		RootPanel.get("6").add(change_reis_state);
		
	}

}
