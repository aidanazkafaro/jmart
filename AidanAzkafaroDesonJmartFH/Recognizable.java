package AidanAzkafaroDesonJmartFH;

/**
 * Write a description of class Recognizable here.
 *
 * @author (Aidan Azkafaro Deson)
 * @version (a version number or a date)
 */
public class Recognizable implements Comparable<Recognizable> {
	public final int id;

	protected Recognizable() {
		this.id = -1;
	}

	public static <T> int setClosingId(Class<T> clazz, int id) {
		//checking if the generic class "Class" inherits from Recognizable class
		if (Class.class.isAssignableFrom(Recognizable.class)) {
			return 0;
		} else {
			return 1;
		}
	}

	public static <T> int getClosingId(Class<T> clazz) {
		if (Class.class.isAssignableFrom(Recognizable.class)) {
			return 0;
		} else {
			return 1;
		}
	}

	public boolean equals(Object other) {

		return (other != null) && (other instanceof Recognizable) && (this.id == ((Recognizable) other).id);
	}

	public boolean equals(Recognizable other) {
		if (this.id == other.id) {
			return true;
		}
		return false;
	}

	@Override
	//compareTo(Object) method is the only method on Java Comparable interface.
	public int compareTo(Recognizable other) {
		// TODO Auto-generated method stub
		if (id == other.id) {
			return 1;
		}
		return 0;
	}
}