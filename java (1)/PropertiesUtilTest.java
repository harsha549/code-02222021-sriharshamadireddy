import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;
import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import  org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.takehometest.PropertiesUtil;

@ExtendWith(MockitoExtension.class)
public class PropertiesUtilTest {

	@Spy
	PropertiesUtil propUtil;
	
	@Spy
	Properties prop;
	@Test
	public void testIfFileResourceNotPresent() {
		String propertyFileName="text";
		Exception exception = assertThrows(FileNotFoundException.class, () -> { propUtil.getPropertiesFromFile(propertyFileName);}
		);
		
		String actualMessage = "Property File  "+propertyFileName+" is not present on classpath";
		assertEquals(actualMessage,exception.getMessage());
	}
	
	@Test
	public void testIfFilePresent() throws Exception {
		String propertyFileName="config.properties";
		Properties propFromFile =propUtil.getPropertiesFromFile(propertyFileName);
		prop.setProperty("url", "https://raw.githubusercontent.com/vamstar/challenge/master/Dataset3.csv");
		prop.setProperty("fileName", "csv.txt");
		assertEquals(prop.get("url"),propFromFile.get("url"));
		assertEquals(prop.get("fileName"),propFromFile.get("fileName"));
	
	}	
}
