package com.sushimayo.database.Repository;

import com.sushimayo.models.JenisMenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JenisMenuRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<JenisMenuModel> getAllJenisMenu() {
        String query = "SELECT * FROM jenis_menu;";
        return jdbcTemplate.query(query, new JenisMenuMapper());
    }

    private class JenisMenuMapper implements RowMapper<JenisMenuModel> {
        @Override
        public JenisMenuModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            JenisMenuModel jenisMenu = new JenisMenuModel();
            jenisMenu.setIdJenisMenu(Integer.parseInt(rs.getString("id_jenismenu")));
            jenisMenu.setNamaJenisMenu(rs.getString("nama_jenismenu"));
            return jenisMenu;
        }
    }
}