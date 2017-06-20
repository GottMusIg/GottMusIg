package com.gottmusig.gottmusig.boundary;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractIT extends AbstractBoundaryTest {

	@ArquillianResource
	private URI baseUri;

	@Deployment(testable = false)
	public static WebArchive createTestArchive() {

		WebArchive archive = createFromWar("target/gottmusig.war");

		log.debug("deployment:\n{}", archive.toString(true));
		return archive;
	}

	private static WebArchive createFromWar(String archiveFilePath) {
		return createFromWar(new File(archiveFilePath));
	}

	private static WebArchive createFromWar(File archiveFile) {
		ZipFile zipFile = zipFile(archiveFile);
		return ShrinkWrap.create(WebArchive.class).as(ZipImporter.class).importFrom(zipFile).as(WebArchive.class);
	}

	private static ZipFile zipFile(File archiveFile) {
		if (archiveFile == null)
			throw new IllegalArgumentException("File must be specified");
		if (!archiveFile.exists())
			throw new IllegalArgumentException("File for import does not exist: " + archiveFile.getAbsolutePath());
		if (archiveFile.isDirectory())
			throw new IllegalArgumentException(
					"File for import must not be a directory: " + archiveFile.getAbsolutePath());

		try {
			return new ZipFile(archiveFile);
		} catch (final ZipException e) {
			throw new IllegalArgumentException(
					"Does not appear to be a valid ZIP file: " + archiveFile.getAbsolutePath());
		} catch (final IOException e) {
			throw new RuntimeException("I/O Error in importing new archive from ZIP: " + archiveFile.getAbsolutePath(),
					e);
		}
	}

	protected String get(String path) {

		Client c = ClientBuilder.newClient();
		WebTarget target = c.target(baseUri).path(path);
		log.debug("Requesting: " + target.getUri());

		String responseMsg = target.request().get(String.class);

		return responseMsg;
	}

}
