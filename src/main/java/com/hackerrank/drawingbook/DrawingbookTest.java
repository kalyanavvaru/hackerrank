package com.hackerrank.drawingbook;


import mockit.Deencapsulation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DrawingbookTest {

    @Test
    public void testPageCount() {
        assertEquals(0, new Solution().testPageCount(6, 1));
        assertEquals(1, new Solution().testPageCount(6, 2));
        assertEquals(1, new Solution().testPageCount(6, 3));
        assertEquals(1, new Solution().testPageCount(6, 4));
        assertEquals(1, new Solution().testPageCount(6, 5));
        assertEquals(0, new Solution().testPageCount(6, 6));


        assertEquals(0, new Solution().testPageCount(5, 1));
        assertEquals(1, new Solution().testPageCount(5, 2));
        assertEquals(1, new Solution().testPageCount(5, 3));
        assertEquals(0, new Solution().testPageCount(5, 4));
        assertEquals(0, new Solution().testPageCount(5, 5));
    }
}
