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
package admin.xxx.modules.system.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @website https://el-admin.vip
* @description /
* @author wzb
* @date 2021-06-18
**/
@Data
public class TblUserDto implements Serializable {

    /** ID */
    private Long id;

    /** 部门名称 */
    private Long deptId;

    /** 用户名 */
    private String username;

    /** 昵称 */
    private String nickName;

    /** 性别 */
    private String gender;

    /** 手机号码 */
    private String phone;

    /** 邮箱 */
    private String email;

    /** 头像地址 */
    private String avatarName;

    /** 头像真实路径 */
    private String avatarPath;

    /** 密码 */
    private String password;

    /** 是否为admin账号 */
    private Boolean isAdmin;

    /** 状态：1启用、0禁用 */
    private Integer enabled;

    /** 创建者 */
    private String createBy;

    /** 更新者 */
    private String updateBy;

    /** 修改密码的时间 */
    private Timestamp pwdResetTime;

    /** 创建时间 */
    private Timestamp createTime;

    /** 更新时间 */
    private Timestamp updateTime;

    /** 身份证号码 */
    private String idNo;

    /** 身份证有效期 */
    private String idValidity;

    /** 生日 */
    private String birthday;

    /** 出生地 */
    private String birthPlace;

    /** 现居住地 */
    private String nowPlace;

    /** 薪酬ID */
    private Long salaryId;

    /** 岗位ID */
    private Long jobId;

    /** 人员状态 */
    private Integer state;

    /** 关联sys_user */
    private Integer userId;
}