package test.com.kranian;

import com.kranian.Main;
import com.kranian.Pattern;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/** 
* Pattern Tester. 
* 
* @author <Authors name> 
* @since <pre>3월 25, 2017</pre> 
* @version 1.0 
*/ 
public class PatternTest { 

@Before
public void before() throws Exception {

} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: sum(int first, int end, int pattern) 
* 
*/ 
@Test
public void testSum() throws Exception {
    Pattern pattern = new Pattern();
    Main.printf( pattern.sum(1,1000000,555) );
    Main.printf( pattern.sum(1,1000000,55) );
    Main.printf( pattern.sum(1,1000000,221) );
}

/** 
* 
* Method: search(String src, String pattern) 
* 
*/ 
@Test
public void testSearch() throws Exception {
    Pattern pattern = new Pattern();
    List<String> data=Stream.of("5","15505","155055","1055","10555","105555","1055555","1555500055").collect(Collectors.toList());
    assertEquals(28,data.stream().mapToInt(src -> pattern.search(src,"5")).sum());
    assertEquals(12, data.stream().mapToInt(src -> pattern.search(src,"55")).sum());
    assertEquals(4,data.stream().mapToInt(src -> pattern.search(src,"555")).sum());
    assertEquals(3,data.stream().mapToInt(src -> pattern.search(src,"5555")).sum());
    assertEquals(1, data.stream().mapToInt(src -> pattern.search(src,"55555")).sum());

}

@Test
public void testSearchText() throws Exception {
    Pattern pattern = new Pattern();
    List<String> data=Stream.of("abac","ABC","ab","abcdabac","ababcad","aaaadkdkab","ababaaaab","abababcab").collect(Collectors.toList());
    assertEquals(14,data.stream().mapToInt(src -> pattern.search(src,"ab")).sum());
}

} 
