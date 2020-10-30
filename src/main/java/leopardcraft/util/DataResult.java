package leopardcraft.util;

import javax.annotation.Nullable;

import leopardcraft.block.IntegerContainerBlock;

public class DataResult<T> {
	
	public boolean err = false;
	public T val;
	
	public DataResult(boolean err, @Nullable T value) {
		if(err) {
			this.val = null;
			this.err = true;
		} else {
			this.val = value;
		}
	}
	
	public DataResult(T value) {
		this(false, value);
	}
	
	public DataResult() {
		this(false, null);
	}
}