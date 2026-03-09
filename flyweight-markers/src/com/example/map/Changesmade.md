
---

## Solution (Flyweight Pattern)

The **Flyweight design pattern** was applied to share style objects instead of duplicating them.

We separated marker data into two parts:

### Intrinsic State (Shared)
Stored in `MarkerStyle`:
- shape
- color
- size
- filled

### Extrinsic State (Unique)
Stored in `MapMarker`:
- latitude
- longitude
- label

---

## Changes Made

### 1. MarkerStyle
- Made the class **immutable**
- All fields are `final`
- Removed setter methods

Reason: shared objects must not change.

---

### 2. MarkerStyleFactory
Created a factory that:
- stores styles in a `HashMap`
- returns an existing style if it already exists
- otherwise creates and caches a new one

Key format used:shape|color|size|filled
Example:

PIN|RED|12|F


---

### 3. MapMarker
Changed the constructor so it **receives a `MarkerStyle` instead of creating one**.

Now `MapMarker` only stores:
- lat
- lng
- label
- shared `MarkerStyle`

---

### 4. MapDataSource
Marker creation now uses:

MarkerStyle style = styleFactory.get(shape, color, size, filled);
instead of creating new style objects.

---

## Result

Possible unique styles: 
3 shapes × 4 colors × 4 sizes × 2 filled = 96


So after refactoring:


30000 markers → ≤ 96 MarkerStyle objects


Memory usage is significantly reduced while the rendering behavior remains unchanged.

---

## Verification

`QuickCheck` counts unique style object identities.

Expected output:


Markers: 20000
Unique style instances: <= 96


This confirms that styles are being reused correctly.

