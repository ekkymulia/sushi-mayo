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

}
