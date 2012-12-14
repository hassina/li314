package pobj.obs;

import java.util.ArrayList;
import java.util.List;

public class SimpleObservable implements ISimpleObservable {
	private List<ISimpleObserver> obs;

	public SimpleObservable() {
		super();
		obs = new ArrayList<ISimpleObserver>();
	}

	@Override
	public void addObserver(ISimpleObserver so) {
		obs.add(so);
	}

	@Override
	public void deleteObserver(ISimpleObserver so) {
		obs.remove(so);
	}

	public void notifyObservers() {
		for (ISimpleObserver o : obs) {
			o.update();
		}
	}

}
