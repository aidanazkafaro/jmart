package AidanAzkafaroDesonJmartFH;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a description of class Recognizable here.
 *
 * @author (Aidan Azkafaro Deson)
 * @version (a version number or a date)
 */
public class Serializable implements Comparable<Serializable> {

	public final int id;
	private static HashMap<Class<?>, Integer> mapCounter = new HashMap<Class<?>, Integer>();

	protected Serializable() {
		Integer counter = mapCounter.get(getClass());
		if (counter == null) {
			mapCounter.put(getClass(), 0);
			this.id = 0;
		} else {
			mapCounter.put(getClass(), counter + 1);
			this.id = counter + 1;
		}

	}

	// mutasi nilai serial dalam mapCounter
	public static <T> Integer setClosingId(Class<T> clazz, int id) {
		return mapCounter.put(clazz, id);

	}

	public static <T> Integer getClosingId(Class<T> clazz) {

		return mapCounter.get(clazz);
	}

	public boolean equals(Object other) {

		return (other != null) && (other instanceof Serializable) && (this.id == ((Serializable) other).id);
	}

	public boolean equals(Serializable other) {
		if (this.id == other.id) {
			return true;
		}
		return false;
	}

	@Override
	// compareTo(Object) method is the only method on Java Comparable interface.
	public int compareTo(Serializable other) {
		// TODO Auto-generated method stub
		if (id == other.id) {
			return 1;
		}
		return 0;
	}

	

}