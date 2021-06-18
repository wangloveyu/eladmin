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
package admin.xxx.modules.system.repository;

import admin.xxx.modules.system.domain.TblUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @website https://el-admin.vip
* @author wzb
* @date 2021-06-18
**/
public interface TblUserRepository extends JpaRepository<TblUser, Long>, JpaSpecificationExecutor<TblUser> {
    /**
    * 根据 Username 查询
    * @param username /
    * @return /
    */
    TblUser findByUsername(String username);
    /**
    * 根据 Email 查询
    * @param email /
    * @return /
    */
    TblUser findByEmail(String email);
}