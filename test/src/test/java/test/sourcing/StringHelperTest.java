package test.sourcing;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringHelperTest {
  
  // All methods should be public void 
  
  StringHelper stringHelper = new StringHelper();
  
  // @BeforeClass execute before everything once, @before execute before every test
  // @AfetrClass execute after everything once, @after execute after every test
  // beforeClass and AfterClass should be static also

  @Test
  public void testTruncateAInFirst2Positions_AACD_CD() {
    
    assertEquals("CD",stringHelper.truncateAInFirst2Positions("AACD"));
    
  }
  
  @Test
  public void testTruncateAInFirst2Positions_emptyString_emptyString() {
    
    assertEquals("",stringHelper.truncateAInFirst2Positions(""));
    
  }
  
  @Test
  public void testTruncateAInFirst2Positions_CADO_CDO() {
    
    assertEquals("CDO",stringHelper.truncateAInFirst2Positions("CADO"));
    
  }
  
  @Test
  public void testTruncateAInFirst2Positions_DCAAD_DCAAD() {
    
    assertEquals("DCAAD",stringHelper.truncateAInFirst2Positions("DCAAD"));
    
  }
  
  @Test
  public void testTruncateAInFirst2Positions_null_null() {
    
    assertEquals(null,stringHelper.truncateAInFirst2Positions(null));
    
  }
  
  @Test
  public void testareFirstAndLastTwoCharactersTheSame_0Caracter_false() {
    
    assertFalse(stringHelper.areFirstAndLastTwoCharactersTheSame(""));
    
  }
    
  @Test
  public void testareFirstAndLastTwoCharactersTheSame_1Caracter_false() {
    
    assertFalse(stringHelper.areFirstAndLastTwoCharactersTheSame("G"));
    
  }
  
  @Test
  public void testareFirstAndLastTwoCharactersTheSame_2Caracters_true() {
    
    assertTrue(stringHelper.areFirstAndLastTwoCharactersTheSame("YH"));
    
  }
  
  
  @Test
  public void testareFirstAndLastTwoCharactersTheSame_FEEXFE_true() {
    
    assertTrue(stringHelper.areFirstAndLastTwoCharactersTheSame("FEEXFE"));
    
  }
  
  @Test
  public void testareFirstAndLastTwoCharactersTheSame_VEJ_false() {
    
    assertFalse(stringHelper.areFirstAndLastTwoCharactersTheSame("VEJ"));
    
  } 
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
    
}

