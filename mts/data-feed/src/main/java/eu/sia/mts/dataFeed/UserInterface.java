package eu.sia.mts.dataFeed;

import javax.inject.Inject;

import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

import eu.sia.mts.dataFeed.element.mainPage.MainPage;

@CDIUI("")
public class UserInterface extends UI {
	
	private static final long serialVersionUID = 694192620841600203L;
	
	@Inject
	private MainPage mainPage;

	@Override
	protected void init(VaadinRequest request) {
	    showLayout(request);
	}

	@Override
	protected void refresh(VaadinRequest request) {
		showLayout(request);
	}

	public void showLayout(VaadinRequest request) {
		setContent(mainPage.create());
	}
}
