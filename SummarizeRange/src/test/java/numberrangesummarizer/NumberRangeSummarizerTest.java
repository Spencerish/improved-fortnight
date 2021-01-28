/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberrangesummarizer;

import java.util.Arrays;
import java.util.Collections;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tumi
 */
public class NumberRangeSummarizerTest {
 
    @Test
    public void testCollect_sorting(){
        
        SummarizeRanges summary = new SummarizeRanges();
        
        assertEquals(Arrays.asList(1, 9, 11, 15, 200) ,summary.collect("200, 1, 11, 9, 15"));
        assertEquals(Arrays.asList(0, 1, 3, 6, 7, 8, 9, 10, 11, 12, 13, 14, 22, 25, 31) ,summary.collect("25, 25, 25, 0, 1, 3, 1, 6, 7, 1, 8, 9, 10, 11, 12, 13, 14, 22, 25, 31"));
    }
    
    @Test
    public void testCollect_nullValues(){
        
        SummarizeRanges summary = new SummarizeRanges();
        
        assertEquals(Collections.<Integer>emptyList() ,summary.collect(null));
        assertEquals(Collections.<Integer>emptyList() ,summary.collect("   "));   
        assertEquals(Arrays.asList(1, 2, 3) ,summary.collect("   1,  2  ,    3"));   
    }
 
    @Test
    public void testSummarizeCollection_range(){
        
        SummarizeRanges summary = new SummarizeRanges();
        
        assertEquals("1, 3, 6-8, 12-15, 21-24, 31" ,summary.summarizeCollection(Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,31)));
        assertEquals("0-3, 5, 8-11, 15, 18, 22-24, 85" ,summary.summarizeCollection(Arrays.asList(0,1,2,3,5,8,9,10,11,15,18,22,23,24,85)));

    }
    
    @Test
    public void testSummarizeCollection_nullValues(){
        
        SummarizeRanges summary = new SummarizeRanges();
        
        assertEquals("" ,summary.summarizeCollection(null));
   
    }
    
}
