package atv3;

import java.util.Collection;

public interface B<T> extends A {
	
	public <String> void m( String objeto);
	
	public void m(Collection<? super T> obj);
	
}
