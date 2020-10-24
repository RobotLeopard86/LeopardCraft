package leopardcraft.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VariableContainer<T> {
	
	private static Logger logger = LogManager.getLogger();
	
	public T val;
	
	public VariableContainer(T value){
		logger.info("Constructing VariableContainer of type " + value.getClass().getName() + " with value " + value.toString());
		this.val = value;
	}
}