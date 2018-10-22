package eu.sia.mts.dataFeed.element.mainPage.impl;

import javax.enterprise.context.Dependent;

import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;

import eu.sia.mts.dataFeed.element.mainPage.MenuBarCreator;

@Dependent
public class MenuBarCreatorImpl implements MenuBarCreator {

	@Override
	public MenuBar createMenuBar() {
		MenuBar menuBar = new MenuBar();
		MenuItem menu1 = menuBar.addItem("Menu1");
		menu1.addItem("Item1");
		menu1.addItem("Item2");
		MenuItem menu2 = menuBar.addItem("Menu2");
		menu2.addItem("Item3");
		menu2.addItem("Item4");
		return menuBar;
	}
}
