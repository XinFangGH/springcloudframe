package com.wbtang.service.member.controller;

import com.wbtang.api.member.MemberApi;
import com.wbtang.api.member.domain.MemberDO;
import com.wbtang.common.entity.Result;
import com.wbtang.common.utils.Md5Utils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * desc
 *
 * @author TangWenBo
 * @date 2019/12/23
 */
@RestController
@RefreshScope
public class MemberController implements MemberApi {

    /**
     * 获取用户详情
     *
     * @param memberId 用户id
     * @return com.wbtang.api.member.domain.MemberDO
     * @author TangWenBo
     * @date 2019/12/23 17:52
     */
    @Override
    public MemberDO get(String memberId) {
        MemberDO memberDO = new MemberDO();
        memberDO.setId(memberId);
        memberDO.setName("哈哈哈" + memberId);
        memberDO.setPhone(Md5Utils.getMD5(memberId));
        return memberDO;
    }


    @RequestMapping("/error")
    public Result error(int a) {

        System.out.println(a);
        if (a == 0) {
            int i = a / 0;
        }

        return Result.fail("嘿嘿");
    }


    /**
     * 自动刷新配置demo
     */
    @Value("${haha}")
    private String haha;

    @RequestMapping("/haha")
    public String demo() {
        System.out.println(haha);
        System.out.println(haha);
        return haha;
    }

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/redis")
    public Result redis(String key) {
        String value = stringRedisTemplate.opsForValue().get(key);
        if (StringUtils.isBlank(value)) {
            stringRedisTemplate.opsForValue().set(key, UUID.randomUUID().toString());
            value = stringRedisTemplate.opsForValue().get(key);
        }
        Map<String, String> map = new HashMap<>(2);
        map.put("value", value);
        return Result.success(map);
    }

}
