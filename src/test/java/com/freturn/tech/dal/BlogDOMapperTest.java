package com.freturn.tech.dal;

import java.util.List;

import com.freturn.tech.dal.query.BlogQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.freturn.tech.dal.dao.BlogDOMapper;
import com.freturn.tech.dal.dataobject.BlogDO;

/**
 * @author yangtao.lyt
 * @version $Id: BlogDOMapperTest, v 0.1 2016-04-20 14:29 yangtao.lyt Exp $
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/persistence.xml"})
public class BlogDOMapperTest {

    private static final Logger logger = LoggerFactory.getLogger(BlogDOMapperTest.class);

    @Autowired
    private BlogDOMapper blogDOMapper;

    @Test
    public void testInsert(){

        BlogDO blogDO = new BlogDO();




        blogDOMapper.insert(blogDO);

        Assert.isTrue(true);

    }


    @Test
    public void testQuery(){

        BlogQuery queryObj = new BlogQuery();
        queryObj.setCreatorId("11");

        List<BlogDO> blogDOList = blogDOMapper.query(queryObj);

        Assert.isTrue(true);

    }



}
