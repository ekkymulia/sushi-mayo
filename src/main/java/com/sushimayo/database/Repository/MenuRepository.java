package com.sushimayo.database.Repository;

import com.sushimayo.models.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class MenuRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<MenuModel> getAllMenu() {
        String query = "SELECT * FROM menu WHERE is_deleted = false;";
        return jdbcTemplate.query(query, new MenuMapper());
    }

    public MenuModel getMenuById(int menuId) {
        String query = "SELECT * FROM menu WHERE id_menu = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{menuId}, new MenuMapper());
    }

    public List<MenuModel> getMenuByName(String menuName) {
        String query = "SELECT * FROM menu WHERE nama_menu = ? and is_deleted = false";
        return jdbcTemplate.query(query, new Object[]{menuName}, new MenuMapper());
    }

    public void insertMenu(MenuModel menu) {
        String hargaMenu = menu.getHargaMenu().replace(",", "");
        String query = "INSERT INTO menu (nama_menu, harga_menu, id_jenismenu, gambar_menu, deskripsi_menu) VALUES ('" + menu.getNamaMenu() + "', '" + hargaMenu + "', " + menu.getIdJenisMenu() + ", '" + menu.getGambarMenu() + "', '" + menu.getDeskripsiMenu() + "')";
        jdbcTemplate.update(query);
    }

    public void deleteMenuById(int menuId) {
        String query = "DELETE FROM menu WHERE id_menu = " + menuId;
        jdbcTemplate.update(query);
    }

    public void softDeleteMenu(int idMenu) {
        String query = "UPDATE menu SET is_deleted = true WHERE id_menu = " + idMenu;
        jdbcTemplate.update(query);
    }

    public void updateMenu(MenuModel menu) {
        String query = "UPDATE menu SET nama_menu = '" + menu.getNamaMenu() + "', harga_menu = '" + menu.getHargaMenu() + "', id_jenismenu = " + menu.getIdJenisMenu() + ", gambar_menu = '" + menu.getGambarMenu() + "', deskripsi_menu = '" + menu.getDeskripsiMenu() + "' WHERE id_menu = " + menu.getIdMenu();
        jdbcTemplate.update(query);
    }



    private class MenuMapper implements RowMapper<MenuModel> {
        @Override
        public MenuModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            MenuModel menu = new MenuModel();
            menu.setIdMenu(rs.getInt("id_menu"));
            menu.setNamaMenu(rs.getString("nama_menu"));
            menu.setHargaMenu(rs.getDouble("harga_menu"));
            menu.setIdJenisMenu(rs.getInt("id_jenismenu"));
            menu.setGambarMenu(rs.getString("gambar_menu"));
            menu.setDeskripsiMenu(rs.getString("deskripsi_menu"));

            return menu;
        }
    }
}
