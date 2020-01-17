package com.wbtang.api.member;

import com.wbtang.api.member.domain.MemberDO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * desc
 *
 * @author TangWenBo
 * @date 2019/12/23
 */
@RequestMapping("/member")
public interface MemberApi {

    /**
     * 获取用户信息
     *
     * @param memberId 用户id
     * @return com.wbtang.api.member.domain.MemberDO
     * @author TangWenBo
     * @date 2019/12/23 17:12
     */
    @GetMapping("/get")
    MemberDO get(@RequestParam("memberId") String memberId);


}
