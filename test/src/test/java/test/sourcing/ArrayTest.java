package test.sourcing;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ArrayTest {

  @Test
  public void testArraySort_simpleArray() {

    int[] nums = {95,8,4,23};
    int[] sorted = {4,8,23,95};
    
    Arrays.sort(nums);
    
    assertArrayEquals(sorted, nums);
  }
  
  @Test(expected=NullPointerException.class)
  public void testArraySort_nullArray() {

    int[] nums = null;
    
    Arrays.sort(nums);

  }
  
  @Test(timeout=30)
  public void testArraySort_performance() {

    int[] nums = {81,55,5,38,0,7};
    
    for(int i=0; i<1000000 ; i++) {
      
      nums[1]=i;
      Arrays.sort(nums);
    }
    
  }

}
