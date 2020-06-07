package com.example.driver1;

import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author admin
 */
@Service
public class SessionUse {

    public final Session session1;

    public SessionUse(@Qualifier("sessionFactory1")
                              Session session1){
        this.session1 = session1;
    }

}
