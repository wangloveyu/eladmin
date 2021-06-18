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
package admin.xxx.modules.system.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @website https://el-admin.vip
* @description /
* @author wzb
* @date 2021-06-18
**/
@Entity
@Data
@Table(name="tbl_user")
public class TblUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(value = "ID")
    private Long id;

    @Column(name = "dept_id")
    @ApiModelProperty(value = "部门名称")
    private Long deptId;

    @Column(name = "username",unique = true)
    @ApiModelProperty(value = "用户名")
    private String username;

    @Column(name = "nick_name")
    @ApiModelProperty(value = "昵称")
    private String nickName;

    @Column(name = "gender")
    @ApiModelProperty(value = "性别")
    private String gender;

    @Column(name = "phone")
    @ApiModelProperty(value = "手机号码")
    private String phone;

    @Column(name = "email",unique = true)
    @ApiModelProperty(value = "邮箱")
    private String email;

    @Column(name = "avatar_name")
    @ApiModelProperty(value = "头像地址")
    private String avatarName;

    @Column(name = "avatar_path")
    @ApiModelProperty(value = "头像真实路径")
    private String avatarPath;

    @Column(name = "password")
    @ApiModelProperty(value = "密码")
    private String password;

    @Column(name = "is_admin")
    @ApiModelProperty(value = "是否为admin账号")
    private Boolean isAdmin;

    @Column(name = "enabled")
    @ApiModelProperty(value = "状态：1启用、0禁用")
    private Integer enabled;

    @Column(name = "create_by")
    @ApiModelProperty(value = "创建者")
    private String createBy;

    @Column(name = "update_by")
    @ApiModelProperty(value = "更新者")
    private String updateBy;

    @Column(name = "pwd_reset_time")
    @ApiModelProperty(value = "修改密码的时间")
    private Timestamp pwdResetTime;

    @Column(name = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Timestamp createTime;

    @Column(name = "update_time")
    @ApiModelProperty(value = "更新时间")
    private Timestamp updateTime;

    @Column(name = "id_no")
    @ApiModelProperty(value = "身份证号码")
    private String idNo;

    @Column(name = "id_validity")
    @ApiModelProperty(value = "身份证有效期")
    private String idValidity;

    @Column(name = "birthday")
    @ApiModelProperty(value = "生日")
    private String birthday;

    @Column(name = "birth_place")
    @ApiModelProperty(value = "出生地")
    private String birthPlace;

    @Column(name = "now_place")
    @ApiModelProperty(value = "现居住地")
    private String nowPlace;

    @Column(name = "salary_id")
    @ApiModelProperty(value = "薪酬ID")
    private Long salaryId;

    @Column(name = "job_id")
    @ApiModelProperty(value = "岗位ID")
    private Long jobId;

    @Column(name = "state")
    @ApiModelProperty(value = "人员状态")
    private Integer state;

    @Column(name = "user_id")
    @ApiModelProperty(value = "关联sys_user")
    private Integer userId;

    public void copy(TblUser source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}