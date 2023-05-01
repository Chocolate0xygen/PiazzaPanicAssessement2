package group24.piazzapanic.maths;

import group24.piazzapanic.Base;

/**
 * This class is a simple 2D vector class. It uses doubles so can store non-integers. Do not use
 * Vector2 to *store* level element positions, but Vector2 has some convenient static methods to
 * help with translating between grid units and screen pixels.
 */
public class Vector2 extends com.badlogic.gdx.math.Vector2 {
    // These should only be from 0 to 1, -1 means unset and anything else is a worrying mistake.
    /** The x position of the vector. Should only be from 0 to 1, -1 means unset */
    public double x;
    /** The y position of the vector. Should only be from 0 to 1, -1 means unset */
    public double y;

    /**
     * Create a new Vector2 with the given x and y values.
     * @param x The x value of the vector.
     * @param y The y value of the vector.
     */
    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Create a new Vector2 with the given x and y values.
     * @param x The x value of the vector.
     * @param y The y value of the vector.
     */
    public Vector2(int x, int y) {
        // This will lead to slight innacuracies, but they get rounded away anyway so it won't
        // change the integer values. (eg 500 / 1280, * 1280 = 500.0000000000001)
        this.x = x / (double) Base.WINDOW_WIDTH;
        this.y = y / (double) Base.WINDOW_HEIGHT;
    }

    /** 
     * Convert a decimal percentage of the screen width to an absolute pixel value.
     * @return the absolute pixel value
     */
    public int getAbsoluteX() {
        return Math.toIntExact(Math.round(x * Base.WINDOW_WIDTH));
    }

    /** 
     * Convert a decimal percentage of the screen width to an absolute pixel value.
     * @return the absolute pixel value
     */
    public int getAbsoluteY() {
        return Math.toIntExact(Math.round(y * Base.WINDOW_HEIGHT));
    }

    /**
     * Creates an on-screen Vector2 from grid units, the parameters are translated to scale both x
     * and y by Base.WINDOW_WIDTH, according the relative width of one tile, Base.TILE_GRID_UNIT.
     * @param gridX The x position of a given cell in the grid.
     * @param gridY The y position of a given cell in the grid.
     * @return A Vector2 referring to the position of the object on the screen.
     */
    public static Vector2 gridUnitTranslate(float gridX, float gridY) {
        // gridX is translated onto the screen by the constant TILE_GRID_UNIT, which is basically
        // the width of one tile in grid units. Doing the same for gridY means it would be scaled
        // as a proportion of the screen height, but we want it on the same scaling as gridX, which
        // uses the screen width. So gridY / height * width to cancel the maths on line 25 out.
        return new Vector2(gridX * Base.TILE_GRID_UNIT,
                gridY * Base.TILE_GRID_UNIT * (double) Base.WINDOW_WIDTH / Base.WINDOW_HEIGHT);
    }

    /**
     * Creates an on-screen Vector2 from grid units, the parameters are translated to scale both x
     * and y by Base.WINDOW_WIDTH, according the relative width of one tile, Base.TILE_GRID_UNIT.
     * @param gridX The x position of a given cell in the grid.
     * @param gridY The y position of a given cell in the grid.
     * @return A Vector2 referring to the position of the object on the screen.
     */
    public static Vector2 gridUnitTranslate(double gridX, double gridY) {
        return new Vector2(gridX * Base.TILE_GRID_UNIT,
                gridY * Base.TILE_GRID_UNIT * (double) Base.WINDOW_WIDTH / Base.WINDOW_HEIGHT);
    }

    /**
     * Equivalent of {@link #gridUnitTranslate(double, double)} but does not create a new instance for memory reasons
     * @param gridX The x position of a given cell in the grid.
     * @param gridY The y position of a given cell in the grid.
     */
    public void gridUnitTranslateInplace(double gridX, double gridY) {
        this.x = (gridX * Base.TILE_GRID_UNIT);
        this.y = (gridY * Base.TILE_GRID_UNIT * (double) Base.WINDOW_WIDTH / Base.WINDOW_HEIGHT);
    }

    /**
     * Equivalent of {@link #gridUnitTranslate(float, float)} but does not create a new instance for memory reasons
     * @param gridX The x position of a given cell in the grid.
     * @param gridY The y position of a given cell in the grid.
     */
//    public void gridUnitTranslateInplace(float gridX, float gridY) {
//        this.x = (gridX * Base.TILE_GRID_UNIT);
//        this.y = (gridY * Base.TILE_GRID_UNIT * (double) Base.WINDOW_WIDTH / Base.WINDOW_HEIGHT);
//    }

    /**
     * Convert grid units to on screen positions inlcuding offset.
     * @param gridX the grid X coordinates
     * @param gridY the grid Y coordinates
     * @return The on-screen position including offset
     */
//    public static Vector2 worldUnitTranslate(float gridX, float gridY) {
//        Vector2 pos = gridUnitTranslate(gridX, gridY);
//        pos.x += GameData.offsetX;
//        pos.y += GameData.offsetY;
//        return pos;
//    }

    /**
     * Convert grid units to on screen positions inlcuding offset.
     * @param gridX The grid X coordinates
     * @param gridY The grid Y coordinates
     * @return The on-screen position including offset
     */
//    public static Vector2 worldUnitTranslate(Double gridX, Double gridY) {
//        Vector2 pos = gridUnitTranslate(gridX, gridY);
//        pos.x += GameData.offsetX / (double) Base.WINDOW_WIDTH;
//        pos.y += GameData.offsetY / (double) Base.WINDOW_HEIGHT;
//        return pos;
//    }
}
