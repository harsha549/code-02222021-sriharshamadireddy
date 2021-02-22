import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

import org.mockito.Mockito;
import static org.mockito.BDDMockito.*;

public class Utility {

	public static URL getMockUrl(final String filename) throws IOException {
	    final File file = new File("src/test/resources/" + filename);
	    //assertTrue("Mock HTML File " + filename + " not found", file.exists());
	    final URLConnection mockConnection = Mockito.mock(URLConnection.class);
	    given(mockConnection.getInputStream()).willReturn(
	            new FileInputStream(file));

	    final URLStreamHandler handler = new URLStreamHandler() {

	        @Override
	        protected URLConnection openConnection(final URL arg0)
	                throws IOException {
	            return mockConnection;
	        }
	    };
	    final URL url = new URL("http://foo.bar", "foo.bar", 80, "", handler);
	    return url;
	}
}
