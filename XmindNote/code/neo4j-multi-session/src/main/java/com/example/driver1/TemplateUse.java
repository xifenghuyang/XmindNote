package com.example.driver1;

import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author admin
 */
@Service
public class TemplateUse {

    public final TransactionTemplate template;

    public TemplateUse(@Qualifier("neo4jTemplate")
                               TransactionTemplate neo4jTemplate){
        this.template = neo4jTemplate;
    }

}
