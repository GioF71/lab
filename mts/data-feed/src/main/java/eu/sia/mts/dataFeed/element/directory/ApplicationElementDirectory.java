package eu.sia.mts.dataFeed.element.directory;

import eu.sia.mts.dataFeed.element.ApplicationElement;

public interface ApplicationElementDirectory {
	void register(ApplicationElement applicationElement);
	ApplicationElement get(Class<?> clazz);
}
