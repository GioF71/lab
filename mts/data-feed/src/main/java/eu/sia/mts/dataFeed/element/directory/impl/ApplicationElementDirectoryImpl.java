package eu.sia.mts.dataFeed.element.directory.impl;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import eu.sia.mts.dataFeed.element.ApplicationElement;
import eu.sia.mts.dataFeed.element.directory.ApplicationElementDirectory;

@Singleton(name = "AED")
@Startup
public class ApplicationElementDirectoryImpl implements ApplicationElementDirectory {

	private final Map<Class<?>, ApplicationElement> map = new HashMap<>();
	
	@Override
	public void register(ApplicationElement applicationElement) {
		map.put(applicationElement.getClass(), applicationElement);
	}

	@Override
	public ApplicationElement get(Class<?> clazz) {
		return map.get(clazz);
	}
}
