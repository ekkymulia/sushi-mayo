package com.sushimayo.database.Repository;

import com.sushimayo.models.NotaModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class NotaRepository {
    private JdbcTemplate jdbcTemplate;

    public NotaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<NotaModel> getAllNota() {
        String query = "SELECT * FROM nota";
        return jdbcTemplate.query(query, new NotaMapper());
    }

    public NotaModel getNotaById(int notaId) {
        String query = "SELECT * FROM nota WHERE id_nota = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{notaId}, new NotaMapper());
    }

    public NotaModel getNotaByPhone(String telpPelanggan) {
        String query = "SELECT * FROM nota WHERE telp_pelanggan = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{telpPelanggan}, new NotaMapper());
    }



    private class NotaMapper implements RowMapper<NotaModel> {
        @Override
        public NotaModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            NotaModel nota = new NotaModel();
            nota.setIdNota(rs.getInt("id_nota"));
            nota.setTelpPelanggan(rs.getString("telp_pelanggan"));
            nota.setAlamat(rs.getString("alamat"));
            nota.setMetodePembayaran(rs.getString("metode_pembayaran"));
            nota.setNamaPelanggan(rs.getString("nama_pelanggan"));
            nota.setTanggalPemesanan(rs.getDate("tanggal_pemesanan"));
            return nota;
        }
    }
}
