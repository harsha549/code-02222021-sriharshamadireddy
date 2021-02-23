import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.BDDMockito.*;

import com.takehometest.DownloadManager;

@ExtendWith(MockitoExtension.class)
public class DownloadManagerTest {

	@Spy
	DownloadManager downloadManager;

	@Test
	public void testIfBothValuesNull() {
		Exception e= assertThrows(RuntimeException.class,() -> { downloadManager.downloadFile(null, null);});

		assertEquals("Please pass the url,fileName values",e.getMessage());

	}

	@Test
	public void testOneValueIsNull() {
		Exception e= assertThrows(RuntimeException.class,() -> { downloadManager.downloadFile("url", null);});

		assertEquals("Please pass the fileName",e.getMessage());

		Exception e1= assertThrows(RuntimeException.class,() -> { downloadManager.downloadFile(null, "url");});

		assertEquals("Please pass the url ",e1.getMessage());

	}
	
	@Test
	public void testBothValuesPresent_validateUrl() {
     
		Exception e= assertThrows(MalformedURLException.class,() -> { downloadManager.downloadFile("url", "csv.txt");});
		
		assertEquals(MalformedURLException.class,e.getClass());
		
	}
	
	@Test
	public void testDataFromUrl() throws Exception {
		
		URL url =Utility.getMockUrl("test.txt");
		String urlPath="";
		doReturn(url).when(downloadManager).getUrl(urlPath);
		String fileName="csvtest.txt";
		Boolean expected=true;
		assertEquals(expected,downloadManager.downloadFile(urlPath, fileName));
	}
	

}
