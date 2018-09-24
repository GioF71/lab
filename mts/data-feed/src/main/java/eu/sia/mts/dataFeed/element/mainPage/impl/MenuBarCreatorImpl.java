package eu.sia.mts.dataFeed.element.mainPage.impl;

import javax.enterprise.context.Dependent;

import com.vaadin.ui.MenuBar;

import eu.sia.mts.dataFeed.element.mainPage.MenuBarCreator;

@Dependent
public class MenuBarCreatorImpl implements MenuBarCreator {

	@Override
	public MenuBar createMenuBar() {
		MenuBar menuBar = new MenuBar();
		menuBar.addItem("Menu1");
		menuBar.addItem("Menu1");
		return menuBar;
	}
}
