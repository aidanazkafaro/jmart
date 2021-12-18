package com.AidanAzkafaroDesonJmartFH;

import java.util.Vector;
import java.util.function.Function;

/**
 * Class untuk penerapan multi-threading
 * 
 * @author Aidan Azkafaro Deson
 * @version 1.0
 * @since 18 Desember 2021
 */
public class ObjectPoolThread<T> extends Thread{

	private Function <T, Boolean> routine;
	private boolean exitSignal;
	private Vector<T> objectPool = new Vector<T>();
	
	/**
	 * 
	 * @param name
	 * @param routine
	 */
	public ObjectPoolThread(String name, Function <T, Boolean> routine) {
		super(name);
		this.routine = routine;
	}
	
	/**
	 * 
	 * @param routine
	 */
	public ObjectPoolThread(Function <T, Boolean> routine) {
		this.routine = routine;
	}
	
//	public ObjectPoolThread(String name, Object routine2) {
//		// TODO Auto-generated constructor stub
//	}

	/**
	 * 
	 * @param object
	 */
	public synchronized void add (T object) {
		objectPool.add(object);
	}
	
	public synchronized void exit() {
        exitSignal = true;
        interrupt();
    }
    
	/**
	 * method run untuk menjalanakan thread
	 */
    public void run() {
        while (!Thread.interrupted() && !exitSignal) {
            if (objectPool.isEmpty()) {
                try {
                    Thread.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                for (T object : objectPool) {
                    if (routine.apply(object) == true) {
                        objectPool.remove(object);
                    } else {
                        continue;
                    }
                }
            }
        }
    }
    
	public int size () {
		return objectPool.size();
		
	}
}
