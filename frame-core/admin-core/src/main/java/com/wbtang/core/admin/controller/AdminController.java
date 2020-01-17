package com.wbtang.core.admin.controller;

import com.wbtang.api.member.domain.MemberDO;
import com.wbtang.api.member.feign.MemberService;
import com.wbtang.common.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * desc
 *
 * @author TangWenBo
 * @date 2019/12/25
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private MemberService memberService;


    @GetMapping("/get")
    public Result get(String memberId) {
        MemberDO memberDO = memberService.get(memberId);
        return Result.success(memberDO);
    }

}
