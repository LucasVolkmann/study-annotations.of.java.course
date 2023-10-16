package study.jdbc.repository;

import study.jdbc.conn.ConnectionFactory;
import study.jdbc.domain.Producer;

import javax.sql.rowset.JdbcRowSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProducerRepositoryRowSet {

    public static List<Producer> findByNameJdbcRowSet(String name) {
        String sql = "SELECT id, name FROM anime_store.producer WHERE name LIKE ?;";
        List<Producer> producers = new ArrayList<>();
        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet();) {
            jrs.setCommand(sql);
            jrs.setString(1, String.format("%%%s%%", name));
            jrs.execute();
            while (jrs.next()){
                Producer producer = Producer.builder()
                        .id(jrs.getInt("id"))
                        .name(jrs.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producers;
    }
}
