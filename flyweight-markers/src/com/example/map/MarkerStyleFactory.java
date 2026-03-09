package com.example.map;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO (student):
 * Implement Flyweight factory that caches MarkerStyle by a stable key.
 *
 * Suggested key format:
 *   shape + "|" + color + "|" + size + "|" + (filled ? "F" : "O")
 *
 * After refactor:
 * - MapDataSource should call this factory to obtain shared MarkerStyle instances.
 */

/**
 * Flyweight Factory
 *
 * This factory ensures that identical MarkerStyle objects
 * are shared instead of creating duplicates.
 *
 * CHANGES MADE:
 * 1. Introduced a cache (Map<String, MarkerStyle>).
 * 2. Before creating a new style, we check if one already exists.
 * 3. If it exists → reuse it.
 * 4. If not → create, store in cache, and return.
 *
 * BENEFIT:
 * Instead of thousands of style objects,
 * we only keep unique style combinations.
 */

// Request style
//       ↓
// Factory checks cache
//       ↓
// Exists? → return existing
// Else → create + store + return
public class MarkerStyleFactory {

    private final Map<String, MarkerStyle> cache = new HashMap<>();

    public MarkerStyle get(String shape, String color, int size, boolean filled) {
        String key = shape + "|" + color + "|" + size + "|" + (filled ? "F" : "O");
        // TODO: return cached instance if present; otherwise create, cache, and return.
            if (cache.containsKey(key)) {
            return cache.get(key);
        }

        MarkerStyle style = new MarkerStyle(shape, color, size, filled);
        cache.put(key, style);
        return style;
    }

    public int cacheSize() {
        return cache.size();
    }
}
