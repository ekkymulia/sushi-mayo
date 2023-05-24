package com.sushimayo.database.Repository;

import com.sushimayo.models.DetailNotaModel;
import com.sushimayo.models.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class MenuRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<String> getAllMenuNames() {
        List<String> menuNames = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT nama_menu FROM menu;");
        for (Map<String, Object> row : rows) {
            String menuName = (String) row.get("nama_menu");
            menuNames.add(menuName);
        }
        return menuNames;
    }
}
