import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Use JUnit assertions to verify IntelligentCache functionality.
public class IntelligentCacheJUnitTest {

    @Test()
    @DisplayName("Boundary Test - Empty Cache")
    public void testEmptyCache() {
        IntelligentCache<Integer, String> cache = new IntelligentCache<>(3);
        assertEquals(0, cache.size());  // verify size = 0
        assertTrue(cache.isEmpty());            // verify cache is empty
        assertNull(cache.get(1));               // verify result is null when search for any key
        assertNull(cache.getMostRecentKey());   // verify result is null when search for most recent used cache
        assertNull(cache.getLeastRecentKey());  // verify result is null when search for least recent used cache
    }

    @Test()
    @DisplayName("Normal Test - Insert And Retrieve Items")
    public void testNormalInsert() {
        IntelligentCache<Integer, String> cache = new IntelligentCache<>(3);
        cache.put(1, "Google");                             // Step 1. insert (1, "Google")
        cache.put(2, "Yahoo");                              // Step 2. insert (2, "Yahoo")
        cache.put(3, "Bing");                               // Step 3. insert (3, "Bing")
        assertEquals(3, cache.size());              // verify size = 3 after 3 inserts
        assertEquals(3, cache.getMostRecentKey());  // verify most recent used cache key = 3 (lastest insert)
        assertEquals(1, cache.getLeastRecentKey()); // verify least recent used cache key = 1 (oldest insert)
        assertEquals("Google", cache.get(1));       // verify value os key = 1 is correct
        assertEquals(1, cache.getMostRecentKey());  // verify most recent used cache key is now updated to 1
    }

    @Test()
    @DisplayName("Edge Case Test - Remove Least Recently Used Item")
    public void testLeastRecentlyUsedRemoval() {
        IntelligentCache<Integer, String> cache = new IntelligentCache<>(3);
        cache.put(1, "Google");                                 // Step 1. insert (1, "Google")
        cache.put(2, "Yahoo");                                  // Step 2. insert (2, "Yahoo")
        cache.put(3, "Bing");                                   // Step 3. insert (3, "Bing")
        cache.get(1);                                           // Step 4. search key = 1 -> MRU:1, LRU: 2
        cache.put(4, "Apple");                                  // Step 5. insert (4, "Apple"):
                                                                //          * size full -> remove key = 2 (LRU)
                                                                //          * Now MRU: 4; LRU: 3
        assertNull(cache.get(2));                               // Verify searching for key = 2 returns Null
        assertEquals(3, cache.size());                 // Verify cache size is 3
        assertEquals(4, cache.getMostRecentKey());     // Verify most recent used cache key = 4
    }

    @Test()
    @DisplayName("Edge Case Test - Update Existing Key")
    public void testUpdateExistingKey() {
        IntelligentCache<Integer, String> cache = new IntelligentCache<>(3);
        cache.put(1, "Google");                                 // Step 1. insert (1, "Google")
        cache.put(1, "Google Updated");                         // Step 2. Update key = 1 with "Google Updated")

        assertEquals(1, cache.size());                  // Verify cache size = 1
        assertEquals("Google Updated", cache.get(1));   // Verify search for key = 1 returns value "Google Updated"
        assertEquals(1, cache.getMostRecentKey());      // Verify most recent used key = 1
    }

    @Test
    @DisplayName("Edge Case Test - Remove Existing Key")
    public void testRemoveKey() {
        IntelligentCache<Integer, String> cache = new IntelligentCache<>(3);
        cache.put(1, "Google");                             // Step 1. insert (1, "Google")
        cache.put(2, "Yahoo");                              // Step 2. insert (2, "Yahoo")
        String removedValue = cache.remove(1);         // Step 3. remove key = 1 -> should return value of key=1 which is "Google"
        assertEquals("Google", removedValue);      // Verify "Google" is the return value after remove key=1
        assertEquals(1, cache.size());             // Verify cache size reduced by 1 which is 2-1=1
        assertNull(cache.get(1));                           // Verify key=1 no longer exist
    }
}