人事管理系统
1.  系统结构
*  **表现层（web层）**：jsp
*  **mvc层**：springmvc
*  **业务逻辑层**：主要由spring Ioc容器管理的业务逻辑组件HrmService组成，可用来封装DAO组件
*  **DAO层**：SQL语句映射，完成对数据库的CRUD操作
*  **领域对象层**：java bean,封装对象
*  **数据库服务层**：mysql hrm_db
2.  系统功能模块
*  用户管理  
*  部门管理
*  职位管理
*  员工管理
*  公告管理
*  文件下载
