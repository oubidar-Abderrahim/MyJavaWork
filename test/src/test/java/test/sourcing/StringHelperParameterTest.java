package test.sourcing;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class StringHelperParameterTest {
  
  // we can only have one parameterized test by class, in case of other testes, create new class
  
  private String input ;
  private String expectedOutput ;
  private StringHelper stringHelper = new StringHelper();
  
  
  
  public StringHelperParameterTest(String input, String expectedOutput) {
    this.input = input;
    this.expectedOutput = expectedOutput;
  }

  @Parameters
  public static Collection<String[]> testCondition() {
    
    String expected[][] = {
        {"AACD", "CD"},
        {"", ""},
        {"CADO", "CDO"},
        {"DCAAD", "DCAAD"},
        {null, null}
    } ;
    return Arrays.asList(expected);
  }

  @Test
  public void testTruncateAInFirst2Positions() {
    
    assertEquals(expectedOutput,stringHelper.truncateAInFirst2Positions(input));
    
  }
  
  
  
  
  
  
  
  
    
}

