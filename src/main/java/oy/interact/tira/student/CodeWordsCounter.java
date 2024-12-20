package oy.interact.tira.student;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Comparator;

import oy.interact.tira.factories.HashTableFactory;
import oy.interact.tira.util.Pair;
import oy.interact.tira.util.TIRAKeyedContainer;

import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;

// Teachers: TODO: Decide what here is left for the students to implement.
// E.g. forming the words based on rules.

public class CodeWordsCounter {

	private TIRAKeyedContainer<String, Integer> codeWords;

	public long cumulativeTimeInMilliseconds;

	private static final int MAX_WORD_SIZE = 4096;
	private static final String FILE_TYPES_TO_INCLUDE = "glob:*.{c,h,cc,cpp,hpp,cs,java,swift,py,html,css,js,ts,xml,json}";
	
	public CodeWordsCounter() {
		codeWords = HashTableFactory.createHashTable();
	}

	public void countWordsinSourceCodeFiles(File inDirectory) throws IOException {

		if (null == codeWords) {
			System.out.println("No implementation for hashtable, doing nothing.");
			return;
		}
		cumulativeTimeInMilliseconds = 0;
		System.out.println("Started counting, please wait...");

		Files.walkFileTree(inDirectory.toPath(), new SimpleFileVisitor<Path>() {
			PathMatcher matcher = FileSystems.getDefault().getPathMatcher(FILE_TYPES_TO_INCLUDE);

			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
				if (file != null && matcher.matches(file.getFileName())) {
					try {
						countWordsFrom(file.toFile());
					} catch (OutOfMemoryError | IOException e) {
						e.printStackTrace();
						return FileVisitResult.TERMINATE;
					}
				}
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFileFailed(Path file, IOException e) {
				return FileVisitResult.CONTINUE;
			}

		});
	}

	private void countWordsFrom(File file) throws OutOfMemoryError, IOException {
		String content = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
		// Characters of a single word as Unicode codepoints.
		int [] wordChars = new int[MAX_WORD_SIZE];
		// Index used to fill wordChars array from the string in the file.
		int codeWordIndex = 0;
		System.out.println("File: " + file.getAbsolutePath());
		long start = System.currentTimeMillis();
		for (int index = 0; index < content.length(); index++) {
			int codePoint = content.codePointAt(index);
			if (Character.isLetter(codePoint)) {
				wordChars[codeWordIndex] = codePoint;
				codeWordIndex++;
			} else if (codeWordIndex >= 2) {
				String word = new String(wordChars, 0, codeWordIndex).toLowerCase();
				Integer wordCount = codeWords.get(word);
				if (wordCount == null) {
					codeWords.add(word, 1);
				} else {
					codeWords.add(word, wordCount + 1);
				}
				codeWordIndex = 0;
			}
		}
		cumulativeTimeInMilliseconds += System.currentTimeMillis() - start;
	}

	@SuppressWarnings("unchecked")
	public Pair<String, Integer>[] topCodeWords(int topCount) throws Exception {
		if (null == codeWords) {
			Pair<String, Integer>[] result = new Pair[1];	
			result[0] = new Pair<>("Hashtable not implemented yet", 0);
			return result;
		}
	
		Pair<String, Integer>[] array = codeWords.toArray();
		
		Algorithms.fastSort(array, new Comparator<Pair<String, Integer>>() {
			@Override
			public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}	
		});

		int n = array.length;
		if (topCount <= array.length) {
			n = topCount;
		}
		Pair<String, Integer>[] resultArray = new Pair[n];
		for (int i = 0; i < n; i++) {
			resultArray[i] = array[i];
		}
		return resultArray;
	}
}
