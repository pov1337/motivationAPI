package ru.tryhard.motivation.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.tryhard.motivation.models.Category;
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
/*        SELECT * FROM motivations
        WHERE category = 1
        order by random()
        limit 1


        SELECT * FROM motivations WHERE motivation_id=?*/
    }

    public List<Category> showCategory(){
        return jdbcTemplate.query("SELECT * FROM categories", new BeanPropertyRowMapper<>(Category.class));
    }

}
