package com.locationguru.learning.advance;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StreamsExample
{
	private static final Logger logger = LogManager.getLogger(StreamsExample.class);

	public static void main(String[] args) throws IOException, URISyntaxException
	{
		final URL resource = StreamsExample.class.getClassLoader().getResource("samples/LongText.txt");

		if (resource == null) { return; }

		final File file = new File(resource.toURI());
		final String content = Files.readString(file.toPath())
									.replace("\r\n", "\n");

		logger.info("Read '{}' characters from file '{}' ..", content.length(), file.getName());

		final Map<String, Long> collect = content.lines()
												 .flatMap(s -> Arrays.stream(s.split(" ")))
												 .map(String::strip)
												 .map(String::toLowerCase)
												 .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


		// collect.forEach((key, value) -> logger.info("{} : {}", key, value));


		final Map<Long, List<String>> result = content.lines()
													  .flatMap(s -> Arrays.stream(s.split(" ")))
													  .map(s -> s.replaceAll("[^A-Za-z]", ""))
													  .map(String::strip)
													  .filter(Predicate.not(String::isBlank))
													  .map(String::toLowerCase)
													  .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
													  .entrySet().stream()
													  .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));

		final Map<Long, List<String>> map = new TreeMap<>(result);


		map.forEach((key, value) -> logger.info("{} : {}", key, value));

	}

}
