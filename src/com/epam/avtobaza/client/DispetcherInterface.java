package com.epam.avtobaza.client;
/**
 * Класс, занимающийся построением всего интерфейса Диспетчера 
 */
public class DispetcherInterface {
	
	public void onLoad() {
		
		// Таблица Рейсов
		Disp_Table_Reisov disp_Table_Reisov = new Disp_Table_Reisov();
		disp_Table_Reisov.LoadReisTable();
		
		// Таблица Водителей
		Disp_Table_drivers disp_Table_drivers = new Disp_Table_drivers();
		disp_Table_drivers.LoadDriverTable();
		
		// Таблица Машин
		Disp_Table_avto disp_Table_avto = new Disp_Table_avto();
		disp_Table_avto.LoadAvtoTable();
				
		// Панель меню добавления/удаления слева
		Disp_left_menu disp_left_menu = new Disp_left_menu();
		disp_left_menu.Make_left_menu();
		
		// Панель назначения автомобилей справа 
		Disp_right_avto_menu disp_right_avto_menu = new Disp_right_avto_menu();
		disp_right_avto_menu.Make_right_menu();
		
		// Меню распределения рейсов
		Disp_left_reis_menu disp_left_reis_menu = new Disp_left_reis_menu();
		disp_left_reis_menu.Make_left_menu_reisov();

	}

}
