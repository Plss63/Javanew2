package oneHash;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Search implements InterHash {
	private String word = "";
	TreeMap<String, Integer> statisticword = new TreeMap<String, Integer>();

	/**
	 * поиск максимального и минимального слова
	 * 
	 * @return max and min word
	 */
	String wordmaxmin() {
		String smin = "", smax = "";
		Iterator<Entry<String, Integer>> itr = statisticword.entrySet()
				.iterator();
		Entry<String, Integer> entry = (Entry<String, Integer>) itr.next();
		smin = entry.getKey();
		smax = entry.getKey();
		while (itr.hasNext()) {
			entry = itr.next();
			String key = entry.getKey();
			if (key.length() >= smax.length())
				smax = key;
			if (key.length() < smin.length())
				smin = key;
		}
		return "max word: " + smax + "; min word: " + smin;
	}

	/**
	 * поиск слов
	 * 
	 * @param ch
	 * @param a
	 */
	@Override
	public void gather(int i) {
		char ch = Character.toLowerCase((char) i);
		if (ch == ' ') {
			if (word == "")
				return;
			if (word != "") {
				if (statisticword.containsKey(word) == true) {
					statisticword.put(word, statisticword.get(word) + 1);
					word = "";
				} else {
					statisticword.put(word, 1);
					word = "";
				}
			}
		}
		if (ch != ' ') {
			word = word + ch;
			if (i == -1) {
				if (statisticword.containsKey(word) == true) {
					statisticword.put(word, statisticword.get(word) + 1);
					word = "";
				} else {
					statisticword.put(word, 1);
					word = "";
				}
			}
		}
	}

	@Override
	public void returnres() {
		wordmaxmin();

	}
}
