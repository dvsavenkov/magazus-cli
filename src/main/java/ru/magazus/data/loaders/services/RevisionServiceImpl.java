package ru.magazus.data.loaders.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ru.magazus.data.loaders.dto.RevisionDTO;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RevisionServiceImpl implements RevisionService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RevisionServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public List<RevisionDTO> getRevision(Long sourceId, Long regionId) {
        String sql = "SELECT DATE_FORMAT((SELECT MAX(insdate) FROM revisions WHERE sourceid = i.sourceid),'%Y-%m-%d') AS `date`\n" +
                ", a1.VALUE AS model_code \n" +
                ", a.VALUE AS model_name\n" +
                ", s.name AS shop_name\n" +
                ", coalesce(ia.attrvalue, 0) AS shop_price\n" +
                ", ir.relurl AS url\n" +
                "FROM registry_items i\n" +
                "join revisions r on (r.id = (select max(id) from revisions where busy=0 AND sourceid = i.sourceid)) \n" +
                "JOIN items_relation ir ON ir.sourceid = i.sourceid AND ir.itemid = i.itemid AND ir.regionid=?\n" +
                "JOIN sources s ON s.id = ir.relsourceid\n" +
                "left JOIN registry_items_attributes a ON i.itemid = a.itemid AND i.sourceid = a.sourceid AND a.attribute = 'name'\n" +
                "left JOIN registry_items_attributes a1 ON i.itemid = a1.itemid AND i.sourceid = a1.sourceid AND a1.attribute = 'code'\n" +
                "left JOIN items_attributes ia ON ia.sourceid=ir.relsourceid AND ia.itemid=ir.relitemid AND ia.regionid = ir.regionid AND ia.attrname='price'\n" +
                "WHERE i.sourceid=?";
        List<RevisionDTO> revisionList = jdbcTemplate.query(sql, new Object[]{regionId, sourceId}, new BeanPropertyRowMapper(RevisionDTO.class));
        return revisionList;
    }
}
