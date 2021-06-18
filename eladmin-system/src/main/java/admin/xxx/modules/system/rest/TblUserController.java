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
package admin.xxx.modules.system.rest;

import admin.xxx.annotation.Log;
import admin.xxx.modules.system.domain.TblUser;
import admin.xxx.modules.system.service.TblUserService;
import admin.xxx.modules.system.service.dto.TblUserQueryCriteria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* @website https://el-admin.vip
* @author wzb
* @date 2021-06-18
**/
@RestController
@RequiredArgsConstructor
@Api(tags = "用户详情管理")
@RequestMapping("/api/tblUser")
public class TblUserController {

    private final TblUserService tblUserService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('tblUser:list')")
    public void download(HttpServletResponse response, TblUserQueryCriteria criteria) throws IOException {
        tblUserService.download(tblUserService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询用户详情")
    @ApiOperation("查询用户详情")
    @PreAuthorize("@el.check('tblUser:list')")
    public ResponseEntity<Object> query(TblUserQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(tblUserService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增用户详情")
    @ApiOperation("新增用户详情")
    @PreAuthorize("@el.check('tblUser:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody TblUser resources){
        return new ResponseEntity<>(tblUserService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改用户详情")
    @ApiOperation("修改用户详情")
    @PreAuthorize("@el.check('tblUser:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody TblUser resources){
        tblUserService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除用户详情")
    @ApiOperation("删除用户详情")
    @PreAuthorize("@el.check('tblUser:del')")
    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestBody Long[] ids) {
        tblUserService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
