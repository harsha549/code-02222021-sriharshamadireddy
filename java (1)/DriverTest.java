import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.takehometest.CSVIngester;
import com.takehometest.DownloadManager;
import com.takehometest.Driver;
import com.takehometest.PropertiesUtil;

/* Fix it future releases.
@ExtendWith(MockitoExtension.class)

public class DriverTest {

	@Spy
	Driver driver;
	
	@Mock
	PropertiesUtil propertiesUtil;
	@Spy
	DownloadManager downloadManager;
	@Mock
	CSVIngester csvIngester;
	@Mock
	Properties prop;
	
	@Test
	public void testMock() throws Exception {
		prop.setProperty("url", "https://localhost:80/");
		prop.setProperty("fileName", "csvtest.txt");
		when(downloadManager.getUrl("https://localhost:80")).thenReturn(Utility.getMockUrl("test.txt"));
		driver.setValues(propertiesUtil, downloadManager, csvIngester);
		String configFileName="config.properties";
		when(propertiesUtil.getPropertiesFromFile(configFileName)).thenReturn(prop);
		//URL url=Utility.getMockUrl("test.txt");
		driver.run(configFileName);
	
	}
	
//	public static URL getMockUrl(final String filename) throws IOException {
//	    final File file = new File("src/test/resources/" + filename);
//	    //assertTrue("Mock HTML File " + filename + " not found", file.exists());
//	    final URLConnection mockConnection = Mockito.mock(URLConnection.class);
//	    when(mockConnection.getInputStream()).thenReturn(
//	            new FileInputStream(file));
//
//	    final URLStreamHandler handler = new URLStreamHandler() {
//
//	        @Override
//	        protected URLConnection openConnection(final URL arg0)
//	                throws IOException {
//	            return mockConnection;
//	        }
//	    };
//	    final URL url = new URL("http://foo.bar", "foo.bar", 80, "", handler);
//	    return url;
//	}
	
}
*/