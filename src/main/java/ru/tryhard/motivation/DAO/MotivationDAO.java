package ru.tryhard.motivation.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.tryhard.motivation.models.Category;
import ru.tryhard.motivation.models.Favorite;
import ru.tryhard.motivation.models.Motivation;

import java.util.List;

@Component
public class MotivationDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public Motivation show(int category){
        return jdbcTemplate.query("SELECT * FROM motivations WHERE category=? ORDER BY RANDOM() LIMIT 1",
                        new Object[]{category}, new BeanPropertyRowMapper<>(Motivation.class))
                .stream().findAny().orElse(null);
    }

    public List<Category> showCategory(){
        return jdbcTemplate.query("SELECT * FROM categories", new BeanPropertyRowMapper<>(Category.class));
    }

    public List<Favorite> showFavorite(){
        return jdbcTemplate.query("SELECT * FROM favorites", new BeanPropertyRowMapper<>(Favorite.class));
    }

    public void saveFavorite(Motivation motivation){
        jdbcTemplate.update("INSERT INTO favorites(favorite_text) VALUES(?)", motivation.getMotivation_text());
    }

    public void deleteFavorite(int favoriteId){
        jdbcTemplate.update("DELETE FROM Favorites WHERE favorite_id=?", favoriteId);
    }

}
