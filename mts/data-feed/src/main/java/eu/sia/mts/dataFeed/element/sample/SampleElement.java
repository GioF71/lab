package eu.sia.mts.dataFeed.element.sample;

import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import eu.sia.mts.dataFeed.element.AbsApplicationElement;

@Singleton
@DependsOn(value = "AED")
@Startup
public class SampleElement extends AbsApplicationElement {

	@Override
	public Component create() {
		VerticalLayout vl = new VerticalLayout();
		vl.addComponent(new Label(this.getClass().getSimpleName()));
		return vl;
	}

}
