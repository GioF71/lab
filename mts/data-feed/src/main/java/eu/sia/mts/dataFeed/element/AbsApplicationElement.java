package eu.sia.mts.dataFeed.element;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import eu.sia.mts.dataFeed.element.directory.ApplicationElementDirectory;

public abstract class AbsApplicationElement implements ApplicationElement {

	 @Inject
	 private ApplicationElementDirectory directory;
	 
	 @PostConstruct
	 private void postConstruct() {
		 directory.register(this);
	 }

}
