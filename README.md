# Function for v1.0
## 路由
* `/` 主页
* `/dashboard` 
    * `/user` 用户管理
    * `/product` 产品管理
    * `/post` 论坛管理
    * `/resource` 资源管理
* `/user` 
    * `/{id}` id用户的详细信息
* `/product` 产品展示
    * `/{id}` id产品的详细信息
* `/post` 帖子列表
    * `/{id}` id帖子的详细信息
* `/api` Ajax API
    * `/users` get,post
        * `/{id}` get, post, put, delete
    * `/products` get,post
        * `/{id}` get, post, put, delete
    * `/posts` get,post
        * `/{id}` get, post, put, delete
    * `/resources` get,post
        * `/{id}` get, post, put, delete

## 功能
### 用户管理
|前端|后端|api|
|---|---|----|
||* [x] 用户表||
|* [ ] 登录|* [x] 登录|`/api/login`|
|* [ ] 注册|* [x] 注册|`/api/register`|
|* [ ] 用户CRUD|* [x] 用户查询|admin登录后get:`/api/users`|
|* [ ] 用户CRUD|* [x] 用户增加|admin登录后post:`/api/users`|
|* [ ] 用户CRUD|* [ ] 单个用户查询|get:`/api/users/{id}`|
|* [ ] 用户CRUD|* [ ] 单个用户更新|put:`/api/users/{id}`|
|* [ ] 用户CRUD|* [x] 单个用户删除|admin登录后delete:`/api/users/{id}`|
|* [ ] 找回密码|* [ ] 找回密码||

### 物品管理
|前端|后端|api|
|---|---|---|
||* [x] 产品表||
|* [ ] 产品CRUD|* [ ] 产品查询|get:`/api/products`|
|* [ ] 产品CRUD|* [ ] 产品增加|post:`/api/products`|
|* [ ] 产品CRUD|* [ ] 单个产品查询|get:`/api/products/{id}`|
|* [ ] 产品CRUD|* [ ] 单个产品更新|put:`/api/products/{id}`|
|* [ ] 产品CRUD|* [ ] 单个产品删除|delete:`/api/products/{id}`|

### 论坛管理
|前端|后端|api|
|---|---|----|
||* [x] 帖子表||
|* [ ] 帖子CRUD|* [ ] 帖子查询|get:`/api/posts`|
|* [ ] 帖子CRUD|* [ ] 帖子增加|post:`/api/posts`|
|* [ ] 帖子CRUD|* [ ] 单个帖子查询|get:`/api/posts/{id}`|
|* [ ] 帖子CRUD|* [ ] 单个帖子更新|put:`/api/posts/{id}`|
|* [ ] 帖子CRUD|* [ ] 单个帖子删除|delete:`/api/posts/{id}`|
|* [ ] 发帖|* [ ] 发帖||
|* [ ] 回帖|* [ ] 回帖||

### 资源管理
|前端|后端|
|---|---|
||* [x] 资源表|
|* [ ] 资源CRUD|* [ ] 资源CRUD|
|* [ ] 发资源|* [ ] 发资源|
