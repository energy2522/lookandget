package com.getandlook.module.dao.impl;

import com.getandlook.module.dao.interfaces.ContentOfClientDao;
import com.getandlook.module.domain.ContentOfClient;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Володимир Майборода on 31.10.2017.
 */

@Repository
public class ContentOfClientDaoImpl implements ContentOfClientDao {
    @Autowired
    private HibernateTemplate template;

    @Override
    public void create(ContentOfClient contentOfClient) {
        template.saveOrUpdate(contentOfClient);
    }

    @Override
    public ContentOfClient findByClientAndContent(Integer idOfClient, String typeOfContent) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ContentOfClient.class);
        detachedCriteria.add(Restrictions.eq("client.id", idOfClient));
//        detachedCriteria.add(Restrictions.eq("content.id", idOfClient));
        List<ContentOfClient> list = (List<ContentOfClient>) template.findByCriteria(detachedCriteria);

       list = list.stream().filter(el -> typeOfContent.equals(el.getContent().getName())).collect(Collectors.toList());

        return DataAccessUtils.uniqueResult(list);
    }


}
