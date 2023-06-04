package com.sushimayo.database.Repository;

import com.sushimayo.models.DetailNotaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DetailNotaRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<DetailNotaModel> getAllUserNames() {
        List<DetailNotaModel> detailNotaList = new ArrayList<>();
        detailNotaList.addAll(jdbcTemplate.queryForList("select qty from detail_nota;", DetailNotaModel.class));
        return detailNotaList;
    }

    public void saveDetailNota(DetailNotaModel detailNotaModel) {
        String sql = "INSERT INTO detail_nota (id_nota, id_menu, qty, harga, total_harga) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                detailNotaModel.getIdNota(),
                detailNotaModel.getIdMenu(),
                detailNotaModel.getQty(),
                detailNotaModel.getHarga(),
                detailNotaModel.getTotalHarga()
        );
    }


}
