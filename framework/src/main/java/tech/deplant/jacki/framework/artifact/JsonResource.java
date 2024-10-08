package tech.deplant.jacki.framework.artifact;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Represents JSON-organized artifacts on Java resource path
 */
public record JsonResource(String resourceName) implements Artifact<String,String> {
	@Override
	public String get() {
		return new String(
				new ByteResource(resourceName()).get(), StandardCharsets.UTF_8)
				.replaceAll("[\u0000-\u001f]", "");
	}

	@Override
	public void accept(String jsonString) {
		try {
			Files.writeString(Paths.get(getClass().getResource(resourceName()).getPath()),
			                  jsonString, StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}