package AidanAzkafaroDesonJmartFH;

import java.util.Vector;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class JsonTable<T> extends Vector {

	public final String filepath;
	private static final Gson gson = new Gson();

//	@SuppressWarnings("unchecked")
	public JsonTable(Class<T> clazz, String filepath) throws IOException {
		this.filepath = filepath;

		// membaca sebuah file yang ditentukan pada filepath
//		File file = new File(filepath);
//		try {
//			File file = new File(filepath);
//			if (!Files.exists(Paths.get(filepath))) {
//				file.mkdir();
//				System.out.println("Created the file succesfully.");
//				
//			} else {
//				System.out.println("File already exists.");
//			}
//		} catch (IOException e) {
//			System.out.println("An error occurred.");
//			e.printStackTrace();
//		}
//		if (!Files.exists(Paths.get(filepath))) {
//		file.mkdir();
//		System.out.println("Created the file succesfully.");
//	
//}
//		Class<T[]> array = ((Class<T[]>) Array.newInstance(clazz, 0).getClass());
//		T[] result = JsonTable.readJson(array, filepath);
//
//		Collections.addAll(this, result);
//		readJson(clazz, filepath);
//		new JsonTable<>(clazz, filepath);
	}

	public static <T> T readJson(Class<T> clazz, String filepath) throws FileNotFoundException {

		final JsonReader read = new JsonReader(new FileReader(filepath));
		return gson.fromJson(read, clazz);

	}

	public void writeJson() throws IOException {
		writeJson(this, this.filepath);
	}

	public static void writeJson(Object object, String filepath) throws IOException {
		final FileWriter writer = new FileWriter(filepath);
		writer.write(gson.toJson(object));
		writer.close();
	}

}
