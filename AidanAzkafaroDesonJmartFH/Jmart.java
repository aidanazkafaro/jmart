package AidanAzkafaroDesonJmartFH;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;

import com.google.gson.*;
import java.io.File;
import java.util.*;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

/**
 *
 * @author (Aidan Azkafaro Deson)
 * 
 */
public class Jmart {

	public static List<Product> filterByAccountId(List<Product> list, int accountId, int page, int pageSize) {

		return paginate(list, page, pageSize, product -> product.accountId == accountId);
	}

	public static List<Product> filterByName(List<Product> list, String search, int page, int pageSize) {

		return paginate(list, page, pageSize, product -> product.name.toLowerCase().contains(search.toLowerCase()));

	}

	// method read terhadap resources
	public static List<Product> read(String filepath) throws FileNotFoundException {
		Gson gson = new Gson();
		Type userListType = new TypeToken<ArrayList<Product>>() {
		}.getType();
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		List<Product> returnList = gson.fromJson(br, userListType);
		return returnList;

	}

	public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice) {
		List<Product> result = new ArrayList<Product>();

		for (Product product : list) {
			if (minPrice != 0.0 && product.price < minPrice) {
				continue;
			}
			if (maxPrice != 0.0 && product.price > maxPrice) {
				continue;
			}

			result.add(product);
		}

		return result;
	}

	public static List<Product> filterByCategory(List<Product> list, ProductCategory category) {

		List<Product> returnList = new ArrayList<Product>();
		for (Product product : list) {
			if (product.category.equals(category)) {
				returnList.add(product);
			}
		}
		return returnList;

		// return Algorithm.<Product>collect(list, prod -> prod.category == category);

	}

	private static List<Product> paginate(List<Product> list, int page, int pageSize, Predicate<Product> pred) {

		List<Product> resultList = new ArrayList<>(pageSize);
		int startingIndex = (page) * pageSize;
		int iteration = 0;
		int occurences = 0;

		for (; iteration < list.size() && occurences < startingIndex; ++iteration) {
			if (pred.predicate(list.get(iteration))) {
				++occurences;
			}
		}

		for (int i = iteration; i < list.size() && resultList.size() < pageSize; ++i) {
			if (pred.predicate(list.get(i))) {
				resultList.add(list.get(i));
			}
		}

		return resultList;

	}

	public static void main(String[] args) throws FileNotFoundException {

		System.out.println("account id: " + new Account(null, null, null, -1).id);
		System.out.println("account id: " + new Account(null, null, null, -1).id);
		System.out.println("account id: " + new Account(null, null, null, -1).id);

		System.out.println("payment id: " + new Payment(-1, -1, -1, null).id);
		System.out.println("payment id: " + new Payment(-1, -1, -1, null).id);
		System.out.println("payment id: " + new Payment(-1, -1, -1, null).id);

		try {
			List<Product> list = read(
					"C:\\Users\\aidan\\Programming\\OOP Tekkom\\Praktikum OOP\\jmart\\randomProductList.json");
			List<Product> filtered = filterByPrice(list, 98000.0, 0.0);
			filtered.forEach(product -> System.out.println(product.price));
		} catch (Throwable t) {
			t.printStackTrace();
		}
		List<Product> list = read(
				"C:\\Users\\aidan\\Programming\\OOP Tekkom\\Praktikum OOP\\jmart\\randomProductList.json");
		System.out.println(filterByAccountId(list, 1, 0, 5));
	}

}
