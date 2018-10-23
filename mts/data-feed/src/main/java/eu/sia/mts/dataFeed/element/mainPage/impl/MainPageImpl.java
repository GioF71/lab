package eu.sia.mts.dataFeed.element.mainPage.impl;

import java.util.Optional;
import java.util.function.Consumer;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import eu.sia.mts.dataFeed.element.ApplicationElement;
import eu.sia.mts.dataFeed.element.directory.ApplicationElementDirectory;
import eu.sia.mts.dataFeed.element.mainPage.MainPage;
import eu.sia.mts.dataFeed.element.mainPage.MenuBarCreator;
import eu.sia.mts.dataFeed.element.sample.SampleElement;
import eu.sia.mts.dataFeed.service.Greeter;

@Dependent
public class MainPageImpl implements MainPage {
	
	@Inject
	private MenuBarCreator menuBarCreator;
	
	@Inject
	private ApplicationElementDirectory directory;
	
	@Inject
	private Greeter greeter;
	
	interface TextConsumer extends Consumer<String> {}

	@Override
	public Component create() {
		VerticalLayout view = new VerticalLayout();
		view.setWidth(100, Unit.PERCENTAGE);
		view.setHeight(100, Unit.PERCENTAGE);
		view.setMargin(false);
		
		MenuBar menuBar = menuBarCreator.createMenuBar();
		view.addComponent(menuBar);
		view.setComponentAlignment(menuBar, Alignment.TOP_LEFT);

	    TextArea textArea = new TextArea();
	    textArea.setHeight(100, Unit.PERCENTAGE);
	    textArea.setWidth(100, Unit.PERCENTAGE);
	    
	    TextConsumer textConsumer = new TextConsumer() {
			
			@Override
			public void accept(String newText) {
				String resultingText = textArea.getValue();
				resultingText = Optional.ofNullable(resultingText)
								.filter(t -> t.length() > 0)
								.map(t -> newText.concat("\n").concat(t))
								.orElse(newText);
				textArea.setValue(resultingText);
			}
		};

	    Component greeter = createGreeterLayout(textConsumer);
	    view.addComponent(greeter);
	    
	    ApplicationElement elem = directory.get(SampleElement.class);
	    Component sampleC = elem.create();
	    view.addComponent(sampleC);
	    
	    view.addComponent(textArea);
	    view.setComponentAlignment(textArea, Alignment.BOTTOM_CENTER);
	    
	    view.setExpandRatio(textArea, 1);
	    return view;
	}

	private Component createGreeterLayout(TextConsumer consumer) {
		HorizontalLayout hl = new HorizontalLayout();
		TextField toBeGreeted = new TextField("Name");
		toBeGreeted.setDescription("Name to be greeted here");
		hl.addComponent(toBeGreeted);
	    Button sayHello = new Button("Say Hello");
	    sayHello.addClickListener(new ClickListener() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				String newText = greeter.sayHello(toBeGreeted.getValue());
				consumer.accept(newText);
			}
		});
	    hl.addComponent(sayHello);
		return hl;
	}
}
