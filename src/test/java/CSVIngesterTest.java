import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.takehometest.CSVIngester;

@ExtendWith(MockitoExtension.class)
public class CSVIngesterTest {
	
	@Spy
	CSVIngester csvIngester;
	
	@Test
	public void test_FileNotFound() throws Exception {
		String fileName="test.txt";
		Exception e = assertThrows(FileNotFoundException.class,() -> { csvIngester.parseCSV(fileName);});
	
		assertEquals(FileNotFoundException.class,e.getClass());
		assertEquals("Given fileName "+fileName+" not present",e.getMessage());
	}
	
	@Test
	public void test_SuccessfulRead() throws Exception {
		String fileName="src/test/resources/test.txt";
		assertEquals(new Long(1),csvIngester.parseCSV(fileName));
	}
	

}
