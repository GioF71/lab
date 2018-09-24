package eu.sia.mts.dataFeed;

import javax.inject.Inject;

import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import eu.sia.mts.dataFeed.service.Greeter;


@CDIUI("")
public class UserInterface extends UI {
	
	private static final long serialVersionUID = 694192620841600203L;
	
	@Inject
	private Greeter greeter;

	@Override
	protected void init(VaadinRequest request) {
	    showLayout(request);
	}

	@Override
	protected void refresh(VaadinRequest request) {
		showLayout(request);
	}

	public void showLayout(VaadinRequest request) {
		VerticalLayout view = new VerticalLayout();
		TextField greeted = new TextField("");
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
	    setContent(view);
	}
}
