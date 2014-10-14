/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dooioo.tel.service;

import com.mongodb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PhoneService {

    @Autowired
    private Mongo mongo;

    public void insert(String name, String phoneGo) {
        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.put("name", name);
        basicDBObject.put("phoneGo", phoneGo);
        basicDBObject.put("phoneCome", "51585229");
        basicDBObject.put("phoneView", "15601622811");
        basicDBObject.put("status", 0);
        basicDBObject.put("id", getMaxId());

        getDBCollection().insert(basicDBObject);
    }

    /**
     * 查询所有有效的数据
     *
     * @return
     */
    public List<DBObject> query() {
        DBCursor cursor = getDBCollection().find().sort(new BasicDBObject("id", 1).append("status", 0));
        return cursor.toArray();
    }

    /**
     * 伪造一个自增的ID
     * 因只是demo，所以不考虑并发问题
     *
     * @return
     */
    private int getMaxId() {
        DBCursor cursor = getDBCollection().find().sort(new BasicDBObject("$natural",-1)).limit(1);
        if(cursor.hasNext()){
            return Integer.parseInt(cursor.next().get("id").toString()) + 1;
        }else{
            return 1;
        }
    }

    private DBCollection getDBCollection() {
        return mongo.getDB("TelCall").getCollection("phones");
    }

}
