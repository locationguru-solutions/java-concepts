package com.locationguru.learning.advance;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Streams
{
	private static final Logger logger = LogManager.getLogger(Streams.class);

	public static void main(String[] args) throws IOException, URISyntaxException
	{
		final URL resource = Streams.class.getClassLoader().getResource("samples/LongText.txt");

		if (resource == null) { return; }

		final File file = new File(resource.toURI());
		final int length = Files.readString(file.toPath()).length();

		logger.info("Read '{}' characters from file '{}' ..", length, file.getName());
	}

}
