package com.kranian;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by kranian on 17. 3. 25.
 */
public class Pattern {

    private String src;
    private String pat;

    public long sum(int first, int end, int pattern){
        final String p =  String.valueOf(pattern);
        return IntStream.range(first,end)
                .mapToObj(d -> String.valueOf(d))
                .mapToInt(s ->search(s,p))
                .sum();


    }

    public int search(String src,String pattern){

        this.src = src;
        this.pat = pattern;

        if( this.src.length() < pat.length() ) return 0;

        int readPos = 0;
        List<LastReadPosition> match = new ArrayList<>();
        while( true ){
            LastReadPosition r = kmp(readPos);
            if(r != null) {
                readPos = r.pos;
                match.add(r);
            }else {
                break;
            }
        }

        return match.stream().mapToInt(p -> p.count).sum();
    }

    private LastReadPosition kmp(int readPos){

        final int srcLen = src.length();
        final int patternLen = pat.length();

        return IntStream.range(readPos,srcLen)
                 .filter(p -> (srcLen - p ) >= patternLen)
                 .filter( p -> this.src.substring(p).substring(0,patternLen).equals(pat))
                 .mapToObj( p -> new LastReadPosition(p+patternLen,1))
                 .findFirst()
                 .orElseGet( () -> null );

    }


    class LastReadPosition {

        public LastReadPosition(int pos,int count ){
            this.pos = pos;
            this.count = count;

        }
        public int pos;
        public int count;
    }
}
