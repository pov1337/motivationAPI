package ru.tryhard.motivation.models;

public class Favorite {

    String favorite_text;

    String favorite_id;


        public Favorite(String favorite_text, String favorite_id) {
        this.favorite_text = favorite_text;
        this.favorite_id = favorite_id;
    }

    public Favorite(){}

    public String getFavorite_text() {
        return favorite_text;
    }

    public void setFavorite_text(String favorite_text) {
        this.favorite_text = favorite_text;
    }

    public String getFavorite_id() {
        return favorite_id;
    }

    public void setFavorite_id(String favorite_id) {
        this.favorite_id = favorite_id;
    }
}
