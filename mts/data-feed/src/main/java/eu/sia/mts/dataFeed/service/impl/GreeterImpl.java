package eu.sia.mts.dataFeed.service.impl;

import java.util.Optional;

import javax.enterprise.context.Dependent;

import eu.sia.mts.dataFeed.service.Greeter;

@Dependent
public class GreeterImpl implements Greeter {

	@Override
	public String sayHello(String to) {
		return String.format("%s [%s] says: hello to %s!", 
				Class.class.getSimpleName(), 
				this.getClass().getSimpleName(),
				Optional.ofNullable(to)
					.filter(t -> t.length() > 0)
					.orElse("<nobody>"));
	}
}
