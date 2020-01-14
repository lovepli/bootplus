package io.github.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import io.github.config.aop.BaseAopService;
import io.github.dao.SysUserLoginLogDao;
import io.github.entity.SysUserLoginLogEntity;
import io.github.service.SysUserLoginLogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 用户登录日志
 *
 * @author Joey
 * @Email 2434387555@qq.com
 */
@Service
public class SysUserLoginLogServiceImpl extends BaseAopService<SysUserLoginLogServiceImpl, SysUserLoginLogDao, SysUserLoginLogEntity>
        implements SysUserLoginLogService {

    @Override
    public Page<SysUserLoginLogEntity> getSelf(Integer offset, Integer limit, Long adminId, String loginIp, String sort,
                                               Boolean order) {
        Wrapper<SysUserLoginLogEntity> wrapper = new EntityWrapper<SysUserLoginLogEntity>();
        wrapper.eq("user_id", adminId);
        if (StringUtils.isNoneBlank(sort) && null != order) {
            wrapper.orderBy(sort, order);
        }
        if (StringUtils.isNoneBlank(loginIp)) {
            wrapper.like("login_ip", loginIp);
        }
        Page<SysUserLoginLogEntity> page = new Page<>(offset, limit);
        return this.selectPage(page, wrapper);
    }

}
