package com.freturn.tech.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.freturn.tech.biz.domain.User;
import com.freturn.tech.biz.manager.UserManager;
import com.freturn.tech.dal.dao.BlogDOMapper;
import com.freturn.tech.dal.dataobject.BlogDO;
import com.freturn.tech.support.constant.PathConstant;

/**
 *
 * 用户controller
 *
 * @author yangtao.lyt
 * @version $Id: BlogController, v 0.1 2016-04-20 20:49 yangtao.lyt Exp $
 */
@Controller
public class UserController {

    /** logger */
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserManager userManager;

    @Resource
    private BlogDOMapper blogDOMapper;


    @RequestMapping("/user/{userId}")
    public String getUserHome(@PathVariable Long userId, ModelMap modelMap) {

        /*UserDO userDO = userDOMapper.queryOneById(userId);

        List<MetadataDO> metadataDOList = metadataDOMapper.queryListByIdList(Splitter.on(",")
                .splitToList(userDO.getCategoryIdList()));

        List<UserExtDO> userExtDOList = userExtDOMapper.queryListByUserId(userId);

        modelMap.addAttribute("user", userDO);
        modelMap.addAttribute("metadataList", metadataDOList);
        modelMap.addAttribute("userExtList", userExtDOList);

        return PathConstant.USER_HOME;*/

        return null;

    }

    @RequestMapping("/user/{userId}/blog/{blogId}")
    public String getBlogHome(@PathVariable String userId, @PathVariable String blogId,
                              ModelMap modelMap) {


        User user = userManager.getUserById(userId);

        BlogDO blogDO = blogDOMapper.selectByPrimaryKey(blogId);

        modelMap.addAttribute("user", user);
        modelMap.addAttribute("blog", blogDO);

        return PathConstant.BLOG_HOME;

    }

    @RequestMapping("/user/{userId}/aboutme")
    public String getAboutMe(@PathVariable String userId, ModelMap modelMap) {

        modelMap.addAttribute("userId", userId);

        return PathConstant.USER_ABOUTME;

    }

    @RequestMapping("/user/{userId}/contact")
    public String getContact(@PathVariable String userId, ModelMap modelMap) {

        modelMap.addAttribute("userId", userId);

        return PathConstant.USER_CONTACT;

    }

}
