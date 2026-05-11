public class Main {
    public static void main(String[] args) {
        System.out.println("=== Phase 4 Intelligent Cache Testing ===");

        System.out.println("\n-- Empty/Boundary Tests --");
        IntelligentCache<Integer, String> cache =
                new IntelligentCache<>(3);
        // Boundary Test: empty cache
        printTest(
                "Verify empty cache size is 0",
                cache.size() == 0
        );

        printTest(
                "Verify search empty cache returns null",
                cache.get(1) == null
        );


        System.out.println("\n-- Normal Logic Tests --");

        // Logic Test: add items
        cache.put(1, "Google");
        cache.put(2, "Yahoo");
        cache.put(3, "Bing");

        printTest(
                "Verify cache size after 3 inserts is 3",
                cache.size() == 3
        );

        printTest(
                "Verify most recent key is 3",
                cache.getMostRecentKey().equals(3)
        );

        printTest(
                "Least recent key is 1",
                cache.getLeastRecentKey().equals(1)
        );
        // Logic Test: get key
        String value = cache.get(1);

        printTest(
                "Verify key 1 returns Google",
                value.equals("Google")
        );

        printTest(
                "Verify after searching key 1, key 1 moves to front -> most recent",
                cache.getMostRecentKey().equals(1)
        );


        System.out.println("\n-- Edge Case Tests --");
        // Edge Case: inserting new key to a fulled list
        cache.put(4, "Apple");
        printTest(
                "Verify after inserting key 4, cache size is still 3",
                cache.size() == 3
        );

        // Edge Case: Least recently used key was removed after inserting into a fulled list
        printTest(
                "Verify least recently used key 2 was removed",
                cache.get(2) == null
        );

        // Edge Case: update existing key
        cache.put(3, "Bing Updated");

        printTest(
                "Verify updating key 3 changes its value",
                cache.get(3).equals("Bing Updated")
        );

        printTest(
                "Verify updated key 3 becomes most recent",
                cache.getMostRecentKey().equals(3)
        );

        System.out.println("\nFinal cache:");
        cache.displayCache();
    }
    public static void printTest(String testName, boolean passed) {
        if (passed) {
            System.out.println(testName + ": PASS");
        } else {
            System.out.println(testName + ": FAIL");
        }
    }
}