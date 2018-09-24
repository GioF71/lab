package eu.sia.mts.dataFeed.element.mainPage.impl;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import eu.sia.mts.dataFeed.element.mainPage.MainPage;
import eu.sia.mts.dataFeed.element.mainPage.MenuBarCreator;
import eu.sia.mts.dataFeed.service.Greeter;

@Dependent
public class MainPageImpl implements MainPage {
	
	@Inject
	private MenuBarCreator menuBarCreator;
	
	@Inject
	private Greeter greeter;

	@Override
	public Component create() {
		VerticalLayout view = new VerticalLayout();
		view.setSizeFull();
		view.setSpacing(false);
		view.setMargin(false);
		
		MenuBar menuBar = menuBarCreator.createMenuBar();
		view.addComponent(menuBar);
		
		TextField greeted = new TextField("");
		greeted.setDescription("Name to be greeted here");
		view.addComponent(greeted);
	    Button say = new Button("Say Hello");
	    say.addClickListener(new ClickListener() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				view.addComponent(new Label(greeter.sayHello(greeted.getValue())));
			}
		});
	    view.addComponent(say);
	    return view;
	}

}
