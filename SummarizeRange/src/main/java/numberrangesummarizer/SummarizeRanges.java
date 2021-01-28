/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Tumi
 */    
public class SummarizeRanges implements NumberRangeSummarizer{

    @Override
    public Collection<Integer> collect(String input){

        if (input == null || input.trim().isEmpty()) return Collections.<Integer>emptyList();

            List<String> convertedNumbers = Arrays.asList(input.trim().split("\\s*,\\s*"));
            List<Integer> allNumbers = new ArrayList<>();
            
            convertedNumbers.forEach(number ->{
                allNumbers.add(Integer.parseInt(number));
            });

        return allNumbers.stream().sorted().distinct().collect(Collectors.toList());
    }
    
    @Override
    public String summarizeCollection(Collection<Integer> input) {
        
        if (input == null || input.isEmpty()) return "";
        
        StringBuilder summarizedNumbers = new StringBuilder();
        List<Integer> inputArray = new ArrayList(input);

        int firstInRange = inputArray.get(0);
        int lastInRange = inputArray.get(0);
        
        for (int currentNumber : inputArray) {
            if (currentNumber - lastInRange > 1) {
                if(firstInRange == lastInRange) {
                    summarizedNumbers.append(firstInRange).append(", ");
                    firstInRange = currentNumber;
                }else{
                    summarizedNumbers.append(firstInRange+"-"+lastInRange+", ");
                    firstInRange = currentNumber;            
                }
            }
            lastInRange = currentNumber;
         }
         summarizedNumbers.append(lastInRange);   
        return summarizedNumbers.toString();
    }
    
    public static void main(String[] args){

        SummarizeRanges summary = new SummarizeRanges();
        System.out.println(summary.summarizeCollection(summary.collect("7,   1   ,3,6,7,8,12,13,14,15,21,22,23,24,31")));
    }
}
