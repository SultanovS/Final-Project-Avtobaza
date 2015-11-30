package com.epam.avtobaza.client;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Avtobaza implements EntryPoint {

	static Logger logger = Logger.getLogger("avtobazaLogger");
	
	VerticalPanel login_vp = new VerticalPanel();
	
	private static final String SERVER_ERROR = "ПРоизошла ошибка при соединении с сервером."
			+ "Проверьте соединение и попробуйте снова";

	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	public void onModuleLoad() {
		
		// Создание формы авторизации
		final Label avtorization = new Label();
		final Button sendButton = new Button("Login!");
		final TextBox nameField = new TextBox();
		final PasswordTextBox passwField = new PasswordTextBox();
		final Label errorLabel = new Label();
		nameField.setText("Login");
		passwField.setText("");
		sendButton.addStyleName("sendButton");
	    login_vp.setSpacing(6);
	    login_vp.add(avtorization);
	    login_vp.add(nameField);
	    login_vp.add(passwField);
	    login_vp.add(sendButton);
	    login_vp.add(errorLabel);
	    errorLabel.setText("");
	    avtorization.setText("Авторизация:");
	    login_vp.setVisible(true);
	 	RootPanel.get("2").add(login_vp);
	 	nameField.selectAll();
		nameField.setFocus(true);

		// Создание слушателя событий для кнопки и обработка нажатия
		class MyHandler implements ClickHandler {
			
			public void onClick(ClickEvent event) {
				if (nameField.getText()=="admin" & passwField.getText()=="admin") {
					for (int i = 1; i <= 9; i++) {
						String s = Integer.toString(i);
						RootPanel.get(s).clear();
					}
					DispetcherInterface dispetcherInterface = new DispetcherInterface();
					login_vp.setVisible(false);
					dispetcherInterface.onLoad();
				}
				greetingService.Check_LoginPassw(nameField.getText(), passwField.getText(), new AsyncCallback<String[][]>() {
					public void onFailure(Throwable caught) {
						logger.log(Level.SEVERE, SERVER_ERROR);
					}
					public void onSuccess(String[][] result) {
						String name=null;
						String id = "";
						for (int i = 0; i < result.length; i++) {
							if (nameField.getText().equals(result[i][2]) & passwField.getText().equals(result[i][3])) {
								id = result[i][0];
								name=result[i][1];
								}
						}
						if (name == null) {
							name="Such user not exist. Try again.";
							errorLabel.setStyleName("serverResponseLabelError");
							errorLabel.setText(name);
							errorLabel.setVisible(true);
							passwField.setText("");
							nameField.selectAll();
							nameField.setFocus(true);
						}
						else {
							DriverInterface driverInterface = new DriverInterface();
							login_vp.setVisible(false);
							driverInterface.onLoad(name, id);
						}
					}
				});
			}
		}

		// Добавление слушателя для кнопки
		MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
	}
}
