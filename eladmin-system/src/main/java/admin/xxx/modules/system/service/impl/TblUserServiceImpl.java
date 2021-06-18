/*
*  Copyright 2019-2020 wzb
*
*  Licensed under the Apache License, Version 2.0 (the "License");
*  you may not use this file except in compliance with the License.
*  You may obtain a copy of the License at
*
*  http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing, software
*  distributed under the License is distributed on an "AS IS" BASIS,
*  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*  See the License for the specific language governing permissions and
*  limitations under the License.
*/
package admin.xxx.modules.system.service.impl;


import admin.xxx.exception.EntityExistException;
import admin.xxx.modules.system.domain.TblUser;
import admin.xxx.modules.system.repository.TblUserRepository;
import admin.xxx.modules.system.service.TblUserService;
import admin.xxx.modules.system.service.dto.TblUserDto;
import admin.xxx.modules.system.service.dto.TblUserQueryCriteria;
import admin.xxx.modules.system.service.mapstruct.TblUserMapper;
import admin.xxx.utils.FileUtil;
import admin.xxx.utils.PageUtil;
import admin.xxx.utils.QueryHelp;
import admin.xxx.utils.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* @website https://el-admin.vip
* @description 服务实现
* @author wzb
* @date 2021-06-18
**/
@Service
@RequiredArgsConstructor
public class TblUserServiceImpl implements TblUserService {

    private final TblUserRepository tblUserRepository;
    private final TblUserMapper tblUserMapper;

    @Override
    public Map<String,Object> queryAll(TblUserQueryCriteria criteria, Pageable pageable){
        Page<TblUser> page = tblUserRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(tblUserMapper::toDto));
    }

    @Override
    public List<TblUserDto> queryAll(TblUserQueryCriteria criteria){
        return tblUserMapper.toDto(tblUserRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public TblUserDto findById(Long id) {
        TblUser tblUser = tblUserRepository.findById(id).orElseGet(TblUser::new);
        ValidationUtil.isNull(tblUser.getId(),"TblUser","id",id);
        return tblUserMapper.toDto(tblUser);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TblUserDto create(TblUser resources) {
        if(tblUserRepository.findByUsername(resources.getUsername()) != null){
            throw new EntityExistException(TblUser.class,"username",resources.getUsername());
        }
        if(tblUserRepository.findByEmail(resources.getEmail()) != null){
            throw new EntityExistException(TblUser.class,"email",resources.getEmail());
        }
        return tblUserMapper.toDto(tblUserRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(TblUser resources) {
        TblUser tblUser = tblUserRepository.findById(resources.getId()).orElseGet(TblUser::new);
        ValidationUtil.isNull( tblUser.getId(),"TblUser","id",resources.getId());
        tblUser = tblUserRepository.findByUsername(resources.getUsername());
        if(tblUser != null && !tblUser.getId().equals(tblUser.getId())){
            throw new EntityExistException(TblUser.class,"username",resources.getUsername());
        }
        tblUser = tblUserRepository.findByEmail(resources.getEmail());
        if(tblUser != null && !tblUser.getId().equals(tblUser.getId())){
            throw new EntityExistException(TblUser.class,"email",resources.getEmail());
        }
        tblUser.copy(resources);
        tblUserRepository.save(tblUser);
    }

    @Override
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            tblUserRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<TblUserDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (TblUserDto tblUser : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("部门名称", tblUser.getDeptId());
            map.put("用户名", tblUser.getUsername());
            map.put("昵称", tblUser.getNickName());
            map.put("性别", tblUser.getGender());
            map.put("手机号码", tblUser.getPhone());
            map.put("邮箱", tblUser.getEmail());
            map.put("头像地址", tblUser.getAvatarName());
            map.put("头像真实路径", tblUser.getAvatarPath());
            map.put("密码", tblUser.getPassword());
            map.put("是否为admin账号", tblUser.getIsAdmin());
            map.put("状态：1启用、0禁用", tblUser.getEnabled());
            map.put("创建者", tblUser.getCreateBy());
            map.put("更新者", tblUser.getUpdateBy());
            map.put("修改密码的时间", tblUser.getPwdResetTime());
            map.put("创建时间", tblUser.getCreateTime());
            map.put("更新时间", tblUser.getUpdateTime());
            map.put("身份证号码", tblUser.getIdNo());
            map.put("身份证有效期", tblUser.getIdValidity());
            map.put("生日", tblUser.getBirthday());
            map.put("出生地", tblUser.getBirthPlace());
            map.put("现居住地", tblUser.getNowPlace());
            map.put("薪酬ID", tblUser.getSalaryId());
            map.put("岗位ID", tblUser.getJobId());
            map.put("人员状态", tblUser.getState());
            map.put("关联sys_user", tblUser.getUserId());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}
