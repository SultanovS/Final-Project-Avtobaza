package com.epam.avtobaza.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;

public class DialogAlert {
	
	void showAlert(String msg) {
		
		final DialogBox dialogbox = new DialogBox();
		Button closeBtn = new Button("Закрыть", new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogbox.hide();
			}
		});
		dialogbox.setText(msg);
		dialogbox.add(closeBtn);
		dialogbox.setAnimationEnabled(true);
		dialogbox.setModal(true);
		dialogbox.center();
	}

}
