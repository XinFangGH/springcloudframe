package com.wbtang.api.member.feign.hystrix;

import com.wbtang.api.member.domain.MemberDO;
import com.wbtang.api.member.feign.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 熔断
 *
 * @author TangWenBo
 * @date 2019/12/23
 */
@RequestMapping("/member/hystrix")
@Component
@Slf4j
public class MemberHystrix implements MemberService {
    @Override
    public MemberDO get(String memberId) {
        return null;
    }
}
