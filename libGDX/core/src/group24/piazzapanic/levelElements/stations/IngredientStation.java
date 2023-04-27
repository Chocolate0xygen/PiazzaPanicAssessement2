package group24.piazzapanic.levelElements.stations;

import com.badlogic.gdx.graphics.Texture;
import group24.piazzapanic.Physics.Movable;
import group24.piazzapanic.game.GameData;
import group24.piazzapanic.levelElements.Dish;
import group24.piazzapanic.levelElements.Ingredient;
import group24.piazzapanic.levelElements.IngredientType;

/**
 * IngredientStations provide the player with a supply of ingredients.
 * Their Item is always the Ingredient specified in IngredientType
 * allowing players to pick up the Ingredient.
 */
public class IngredientStation extends Station {
    private final IngredientType ingredientType; // The type of ingredient the IngredientStation serves.

    /**
     * Find and return the correct texture for the given ingredient type
     *
     * @param type The IngredientType we want the texture for.
     * @return a Texture for the ingredientStation
     */
    public static Texture getIngredientStationAsset(IngredientType type) {
        Texture texture = GameData.ingredientStationTexture;
        switch (type.getName()) {
            case "tomato":
                return GameData.tomatoStationTexture;
            case "onion":
                return GameData.onionStationTexture;
            case "lettuce":
                return GameData.lettuceStationTexture;
            case "bread":
                return GameData.breadStationTexture;
            case "meat":
                return GameData.meatStationTexture;
            case "dish":
                return GameData.dishStationTexture;
            case "dough":
                return GameData.doughStationTexture;
            case "sauce":
                return GameData.sauceStationTexture;
            case "cheese":
                return GameData.cheeseStationTexture;
            case "potato":
                return GameData.potatoStationTexture;
        }
        return texture;
    }

    /**
     * Construct the IngredientStation class
     *
     * @param gridX          the X grid coordinates of the station
     * @param gridY          the Y grid coordinates of the station
     * @param ingredientType the IngredientType that the station serves.
     */
    public IngredientStation(int gridX, int gridY, IngredientType ingredientType) {
        super(getIngredientStationAsset(ingredientType));
        this.ingredientType = ingredientType;
    }

    /**
     * A stub to stop players putting items down on the IngredientStation
     *
     * @param item the Movable the player is trying to put down (but this is pointless!)
     * @return false. always.
     */
    @Override
    public boolean placeItem(Movable item) {
        return false;
    }

    /**
     * Pick up the Ingredient or Dish from the station.
     *
     * @return An Ingredient or Dish. The type returned is specified in the constructor {@link #IngredientStation}
     */
    @Override
    public Movable takeItem() {
        if (ingredientType.getName() == "dish") {
            return new Dish();
        }
        return new Ingredient(ingredientType);
    }

    @Override
    public boolean isEqual(Object obj){
        if(!(obj instanceof Station)){
            return false;
        }
        IngredientStation station = (IngredientStation) obj;
        if (this.ingredientType.equals(station.ingredientType) == false){
            return false;
        }
        if(this.item!=station.item){
            return false;
        }
        if(this.texture != station.texture){
            return false;
        }
        if(this.available != station.available){
            return false;
        }
        return true;

    }

}
