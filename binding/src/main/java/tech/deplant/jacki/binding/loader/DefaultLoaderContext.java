package tech.deplant.jacki.binding.loader;

public class DefaultLoaderContext {

	private static DefaultLoader loader;

	public static DefaultLoader SINGLETON(ClassLoader classLoader) {
		if (loader == null) {
			loader = new DefaultLoader(classLoader);
		}
		return loader;
	}
}
