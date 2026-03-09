package com.example.map;

/**
 * CURRENT STATE (BROKEN ON PURPOSE):
 * Each marker owns a private MarkerStyle created via 'new'.
 * This means identical styles are duplicated across thousands of markers.
 *
 * TODO (student):
 * - Store intrinsic state as a shared MarkerStyle obtained from MarkerStyleFactory.
 * - Keep only extrinsic state here: lat, lng, label.
 */

/**
 * Represents a marker placed on the map.
 *
 * CHANGES MADE:
 * 1. Removed creation of MarkerStyle inside this class.
 * 2. MarkerStyle is now passed from outside.
 *
 * WHY?
 * MapMarker should only hold extrinsic data.
 * Style is intrinsic and should be shared using Flyweight.
 *
 * Extrinsic state (unique per marker):
 *   lat, lng, label
 *
 * Intrinsic state (shared):
 *   MarkerStyle
 */

// MapMarker
//  ├─ lat
//  ├─ lng
//  ├─ label
//  └─ MarkerStyle (shared reference)
//      ├─ shape
//      ├─ color
//      ├─ size
//      └─ filled
public class MapMarker {

    private final double lat;
    private final double lng;
    private final String label;

    // BROKEN: style is created per marker; should be shared
    private final MarkerStyle style;

    public MapMarker(double lat, double lng, String label,MarkerStyle style) {
        this.lat = lat;
        this.lng = lng;
        this.label = label;

        // BROKEN: per-marker allocation
        this.style = style;
    }

    public double getLat() { return lat; }
    public double getLng() { return lng; }
    public String getLabel() { return label; }
    public MarkerStyle getStyle() { return style; }
}
